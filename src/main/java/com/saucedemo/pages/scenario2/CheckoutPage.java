package com.saucedemo.pages.scenario2;

import com.saucedemo.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Model for the Checkout process, handling cart review to order completion.
 */
public class CheckoutPage extends BasePage {

    // Locators for Checkout and Shipping Info Elements
    private final By cartIconBtn = By.className("shopping_cart_badge");
    private final By checkoutBtn = By.id("checkout");
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By continueBtn = By.id("continue");
    private final By infoLabel = By.className("summary_value_label");
    private final By finishBtn = By.id("finish");
    private final By completeLabel = By.className("title");

    // Constructor to initialize the WebDriver and pass it to the BasePage
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    // Click on the shopping cart badge/icon
    public void ClickOnCartIconBtn() {
        click(cartIconBtn);
    }

    // Click on the checkout button to start the shipping process
    public void ClickOnCheckOutBtn() {
        click(checkoutBtn);
    }

    // Enter first name into the shipping information form
    public void enterFirstName(String firstName) {
        type(firstNameField, firstName);
    }

    // Enter last name into the shipping information form
    public void enterLastName(String lastName) {
        type(lastNameField, lastName);
    }

    // Enter postal code into the shipping information form
    public void enterPostalCode(String postalCode) {
        type(postalCodeField, postalCode);
    }

    // Click continue to proceed to the order overview page
    public void ClickOnContinueBtn() {
        click(continueBtn);
    }

    // Extract and parse the Payment ID number from the summary label
    public String paymentId() {
        return getElement(infoLabel).getText().split("#")[1];
    }

    // Click finish to finalize the purchase order
    public void ClickOnFinishBtn() {
        click(finishBtn);
    }

    // Extract and clean the order completion success message text
    public String completeLabel() {
        return getElement(completeLabel).getText().split(":")[1].trim().split("!")[0];
    }

    // High-level workflow that orchestrates the entire checkout and purchase flow
    public void purchaseProductWorkflow(String fName, String lName, String postalCode) {
        // 1. Open cart and initiate checkout
        ClickOnCartIconBtn();
        ClickOnCheckOutBtn();

        // 2. Fill in shipping information and proceed
        enterFirstName(fName);
        enterLastName(lName);
        enterPostalCode(postalCode);
        ClickOnContinueBtn();

        // 3. Log the generated payment ID for debugging/tracking
        System.out.println("✔ تم توليد رقم الشراء بنجاح:" + paymentId());

        // 4. Finalize the order
        ClickOnFinishBtn();

        // 5. Get the final confirmation status text
        completeLabel();
    }
}