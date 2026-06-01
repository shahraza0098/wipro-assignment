Feature: Booking

Scenario: Complete Booking Flow

Given user is logged in
When user searches hotel
And user selects hotel
And user completes booking
Then booking confirmation should display