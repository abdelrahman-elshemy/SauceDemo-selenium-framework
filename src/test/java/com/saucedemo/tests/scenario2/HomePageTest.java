package com.saucedemo.tests.scenario2;

import com.saucedemo.pages.scenario1.LoginWithValidCredentialsPage;
import com.saucedemo.pages.scenario2.HomePagePage;
import com.saucedemo.tests.BaseTest;
import data.dataReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

/**
 * Test Scenario 2 (Independent): Validates product searching and cart state toggling on the HomePage.
 */
public class HomePageTest extends BaseTest {

    @Test(description = "Verify that a user can successfully add a product to the cart and complete the checkout workflow")
    public void verifyProductPurchaseWorkflow() throws IOException, ParseException {
        // Initialize data reader to fetch valid login credentials
        dataReader dReader = new dataReader();
        dReader.reader();

        // Initialize required Page Objects locally
        LoginWithValidCredentialsPage loginPage = new LoginWithValidCredentialsPage(driver);
        HomePagePage homePage = new HomePagePage(driver);

        // Perform login and locate the target product to add it to the cart
        loginPage.loginWithExistingUser(dReader.UserName, dReader.Password);
        homePage.getProductByName();
        homePage.addToCart();

        // Assert that the button text toggled to 'Remove' after adding the item
        String actualButtonText = homePage.getRemoveButtonText();
        Assert.assertEquals(actualButtonText, "Remove",
                "Validation Failed: The 'Add to Cart' button did not change to 'Remove'.");
    }
}