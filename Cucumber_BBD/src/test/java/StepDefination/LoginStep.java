package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {

	WebDriver driver;
		

@Given("login page should be open in default browser")
public void login_page_should_be_open_in_default_browser() {
	driver=new ChromeDriver();
    driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
    
    
    }

@When("^click on username field and add valid user (.*)$")
public void click_on_username_field_and_add_valid_user_username(String username1) {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.id("input-email")).sendKeys(username1);
}

@And("^then click on password button and enter valid (.*)$")
public void then_click_on_password_button_and_enter_valid_password(String password1) {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.id("input-password")).sendKeys(password1);
}

@And("now click on submit button")
public void now_click_on_submit_button() {
    // Write code here that turns the phrase above into concrete actions
	 driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
}

@Then("login successfully and redirect to home page")
public void login_successfully_and_redirect_to_home_page() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("login success");
}

	

}
