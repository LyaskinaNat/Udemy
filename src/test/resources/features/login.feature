Feature: Login into account
| In order to Login into the account
| As an existing user
| I want the system to validate the input of user credentials

  Background:
    Given User navigates to WebDriverUniversity website
    And User clicks on the Login option

  @positive
  Scenario: Login into account with valid credentials

    Given User enters a valid username
    And User enters a valid password
    When User clicks on the Login button
    Then User should be shown login success message

  @full_coverage
  Scenario Outline: Login into account with user credentials

    Given User enters "<username>" username
    And User enters "<password>" password
    When User clicks on the Login button
    Then User should be shown login "<message>" message

    Examples:

      |   username     |   password     |   message             |
      |   user1        |   pass1        | validation failed     |
      |   webdriver    |   webdriver123 | validation succeeded  |

