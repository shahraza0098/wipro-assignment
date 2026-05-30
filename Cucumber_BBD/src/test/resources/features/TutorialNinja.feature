Feature: Tutorials Ninja Testing
Background:
Given user opens browser

@Smoke
Scenario Outline: Register user
When user registers with valid credential "<firstN>" "<lastN>" "<email1>" "<telephone1>" "<password1>" "<confirmPass1>"
Then registration should be successful

Examples:
|firstN|lastN|email1|telephone1|password1|confirmPass1|
|Shahid|Raza|shr67fdfg723@gmail.com|9091421098|shah123|shah123|

@Smoke
Scenario Outline: Login user
When user logs in with valid credential "<email>" "<pass>"
Then login should be successful

Examples:
|email|pass|
|shahraza21123@gmail.com|shah123|

@Regression
Scenario Outline: Search Product
When user searches "<product>"
Then product should be displayed

Examples:
| product |
| iphone |
| imac |
| tab |
@Regression
Scenario: Add product
When user adds product to cart
Then product should be added to cart
@Regression
Scenario: Remove product
When user removes product
Then product should be removed
@Regression
Scenario: Checkout
When user checkout
Then checkout page should open
@Regression
Scenario: Logout
When user logout
Then logout should be successful