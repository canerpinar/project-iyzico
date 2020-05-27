package com.service.service;

import com.service.entity.Buyer;
import com.service.repository.BuyerRepository;
import org.springframework.stereotype.Service;

@Service
public class BuyerService extends AbstractService<Buyer,Long> {

    private BuyerRepository buyerRepository;

    public BuyerService(BuyerRepository buyerRepository) {
        super(buyerRepository);
        this.buyerRepository = buyerRepository;
    }

    public Buyer findBuyerByEmail(String email){
        Buyer buyer =null;
        try {
            buyer = buyerRepository.findBuyerByEmail(email);
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        return buyer;
    }
}
