package cucumber;

import com.saucedemo.pages.scenario1.LoginWithValidCredentialsPage;
import com.saucedemo.pages.scenario2.CheckoutPage;
import com.saucedemo.pages.scenario2.HomePagePage;
import org.openqa.selenium.WebDriver;

/**
 * CucumberBase acts as a central context share layer, holding the shared
 * static WebDriver and Page Object instances across multiple Step Definitions.
 */
public class CucumberBase {

    // Shared static driver to maintain the same browser session throughout the execution lifecycle
    protected static WebDriver driver;

    // Page Object instances shared globally across BDD step definitions
    public LoginWithValidCredentialsPage loginPage;
    public HomePagePage homePage;
    public CheckoutPage checkoutPage;
}