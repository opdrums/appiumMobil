@mobil
Feature: Automate User App Login
  Background:
    Given the user has set up their country in Colombia

  @loginAppFormal
  Scenario Outline: Login success
    Given the user selects a Gmail account <account>
    Then the user should see the home passenger screen
    Examples:
    | account|
    | testng97@gmail.com|

  @logoutUser
  Scenario Outline: successful logout
    Given the user selects a Gmail account <account>
    When the user clicks en el boton account
    Then the user clicks the logout button and should be logged out successfully
    Examples:
      | account|
      | testng97@gmail.com|
