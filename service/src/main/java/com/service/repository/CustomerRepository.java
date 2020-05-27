package com.service.repository;


import com.service.entity.Buyer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Buyer,Long> {

}
