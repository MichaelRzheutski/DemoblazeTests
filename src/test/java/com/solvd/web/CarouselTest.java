package com.solvd.web;

import com.solvd.gui.components.Carousel;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CarouselTest extends TestBase {
    @Test(description = "Check slide changed")
    public void checkSlideChangedTest() {
        getHomePage();
        SoftAssert softAssert = new SoftAssert();

        Carousel carousel = new Carousel(getDriver());
        carousel.isUIObjectPresent(3);
        softAssert.assertTrue(carousel.isCarouselItemPresent(1));

        softAssert.assertEquals(carousel.getSlideByIndex(2), "carousel-item active", "Slide has not changed");
        softAssert.assertAll();
    }
}
