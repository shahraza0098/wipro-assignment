Feature: E-Commerce End To End Flow

Background:
Given user opens browser

@Smoke
Scenario Outline: Complete E-Commerce Flow

When user logs in using excel data "<rownum>"
And user searches "<product>"
And user applies filter
And user adds multiple products to cart
And user removes one product
Then total amount should be validated
When user proceeds to checkout
And user logout
Then logout should be successful

Examples:
| rownum | product |
| 1      | iphone  |