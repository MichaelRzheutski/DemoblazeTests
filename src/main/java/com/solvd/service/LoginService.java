package com.solvd.service;

import com.solvd.domain.User;
import com.solvd.domain.enums.Users;
import com.solvd.gui.components.LoginModalWindow;
import com.solvd.gui.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class LoginService {
    public User getUser(Users users) {
        return new User(users.getUsername(), users.getPassword());
    }

    public void login(User user, WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        LoginModalWindow loginModalWindow = homePage.getHeader().clickLoginButton();

        loginModalWindow.typeUserName(user.getUsername());
        loginModalWindow.typePassword(user.getPassword());
        loginModalWindow.clickLoginButton();
    }
}
