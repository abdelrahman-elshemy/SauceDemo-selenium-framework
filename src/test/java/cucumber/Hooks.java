package cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

/**
 * Cucumber Hooks class managing browser lifecycle actions (Setup and Teardown)
 * by initializing and terminating the globally shared WebDriver context.
 */
public class Hooks extends CucumberBase {

    protected Properties prop;
    protected FileInputStream file;
    protected ChromeOptions options;
    protected EdgeOptions edgeOptions;

    // Initializes configuration settings and launches the target browser before each dynamic scenario
    @Before
    public void beforeScenario() throws IOException {
        System.out.println("Starting new scenario...");

        prop = new Properties();
        file = new FileInputStream("src/test/resources/config.properties");
        prop.load(file);

        // Prioritize terminal configuration parameters over the configuration properties file
        String browserName = System.getProperty("browser");
        if (browserName == null) {
            browserName = prop.getProperty("browser");
        }

        switch (browserName) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "chrome-headless":
                options = new ChromeOptions();
                options.addArguments("--headless=new");
                driver = new ChromeDriver(options);
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "edge-headless":
                edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=new");
                driver = new EdgeDriver(edgeOptions);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("The provided browser name not supported " + browserName);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
    }

    // Safely disposes and terminates the active WebDriver session after scenario execution completes
    @After
    public void afterScenario() {
        System.out.println("Ending scenario...");
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println("Error during tearDown: " + e.getMessage());
        }
    }
}