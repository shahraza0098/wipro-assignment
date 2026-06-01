package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ExcelUtility;
import utilities.ConfigReader;

/**
 * Question 1 – Login Module Page Object
 * Handles all login-related interactions.
 * Uses @FindBy annotations for clean element mapping.
 */
public class LoginPage extends BasePage {

    // ========================
    // Web Element Declarations
    // ========================
    @FindBy(xpath = "//input[@name='username'] | //input[@id='username'] | //input[@type='email']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@name='password'] | //input[@id='password'] | //input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit'] | //input[@type='submit'] | //button[contains(text(),'Login')]")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class,'alert-danger')] | //div[contains(@class,'error')] | //p[contains(@class,'text-danger')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//a[contains(@href,'logout')] | //a[contains(text(),'Logout')] | //li[contains(@class,'user-menu')]")
    private WebElement logoutLink;

    // Dynamic XPath locators (Question 9)
    private final By usernameLocator = By.xpath("//input[contains(@name,'username') or @type='email']");
    private final By passwordLocator = By.xpath("//input[@type='password']");
    private final By loginBtnLocator = By.xpath("//button[@type='submit' or contains(@class,'btn-primary')]");

    // ========================
    // Actions
    // ========================

    /**
     * Navigate directly to the login page.
     */
    public LoginPage navigateToLogin() {
        driver.get(ConfigReader.getProperty("base.url") + "en/user/login");
        return this;
    }

    /**
     * Enters username in the username field.
     */
    public LoginPage enterUsername(String username) {
        WebElement field = waitUtil.waitForVisible(usernameLocator);
        field.clear();
        if (username != null && !username.isEmpty()) {
            field.sendKeys(username);
        }
        return this;
    }

    /**
     * Enters password in the password field.
     */
    public LoginPage enterPassword(String password) {
        WebElement field = waitUtil.waitForVisible(passwordLocator);
        field.clear();
        if (password != null && !password.isEmpty()) {
            field.sendKeys(password);
        }
        return this;
    }

    /**
     * Clicks the login button.
     */
    public void clickLoginButton() {
        waitUtil.waitForClickable(loginBtnLocator).click();
    }

    /**
     * Full login action combining username, password entry and button click.
     */
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    /**
     * Login using credentials read from Excel (Question 1 – read from Excel).
     */
    public void loginFromExcel(int rowIndex) {
        ExcelUtility excel = new ExcelUtility(
            System.getProperty("user.dir") + "/" + ConfigReader.getProperty("excel.path")
        );
        String username = excel.getCellData("LoginData", rowIndex, 0);
        String password = excel.getCellData("LoginData", rowIndex, 1);
        excel.close();
        login(username, password);
    }

    // ========================
    // Validations
    // ========================

    /**
     * Returns true if login was successful (logout link visible).
     */
    public boolean isLoginSuccessful() {
        try {
            return waitUtil.waitForVisible(By.xpath(
                "//a[contains(@href,'logout')] | //li[contains(@class,'user-menu')] | //span[contains(text(),'My Account')]"
            )) != null;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Returns true if an error message is displayed.
     */
    public boolean isErrorDisplayed() {
        try {
            return waitUtil.waitForVisible(By.xpath(
                "//div[contains(@class,'alert-danger')] | //div[contains(@class,'text-danger')] | //p[@class='text-danger']"
            )).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Returns the error message text.
     */
    public String getErrorMessage() {
        try {
            return waitUtil.waitForVisible(By.xpath(
                "//div[contains(@class,'alert')] | //p[contains(@class,'error')]"
            )).getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Returns current page URL.
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Returns current page title.
     */
    public String getPageTitle() {
        return driver.getTitle();
    }
}
