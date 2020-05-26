package com.projectiyzico.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

public class ConvertPayout {
    private BigDecimal paidPrice;
    private BigDecimal iyziCommissionRateAmount;
    private BigDecimal iyziCommissionFee;
    private BigDecimal blockageRateAmountMerchant;
    private BigDecimal blockageRateAmountSubMerchant;
    private BigDecimal subMerchantPayoutAmount;
    private BigDecimal merchantPayoutAmount;
    private BigDecimal iyziConversionRate;
    private BigDecimal iyziConversionRateAmount;
    private String currency;

    public ConvertPayout() {
    }

    public BigDecimal getPaidPrice() {
        return this.paidPrice;
    }

    public void setPaidPrice(BigDecimal paidPrice) {
        this.paidPrice = paidPrice;
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

    public BigDecimal getIyziConversionRate() {
        return this.iyziConversionRate;
    }

    public void setIyziConversionRate(BigDecimal iyziConversionRate) {
        this.iyziConversionRate = iyziConversionRate;
    }

    public BigDecimal getIyziConversionRateAmount() {
        return this.iyziConversionRateAmount;
    }

    public void setIyziConversionRateAmount(BigDecimal iyziConversionRateAmount) {
        this.iyziConversionRateAmount = iyziConversionRateAmount;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}