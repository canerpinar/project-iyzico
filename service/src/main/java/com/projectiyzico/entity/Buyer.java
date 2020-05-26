package com.projectiyzico.entity;



import javax.persistence.*;

@Entity
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String identityNumber;
    @Column
    private String email;
    @Column
    private String gsmNumber;

    private String registrationDate;
    private String lastLoginDate;
    private String registrationAddress;
    @Column
    private String city;
    @Column
    private String country;
    private String zipCode;
    private String ip;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getSurname() {
        return surname;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getIdentityNumber() {
        return identityNumber;
    }


    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getGsmNumber() {
        return gsmNumber;
    }


    public void setGsmNumber(String gsmNumber) {
        this.gsmNumber = gsmNumber;
    }


    public String getRegistrationDate() {
        return registrationDate;
    }


    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }


    public String getLastLoginDate() {
        return lastLoginDate;
    }


    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }


    public String getRegistrationAddress() {
        return registrationAddress;
    }


    public void setRegistrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }


    public String getCountry() {
        return country;
    }


    public void setCountry(String country) {
        this.country = country;
    }


    public String getZipCode() {
        return zipCode;
    }


    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    public String getIp() {
        return ip;
    }


    public void setIp(String ip) {
        this.ip = ip;
    }

    public String toString() {
        return (new ToStringRequestBuilder(this)).append("id", this.id).append("name", this.name).append("surname", this.surname).append("identityNumber", this.identityNumber).append("email", this.email).append("gsmNumber", this.gsmNumber).append("registrationDate", this.registrationDate).append("lastLoginDate", this.lastLoginDate).append("registrationAddress", this.registrationAddress).append("city", this.city).append("country", this.country).append("zipCode", this.zipCode).append("ip", this.ip).toString();
    }
}
