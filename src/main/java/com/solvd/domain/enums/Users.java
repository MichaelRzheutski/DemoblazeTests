package com.solvd.domain.enums;

import com.zebrunner.carina.utils.R;

import static com.zebrunner.carina.utils.R.TESTDATA;

public enum Users {
    VALID(TESTDATA.get("valid.login"), TESTDATA.get("valid.password")),
    INVALID(TESTDATA.get("invalid.login"), R.TESTDATA.get("invalid.password"));

    private final String username;
    private final String password;

    Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
