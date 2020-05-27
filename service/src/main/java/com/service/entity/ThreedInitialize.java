package com.service.entity;

import com.google.gson.annotations.SerializedName;

public class ThreedInitialize extends IyziResources {

    @SerializedName("threeDSHtmlContent")
    private String htmlContent;

    public ThreedInitialize() {

    }

    public static ThreedInitialize create(CreatorPaymentRequest request, SecretOptions options) {
        ThreedInitialize response = (ThreedInitialize) HttpClients.create().post(options.getBaseUrl() + "/payment/3dsecure/initialize", getHttpHeaders(request, options), request, ThreedInitialize.class);
        if (response != null) {
            response.setHtmlContent(DigestHelp.decodeString(response.getHtmlContent()));
        }
        return response;
    }

    public String getHtmlContent() {
        return this.htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }
}
