package com.solvd.gui.pages;

import com.solvd.gui.components.OrderModal;
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

    @FindBy(xpath = "//*[@data-target='#orderModal']")
    private ExtendedWebElement placeOrderButton;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(productsTitle);
    }

    public boolean isProductInCart() {
        return phoneMakeInCart.isElementPresent();
    }

    public boolean isPlaceOrderButtonPresent() {
        return placeOrderButton.isElementPresent();
    }

    public OrderModal clickPlaceOrderButton() {
        placeOrderButton.click();
        return new OrderModal(driver);
    }
}
