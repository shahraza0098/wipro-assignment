Feature: PHPTravels Hotel Search
  # Question 3 – Hotel Search Automation
  # Question 4 – Dynamic Price Validation

  @Smoke @HotelSearch
  Scenario Outline: Search for hotels and validate results
    Given user launches browser
    And user is on the hotel search page
    When user enters destination "<destination>"
    And user selects check-in date "<checkin>" and check-out date "<checkout>"
    And user selects <travellers> travellers
    And user clicks search button
    Then hotel search results should be displayed
    And available hotels count should be greater than 0

    Examples:
      | destination | checkin    | checkout   | travellers |
      | Dubai       | 2025-08-01 | 2025-08-05 | 2          |
      | London      | 2025-09-10 | 2025-09-15 | 1          |

  @Regression @PriceValidation
  Scenario: Validate dynamic hotel prices
    Given user launches browser
    And user is on the hotel search page
    When user enters destination "Dubai"
    And user selects check-in date "2025-08-01" and check-out date "2025-08-05"
    And user selects 2 travellers
    And user clicks search button
    And user fetches all hotel prices
    Then validate the highest hotel price
    And validate the lowest hotel price
    And validate the average hotel price
    And check for duplicate hotel names

---

Feature: PHPTravels Complete Booking Workflow
  # Question 5 – End-to-End Booking Flow

  @E2E @Booking
  Scenario: Complete end-to-end hotel booking workflow
    Given user launches browser
    And user logs in with valid credentials
    And user is on the hotel search page
    When user enters destination "Dubai"
    And user selects check-in date "2025-08-01" and check-out date "2025-08-05"
    And user selects 2 travellers
    And user clicks search button
    Then hotel search results should be displayed
    When user selects a hotel to book
    And user enters traveller details
    And user confirms the booking
    Then booking confirmation message should be displayed
    And user logs out
