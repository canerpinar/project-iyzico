package com.projectiyzico.repository;


import com.projectiyzico.entity.Buyer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Buyer,Long> {

}
