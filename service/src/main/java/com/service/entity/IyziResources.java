package com.service.entity;



import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.HashMap;
import java.util.Map;

public class IyziResources {
    private static final String AUTHORIZATION = "Authorization";
    private static final String RANDOM_HEADER_NAME = "x-iyzi-rnd";
    private static final String IYZIWS_HEADER_NAME = "IYZWS ";
    private static final String COLON = ":";
    private static final int RANDOM_STRING_SIZE = 8;
    private String status;
    private String errorCode;
    private String errorMessage;
    private String errorGroup;
    private String locale;
    private long systemTime;
    private String conversationId;



    public IyziResources() {
    }

    protected static Map<String, String> getHttpHeaders(Request request, SecretOptions options) {
        Map<String, String> headers = new HashMap();
        String randomString = System.currentTimeMillis() + RandomStringUtils.randomAlphanumeric(8);
        headers.put("x-iyzi-rnd", randomString);
        headers.put("Authorization", prepareAuthorizationString(request, randomString, options));
        return headers;
    }

    private static String prepareAuthorizationString(Request request, String randomString, SecretOptions options) {
        String hash = HashGenerate.generateHash(options.getApiKey(), options.getSecretKey(), randomString, request);
        return "IYZWS " + options.getApiKey() + ":" + hash;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorGroup() {
        return this.errorGroup;
    }

    public void setErrorGroup(String errorGroup) {
        this.errorGroup = errorGroup;
    }

    public String getLocale() {
        return this.locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public long getSystemTime() {
        return this.systemTime;
    }

    public void setSystemTime(long systemTime) {
        this.systemTime = systemTime;
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
