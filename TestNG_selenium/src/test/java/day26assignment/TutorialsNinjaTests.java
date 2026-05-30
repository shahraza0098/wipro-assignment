package day26assignment;

import org.testng.annotations.Test;

import testing_practice.NopCommercePage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TutorialsNinjaTests {
	
	
	
	WebDriver driver;
	TutorialsNinjaPage tn;
	
	
	
	
	
	 @BeforeTest(alwaysRun=true)
	 public void setup(){

	        driver=new ChromeDriver();

	        driver.manage().window().maximize();

	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	        driver.get("https://tutorialsninja.com/demo/");

	        tn=new TutorialsNinjaPage(driver);
	    }
	 
	 
	 
	 @DataProvider
	  public Object[][] reg() {
	    return new Object[][] {
	    	{"Shahid","Raza","shahraza20123@gmail.com","9091421098","shah123","shah123"},
//	    	{"Raj","Aryan","rajaryan6723@gmail.com","9067221098","raj123","raj123"}
	    };
	  }
	 
	 @DataProvider
	 public Object[][] ProductNameData(){
		 return new Object[][] {
		    	{"iphone"},
		    	{"imac"},
		    	{"tab"}
		    };
	 }
  @Test(dataProvider = "reg", groups="regression")
  public void register(String firstN, String lastN, String email1,String  telephone1, String password1, String confirmPass1) {
	 tn.registerUser(firstN, lastN, email1, telephone1, password1, confirmPass1);
  }
  
  
  @Test(groups="regression")
  public void login() {
	  tn.loginUser("shahraza21123@gmail.com", "shah123");
  }
  @Test(dataProvider = "ProductNameData", groups="smoke", priority=2)
  public void searchProductByName(String prodcName) {
	  tn.searchProduct(prodcName);
  }

  @Test(groups="smoke", priority=2)
  public void addToCart() {
	  tn.addToCart();
  }
  @Test(groups="smoke", priority=3)
 public void removeItemFromCart() {
	 tn.deleteCartItem();
 }
 
  @Test(groups="smoke",  priority=4)
 public void checkoutFunction() {
	 tn.checkout();
 }
  @Test(groups="smoke",  priority=5)
 public void logoutFunc() {
	 tn.logout();
 }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.close();
  }

}
