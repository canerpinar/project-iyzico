package com.service.repository;

import com.service.entity.CreatorThreedPaymentRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatorThreedPaymentRequestRepository extends CrudRepository<CreatorThreedPaymentRequest,Long> {
}
