Feature: Invalid Login Test 

Scenario Outline: Invalid Login

Given User launches application
When User logs in with invalid credentials
Then Invalid login alert should be displayed

