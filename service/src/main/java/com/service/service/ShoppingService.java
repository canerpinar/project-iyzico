package com.service.service;


import com.service.entity.Shopping;
import com.service.repository.ShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShoppingService {

    @Autowired
    private ShoppingRepository shoppingRepository;

    @Transactional
    public void save(Shopping shopping){
        shoppingRepository.save(shopping);
    }

    public Shopping getShopping(Long id){
        return shoppingRepository.findById(id).get();
    }

/*
    private Long findLastShopping(){
        Long shopping_id = null;
        try {
            Shopping shopping = shoppingRepository.findLastShopping();
            shopping_id = shopping.getId() + 1L;
        }catch (NullPointerException e) {
            shopping_id = 1L;
        }
        return shopping_id;
    }

    private Long getNextId(){
        Long nextId = findLastShopping();
        return nextId;
    }
*/
    public List<Shopping> getAllShopping(){
        return (List<Shopping>) shoppingRepository.findAll();
    }

    public Shopping getLasShopping(){
        return shoppingRepository.findLastShopping();
    }

    public void deleteAll(){
        shoppingRepository.deleteAll();
    }
}
