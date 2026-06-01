package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import reports.ExtentReportManager;

/**
 * Question 1 – Login Step Definitions
 * Implements all Cucumber steps for the Login feature.
 * Question 15 – Advanced Assertions (Hard + Soft Assert)
 */
public class LoginSteps {

    private LoginPage loginPage;
    private SoftAssert softAssert;    // Soft assert: continues even after failure
    private String currentUsername;
    private String currentPassword;

    @Given("user launches browser")
    public void user_launches_browser() {
        loginPage = new LoginPage();
        softAssert = new SoftAssert();
        loginPage.navigateToLogin();
        ExtentReportManager.getTest().info("Browser launched and navigated to: " + loginPage.getCurrentUrl());
        System.out.println("Browser launched successfully.");
    }

    @When("user enters {string} and {string}")
    public void user_enters_username_and_password(String username, String password) {
        this.currentUsername = username;
        this.currentPassword = password;
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        ExtentReportManager.getTest().info(
            "Entered Username: [" + username + "], Password: [" + (password.isEmpty() ? "BLANK" : "***") + "]"
        );
    }

    @And("clicks on login button")
    public void clicks_on_login_button() {
        loginPage.clickLoginButton();
        ExtentReportManager.getTest().info("Clicked on Login button.");
    }

    @Then("validate login result")
    public void validate_login_result() {
        boolean validCredentials = isValidCredential(currentUsername, currentPassword);

        if (validCredentials) {
            // Hard Assert for valid login – we MUST pass
            boolean isLoggedIn = loginPage.isLoginSuccessful();

            // Question 15 – Soft Assert on URL
            softAssert.assertTrue(
                loginPage.getCurrentUrl().contains("account") || loginPage.getCurrentUrl().contains("dashboard"),
                "URL should contain 'account' or 'dashboard' after successful login"
            );

            // Question 15 – Soft Assert on Page Title
            softAssert.assertFalse(
                loginPage.getPageTitle().toLowerCase().contains("login"),
                "Page title should NOT contain 'login' after successful login"
            );

            softAssert.assertAll(); // Run all soft assertions

            // Hard Assert: login must succeed for valid credentials
            org.testng.Assert.assertTrue(isLoggedIn, "Login should succeed for valid credentials");
            ExtentReportManager.getTest().pass("Valid login successful. URL: " + loginPage.getCurrentUrl());

        } else {
            // Invalid login – expect error or stay on login page
            boolean isError = loginPage.isErrorDisplayed();
            boolean stayedOnLoginPage = loginPage.getCurrentUrl().contains("login");

            // Soft Assert: either error shows OR URL still contains 'login'
            softAssert.assertTrue(
                isError || stayedOnLoginPage,
                "Should show error or remain on login page for invalid credentials"
            );

            // Question 15 – Assert page title still contains login
            softAssert.assertTrue(
                loginPage.getPageTitle().toLowerCase().contains("login") || stayedOnLoginPage,
                "Page should remain on login page for invalid credentials"
            );

            softAssert.assertAll();
            ExtentReportManager.getTest().pass(
                "Invalid login correctly rejected. Error shown: " + isError + " | URL: " + loginPage.getCurrentUrl()
            );
        }
    }

    /**
     * Determines if the given username/password combination is expected to be valid.
     */
    private boolean isValidCredential(String username, String password) {
        if (username == null || username.isEmpty()) return false;
        if (password == null || password.isEmpty()) return false;
        return username.equals("user@phptravels.com") && password.equals("demouser");
    }
}
