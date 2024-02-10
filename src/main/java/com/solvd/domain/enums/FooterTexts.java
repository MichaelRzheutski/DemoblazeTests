package com.solvd.domain.enums;

import com.zebrunner.carina.utils.R;

public enum FooterTexts {
    ABOUT_US_TEXT(R.TESTDATA.get("aboutUsText"));

    private final String aboutUsText;

    FooterTexts(String aboutUsText) {
        this.aboutUsText = aboutUsText;
    }

    public String getAboutUsText() {
        return aboutUsText;
    }
}
