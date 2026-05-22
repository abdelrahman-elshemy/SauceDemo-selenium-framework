package cucumber.CucumberRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Cucumber TestNG Runner configuration specifically for the HomePage feature and reporting.
 */
@CucumberOptions(
        features = "src/test/java/cucumber/features/HomePage.feature",
        glue = {"cucumber.stepDefinition", "cucumber"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class HomePageRunner extends AbstractTestNGCucumberTests {
    // Inherits TestNG lifecycle to execute Cucumber features as standard TestNG tests
}