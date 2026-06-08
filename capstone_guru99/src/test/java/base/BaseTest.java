package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.LoginPage;

public class BaseTest {

    protected WebDriver driver;

    protected LoginPage loginPage;

    @BeforeMethod
    public void setup() {

        driver = DriverFactory.initDriver();

        driver.get("https://demo.guru99.com/V4/");
        

        loginPage = new LoginPage(driver);
    }

    protected void loginToApplication(String username,
                                      String password) {

        loginPage.enterUsername(username);

        loginPage.enterPassword(password);
        
        if(password.equalsIgnoreCase("")) {
        	 loginPage.clickLogin();
        }

        loginPage.clickLogin();
    }


    @AfterMethod
    public void tearDown() {
    	System.out.println("test completed");
//        DriverFactory.quitDriver();
    }
}