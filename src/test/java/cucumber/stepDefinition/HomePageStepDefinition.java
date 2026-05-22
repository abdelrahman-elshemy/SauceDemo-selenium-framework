package cucumber.stepDefinition;

import com.saucedemo.pages.scenario1.LoginWithValidCredentialsPage;
import com.saucedemo.pages.scenario2.HomePagePage;
import cucumber.CucumberBase;
import cucumber.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

/**
 * Step Definition class handling product search, selection, and homepage assertions.
 */
public class HomePageStepDefinition extends CucumberBase {

    // Initialize the HomePage Page Object and locate the target product dynamically
    @When("user gets the product by name")
    public void user_gets_the_product_by_name() {
        homePage = new HomePagePage(driver);
        homePage.getProductByName();
    }

    // Safely verify initialization and trigger the action to add the product to the cart
    @And("user adds the product to cart")
    public void user_adds_the_product_to_cart() {
        if (homePage == null) {
            homePage = new HomePagePage(driver);
        }
        homePage.addToCart();
    }

    // Extract the button text and assert that the action toggled it to 'Remove'
    @Then("the \"Add to Cart\" button should change to \"Remove\"")
    public void the_add_to_cart_button_should_change_to_remove() {
        if (homePage == null) {
            homePage = new HomePagePage(driver);
        }

        String actualButtonText = homePage.getRemoveButtonText();
        Assert.assertEquals(actualButtonText, "Remove",
                "Validation Failed: The 'Add to Cart' button did not change to 'Remove'.");
    }
}