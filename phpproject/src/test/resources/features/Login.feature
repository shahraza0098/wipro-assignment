Feature: Login Module

@Smoke
Scenario: Valid Login

Given user launches browser
When user enters credentials from excel row 1
And clicks on login button
Then validate login result

@Regression
Scenario: Invalid Login

Given user launches browser
When user enters credentials from excel row 2
And clicks on login button
Then validate login result