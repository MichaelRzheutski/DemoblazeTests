package com.solvd.web;

import com.solvd.domain.enums.Users;
import com.solvd.gui.components.Header;
import com.solvd.service.LoginService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    private final LoginService loginService = new LoginService();

    @Test(description = "Verify valid login")
    public void verifyValidLogin() {
        getHomePage();
        Header header = new Header(getDriver());
        loginService.login(loginService.getUser(Users.VALID), getDriver());
        Assert.assertTrue(header.isWelcomeUserButtonPresent(), "Welcome user button is not present");
    }

    @Test(description = "Verify invalid login")
    public void verifyInvalidLogin() {
        getHomePage();
        Header header = new Header(getDriver());
        loginService.login(loginService.getUser(Users.INVALID), getDriver());
        Assert.assertEquals(header.isWrongPasswordAlertAppeared(), "Wrong password.", "Password correct");
    }

    @Test(description = "Verify logout")
    public void verifyLogout() {
        getHomePage();
        Header header = new Header(getDriver());
        loginService.login(loginService.getUser(Users.VALID), getDriver());
        Assert.assertTrue(header.logOutUser(), "User is not logged out");
    }
}
