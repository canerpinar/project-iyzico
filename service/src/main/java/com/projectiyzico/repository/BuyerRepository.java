package com.projectiyzico.repository;

import com.projectiyzico.entity.Buyer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends CrudRepository<Buyer,Long> {
    @Query("select buyer  from Buyer buyer where buyer.email = :email")
    public Buyer findBuyerByEmail(@Param("email") String email);
}
