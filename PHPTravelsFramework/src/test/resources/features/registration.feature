Feature: PHPTravels User Registration Module
  # Question 2 – User Registration Automation
  # Covers: mandatory fields, dropdown, random email, dynamic XPath, explicit wait

  @Regression @Registration
  Scenario Outline: Validate User Registration with different countries
    Given user launches browser
    And user navigates to registration page
    When user fills registration form with valid details for country "<country>"
    And user submits the registration form
    Then user should be registered successfully

    Examples:
      | country |
      | India   |
      | United States |
