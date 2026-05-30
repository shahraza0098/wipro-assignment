package StepDefination;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TutorialsNinjaPage;

public class TutorialsNinjaSteps {

	 TutorialsNinjaPage tn=
	            new TutorialsNinjaPage(Hooks.driver);
    
    @Given("user opens browser")
    public void user_opens_browser() {
    	System.out.println("browser open");
    }

  

    @When("^user registers with valid credential (.*) (.*) (.*) (.*) (.*) (.*)$")
    public void register(String firstN,
                         String lastN,
                         String email1,
                         String telephone1,
                         String password1,
                         String confirmPass1){

        tn.registerUser(firstN,lastN,email1,
                telephone1,password1,confirmPass1);
    }
    @Then("registration should be successful")
    public void regSuccess() {

        System.out.println("Registration success");
    }



    @When("^user logs in with valid credential (.*) (.*)$")
    public void login(String email,String pass){

        tn.loginUser(email,pass);
    }

    @Then("login should be successful")
    public void loginSuccess() {

        System.out.println("Login successful");
    }
    @When("^user searches (.*)$")
    public void search(String product){

        tn.searchProduct(product);
    }
    @Then("product should be displayed")
    public void productDisplay() {

        System.out.println("Product displayed");
    }

    @When("user adds product to cart")
    public void cart(){
   
        tn.addToCart();
    }
    @Then("product should be added to cart")
    public void addSuccess() {

        System.out.println("Added to cart");
    }
    

    @When("user removes product")
    public void remove(){

        tn.deleteCartItem();
    }
    @Then("product should be removed")
    public void removeSuccess() {

        System.out.println("Removed from cart");
    }


    @When("user checkout")
    public void checkout(){
    	
        tn.checkout();
    }
    @Then("checkout page should open")
    public void checkoutSuccess() {

        System.out.println("Checkout page opened");
    }


    @When("user logout")
    public void logout(){
    
        tn.logout();
    }
    @Then("logout should be successful")
    public void logoutSuccess() {

        System.out.println("Logout successful");
    }

}