package testing_practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

//import testing_prsactice.NopCommercePage;

public class NopCommerceTest {

    WebDriver driver;
    NopCommercePage np;


    @BeforeTest
    public void setup(){

        driver=new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://demowebshop.tricentis.com/");

        np=new NopCommercePage(driver);
    }



    @Test(priority=1)
    public void registrationTest(){

        np.registerUser();
    }



    @Test(priority=2)
    public void loginTest(){

        np.loginUser("shahid123@gmail.com", "shahid123");
    }



    @Test(priority=3)
    public void multipleSearchTest(){

        np.searchProduct("Laptop");

        np.searchProduct("Gift");

        np.searchProduct("Camera");
    }



    @Test(priority=4)
    public void addToCartTest(){

        np.addToCart();
    }



    @Test(priority=5)
    public void productDetailsTest(){

        np.productDetails();
    }



    @Test(priority=6)
    public void deleteCartItemTest(){

        np.deleteCartItem();
    }



    @Test(priority=7)
    public void changeNameTest(){

        np.changeName();
    }



    @AfterTest
    public void closeBrowser(){

        driver.quit();
    }

}