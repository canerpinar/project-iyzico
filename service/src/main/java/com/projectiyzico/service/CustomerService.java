package com.projectiyzico.service;

import com.projectiyzico.entity.Buyer;
import com.projectiyzico.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService  {

    @Autowired
    private CustomerRepository customerRepository;

    public Buyer findById(Long id){
        Optional<Buyer> customer = customerRepository.findById(id);
        return customer.get();
    }

    public void save(Buyer buyer){
        customerRepository.save(buyer);
    }

}
