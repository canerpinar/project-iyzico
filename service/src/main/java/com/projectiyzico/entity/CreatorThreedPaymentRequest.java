package com.projectiyzico.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CreatorThreedPaymentRequest extends Request {


    @Column(name="paymentId")
    private String paymentId;
    @Column(name="conversationData")
    private String conversationData;

    public CreatorThreedPaymentRequest() {
    }


    public String getPaymentId() {
        return this.paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getConversationData() {
        return this.conversationData;
    }

    public void setConversationData(String conversationData) {
        this.conversationData = conversationData;
    }

    public String toString() {
        return (new ToStringRequestBuilder(this)).appendSuper(super.toString()).append("paymentId", this.paymentId).append("conversationData", this.conversationData).toString();
    }

}
