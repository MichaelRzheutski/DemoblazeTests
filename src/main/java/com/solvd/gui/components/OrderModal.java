package com.solvd.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Month;
import java.time.Year;

public class OrderModal extends AbstractUIObject {
    @FindBy(xpath = "//div[@class='form-group']/input[@id='name']")
    private ExtendedWebElement nameField;

    @FindBy(xpath = "//div[@class='form-group']/input[@id='country']")
    private ExtendedWebElement countryField;

    @FindBy(xpath = "//div[@class='form-group']/input[@id='city']")
    private ExtendedWebElement cityField;

    @FindBy(xpath = "//div[@class='form-group']/input[@id='card']")
    private ExtendedWebElement creditCardField;

    @FindBy(xpath = "//div[@class='form-group']/input[@id='month']")
    private ExtendedWebElement monthField;

    @FindBy(xpath = "//div[@class='form-group']/input[@id='year']")
    private ExtendedWebElement yearField;

    @FindBy(xpath = "//button[@onclick='purchaseOrder()']")
    private ExtendedWebElement purchaseOrderButton;

    @FindBy(css = "div.sweet-alert.showSweetAlert.visible h2")
    private ExtendedWebElement purchaseSuccess;

    @FindBy(css = ".confirm.btn.btn-lg.btn-primary")
    private ExtendedWebElement confirmPurchase;

    public OrderModal(WebDriver driver) {
        super(driver);
    }

    public OrderModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public OrderModal typeName(String name) {
        nameField.type(name);
        return this;
    }

    public OrderModal typeCountry(String country) {
        countryField.type(country);
        return this;
    }

    public OrderModal typeCity(String city) {
        cityField.type(city);
        return this;
    }

    public OrderModal typeCreditCard(Long creditCard) {
        creditCardField.type(formatCard(String.valueOf(creditCard)));
        return this;
    }

    public OrderModal typeMonth(Month month) {
        monthField.type(String.valueOf(month));
        return this;
    }

    public OrderModal typeYear(Year year) {
        yearField.type(String.valueOf(year));
        return this;
    }

    public OrderModal clickPurchaseOrderButton() {
        purchaseOrderButton.click();
        return this;
    }

    public boolean isPurchaseDone() {
        return purchaseSuccess.isElementPresent();
    }

    public OrderModal confirmPurchase() {
        if (isPurchaseDone()) {
            confirmPurchase.click();
        }
        return this;
    }

    private static String formatCard(String cardNumber) {
        if (cardNumber == null) {
            return null;
        }
        char delimiter = ' ';
        return cardNumber.replaceAll(".{4}(?!$)", "$0" + delimiter);
    }

}
