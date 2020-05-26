package com.projectiyzico.service;

import com.projectiyzico.entity.CreatorPaymentRequest;
import com.projectiyzico.repository.CreatorPaymentRequestRepository;
import org.springframework.stereotype.Service;

@Service
public class CreatorPaymentRequestService extends AbstractService<CreatorPaymentRequest,Long>{

    private CreatorPaymentRequestRepository creatorPaymentRequestRepository;

    public CreatorPaymentRequestService(CreatorPaymentRequestRepository creatorPaymentRequestRepository) {
        super(creatorPaymentRequestRepository);
        this.creatorPaymentRequestRepository = creatorPaymentRequestRepository;
    }

    public CreatorPaymentRequest lastRecordPaymentRequest(){
        try {
            CreatorPaymentRequest creatorPaymentRequest = creatorPaymentRequestRepository.lastCreatorPaymentRequest();
            System.out.println(creatorPaymentRequest);
            return creatorPaymentRequest;
        }catch (NullPointerException e){
            System.out.println("Null hoca");
            return null;
        }
    }

    public String getConversationId(){
        if(lastRecordPaymentRequest() == null){
            return "1";
        }else
        {
            int conversationId = Integer.valueOf(lastRecordPaymentRequest().getConversationId())+1;
            return String.valueOf(conversationId);
        }
    }

    public String getNextBasketId(){
        if(lastRecordPaymentRequest() == null ){
            return "1";
        }else{
            int basketId = Integer.valueOf(lastRecordPaymentRequest().getBasketId()) +1;
            return String.valueOf(basketId);
        }
    }

    public CreatorPaymentRequest findCreatorPaymentRequestByConversationId(String conversationId){
        return creatorPaymentRequestRepository.findCreatorPaymentRequestByConversationId(conversationId);
    }

}
