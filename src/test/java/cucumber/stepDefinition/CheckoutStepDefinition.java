package cucumber.stepDefinition;

import com.saucedemo.pages.scenario2.CheckoutPage;
import cucumber.CucumberBase;
import io.cucumber.java.en.And;

/**
 * Step Definition class handling the execution of checkout and purchase business steps.
 */
public class CheckoutStepDefinition extends CucumberBase {

    // Executes the purchase workflow by safely initializing the CheckoutPage if needed
    @And("user continue to checkout and writes the {string}, {string} and {string} then checkout done")
    public void userContinueToCheckoutAndWritesTheAndZipCodeThenCheckoutDone(String Fname, String Lname, String zipCode) throws Throwable {
        if (checkoutPage == null) {
            checkoutPage = new CheckoutPage(driver);
        }

        checkoutPage.purchaseProductWorkflow(Fname, Lname, zipCode);
    }
}