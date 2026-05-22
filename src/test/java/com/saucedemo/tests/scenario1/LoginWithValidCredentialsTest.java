package com.saucedemo.tests.scenario1;

import com.saucedemo.pages.scenario1.LoginWithValidCredentialsPage;
import com.saucedemo.tests.BaseTest;
import data.dataReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

/**
 * Test Scenario 1: Validates positive login functionality using external test data.
 */
public class LoginWithValidCredentialsTest extends BaseTest {

    @Test(description = "Verify that a user can successfully login with valid credentials")
    public void loginWithValidCredentials() throws IOException, ParseException {
        // Initialize the data reader and parse external test data sources
        dataReader dReader = new dataReader();
        dReader.reader();

        // Initialize Login Page Object with the active WebDriver instance
        LoginWithValidCredentialsPage loginPage = new LoginWithValidCredentialsPage(driver);

        // Execute the complete login action flow using valid test data
        loginPage.loginWithExistingUser(dReader.UserName, dReader.Password);

        // Assert that the user successfully logs in and the dashboard logo is displayed
        Assert.assertTrue(loginPage.isLoginSuccess(), "Login Failed: Product header is not visible after the login");
    }
}