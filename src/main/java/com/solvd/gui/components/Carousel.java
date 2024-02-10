package com.solvd.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Carousel extends AbstractUIObject {
    @FindBy(css = "div.carousel-item.active")
    private ExtendedWebElement carouselItem;

    public Carousel(WebDriver driver) {
        super(driver);
    }

    public Carousel(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isCarouselItemPresent(int index) {
        return carouselItem.format(index).isElementPresent();
    }

    public String getSlideByIndex(int index) {
        return carouselItem.format(index).getAttribute("class");
    }
}
