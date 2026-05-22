@CheckOutFeature
Feature: CheckOut Functionality
  As a user
  I want to add item to cart and checkout
  So that I can buy an item

  # Common prerequisite steps executed before each scenario in this feature file
  Background:
    Given the user is on the SauceDemo login page

  # End-to-end user journey using dynamic data injection from the Examples table
  @ValidLogin
  Scenario Outline: End to end checkout process
    When User enters "<name>" and "<password>"
    And clicks on the login button
    Then System should log the user in and the dashboard appears
    And user gets the product by name
    And user adds the product to cart
    Then the "Add to Cart" button should change to "Remove"
    And user continue to checkout and writes the "<first name>", "<last name>" and "<zip code>" then checkout done

    # Test Data Driven table providing variables for the Scenario Outline fields
    Examples:
      | name          | password     | first name  | last name | zip code |
      | standard_user | secret_sauce | Abdelrahman | Elshemy   | 12345    |