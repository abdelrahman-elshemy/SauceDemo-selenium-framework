package com.saucedemo.pages.scenario1;

import com.saucedemo.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Model for the Login screen and its basic assertions.
 */
public class LoginWithValidCredentialsPage extends BasePage {

    // Locators for Login Page Elements
    private final By userNameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By LoginBtn = By.id("login-button");
    private final By loginSuccessLogo = By.className("app_logo");

    // Constructor to initialize the WebDriver and pass it to the BasePage
    public LoginWithValidCredentialsPage(WebDriver driver) {
        super(driver);
    }

    // Enter username into the credentials field
    public void enterUserName(String userName) {
        type(userNameField, userName);
    }

    // Enter password into the credentials field
    public void enterPassword(String password) {
        type(passwordField, password);
    }

    // Click the login button to submit credentials
    public void clickOnLoginBtn() {
        click(LoginBtn);
    }

    // Verify if the user successfully reached the homepage by checking the logo
    public boolean isLoginSuccess() {
        return getElement(loginSuccessLogo).isDisplayed();
    }

    // High-level action to perform the complete login flow in a single step
    public void loginWithExistingUser(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        clickOnLoginBtn();
    }
}