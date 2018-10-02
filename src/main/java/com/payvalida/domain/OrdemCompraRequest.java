package com.payvalida.domain;

import com.payvalida.enums.Language;
import com.payvalida.enums.Money;
import com.payvalida.enums.PaymentMethod;
import com.payvalida.security.Authentication;

import java.math.BigInteger;
import java.time.LocalDate;

public class OrdemCompraRequest extends DomainBase {

    private Integer country;
    private String email;
    private String order;
    private String reference;
    private Money money;
    private BigInteger amount; //verficar se aceita casas decimais
    private String description;
    private Language language;
    private boolean recurrent;
    private LocalDate expiration;
    private PaymentMethod method;
    private String iva;

    public OrdemCompraRequest(Integer country, String email, String order, String reference,
                              Money money, BigInteger amount, String description, Language language,
                              boolean recurrent, LocalDate expiration, PaymentMethod method, String iva) {

        this.country = country;
        this.email = email;
        this.order = order;
        this.reference = reference;
        this.money = money;
        this.amount = amount;
        this.description = description;
        this.language = language;
        this.recurrent = recurrent;
        this.expiration = expiration;
        this.method = method;
        this.iva = iva;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public boolean isRecurrent() {
        return recurrent;
    }

    public void setRecurrent(boolean recurrent) {
        this.recurrent = recurrent;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    @Override
    public String getChecksum() {
        Authentication authentication = new Authentication();
        return authentication.generateCheckSum(this.email, this.country.toString(),
                this.order, this.money.toString(), this.amount.toString());
    }
}
