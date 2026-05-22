package cucumber.stepDefinition;

import com.saucedemo.pages.scenario1.LoginWithValidCredentialsPage;
import cucumber.CucumberBase;
import cucumber.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

/**
 * Step Definition class handling authentication actions and initial page setup.
 */
public class LoginStepDefinition extends CucumberBase {

    // Initialize the Login Page Object using the shared driver instance
    @Given("the user is on the SauceDemo login page")
    public void the_user_is_on_the_SauceDemo_login_page() {
        loginPage = new LoginWithValidCredentialsPage(driver);
    }

    // Input credentials injected dynamically from the Gherkin Feature file
    @When("User enters {string} and {string}")
    public void When_User_enters_username_and_password(String userName, String password) {
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
    }

    // Trigger the login form submission
    @And("clicks on the login button")
    public void clicks_on_the_login_button() {
        loginPage.clickOnLoginBtn();
    }

    // Assert that the user successfully logs in by checking the dashboard visibility
    @Then("System should log the user in and the dashboard appears")
    public void System_should_log_the_user_in_and_the_dashboard_appears() {
        Assert.assertTrue(loginPage.isLoginSuccess(),
                "Login Failed: Product header is not visible after the login");
    }
}