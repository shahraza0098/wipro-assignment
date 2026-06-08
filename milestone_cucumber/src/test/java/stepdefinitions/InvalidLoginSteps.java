package stepdefinitions;

import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class InvalidLoginSteps {

    LoginPage loginPage =
            new LoginPage(Hooks.driver);

    @When("User logs in with invalid credentials {string} and {string}")
    public void user_logs_in_with_invalid_credentials(
            String username,
            String password) {

        loginPage.loginToApplication(
                username,
                password);
    }

    @Then("Invalid login alert should be displayed")
    public void invalid_login_alert_should_be_displayed() {

        Assert.assertTrue(
                loginPage.isInvalidLoginAlertPresent(),
                "Invalid login alert was not displayed");
    }
}