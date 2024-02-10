package com.solvd.gui.components;

import com.solvd.gui.pages.CartPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header extends AbstractUIObject {
    @FindBy(xpath = "//*[@id='cartur']")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = ".//*[@id='login2']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = ".//*[@id='nameofuser']")
    private ExtendedWebElement welcomeUserButton;

    @FindBy(xpath = ".//*[@id='logout2']")
    private ExtendedWebElement logOutButton;

    public Header(WebDriver driver) {
        super(driver);
    }

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CartPage clickCartButton() {
        cartButton.click();
        return new CartPage(driver);
    }

    public LoginModalWindow clickLoginButton() {
        loginButton.click();
        return new LoginModalWindow(driver);
    }

    public boolean isWelcomeUserButtonPresent() {
        return welcomeUserButton.isElementPresent();
    }

    public String isWrongPasswordAlertAppeared() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.accept();
        return alertMessage;
    }

    public boolean logOutUser() {
        boolean isUserLoggedIn = isWelcomeUserButtonPresent();
        if (isUserLoggedIn) {
            logOutButton.click();
            return true;
        } else {
            return false;
        }
    }
}
