@udemy
Feature: Login into account
| In order to Login into the account
| As an existing user
| I want the system to validate the input of user credentials

  Scenario: Login into account with valid credentials - Chrome
    Given User navigates to WebDriverUniversity website
    And User clicks on the Login option
    And User enters a valid username
    And User enters a valid password
    When User clicks on the Login button
    Then User should be shown login success message