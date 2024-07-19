@mobil
Feature: How to automation login User app
  Background:
    Given user turn notification OK

  @loginAppFormal
  Scenario Outline:
    Given user click button sign in  <login>
    When enter form <email> and <password>
    Then visuality a validation booking
    Examples:
      | login               | email              | password |
      | Continue with email | himalaya@gmail.com | 123456   |

  @loginAppGmail
  Scenario Outline:
    Given user click button sign in  <login>
    When select account gmail <email>
    Then visuality a validation booking
    Examples:
      | login                | email                |  |
      | Continue with Google | testng97@gmail.com |  |

  @loginAppFacebook
  Scenario Outline:
    Given user click button sign in  <login>
    When enter field <email> and <password> facebook
    Then visuality a validation booking

    Examples:
      | login                  | email             | password |
      | Continue with Facebook | example@gmail.com | 123456   |
