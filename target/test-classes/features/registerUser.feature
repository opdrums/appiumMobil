@mobil
Feature: Automate User App register
  Background:
    Given the user has set up their country in Colombia

  @registerUserSuccessfully
  Scenario Outline: Register succesfully
    Given the user clicks the create Account button
    When fills in the registration form with <email> and <password>
    Then the user should see success register
    Examples:
      | email|password|
      | testng97+3@gmail.com|De_12457|

  @registerUserFaild
  Scenario Outline: Register succesfully incorrect
    Given the user clicks the create Account button
    When fills in the registration form with <email> and <password>
    Then the user should see success register
    Examples:
      | email|password|
      | testng97+3@gmail.com|de_12457|
