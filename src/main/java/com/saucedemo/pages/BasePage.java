package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * BasePage serves as the parent class for all Page Objects,
 * encapsulating common Selenium actions and synchronization wrappers.
 */
public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    // Initialize WebDriver and set up a global Explicit Wait timeout
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Wait for an element to be visible before locating and returning it
    protected WebElement getElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    // Wait for the element to be visible and click on it
    protected void click(By locator) {
        getElement(locator).click();
    }

    // Fluent explicit wait utility to sync up with a specific WebElement
    protected void waitUntilExpectedElementToAppear(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for the field, clear existing text, and safely simulate typing
    protected void type(By locator, String text) {
        WebElement element = getElement(locator);
        element.clear();
        element.sendKeys(text);
    }
}