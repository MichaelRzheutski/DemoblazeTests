package com.solvd.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.Objects;

public class Phone {
    private String phoneMake;
    private String phoneDescription;
    private int phonePrice;

    public Phone() {
    }

    public Phone(String phoneMake, String phoneDescription, int phonePrice) {
        this.phoneMake = phoneMake;
        this.phoneDescription = phoneDescription;
        this.phonePrice = phonePrice;
    }

    public String getPhoneMake() {
        return phoneMake;
    }

    public void setPhoneMake(String phoneMake) {
        this.phoneMake = phoneMake;
    }

    public String getPhoneDescription() {
        return phoneDescription;
    }

    public void setPhoneDescription(String phoneDescription) {
        this.phoneDescription = phoneDescription;
    }

    public int getPhonePrice() {
        return phonePrice;
    }

    public void setPhonePrice(int phonePrice) {
        this.phonePrice = phonePrice;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneMake, phoneDescription, phonePrice);
    }
}
