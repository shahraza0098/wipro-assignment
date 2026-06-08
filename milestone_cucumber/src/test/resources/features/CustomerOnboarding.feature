Feature: Customer Onboarding

Scenario: Create Customer and Account

Given User launches application

When User logs in with valid credentials

And User navigates to New Customer page

And User creates a new customer

And User captures customer id

And User navigates to New Account page

And User creates account using customer id

Then Account should be created successfully