@HomePageFeature
Feature: Home Page Functionality
  As a user
  I want to interact with the home page
  So that I can browse and manage products

  # Common prerequisite step executed before running the scenario
  Background:
    Given the user is on the SauceDemo login page

  # Validates the product selection and dynamic button state change on the home page
  @addToCart
  Scenario Outline: add product to cart and validate that the button changes to "Remove"
    When User enters "<name>" and "<password>"
    And clicks on the login button
    Then System should log the user in and the dashboard appears
    And user gets the product by name
    And user adds the product to cart
    Then the "Add to Cart" button should change to "Remove"

    # Test data set used to drive the login and product interaction steps
    Examples:
      | name          | password     |
      | standard_user | secret_sauce |