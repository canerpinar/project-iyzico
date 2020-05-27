package com.service.repository;

import com.service.entity.PaymentCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentCardRepository extends CrudRepository<PaymentCard,Long> {
}
