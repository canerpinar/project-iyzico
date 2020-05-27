package com.service.entity;

public class ThreedPayment extends PaymentResources {
    public ThreedPayment() {
    }

    public static ThreedPayment create(CreatorThreedPaymentRequest request, SecretOptions options) {
        return (ThreedPayment) HttpClients.create().post(options.getBaseUrl() + "/payment/3dsecure/auth", getHttpHeaders(request, options), request, ThreedPayment.class);
    }

    public static ThreedPayment retrieve(RetrievePaymentRequest request, SecretOptions options) {
        return (ThreedPayment)HttpClients.create().post(options.getBaseUrl() + "/payment/detail", getHttpHeaders(request, options), request, ThreedPayment.class);
    }
}
