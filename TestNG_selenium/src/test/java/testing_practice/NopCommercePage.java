package testing_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NopCommercePage {

    WebDriver driver;

    public NopCommercePage(WebDriver driver) {
        this.driver = driver;
    }

    // reg
    By register = By.linkText("Register");
    By gender = By.id("gender-male");
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By email = By.id("Email");
    By password = By.id("Password");
    By confirmPassword = By.id("ConfirmPassword");
    By registerBtn = By.id("register-button");

    // login
    By login = By.linkText("Log in");
    By loginBtn = By.xpath("//input[@value='Log in']");

    // search
    By searchBox = By.id("small-searchterms");

    // add cart
    By giftItem = By.xpath("//input[@value='Add to cart']");
    By recipientName = By.id("giftcard_4_RecipientName");
    By addCartBtn = By.id("add-to-cart-button-4");

    // cart
    By cart = By.id("topcartlink");
    By removeItem = By.name("removefromcart");
    By updateCart = By.name("updatecart");

    // product details
    By product = By.xpath("//img[@title='Show details for Simple Computer']");

    // change name
    By account = By.className("account");



    // reg method
    public void registerUser() {

        driver.findElement(register).click();

        driver.findElement(gender).click();

        driver.findElement(firstName).sendKeys("Shahid");

        driver.findElement(lastName).sendKeys("Raza");

        driver.findElement(email).sendKeys("shahid123@gmail.com");

        driver.findElement(password).sendKeys("shahid123");

        driver.findElement(confirmPassword).sendKeys("shahid123");

        driver.findElement(registerBtn).click();
    }


    //login method
    public void loginUser(String mail,String pass){

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
          "https://demowebshop.tricentis.com/search?q=gift");

        driver.findElement(giftItem).click();

        driver.findElement(recipientName).sendKeys("xyz");

        driver.findElement(addCartBtn).click();
    }


    // product details
    public void productDetails(){

        driver.navigate().to("https://demowebshop.tricentis.com/");

        driver.findElement(product).click();
    }



    // delete item
    public void deleteCartItem(){

        driver.findElement(cart).click();

        driver.findElement(removeItem).click();

        driver.findElement(updateCart)
                .click();
    }



    // change name
    public void changeName(){

        driver.navigate().to( "https://demowebshop.tricentis.com/customer/info");

        WebElement fName=driver.findElement(firstName);

        fName.sendKeys(Keys.CONTROL,"a");
        fName.sendKeys(Keys.BACK_SPACE);

        fName.sendKeys("New");



        WebElement lName= driver.findElement(lastName);

        lName.sendKeys(Keys.CONTROL,"a");
        lName.sendKeys(Keys.BACK_SPACE);

        lName.sendKeys("Changed");
    }

}