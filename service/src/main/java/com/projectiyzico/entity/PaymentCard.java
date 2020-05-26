package com.projectiyzico.entity;



import javax.persistence.*;

@Entity
public class PaymentCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardHolderName;
    private String cardNumber;
    private String expireYear;
    private String expireMonth;
    private String cvc;
    private Integer registerCard;
    private String cardAlias;
    private String cardToken;
    private String cardUserKey;

    public PaymentCard() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardHolderName() {
        return this.cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpireYear() {
        return this.expireYear;
    }

    public void setExpireYear(String expireYear) {
        this.expireYear = expireYear;
    }

    public String getExpireMonth() {
        return this.expireMonth;
    }

    public void setExpireMonth(String expireMonth) {
        this.expireMonth = expireMonth;
    }

    public String getCvc() {
        return this.cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public Integer getRegisterCard() {
        return this.registerCard;
    }

    public void setRegisterCard(Integer registerCard) {
        this.registerCard = registerCard;
    }

    public String getCardAlias() {
        return this.cardAlias;
    }

    public void setCardAlias(String cardAlias) {
        this.cardAlias = cardAlias;
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

    public String toString() {
        return (new ToStringRequestBuilder(this)).append("cardHolderName", this.cardHolderName).append("cardNumber", this.cardNumber).append("expireYear", this.expireYear).append("expireMonth", this.expireMonth).append("cvc", this.cvc).append("registerCard", this.registerCard).append("cardAlias", this.cardAlias).append("cardToken", this.cardToken).append("cardUserKey", this.cardUserKey).toString();
    }
}
