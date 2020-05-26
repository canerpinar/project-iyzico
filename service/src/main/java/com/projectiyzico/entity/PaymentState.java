package com.projectiyzico.entity;

import java.util.Objects;

public class PaymentState {
    private String status;
    private String errorCode;
    private String errorMessage;
    private String errorGroup;
    private String locale;
    private long systemTime;
    private String conversationId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorGroup() {
        return errorGroup;
    }

    public void setErrorGroup(String errorGroup) {
        this.errorGroup = errorGroup;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public long getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(long systemTime) {
        this.systemTime = systemTime;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentState that = (PaymentState) o;
        return systemTime == that.systemTime &&
                status.equals(that.status) &&
                errorCode.equals(that.errorCode) &&
                errorMessage.equals(that.errorMessage) &&
                errorGroup.equals(that.errorGroup) &&
                locale.equals(that.locale) &&
                conversationId.equals(that.conversationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, errorCode, errorMessage, errorGroup, locale, systemTime, conversationId);
    }

    @Override
    public String toString() {
        return "Status : "+ status + " Error Code : " + this.errorCode +"Error Message : " + this.errorMessage;
    }
}
