@mobil
Feature: How to automation login User

  @
  Scenario Outline:
    Given user click button sign in
    When select to account <user>
    Then visuality view song music
  Examples:
    | user     |
    | estudios |
