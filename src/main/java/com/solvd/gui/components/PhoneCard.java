package com.solvd.gui.components;

import com.solvd.domain.Phone;
import com.solvd.gui.pages.ProductPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PhoneCard extends AbstractUIObject {
    @FindBy(xpath = "//*[@id='tbodyid']//a[@class='hrefch']")
    private ExtendedWebElement phoneMake;

    @FindBy(xpath = "//*[@id='tbodyid']//p")
    private ExtendedWebElement phoneDescription;

    @FindBy(xpath = "//*[@id='tbodyid']//h5")
    private ExtendedWebElement phonePrice;

    @FindBy(xpath = "//*[@id='tbodyid']//a[text()='Nokia lumia 1520']")
    private ExtendedWebElement nokiaLumia1520;

    public PhoneCard(WebDriver driver) {
        super(driver);
    }

    public PhoneCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public Phone getPhone() {
        Phone phone = new Phone();
        phone.setPhoneMake(phoneMake.getText());
        phone.setPhoneDescription(phoneDescription.getText());
        phone.setPhonePrice(Integer.parseInt(phonePrice.getText().replace("$", "")));

        return phone;
    }

    public boolean isNokiaLumia1520Present() {
        return nokiaLumia1520.isElementPresent();
    }

    public ProductPage goToProductPage() {
        phoneMake.click();
        return new ProductPage(driver);
    }
}
