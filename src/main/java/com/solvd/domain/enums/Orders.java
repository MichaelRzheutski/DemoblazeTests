package com.solvd.domain.enums;

import com.zebrunner.carina.utils.R;

public enum Orders {
    SAMSUNG_GALAXY_S6(
            R.TESTDATA.get("order.name"),
            R.TESTDATA.get("order.country"),
            R.TESTDATA.get("order.city"),
            R.TESTDATA.get("order.creditCard"),
            R.TESTDATA.get("order.month"),
            R.TESTDATA.get("order.year")
    );

    private final String name;
    private final String country;
    private final String city;
    private final String creditCard;
    private final String month;
    private final String year;

    Orders(String name,
           String country,
           String city,
           String creditCard,
           String month,
           String year) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.creditCard = creditCard;
        this.month = month;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }
}
