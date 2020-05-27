package com.web.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.service.adviceHandler.PropertiesNotFound;
import com.service.entity.*;
import com.service.installment.InstallmentInf;
import com.service.installment.RetrieveInstallmentRequest;
import com.service.service.ExceptionHandler;
import com.service.service.PaymentService;
import com.service.service.UrunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;


@Controller
@RequestMapping("/")
@SessionAttributes({"basketItems"})
public class IndexController {

    private PaymentService paymentService;
    private UrunService urunService; //ürünler veritabanından çekmek için kullanıldı

    @Autowired
    private ExceptionHandler exceptionHandler;

    public IndexController(PaymentService paymentService, UrunService urunService) {
        this.paymentService = paymentService;
        this.urunService = urunService;
    }

    @RequestMapping(value = {"","/"})
    public ModelAndView index(HttpSession session){

        ModelAndView modelAndView = new ModelAndView("index");
        if(!session.isNew()){
            if(session.getAttribute("basketItems") ==null || session.getAttribute("basketItems").equals("")){
                System.out.println("ÜRÜN EKLENMEMİŞ");
            }else{
                System.out.println("----EKLENEN ÜRÜNLER------");
                List<BasketItem> basketItems = (List<BasketItem>) session.getAttribute("basketItems");
                modelAndView.addObject("toplam",priceSum(basketItems));
            }
        }
        return modelAndView;
    }

    @ModelAttribute(name = "basketItems")
    public List<BasketItem> basketItems(){
        return new ArrayList<BasketItem>();
    }


    public BigDecimal priceSum(@SessionAttribute("basketItems") List<BasketItem> basketItems){
        BigDecimal sum = new BigDecimal("0");
        for (BasketItem basketItem : basketItems) {
            sum = sum.add(basketItem.getPrice());
        }

        System.out.println("SUM DEĞER : " + sum);
        return sum;
    }

    @RequestMapping(value="/callback")
    public String callback(@RequestParam Map<String,String> map, Model model,HttpSession session,@SessionAttribute("basketItems") List<BasketItem> basketItems){
        if(session.isNew()){
            System.out.println("YENİ OTURUM");
            System.out.println(session.getId());
        }else{
            System.out.println("ESKİ OTURUM");
            System.out.println(session.getId());
        }
        System.out.println("APİDEN DÖNEN DEĞERLER : " + map);
        Map modelMap = paymentService.paymentComplete(map);
        model.mergeAttributes(modelMap);
        System.out.println(map);
        session.invalidate();
        basketItems.clear();
        return "callback";
    }

    @RequestMapping(value="/urunler")
    @ResponseBody
    public List<BasketItem> urunler(){//veritabanında ürünleri göstermek için kullanuldu
        return urunService.getUrunList();
    }


    @RequestMapping(value="/indexPage")
    @ResponseBody
    public List<BasketItem> indexPage(@SessionAttribute("basketItems") List<BasketItem> basketItems) throws JsonProcessingException{
        return basketItems;
    }

    @RequestMapping(value = "/addUrun")
    @ResponseBody
    public String addUrun(@RequestBody String urun,@SessionAttribute("basketItems") List<BasketItem> basketItems) throws JsonProcessingException {
        boolean listedeVar = false;
        ObjectMapper mapper = new ObjectMapper();
        String returnUrun = null;
        BasketItem added = mapper.readValue(urun, BasketItem.class);
        for(BasketItem basketItem : basketItems){
            System.out.println("EKLENEN : " + added.toString());
            System.out.println("LİSTEDE Kİ  : " + basketItem.toString());
            if(basketItem.getId().equals(added.getId())){
                listedeVar = true;
                break;
            }
        }
        if(listedeVar){ returnUrun = null;
            System.out.println("-------------LİSTEDE VAR----------");
        }
        else{
            returnUrun = mapper.writeValueAsString(added);
            basketItems.add(added);
        }
        return mapper.writeValueAsString(basketItems);
    }

    @RequestMapping(value = "/subtractUrun")
    @ResponseBody
    public String subtractUrun(@RequestBody String urun,@SessionAttribute("basketItems") List<BasketItem> basketItems) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        BasketItem subtract = mapper.readValue(urun, BasketItem.class);
        for(BasketItem basketItem : basketItems){
            if(basketItem.getId().equals(subtract.getId())){
                basketItems.remove(basketItem);
                break;
            }
        }
        return mapper.writeValueAsString(basketItems);
    }

    @RequestMapping(value = "/installment")
    @ResponseBody
    public String infoInstallment(@RequestParam("cardNumber") String newValue,@RequestParam("totalPrice") String totalPrice,@SessionAttribute("basketItems") List<BasketItem> basketItems) throws JsonProcessingException {
        RetrieveInstallmentRequest retrieveInstallmentRequest = new RetrieveInstallmentRequest();
        retrieveInstallmentRequest.setBinNumber(newValue.substring(0,6));
        retrieveInstallmentRequest.setPrice(new BigDecimal(totalPrice));
        InstallmentInf installmentInf = paymentService.doInstallment(retrieveInstallmentRequest);
        System.out.println("INSTALLMENT INFO : " + installmentInf);
        //System.out.println(newValue);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(installmentInf);
    }

    @RequestMapping(value = "/paymentSend",method = RequestMethod.POST)
    public ModelAndView paymentSend(@RequestParam Map<String,String> params, @SessionAttribute("basketItems") List<BasketItem> basketItems, HttpServletRequest request) throws JsonProcessingException, PropertiesNotFound, UnknownHostException {
        CreatorPaymentRequest paymentRequest = new CreatorPaymentRequest();
        //CreatePaymentRequest paymentRequest = new CreatePaymentRequest();
        paymentRequest.setLocale(Locale.ENGLISH.getDisplayName());

        paymentRequest.setCurrency("TRY");
        String installment = (params.get("installment").equals("") || params.get("installment")==null) ? "1" : params.get("installment");
        paymentRequest.setInstallment(Integer.valueOf(installment));

        paymentRequest.setPaymentChannel("WEB");
        paymentRequest.setPaymentGroup("PRODUCT");
        String returnUrl = "http://" + request.getHeader("host")+request.getContextPath()+"/callback";
        paymentRequest.setCallbackUrl(returnUrl);

        //httpServletRequest.getSession().setAttribute("conversationId",request.getConversationId());

        Buyer buyer = new Buyer();
        buyer.setName(params.get("name"));
        buyer.setEmail(params.get("email"));
        buyer.setIdentityNumber(params.get("identityNumber"));
        buyer.setCity(params.get("city"));
        buyer.setCountry(params.get("country"));
        buyer.setGsmNumber(params.get("phone"));
        buyer.setIp(InetAddress.getLocalHost().getHostAddress());
        buyer.setSurname(params.get("surname"));
        buyer.setRegistrationAddress("Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1");

        Address shippingAddress = new Address();
        shippingAddress.setContactName(params.get("contactName"));
        shippingAddress.setCity(params.get("city"));
        shippingAddress.setCountry(params.get("country"));
        shippingAddress.setAddress(params.get("fullAddress"));
        shippingAddress.setZipCode(params.get("zipCode"));

        Address billingAddress = new Address();
        billingAddress.setAddress(params.get("fullAddress"));
        billingAddress.setContactName(params.get("contactName"));
        billingAddress.setCity(params.get("city"));
        billingAddress.setCountry(params.get("country"));

        PaymentCard paymentCard = new PaymentCard();
        paymentCard.setCardHolderName(params.get("cardHolderName"));
        paymentCard.setCardNumber(params.get("cardNumber"));
        paymentCard.setCvc(params.get("ccv"));
        paymentCard.setExpireMonth(params.get("expireMonth"));
        paymentCard.setExpireYear(params.get("expireYear"));


        //paymentService.setCreatePaymentRequest(paymentRequest);
        paymentRequest.setPrice(priceSum(basketItems));

        paymentRequest.setPaidPrice(new BigDecimal(params.get("totalPrice")));

        paymentRequest.setBasketItems(basketItems);
        paymentRequest.setBuyer(buyer);
        paymentRequest.setBillingAddress(billingAddress);
        paymentRequest.setShippingAddress(shippingAddress);
        paymentRequest.setPaymentCard(paymentCard);
        ModelAndView modelAndView = new ModelAndView();
        PaymentState paymentState = paymentService.sendPayment(paymentRequest);
        System.out.println(paymentState.toString());
        if(paymentState.getStatus().equals("failure")){
            String stringBuilder="?name=".concat(buyer.getName()).concat("&surname=").concat(buyer.getSurname())
                    .concat("&email=").concat(buyer.getEmail()).concat("&phone=").concat(buyer.getGsmNumber()).concat("&shippingName=")
                    .concat(shippingAddress.getContactName()).concat("&identityNo=").concat(buyer.getIdentityNumber()).concat("&city=").concat(shippingAddress.getCity()).concat("&country=")
                    .concat(shippingAddress.getCountry()).concat("&address=").concat(shippingAddress.getAddress()).concat("&zipCode=").concat(shippingAddress.getZipCode())
                    .concat("&holderName=").concat(paymentCard.getCardHolderName()).concat("&cardNo=").concat(paymentCard.getCardNumber())
                    .concat("&ccv=").concat(paymentCard.getCvc()).concat("&month=").concat(paymentCard.getExpireMonth()).concat("&year=")
                    .concat(paymentCard.getExpireYear()).concat("&installment=").concat(installment).concat("&totalPrice=").concat(priceSum(basketItems).toString());
            modelAndView.addObject("error",paymentState.getErrorCode());
            modelAndView.addObject("message",paymentState.getErrorMessage());

            stringBuilder = stringBuilder.replace("ç","%C3%A7").replace("Ç", "%C3%87")
            .replace("ğ", "%C4%9F").replace("Ğ", "%C4%9E").replace("ı","%C4%B1")
            .replace("İ","%C4%B0").replace("ö","%C3%B6").replace("Ö","%C3%96")
            .replace("ş","%C5%9F").replace("Ş","%C5%9E").replace("ü","%C3%BC").replace("Ü","%C3%9C");
            modelAndView.setViewName("redirect:/"+stringBuilder);

        }else{
            modelAndView.setViewName("3dsecurity");
            modelAndView.addObject("content",paymentService.getHtmlContent());
        }

        return modelAndView;
    }

}
