package com.projectiyzico.entity;

public class RetrievePaymentRequest extends Request {
    private String paymentId;
    private String paymentConversationId;

    public RetrievePaymentRequest() {
    }

    public String getPaymentId() {
        return this.paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentConversationId() {
        return this.paymentConversationId;
    }

    public void setPaymentConversationId(String paymentConversationId) {
        this.paymentConversationId = paymentConversationId;
    }

    public String toString() {
        return (new ToStringRequestBuilder(this)).appendSuper(super.toString()).append("paymentId", this.paymentId).append("paymentConversationId", this.paymentConversationId).toString();
    }
}
