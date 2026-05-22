package cucumber.CucumberRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Cucumber TestNG Runner configuration specifically for the Login with valid credentials feature.
 */
@CucumberOptions(
        features = "src/test/java/cucumber/features/LoginWithValidCredentials.feature",
        glue = {"cucumber.stepDefinition", "cucumber"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class LoginWithValidCredentialsRunner extends AbstractTestNGCucumberTests {
    // Inherits TestNG lifecycle to execute Cucumber features as standard TestNG tests
}