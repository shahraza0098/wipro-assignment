package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import utilities.ExcelUtils;

public class AssignPage {

    WebDriver driver;
    WebDriverWait wait;

    public AssignPage(WebDriver driver) {

        this.driver = driver;

        wait =
            new WebDriverWait(driver,
                    Duration.ofSeconds(10));
    }

    By myAccount =
            By.xpath("//a[@title='My Account']");

    By login =
            By.linkText("Login");

    By email =
            By.id("input-email");

    By password =
            By.id("input-password");

    By loginBtn =
            By.xpath("//input[@value='Login']");

    By searchBox =
            By.name("search");

    By sort =
            By.id("input-sort");

    By addCartButtons =
            By.xpath("//button[contains(@onclick,'cart.add')]");

    By cart =
            By.xpath("//span[text()='Shopping Cart']");

    By removeBtn =
            By.xpath("(//button[@data-original-title='Remove'])[1]");

    By checkoutBtn =
            By.linkText("Checkout");

    By logoutBtn =
            By.linkText("Logout");

    public void loginUsingExcel(int row) {

        String user =
                ExcelUtils.getCellData(row,0);

        String pass =
                ExcelUtils.getCellData(row,1);

        driver.findElement(myAccount).click();

        driver.findElement(login).click();

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(email));

        driver.findElement(email)
                .sendKeys(user);

        driver.findElement(password)
                .sendKeys(pass);

        driver.findElement(loginBtn).click();
    }

    public void searchProduct(String product) {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(searchBox));

        WebElement search =
                driver.findElement(searchBox);

        search.clear();

        search.sendKeys(product);

        search.sendKeys(Keys.ENTER);
    }

    public void applyFilter() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(sort));

        Select select =
                new Select(driver.findElement(sort));

        select.selectByIndex(1);
    }

    public void addMultipleProducts() {

        List<WebElement> products =
                driver.findElements(addCartButtons);

        if(products.size() >= 2) {

            products.get(0).click();

            products.get(1).click();
        }
    }

    public void removeOneProduct() {

        driver.findElement(cart).click();

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(removeBtn));

        driver.findElement(removeBtn).click();
    }

    public String getTotalAmount() {

        return driver.findElement(
                By.xpath("//strong[text()='Total']")
        ).getText();
    }

    public void checkout() {

        driver.findElement(checkoutBtn).click();
    }

    public void logout() {

        driver.findElement(myAccount).click();

        driver.findElement(logoutBtn).click();
    }
}