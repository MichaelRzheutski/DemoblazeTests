package com.solvd.web;

import com.solvd.gui.components.Header;
import com.solvd.gui.components.PhoneCard;
import com.solvd.gui.pages.CartPage;
import com.solvd.gui.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends TestBase {
    @Test(description = "Verify cart page")
    public void verifyCardPageTest() {
        getHomePage();
        Header header = new Header(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        header.clickCartButton();
        Assert.assertTrue(cartPage.isPageOpened());
    }

    @Test(description = "Put single product to cart")
    public void putSingleProductToCartTest() {
        getHomePage();
        SoftAssert softAssert = new SoftAssert();

        PhoneCard phoneCard = new PhoneCard(getDriver());
        phoneCard.isUIObjectPresent(2);
        phoneCard.goToProductPageByIndex(1);

        ProductPage productPage = new ProductPage(getDriver());
        softAssert.assertTrue(productPage.isPageOpened());

        String addToCartMessage = productPage.putProductToCart();
        softAssert.assertEquals(addToCartMessage, "Product added", "Product not added to the cart");
        softAssert.assertAll();
    }

    @Test(description = "Put multiple products to cart")
    public void putMultipleProductsToCartTest() {
        getHomePage();
        SoftAssert softAssert = new SoftAssert();
        PhoneCard phoneCard = new PhoneCard(getDriver());
        ProductPage productPage = new ProductPage(getDriver());
        String addToCartMessage;

        phoneCard.isUIObjectPresent(2);
        phoneCard.goToProductPageByIndex(1);
        softAssert.assertTrue(productPage.isPageOpened());
        addToCartMessage = productPage.putProductToCart();
        softAssert.assertEquals(addToCartMessage, "Product added", "Product not added to the cart");

        productPage.navigateBack();
        productPage.navigateBack();

        phoneCard.isUIObjectPresent(2);
        phoneCard.goToProductPageByIndex(2);
        softAssert.assertTrue(productPage.isPageOpened());
        addToCartMessage = productPage.putProductToCart();
        softAssert.assertEquals(addToCartMessage, "Product added", "Product not added to the cart");

        softAssert.assertAll();
    }

    @Test
    public void isProductAddedToCartTest() {
        getHomePage();
        SoftAssert softAssert = new SoftAssert();

        PhoneCard phoneCard = new PhoneCard(getDriver());
        phoneCard.isUIObjectPresent(2);
        phoneCard.goToProductPageByIndex(1);

        ProductPage productPage = new ProductPage(getDriver());
        softAssert.assertTrue(productPage.isPageOpened());

        String addToCartMessage = productPage.putProductToCart();
        softAssert.assertEquals(addToCartMessage, "Product added", "Product not added to the cart");

        Header header = new Header(getDriver());
        header.clickCartButton();

        CartPage cartPage = new CartPage(getDriver());
        softAssert.assertTrue(cartPage.isPageOpened());
        softAssert.assertTrue(cartPage.isProductInCart());

        softAssert.assertAll();
    }
}
