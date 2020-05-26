package com.projectiyzico.entity;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.List;

public class PaymentResources extends IyziResources {
    private BigDecimal price;
    private BigDecimal paidPrice;
    private String currency;
    private Integer installment;
    private String paymentId;
    private String paymentStatus;
    private Integer fraudStatus;
    private BigDecimal merchantCommissionRate;
    private BigDecimal merchantCommissionRateAmount;
    private BigDecimal iyziCommissionRateAmount;
    private BigDecimal iyziCommissionFee;
    private String cardType;
    private String cardAssociation;
    private String cardFamily;
    private String cardToken;
    private String cardUserKey;
    private String binNumber;
    private String basketId;
    @SerializedName("itemTransactions")
    private List<PaymentItem> paymentItems;
    private String connectorName;

    public PaymentResources() {
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPaidPrice() {
        return this.paidPrice;
    }

    public void setPaidPrice(BigDecimal paidPrice) {
        this.paidPrice = paidPrice;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getInstallment() {
        return this.installment;
    }

    public void setInstallment(Integer installment) {
        this.installment = installment;
    }

    public String getPaymentId() {
        return this.paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentStatus() {
        return this.paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getFraudStatus() {
        return this.fraudStatus;
    }

    public void setFraudStatus(Integer fraudStatus) {
        this.fraudStatus = fraudStatus;
    }

    public BigDecimal getMerchantCommissionRate() {
        return this.merchantCommissionRate;
    }

    public void setMerchantCommissionRate(BigDecimal merchantCommissionRate) {
        this.merchantCommissionRate = merchantCommissionRate;
    }

    public BigDecimal getMerchantCommissionRateAmount() {
        return this.merchantCommissionRateAmount;
    }

    public void setMerchantCommissionRateAmount(BigDecimal merchantCommissionRateAmount) {
        this.merchantCommissionRateAmount = merchantCommissionRateAmount;
    }

    public BigDecimal getIyziCommissionRateAmount() {
        return this.iyziCommissionRateAmount;
    }

    public void setIyziCommissionRateAmount(BigDecimal iyziCommissionRateAmount) {
        this.iyziCommissionRateAmount = iyziCommissionRateAmount;
    }

    public BigDecimal getIyziCommissionFee() {
        return this.iyziCommissionFee;
    }

    public void setIyziCommissionFee(BigDecimal iyziCommissionFee) {
        this.iyziCommissionFee = iyziCommissionFee;
    }

    public String getCardType() {
        return this.cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardAssociation() {
        return this.cardAssociation;
    }

    public void setCardAssociation(String cardAssociation) {
        this.cardAssociation = cardAssociation;
    }

    public String getCardFamily() {
        return this.cardFamily;
    }

    public void setCardFamily(String cardFamily) {
        this.cardFamily = cardFamily;
    }

    public String getCardToken() {
        return this.cardToken;
    }

    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }

    public String getCardUserKey() {
        return this.cardUserKey;
    }

    public void setCardUserKey(String cardUserKey) {
        this.cardUserKey = cardUserKey;
    }

    public String getBinNumber() {
        return this.binNumber;
    }

    public void setBinNumber(String binNumber) {
        this.binNumber = binNumber;
    }

    public String getBasketId() {
        return this.basketId;
    }

    public void setBasketId(String basketId) {
        this.basketId = basketId;
    }

    public List<PaymentItem> getPaymentItems() {
        return this.paymentItems;
    }

    public void setPaymentItems(List<PaymentItem> paymentItems) {
        this.paymentItems = paymentItems;
    }

    public String getConnectorName() {
        return this.connectorName;
    }

    public void setConnectorName(String connectorName) {
        this.connectorName = connectorName;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
