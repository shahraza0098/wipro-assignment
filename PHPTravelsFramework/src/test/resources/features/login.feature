Feature: PHPTravels Login Module
  # Question 1 – Login Module Automation
  # Tests: Valid login, Invalid login, Blank username, Blank password
  # Data read from Excel | Screenshots on failure | Extent Report logs

  @Smoke @Regression
  Scenario Outline: Validate Login Functionality
    Given user launches browser
    When user enters "<username>" and "<password>"
    And clicks on login button
    Then validate login result

    Examples:
      | username                | password  |
      | user@phptravels.com     | demouser  |
      | invalid@gmail.com       | invalid   |
      |                         | demouser  |
      | user@phptravels.com     |           |
