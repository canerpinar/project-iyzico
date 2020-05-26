package com.projectiyzico.repository;


import com.projectiyzico.entity.BasketItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrunRepository extends CrudRepository<BasketItem,Long> {

}
