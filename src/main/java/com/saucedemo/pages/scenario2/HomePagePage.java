package com.saucedemo.pages.scenario2;

import com.saucedemo.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

/**
 * HomePage class handles all UI interactions for the main landing page,
 * including product searching and product selection workflows.
 */
public class HomePagePage extends BasePage {

    // Centralized Locators for Product Elements
    private final By productNames = By.xpath("//div[@data-test='inventory-item-name']");
    private final By addToCartBtn = By.xpath("//div[@class='pricebar']/button");
    private final By removeBtn = By.xpath("//div[@class='pricebar']/button");

    // Constructor to initialize WebDriver and pass it to the BasePage
    public HomePagePage(WebDriver driver) {
        super(driver);
    }

    // Dynamic search to locate and return the specific product element using Java Streams
    public WebElement getProductByName() {
        // Fetch all product links dynamically from the current DOM
        List<WebElement> products = driver.findElements(productNames);

        // Isolate the target product element safely using Java Streams
        WebElement desiredProduct = products.stream()
                .filter(product -> product.getText().contains("Bike"))
                .findFirst()
                .orElse(null);

        Assert.assertNotNull(desiredProduct, "Validation Failed: The target product 'Bike' was not found on the page.");
        return desiredProduct;
    }

    // Find the specific product and click its corresponding 'Add to Cart' button
    public void addToCart() {
        getProductByName().findElement(addToCartBtn).click();
    }

    // Extract the text from the button to verify if it changed to 'Remove'
    public String getRemoveButtonText() {
        return getElement(removeBtn).getText();
    }
}