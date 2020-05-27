package com.service.service;

import com.service.entity.CreatorThreedPaymentRequest;
import com.service.repository.CreatorThreedPaymentRequestRepository;
import org.springframework.stereotype.Service;

@Service
public class CreatorThreedPaymentRequestService extends AbstractService<CreatorThreedPaymentRequest,Long> {

    private CreatorThreedPaymentRequestRepository creatorThreedPaymentRequestRepository;

    public CreatorThreedPaymentRequestService(CreatorThreedPaymentRequestRepository crudRepository) {
        super(crudRepository);
        this.creatorThreedPaymentRequestRepository = crudRepository;
    }


}
