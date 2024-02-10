package com.solvd.gui.components;

import com.solvd.domain.FooterContent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class Footer extends AbstractUIObject {
    @FindBy(xpath = "//*[@id='footc']")
    private ExtendedWebElement footer;

    @FindBy(xpath = "//*[@class='col-sm-4 col-lg-4 col-md-4']//b")
    private ExtendedWebElement aboutUsTitle;

    @FindBy(xpath = "//*[@class='grrrr']/following-sibling::p")
    private ExtendedWebElement aboutUsText;

    @FindBy(xpath = "//*[@class='col-sm-3 col-lg-3 col-md-3']//b")
    private ExtendedWebElement getInTouchTitle;

    @FindBy(xpath = "//*[@class='col-sm-3 col-lg-3 col-md-3']//p[1]")
    private ExtendedWebElement getInTouchAddress;

    @FindBy(xpath = "//*[@class='col-sm-3 col-lg-3 col-md-3']//p[2]")
    private ExtendedWebElement getInTouchPhone;

    @FindBy(xpath = "//*[@class='col-sm-3 col-lg-3 col-md-3']//p[3]")
    private ExtendedWebElement getInTouchEmail;

    @FindBy(xpath = "//h4[text()=' PRODUCT STORE']")
    private ExtendedWebElement productSoreTitle;

    @FindBy(xpath = "//*[@class='col-sm-4 col-lg-4 col-md-4']//img")
    private ExtendedWebElement img;

    public Footer(WebDriver driver) {
        super(driver);
    }

    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isFooterPresent() {
        return footer.isElementPresent();
    }

    public FooterContent getAboutUsBlock() {
        return new FooterContent(
                aboutUsTitle.getText(),
                aboutUsText.getText()
        );
    }

    public FooterContent getInTouchBlock() {
        return new FooterContent(
                getInTouchTitle.getText(),
                getInTouchAddress.getText(),
                getInTouchPhone.getText(),
                getInTouchEmail.getText()
        );
    }

    public FooterContent getProductStoreBlock() {
        FooterContent footerContent = new FooterContent();
        footerContent.setTitle(productSoreTitle.getText());
        footerContent.setImg(img.getAttribute("src"));

        return footerContent;
    }

    public void scrollToFooter() {
        WebElement element = driver.findElement(By.id("footc"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
