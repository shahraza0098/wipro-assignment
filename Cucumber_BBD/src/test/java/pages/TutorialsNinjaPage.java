package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TutorialsNinjaPage {
	
	
	
	WebDriver driver;

    public TutorialsNinjaPage(WebDriver driver) {
        this.driver = driver;
    }
    
 // reg
    By register = By.linkText("Register");
    By gender = By.id("gender-male");
    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By telephone=By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPassword = By.id("input-confirm");
    By agreeCheck=By.cssSelector("input[name='agree']");
    By registerBtn = By.cssSelector("input.btn[value=\'Continue\']");
    
    
    // login
    By login = By.linkText("Login");
    By loginBtn = By.cssSelector("//input[value=\"Login\"]");

    // search
    By searchBox = By.cssSelector("input[name='search']");

    // add cart
    By addtocart = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]");
   
   

    // cart
    By cart = By.cssSelector("a[href=\"https://tutorialsninja.com/demo/index.php?route=checkout/cart\"]");
    By removeItem = By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[2]");
    By updateCart = By.name("updatecart");
    
    //checkout
    
    By checkoutBtn=By.linkText("Checkout");

    // product details
    By product = By.xpath("//img[@title='Show details for Simple Computer']");

    // change name
    By account = By.className("account");
    
    //logout tbtn
    By logoutbtn=By.linkText("Logout");
    
 // reg method
    public void registerUser(String firstN, String lastN, String email1,String  telephone1, String password1, String confirmPass1) {
    	driver.findElement( By.xpath("//a[@title='My Account']")).click();
        driver.findElement(register).click();

  

        driver.findElement(firstName).sendKeys(firstN);

        driver.findElement(lastName).sendKeys(lastN);

        driver.findElement(email).sendKeys(email1);
        driver.findElement(telephone).sendKeys(telephone1);

        driver.findElement(password).sendKeys(password1);

        driver.findElement(confirmPassword).sendKeys(confirmPass1);
        
        driver.findElement(agreeCheck).click();
        driver.findElement(registerBtn).click();
    }
    
    
  //login method
    public void loginUser(String mail,String pass){
    	driver.findElement( By.xpath("//a[@title='My Account']")).click();
       
        driver.findElement(login).click();

        driver.findElement(email).sendKeys(mail);

        driver.findElement(password).sendKeys(pass);

        driver.findElement(loginBtn).click();
    }
    
    
    // search method
    public void searchProduct(String productName){

        WebElement search= driver.findElement(searchBox);

        search.clear();

        search.sendKeys(productName);

        search.sendKeys(Keys.ENTER);
    }
    
    
    // add to cart method
    public void addToCart(){

        driver.navigate().to(
          "https://tutorialsninja.com/demo/index.php?route=product/search&search=tab");

        driver.findElement(addtocart).click();

    }
    
    
 // delete item
    public void deleteCartItem(){

        driver.findElement(cart).click();

        driver.findElement(removeItem).click();

//        driver.findElement(updateCart)
//                .click();
    }
    
    
    //checkout
    
    public void checkout() {
    	driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=checkout/cart");
    	driver.findElement(checkoutBtn).click();
    }
    
    
    // log out
    
    public void logout() {
    	driver.findElement( By.xpath("//a[@title='My Account']")).click();
    	driver.findElement(logoutbtn).click();
    }
    
    

    
//  @Test
//  public void f() {
//  }
}
