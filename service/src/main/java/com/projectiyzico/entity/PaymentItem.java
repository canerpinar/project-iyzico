package com.projectiyzico.entity;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

public class PaymentItem {
    private String itemId;
    private String paymentTransactionId;
    private Integer transactionStatus;
    private BigDecimal price;
    private BigDecimal paidPrice;
    private BigDecimal merchantCommissionRate;
    private BigDecimal merchantCommissionRateAmount;
    private BigDecimal iyziCommissionRateAmount;
    private BigDecimal iyziCommissionFee;
    private BigDecimal blockageRate;
    private BigDecimal blockageRateAmountMerchant;
    private BigDecimal blockageRateAmountSubMerchant;
    private String blockageResolvedDate;
    private String subMerchantKey;
    private BigDecimal subMerchantPrice;
    private BigDecimal subMerchantPayoutRate;
    private BigDecimal subMerchantPayoutAmount;
    private BigDecimal merchantPayoutAmount;
    private ConvertPayout convertedPayout;

    public PaymentItem() {
    }

    public String getItemId() {
        return this.itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getPaymentTransactionId() {
        return this.paymentTransactionId;
    }

    public void setPaymentTransactionId(String paymentTransactionId) {
        this.paymentTransactionId = paymentTransactionId;
    }

    public Integer getTransactionStatus() {
        return this.transactionStatus;
    }

    public void setTransactionStatus(Integer transactionStatus) {
        this.transactionStatus = transactionStatus;
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

    public BigDecimal getBlockageRate() {
        return this.blockageRate;
    }

    public void setBlockageRate(BigDecimal blockageRate) {
        this.blockageRate = blockageRate;
    }

    public BigDecimal getBlockageRateAmountMerchant() {
        return this.blockageRateAmountMerchant;
    }

    public void setBlockageRateAmountMerchant(BigDecimal blockageRateAmountMerchant) {
        this.blockageRateAmountMerchant = blockageRateAmountMerchant;
    }

    public BigDecimal getBlockageRateAmountSubMerchant() {
        return this.blockageRateAmountSubMerchant;
    }

    public void setBlockageRateAmountSubMerchant(BigDecimal blockageRateAmountSubMerchant) {
        this.blockageRateAmountSubMerchant = blockageRateAmountSubMerchant;
    }

    public String getBlockageResolvedDate() {
        return this.blockageResolvedDate;
    }

    public void setBlockageResolvedDate(String blockageResolvedDate) {
        this.blockageResolvedDate = blockageResolvedDate;
    }

    public String getSubMerchantKey() {
        return this.subMerchantKey;
    }

    public void setSubMerchantKey(String subMerchantKey) {
        this.subMerchantKey = subMerchantKey;
    }

    public BigDecimal getSubMerchantPrice() {
        return this.subMerchantPrice;
    }

    public void setSubMerchantPrice(BigDecimal subMerchantPrice) {
        this.subMerchantPrice = subMerchantPrice;
    }

    public BigDecimal getSubMerchantPayoutRate() {
        return this.subMerchantPayoutRate;
    }

    public void setSubMerchantPayoutRate(BigDecimal subMerchantPayoutRate) {
        this.subMerchantPayoutRate = subMerchantPayoutRate;
    }

    public BigDecimal getSubMerchantPayoutAmount() {
        return this.subMerchantPayoutAmount;
    }

    public void setSubMerchantPayoutAmount(BigDecimal subMerchantPayoutAmount) {
        this.subMerchantPayoutAmount = subMerchantPayoutAmount;
    }

    public BigDecimal getMerchantPayoutAmount() {
        return this.merchantPayoutAmount;
    }

    public void setMerchantPayoutAmount(BigDecimal merchantPayoutAmount) {
        this.merchantPayoutAmount = merchantPayoutAmount;
    }

    public ConvertPayout getConvertedPayout() {
        return this.convertedPayout;
    }

    public void setConvertedPayout(ConvertPayout convertedPayout) {
        this.convertedPayout = convertedPayout;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
