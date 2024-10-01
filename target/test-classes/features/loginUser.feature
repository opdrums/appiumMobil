@mobil
Feature: How to automation login User app
  Background:
    Given user septup country in Colombia

  @loginAppFormal
  Scenario Outline:
    Given select an account in gmail <account>
   # Given user click button sign in  <login>
    #When enter form <email> and <password>
    #Then visuality a validation booking
    Examples:
    | account|
    | testng97@gmail.com|
