package com.solvd.gui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {
    @FindBy(xpath = ".//h2[text()='Products']")
    private ExtendedWebElement productsTitle;

    @FindBy(xpath = ".//td[text()='Samsung galaxy s6']")
    private ExtendedWebElement phoneMakeInCart;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(productsTitle);
    }

    public boolean isProductInCart() {
        return phoneMakeInCart.isElementPresent();
    }
}
