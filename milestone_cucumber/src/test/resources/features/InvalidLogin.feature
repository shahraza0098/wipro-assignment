Feature: Invalid Login Test 

Scenario Outline: Invalid Login

Given User launches application
When User logs in with invalid credentials "<username>" and "<password>"
Then Invalid login alert should be displayed

Examples:
| username | password |
| user2    | pass2    |
| user3    | pass3    |