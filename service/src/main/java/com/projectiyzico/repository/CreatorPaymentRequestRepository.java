package com.projectiyzico.repository;

import com.projectiyzico.entity.CreatorPaymentRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface CreatorPaymentRequestRepository extends CrudRepository<CreatorPaymentRequest,Long> {

    @Query(value = "select * from creator_payment_request where id = (select max(id) from creator_payment_request);",nativeQuery =
    true)
    CreatorPaymentRequest lastCreatorPaymentRequest();

    @Query("select paymentRequest from  CreatorPaymentRequest paymentRequest where paymentRequest.conversationId = :conversationId")
    CreatorPaymentRequest findCreatorPaymentRequestByConversationId(@Param("conversationId") String conversationId);

}
