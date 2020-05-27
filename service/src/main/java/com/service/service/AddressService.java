package com.service.service;

import com.service.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends AbstractService{


    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        super(addressRepository);
    }

}
