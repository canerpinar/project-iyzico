package com.projectiyzico.repository;

import com.projectiyzico.entity.CreatorThreedPaymentRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatorThreedPaymentRequestRepository extends CrudRepository<CreatorThreedPaymentRequest,Long> {
}
