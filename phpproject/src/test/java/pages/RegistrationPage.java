package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstName = By.name("first_name");
    By lastName = By.name("last_name");
    By email = By.name("email");
    By password = By.name("password");
    By confirmPassword = By.name("password_confirmation");
    By securityAnswer = By.xpath("//input[contains(@placeholder,'answer')]");
    By termsCheckbox = By.xpath("//input[@type='checkbox']");
    By createAccountBtn = By.xpath("//button[contains(.,'Create Account')]");

    public void register(String fn,String ln,String mail,
            String pass,String answer) {

        driver.findElement(firstName).sendKeys(fn);
        driver.findElement(lastName).sendKeys(ln);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(pass);
        driver.findElement(securityAnswer).sendKeys(answer);
        driver.findElement(termsCheckbox).click();
        driver.findElement(createAccountBtn).click();
    }
}