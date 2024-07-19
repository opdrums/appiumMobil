@mobil
Feature: how to automation wants to buy
  Background:
    Given user turn notification OK

  @buy
  Scenario Outline:
    Given user click button sign in  <login>
    When select account gmail <email>
    Given select <city> as destination
    And select date  <dateOrigen> and <dateDestination>
    And select to count <count>  rooms and guest and children
    Then visuality properties
    Examples:
      | login                | email              | city   | dateOrigen   | dateDestination | count |  |
      | Continue with Google | testng97@gmail.com | Bogotá | 22 July 2024 | 31 July 2024    | 2     |  |
    
