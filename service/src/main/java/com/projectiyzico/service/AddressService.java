package com.projectiyzico.service;

import com.projectiyzico.entity.Address;
import com.projectiyzico.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends AbstractService{


    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        super(addressRepository);
    }

}
