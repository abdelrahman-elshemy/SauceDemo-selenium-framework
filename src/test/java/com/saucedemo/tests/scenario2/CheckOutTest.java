package com.saucedemo.tests.scenario2;

import com.saucedemo.pages.scenario1.LoginWithValidCredentialsPage;
import com.saucedemo.pages.scenario2.CheckoutPage;
import com.saucedemo.pages.scenario2.HomePagePage;
import com.saucedemo.tests.BaseTest;
import data.dataReader;
import listeners.RetryAnalyzer;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

/**
 * Test Scenario 2: End-to-End workflow validating Login, Adding to Cart, and Checkout completion.
 */
public class CheckOutTest extends BaseTest {

    // Declared at class level so initialized pages can persist across methods if needed
    private LoginWithValidCredentialsPage loginPage;
    private HomePagePage homePage;
    private CheckoutPage checkoutPage;
    private dataReader dReader;

    @Test(description = "Step 1: Verify user can login successfully", retryAnalyzer = RetryAnalyzer.class)
    public void loginTest() throws IOException, ParseException {
        // Parse data and perform login flow
        dReader = new dataReader();
        dReader.reader();
        loginPage = new LoginWithValidCredentialsPage(driver);
        loginPage.loginWithExistingUser(dReader.UserName, dReader.Password);

        // Quick validation to ensure login completed before moving forward
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                "Login Failed: User was not redirected to the inventory page.");
    }

    @Test(
            description = "Step 2: Verify user can add a product to the cart",
            dependsOnMethods = {"loginTest"},
            retryAnalyzer = RetryAnalyzer.class
    )
    public void addToCartTest() {
        // Locate target product and add it to the cart
        homePage = new HomePagePage(driver);
        homePage.getProductByName();
        homePage.addToCart();

        // Validate button text change to ensure item is in the cart
        Assert.assertEquals(homePage.getRemoveButtonText(), "Remove",
                "Cart Error: The button did not toggle to 'Remove'.");
    }

    @Test(
            description = "Step 3: Verify user can complete the checkout workflow",
            dependsOnMethods = {"addToCartTest"},
            retryAnalyzer = RetryAnalyzer.class
    )
    public void checkoutTest() throws IOException, ParseException {
        // Parse shipping data and execute the purchase workflow
        dReader = new dataReader();
        dReader.reader();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.purchaseProductWorkflow(dReader.firstName, dReader.lastName, dReader.postalCode);

        // Verify the final order confirmation label
        String actualLabelText = checkoutPage.completeLabel();
        Assert.assertEquals(actualLabelText, "Complete",
                "Validation Failed: Checkout incomplete. Confirmation label 'Complete' not found.");
    }
}