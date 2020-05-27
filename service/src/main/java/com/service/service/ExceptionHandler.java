package com.service.service;


import com.service.adviceHandler.PropertiesNotFound;
import com.service.entity.PaymentCard;
import com.service.entity.Buyer;
import com.service.entity.ShippingAddress;
import org.springframework.stereotype.Service;

@Service
public class ExceptionHandler extends Throwable {

   public ExceptionHandler(){

    }

    public void propertiesNotFound(Object t) throws PropertiesNotFound {
        PropertiesNotFound propertiesNotFound = new PropertiesNotFound();
        if(t instanceof PaymentCard){
            if(((PaymentCard) t).getCardHolderName().equals("") || ((PaymentCard) t).getExpireMonth().equals("") || ((PaymentCard) t).getExpireYear().equals("")
                    || ((PaymentCard) t).getCvc().equals("") || ((PaymentCard) t).getCardNumber().equals("")){

                PropertiesNotFound response = new PropertiesNotFound();
                response.setMessage("Kredi Kartı nda null properties -->".concat(t.toString()));
                throw response;
            }
            }

        if(t instanceof Buyer){
            if(((Buyer) t).getName().equals("") || ((Buyer) t).getIdentityNumber().equals("") || ((Buyer) t).getIp().equals("")||
            ((Buyer) t).getSurname().equals("") || ((Buyer) t).getGsmNumber().equals("") || ((Buyer)t).getEmail().equals("")){
                PropertiesNotFound response = new PropertiesNotFound();
                response.setMessage("Satıcı null properties -->".concat(t.toString()));
                throw response;
            }
        }

        if(t instanceof ShippingAddress){
            if(((ShippingAddress)t).getAddress().equals("") || ((ShippingAddress)t).getCity().equals("") ||
                    ((ShippingAddress)t).getContactName().equals("") || ((ShippingAddress)t).getCountry().equals("")){
                PropertiesNotFound response = new PropertiesNotFound();
                response.setMessage("Shipping adres properties null -->".concat(t.toString()));
                throw response;
            }
        }

        }

    }

