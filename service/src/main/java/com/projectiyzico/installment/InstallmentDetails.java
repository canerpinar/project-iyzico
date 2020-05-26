package com.projectiyzico.installment;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.List;

public class InstallmentDetails {
    private String binNumber;
    private BigDecimal price;
    private String cardType;
    private String cardAssociation;
    private String cardFamilyName;
    private Integer force3ds;
    private Long bankCode;
    private String bankName;
    private List<InstallmentPrice> installmentPrices;

    public InstallmentDetails() {
    }

    public String getBinNumber() {
        return this.binNumber;
    }

    public void setBinNumber(String binNumber) {
        this.binNumber = binNumber;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public String getCardFamilyName() {
        return this.cardFamilyName;
    }

    public void setCardFamilyName(String cardFamilyName) {
        this.cardFamilyName = cardFamilyName;
    }

    public Integer getForce3ds() {
        return this.force3ds;
    }

    public void setForce3ds(Integer force3ds) {
        this.force3ds = force3ds;
    }

    public Long getBankCode() {
        return this.bankCode;
    }

    public void setBankCode(Long bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public List<InstallmentPrice> getInstallmentPrices() {
        return this.installmentPrices;
    }

    public void setInstallmentPrices(List<InstallmentPrice> installmentPrices) {
        this.installmentPrices = installmentPrices;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
