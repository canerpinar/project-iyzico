package com.service.installment;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

public class InstallmentPrice {
    private BigDecimal installmentPrice;
    private BigDecimal totalPrice;
    private Integer installmentNumber;

    public InstallmentPrice() {
    }

    public BigDecimal getInstallmentPrice() {
        return this.installmentPrice;
    }

    public void setInstallmentPrice(BigDecimal installmentPrice) {
        this.installmentPrice = installmentPrice;
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getInstallmentNumber() {
        return this.installmentNumber;
    }

    public void setInstallmentNumber(Integer installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
