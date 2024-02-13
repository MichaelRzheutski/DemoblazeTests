package com.solvd.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginModalWindow extends AbstractUIObject {
    @FindBy(xpath = "//*[@id='loginusername']")
    private ExtendedWebElement loginField;

    @FindBy(xpath = "//*[@id='loginpassword']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//*[@id='logInModal']//button[text()='Close']")
    private ExtendedWebElement closeButton;

    @FindBy(xpath = "//button[text()='Log in']")
    private ExtendedWebElement loginButton;

    public LoginModalWindow(WebDriver driver) {
        super(driver);
    }

    public LoginModalWindow(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LoginModalWindow typeUserName(String username) {
        loginField.type(username);
        return this;
    }

    public LoginModalWindow typePassword(String password) {
        passwordField.type(password);
        return this;
    }

    public LoginModalWindow clickLoginButton() {
        loginButton.click();
        return this;
    }
}
