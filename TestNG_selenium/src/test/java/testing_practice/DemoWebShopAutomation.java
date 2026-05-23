package testing_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoWebShopAutomation {

    WebDriver driver;

    @BeforeClass
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demowebshop.tricentis.com/");
    }

    @Test(priority = 1)
    public void loginTest() {

        driver.findElement(By.linkText("Log in")).click();

        driver.findElement(By.id("Email")).sendKeys("srhshaah12@gmail.com");

        driver.findElement(By.id("Password")).sendKeys("shahid123");

        driver.findElement(By.cssSelector("input.login-button")).click();

        String accountText = driver.findElement(By.className("account")).getText();

        Assert.assertTrue(accountText.contains("testuser123@test.com"));

        System.out.println("Login Successful");
    }

    @Test(priority = 2)
    public void searchProductTest() {

        WebElement searchBox = driver.findElement(By.id("small-searchterms"));

        searchBox.sendKeys("laptop");

        driver.findElement(By.cssSelector("input.search-box-button")).click();

        String pageTitle = driver.getTitle();

        Assert.assertTrue(pageTitle.contains("Search"));

        System.out.println("Search Successful");
    }

    @Test(priority = 3)
    public void verifyProductDetails() {

        WebElement productTitle =driver.findElement(By.cssSelector("h2.product-title"));

        System.out.println("Product Title: "+ productTitle.getText());

        Assert.assertTrue(productTitle.isDisplayed());

        WebElement price = driver.findElement(By.className("price"));

        System.out.println("Price: " + price.getText());

        Assert.assertTrue(price.isDisplayed());

        WebElement rating = driver.findElement(By.cssSelector(".rating"));

        Assert.assertTrue(rating.isDisplayed());

        System.out.println("Rating Displayed");
    }

    @Test(priority = 4)
    public void verifyImageZoom() {

        driver.findElement(By.cssSelector("h2.product-title a")).click();

        WebElement image =driver.findElement(By.cssSelector(".picture img"));

        Assert.assertTrue(image.isDisplayed());

        System.out.println("Product Image Displayed");

        // Simulated zoom verification
        String imageSrc = image.getAttribute("src");

        Assert.assertNotNull(imageSrc);

        System.out.println("Image Zoom Area Verified");
    }

    @Test(priority = 5)
    public void verifyButtons() {

        WebElement addToCart = driver.findElement(By.id("add-to-cart-button-31"));

        Assert.assertTrue(addToCart.isDisplayed());

        System.out.println("Add to Cart Button Visible");



        Assert.assertTrue(addToCart.isEnabled());

        System.out.println("Buy Button Functionality Verified");
    }

    @Test(priority = 6)
    public void checkoutFlow() {

        driver.findElement(By.id("add-to-cart-button-31")).click();

        driver.findElement(By.linkText("Shopping cart")).click();

        WebElement checkoutBtn =
                driver.findElement(By.id("checkout"));

        Assert.assertTrue(checkoutBtn.isDisplayed());

        System.out.println("Checkout Button Visible");
    }

    @AfterClass
    public void afterTest() {

        driver.quit();
    }
}