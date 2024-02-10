package com.solvd.gui.components;

import com.solvd.domain.Phone;
import com.solvd.gui.pages.ProductPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PhoneCard extends AbstractUIObject {
    @FindBy(xpath = "//*[@id='tbodyid']/div[%d]//a[@class='hrefch']")
    private ExtendedWebElement phoneMake;

    @FindBy(xpath = "//*[@id='tbodyid']/div[%d]//p")
    private ExtendedWebElement phoneDescription;

    @FindBy(xpath = "//*[@id='tbodyid']/div[%d]//h5")
    private ExtendedWebElement phonePrice;

    public PhoneCard(WebDriver driver) {
        super(driver);
    }

    public PhoneCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public Phone getPhoneByIndex(int index) {
        Phone phone = new Phone();
        phone.setPhoneMake(phoneMake.format(index).getText());
        phone.setPhoneDescription(phoneDescription.format(index).getText());
        phone.setPhonePrice(Integer.parseInt(phonePrice.format(index).getText().replace("$", "")));

        return phone;
    }

    public boolean isNokiaLumia1520PresentByIndex(int index) {
        return phoneMake.format(index).isElementPresent();
    }

    public ProductPage goToProductPageByIndex(int index) {
        phoneMake.format(index).click();
        return new ProductPage(driver);
    }
}
