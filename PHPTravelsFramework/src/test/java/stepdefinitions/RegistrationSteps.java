package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.RegistrationPage;
import reports.ExtentReportManager;

/**
 * Question 2 – User Registration Step Definitions
 */
public class RegistrationSteps {

    private RegistrationPage registrationPage;

    @Given("user navigates to registration page")
    public void user_navigates_to_registration_page() {
        registrationPage = new RegistrationPage();
        registrationPage.navigateToRegistration();
        ExtentReportManager.getTest().info("Navigated to registration page.");
    }

    @When("user fills registration form with valid details for country {string}")
    public void user_fills_registration_form(String country) {
        registrationPage.fillRegistrationForm(
            "Test", "Automation",
            "9876543210", "Test@1234",
            country
        );
        ExtentReportManager.getTest().info("Registration form filled. Country: " + country);
    }

    @And("user submits the registration form")
    public void user_submits_registration_form() {
        registrationPage.submitRegistration();
        ExtentReportManager.getTest().info("Registration form submitted.");
    }

    @Then("user should be registered successfully")
    public void user_should_be_registered_successfully() {
        Assert.assertTrue(registrationPage.isRegistrationSuccessful(),
            "Registration should succeed with valid details.");
        ExtentReportManager.getTest().pass("User registered successfully.");
    }
}
