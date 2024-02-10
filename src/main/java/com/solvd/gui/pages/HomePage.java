package com.solvd.gui.pages;

import com.solvd.gui.components.Header;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy(xpath = "//*[@id='narvbarx']")
    private Header header;

    @FindBy(xpath = "//*[@id='prev2']")
    private ExtendedWebElement prevButton;

    @FindBy(xpath = "//*[@id='next2']")
    private ExtendedWebElement nextButton;


    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    @Override
    public void open() {
        super.openURL(Configuration.getRequired("url"));
    }

    public HomePage nextButtonClick() {
        nextButton.click();
        return this;
    }

    public HomePage prevButtonClick() {
        prevButton.click();
        return this;
    }

    public Header getHeader() {
        return header;
    }
}
