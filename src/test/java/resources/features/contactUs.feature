Feature: Submit data to webdriveruniversity.com using contact us form

  Scenario: Submit valid data via contact us form
    Given I access webdriveruniversity contact us form
    And I enter the valid firstname
    And I enter  the valid last name
      |  woods  |  jackson  |  jones  |
    And I enter a valid email address
    And I enter comments
      | example comment 1  |  example comment 2  |
    When I click on submit button
    Then the information should successfully be submitted via the contact form

