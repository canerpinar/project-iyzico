package com.projectiyzico.repository;

import com.projectiyzico.entity.PaymentCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentCardRepository extends CrudRepository<PaymentCard,Long> {
}
