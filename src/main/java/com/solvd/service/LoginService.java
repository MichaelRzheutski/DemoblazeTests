package com.solvd.service;

import com.solvd.domain.User;
import com.solvd.domain.enums.Users;
import com.solvd.gui.components.LoginModalWindow;
import com.solvd.gui.pages.HomePage;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;

public class LoginService {
    public User getUser(Users users) {
        User user = null;
        switch (users) {
            case VALID -> {
                user = new User(
                        R.TESTDATA.get("valid.login"),
                        R.TESTDATA.get("valid.password")
                );
            }
            case INVALID -> {
                user = new User(
                        R.TESTDATA.get("invalid.login"),
                        R.TESTDATA.get("invalid.password")
                );
            }
        }
        return user;
    }

    public void login(User user, WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        LoginModalWindow loginModalWindow = homePage.getHeader().clickLoginButton();

        loginModalWindow.typeUserName(user.getUsername());
        loginModalWindow.typePassword(user.getPassword());
        loginModalWindow.clickLoginButton();
    }
}
