package com.service.service;


import com.service.adviceHandler.PropertiesNotFound;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.entity.*;
import com.service.installment.InstallmentInf;
import com.service.installment.RetrieveInstallmentRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class PaymentService {
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private CreatorThreedPaymentRequestService creatorThreedPaymentRequestService;

    @Autowired
    private CreatorPaymentRequestService paymentRequestService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private BuyerService buyerService;
    @Autowired
    private ExceptionHandler exceptionHandler;

    public PaymentService(UrunService urunService, ShoppingService shoppingService, CustomerService customerService) {
        this.urunService = urunService;
        this.shoppingService = shoppingService;
        this.customerService = customerService;

    }
    private ThreedInitialize threedsInitialize;

    private PaymentState paymentState;

    private UrunService urunService;
    private ShoppingService shoppingService;
    private CustomerService customerService;

    private List<BasketItem> basketItems;


    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

    public void setBasketItems(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
    }

    public String getNextConversation() {
        return paymentRequestService.getConversationId();
    }

    public String getNextBasketId(){return paymentRequestService.getNextBasketId();}

    public String getHtmlContent(){
        return threedsInitialize.getHtmlContent();
    }

    public static SecretOptions getOptions(){
        SecretOptions options = new SecretOptions();
        options.setBaseUrl("https://sandbox-api.iyzipay.com");
        options.setApiKey("sandbox-m5W7JlSSJbDzv2ehEnC9TmV3AmtUs6aw");
        options.setSecretKey("sandbox-OUf8UZpOkTSgKCbE4ANmcTtQkXR86CHS");
        return options;
    }


    public InstallmentInf doInstallment(RetrieveInstallmentRequest retrieveInstallmentRequest){
        InstallmentInf installmentInfo = InstallmentInf.retrieve(retrieveInstallmentRequest, getOptions());
        return installmentInfo;
    }

    public PaymentState sendPayment(CreatorPaymentRequest paymentRequest) throws JsonProcessingException {

        Buyer buyer = null;
        try{
             buyer = buyerService.findBuyerByEmail(paymentRequest.getBuyer().getEmail());
             paymentRequest.getBuyer().setId(buyer.getId());
        }catch (NullPointerException e){
            Buyer buyer_  = buyerService.save(paymentRequest.getBuyer());
            paymentRequest.getBuyer().setId(buyer_.getId());
            System.out.println(e.getMessage());
        }
            paymentRequest.setConversationId(getNextConversation());
            paymentRequest.setBasketId(getNextBasketId());
        try {
            exceptionHandler.propertiesNotFound(paymentRequest.getPaymentCard());
            exceptionHandler.propertiesNotFound(paymentRequest.getBuyer());
            exceptionHandler.propertiesNotFound(paymentRequest.getBasketItems());
            exceptionHandler.propertiesNotFound(paymentRequest.getShippingAddress());
            threedsInitialize = new ThreedInitialize().create(paymentRequest,getOptions());
        }catch (PropertiesNotFound propertiesNotFound){
            threedsInitialize = new ThreedInitialize();
            threedsInitialize.setErrorCode("400");
            threedsInitialize.setErrorMessage(propertiesNotFound.getMessage());
            threedsInitialize.setStatus("failure");
        }
        if(threedsInitialize.getStatus().equals("success")){
            addressService.save(paymentRequest.getBillingAddress());
            addressService.save(paymentRequest.getShippingAddress());
            if(buyerService.findBuyerByEmail(paymentRequest.getBuyer().getEmail())==null){
                buyerService.save(paymentRequest.getBuyer());
            }
            paymentRequestService.save(paymentRequest);
        }

        String paymentStateString = mapper.writeValueAsString(threedsInitialize);
        paymentState = mapper.readValue(paymentStateString,PaymentState.class);

        System.out.println("MONGTH : " + paymentRequest.getPaymentCard().getExpireMonth()+" : " + paymentRequest.getPaymentCard().toString());

        return paymentState;
    }


    /**
     * <p>This is a simple description of the method. . .
     * <a href="http://www.supermanisthegreatest.com">Superman!</a>
     * </p>
     * @param mapsAttribute the amount of incoming damage
     * @return the amount of health hero has after attack
     * @see <a href="http://www.link_to_jira/HERO-402">HERO-402</a>
     * @since 1.0
     */
    @Transactional
    public Map<String,Object> paymentComplete(Map<String,String> mapsAttribute){
        Map<String,Object> modelMap = new HashMap<>();
        Map<String,String> maps = new HashMap<>();
        String conversationId = mapsAttribute.get("conversationId");
        CreatorPaymentRequest creatorPaymentRequest = paymentRequestService.findCreatorPaymentRequestByConversationId(conversationId);
        if(creatorPaymentRequest != null)
        {
            CreatorThreedPaymentRequest okPayment = new CreatorThreedPaymentRequest();
            okPayment.setLocale(Locale.forLanguageTag("TR").getDisplayName());
            okPayment.setConversationId(mapsAttribute.get("conversationId"));
            okPayment.setPaymentId(mapsAttribute.get("paymentId"));
            ThreedPayment threedsPayment = ThreedPayment.create(okPayment, PaymentService.getOptions());
            System.out.println("ÖDEME SONUCU : " + threedsPayment);
            if(threedsPayment.getStatus().equals("success")){
                creatorThreedPaymentRequestService.save(okPayment);
            }
            modelMap.put("buyer",creatorPaymentRequest.getBuyer());
            modelMap.put("billingAddress",creatorPaymentRequest.getBillingAddress());
            Shopping shopping = new Shopping();
            List<BasketItem> basketItemList1 = new ArrayList<>();
            List<PaymentDetail> paymentDetails = new ArrayList<>();
            shopping.setId(Long.parseLong(creatorPaymentRequest.getBasketId()));
            for(PaymentItem paymentItem : threedsPayment.getPaymentItems()){
                PaymentDetail paymentDetail = new PaymentDetail();
                paymentDetail.setShopping(shopping);
                paymentDetail.setPaymentTransactionId(paymentItem.getPaymentTransactionId());
                paymentDetail.setBasketItem(urunService.getUrun(Long.parseLong(paymentItem.getItemId())));
                basketItemList1.add(urunService.getUrun(Long.parseLong(paymentItem.getItemId())));
                paymentDetails.add(paymentDetail);
            }
            modelMap.put("basket",basketItemList1);
            Buyer buyer = customerService.findById(creatorPaymentRequest.getBuyer().getId());
            //customer.setIds(Long.parseLong(paymentService.getBuyer().getId()));
            shopping.setPaymentDetail(paymentDetails);
            shopping.setBuyer(buyer);
            shopping.setPaymentId(threedsPayment.getConversationId());
            shopping.setShoppinTime(new Date());
            shopping.setSumPrice(creatorPaymentRequest.getPrice());
            //shopping.setUrunList(urunList1);
            shoppingService.save(shopping);
            System.out.println("İşlem başarılıdır");

        }
        return modelMap;

    }




/*
    public ThreedsInitialize getThreedsInitialize() {
        return threedsInitialize;
    }

    public void setThreedsInitialize(ThreedsInitialize threedsInitialize) {
        this.threedsInitialize = threedsInitialize;
    }


 */
}
