package com.saucedemo.pages.scenario3;

import com.saucedemo.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Model for handling negative login scenarios with invalid credentials.
 */
public class LoginWithInvalidCredentialsPage extends BasePage {

    // Locators for Login Input Fields and Controls
    private final By userNameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By LoginBtn = By.id("login-button");

    // Constructor to initialize WebDriver and pass it to the BasePage wrapper
    public LoginWithInvalidCredentialsPage(WebDriver driver) {
        super(driver);
    }

    // Enter invalid or locked-out username into the field
    public void enterUserName(String userName) {
        type(userNameField, userName);
    }

    // Enter invalid password into the field
    public void enterPassword(String password) {
        type(passwordField, password);
    }

    // Click the login button to trigger validation/error message
    public void clickOnLoginBtn() {
        click(LoginBtn);
    }
}