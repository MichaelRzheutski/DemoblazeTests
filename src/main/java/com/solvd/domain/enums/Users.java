package com.solvd.domain.enums;

public enum Users {
    VALID("Valid"),
    INVALID("Invalid");

    private final String credentials;

    Users(String credentials) {
        this.credentials = credentials;
    }

    public String getCredentials() {
        return credentials;
    }
}
