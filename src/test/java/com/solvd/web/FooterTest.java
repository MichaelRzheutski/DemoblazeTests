package com.solvd.web;

import com.solvd.gui.components.Footer;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.solvd.domain.enums.FooterTexts.ABOUT_US_TEXT;

public class FooterTest extends TestBase {
    @Test(description = "Check about us block")
    public void checkAboutUsBlockTest() {
        getHomePage();
        SoftAssert softAssert = new SoftAssert();

        Footer footer = new Footer(getDriver());
        footer.isUIObjectPresent(2);
        softAssert.assertTrue(footer.isFooterPresent());
        footer.scrollToFooter();

        softAssert.assertEquals(footer.getAboutUsBlock().getTitle(), "About Us", "Title incorrect");
        softAssert.assertEquals(footer.getAboutUsBlock().getText(), ABOUT_US_TEXT.getAboutUsText(), "Text incorrect");
        softAssert.assertAll();
    }

    @Test(description = "Check get in touch block")
    public void checkGetInTouchBlockTest() {
        getHomePage();
        SoftAssert softAssert = new SoftAssert();

        Footer footer = new Footer(getDriver());
        footer.isUIObjectPresent(2);
        softAssert.assertTrue(footer.isFooterPresent());
        footer.scrollToFooter();

        softAssert.assertEquals(footer.getInTouchBlock().getTitle(), "Get in Touch", "Title incorrect");
        softAssert.assertEquals(footer.getInTouchBlock().getAddress(), "Address: 2390 El Camino Real", "Address incorrect");
        softAssert.assertEquals(footer.getInTouchBlock().getPhone(), "Phone: +440 123456", "Phone incorrect");
        softAssert.assertEquals(footer.getInTouchBlock().getEmail(), "Email: demo@blazemeter.com", "Email incorrect");
        softAssert.assertAll();
    }

    @Test(description = "Check product store block")
    public void checkProductStoreBlockTest() {
        getHomePage();
        SoftAssert softAssert = new SoftAssert();

        Footer footer = new Footer(getDriver());
        footer.isUIObjectPresent(2);
        softAssert.assertTrue(footer.isFooterPresent());
        footer.scrollToFooter();

        softAssert.assertEquals(footer.getProductStoreBlock().getTitle(), "PRODUCT STORE", "Title incorrect");
        softAssert.assertEquals(footer.getProductStoreBlock().getImg(), "https://www.demoblaze.com/bm.png", "Img incorrect");
        softAssert.assertAll();
    }
}
