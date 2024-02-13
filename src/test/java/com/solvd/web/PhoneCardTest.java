package com.solvd.web;

import com.solvd.gui.components.PhoneCard;
import com.solvd.gui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PhoneCardTest extends TestBase {
    @Test(description = "Check phone availability")
    public void checkPhoneAvailabilityTest() {
        getHomePage();

        PhoneCard phoneCard = new PhoneCard(getDriver());
        String phoneMake = phoneCard.getPhoneByIndex(1).getPhoneMake();
        phoneCard.isUIObjectPresent(2);
        phoneCard.goToProductPageByIndex(1);

        Assert.assertEquals(phoneMake, "Samsung galaxy s6", "There is no such model on the page");
    }

    @Test(description = "Check next button work")
    public void checkNextButtonWorkTest() {
        HomePage homePage = getHomePage();

        PhoneCard phoneCard = new PhoneCard(getDriver());
        phoneCard.isUIObjectPresent(2);
        String beforeNextButtonPressed = phoneCard.getPhoneByIndex(1).getPhoneMake();
        homePage.nextButtonClick();
        String afterNextButtonPressed = phoneCard.getPhoneByIndex(1).getPhoneMake();

        Assert.assertEquals(beforeNextButtonPressed, afterNextButtonPressed, "Next button is not working");
    }

    @Test(description = "Check prev button work")
    public void checkPrevButtonWorkTest() {
        HomePage homePage = getHomePage();

        PhoneCard phoneCard = new PhoneCard(getDriver());
        phoneCard.isUIObjectPresent(2);
        homePage.prevButtonClick();

        Assert.assertTrue(phoneCard.isNokiaLumia1520PresentByIndex(1), "Prev button is not working");
    }
}
