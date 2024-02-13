package com.solvd.web;

import com.solvd.gui.pages.HomePage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;

public class TestBase extends AbstractTest {
    protected HomePage getHomePage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());
        return homePage;
    }
}
