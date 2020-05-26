package com.projectiyzico.service;


import com.projectiyzico.entity.BasketItem;
import com.projectiyzico.repository.UrunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrunService {

    @Autowired
    UrunRepository urunRepository;

    public UrunService() {
    }

    public void deleteAll(){
        urunRepository.deleteAll();
    }

    public void save(BasketItem basketItem){
        urunRepository.save(basketItem);
    }

    public List<BasketItem> getUrunList(){
        return (List<BasketItem>) urunRepository.findAll();
    }

    public BasketItem getUrun(Long id){
        return urunRepository.findById(id).get();
    }
}
