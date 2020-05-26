package com.projectiyzico.service;

import com.projectiyzico.entity.CreatorThreedPaymentRequest;
import com.projectiyzico.repository.CreatorThreedPaymentRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CreatorThreedPaymentRequestService extends AbstractService<CreatorThreedPaymentRequest,Long> {

    private CreatorThreedPaymentRequestRepository creatorThreedPaymentRequestRepository;

    public CreatorThreedPaymentRequestService(CreatorThreedPaymentRequestRepository crudRepository) {
        super(crudRepository);
    }


}
