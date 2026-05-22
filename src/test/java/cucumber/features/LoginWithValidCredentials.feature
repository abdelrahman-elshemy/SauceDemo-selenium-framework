@FeatureTag
Feature: login with valid credentials
  As a user
  I want to login with valid credentials
  So that I can buy an item

  # Common prerequisite step to ensure the browser is on the landing page
  Background: Navigate to login page
    Given the user is on the SauceDemo login page

  # Positive testing scenario to verify successful authorization using valid accounts
  @Checkout
  Scenario Outline: login with valid credentials
    When User enters "<name>" and "<password>"
    And clicks on the login button
    Then System should log the user in and the dashboard appears

    # Data matrix used to feed usernames and passwords into the scenario parameters
    Examples:
      | name          | password     |
      | standard_user | secret_sauce |