Feature: verify Login functionality
Scenario Outline: Verify user is able to login with different credentials
Given login page should be open in default browser
When click on username field and add valid user <username1>
And then click on password button and enter valid <password1>
And now click on submit button
Then login successfully and redirect to home page


Examples:
|username1|password1|status|
|shahraza21123@gmail.com|shah123|pass|
|shas@gmail.com|shah123|fail|
|shahraza21123@gmail.com|asdj7|fail|
|dsajin|asudj8|fail|