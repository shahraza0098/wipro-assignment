package stepdefinitions;

import java.util.List;

import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.ExcelUtils;

public class InvalidLoginSteps {

    LoginPage loginPage =
            new LoginPage(Hooks.driver);

    @When("User logs in with invalid credentials")
    public void user_logs_in_with_invalid_credentials() throws InterruptedException {

    	
    	   String filePath =
                   "src/test/resources/testdata/loginData.xlsx";

           List<String[]> loginData =
                   ExcelUtils.getLoginData(
                           filePath,
                           "Sheet1");

        

           for (String[] row : loginData) {

               String username = row[0];
               String password = row[1];

               System.out.println(
                       "Testing -> "
                       + username
                       + " | "
                       + password);

               loginPage.loginToApplication(
                       username,
                       password);
               Thread.sleep(2000);
               
               Hooks.driver.switchTo().alert().accept();
               
//               String alertText = Hooks.driver.switchTo()
//                       .alert()
//                       .getText();
//
//System.out.println("Alert Message: " + alertText);

           
           }
    	
    	
    
    }

    @Then("Invalid login alert should be displayed")
    public void invalid_login_alert_should_be_displayed() {

       System.out.println("test cases finished");
    }
}