package com.saucedemo.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import utilities.Helper;

/**
 * BaseTest manages WebDriver lifecycle, framework configurations,
 * and global test execution hooks (Setup, Teardown, Screenshots).
 */
public class BaseTest {

    protected WebDriver driver;
    protected Properties prop;
    protected FileInputStream file;
    protected ChromeOptions options;
    protected EdgeOptions edgeOptions;

    // Set up configuration properties, initialize the specified browser, and navigate to base URL
    @BeforeClass
    public void setUp() throws IOException {
        prop = new Properties();
        file = new FileInputStream("src/test/resources/config.properties");
        prop.load(file);

        // Prioritize browser parameter passed via CLI/Terminal over config file properties
        String browserName = System.getProperty("browser");
        if (browserName == null) {
            browserName = prop.getProperty("browser");
        }

        // Initialize the appropriate driver instance based on the target browser name
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

    // Terminate the WebDriver session safely to release resources after all class tests finish
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Automatically capture a screenshot whenever a test method execution results in a failure
    @AfterMethod
    public void takeScreenShot(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed!");
            System.out.println("TAKING Screenshot .....");
            Helper.captureScreenshot(driver, result.getName());
        }
    }
}