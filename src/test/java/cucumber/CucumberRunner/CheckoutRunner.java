package cucumber.CucumberRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Cucumber TestNG Runner configuration to map features, steps, and reporting plugins.
 */
@CucumberOptions(
        features = "src/test/java/cucumber/features/Checkout.feature",
        glue = {"cucumber.stepDefinition", "cucumber"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class CheckoutRunner extends AbstractTestNGCucumberTests {
    // Inherits TestNG lifecycle to execute Cucumber features as standard TestNG tests
}