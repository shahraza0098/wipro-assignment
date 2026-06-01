package utilities;

import base.DriverFactory;
import pages.LoginPage;

public class LoginHelper {

    public static void login() {

        LoginPage login =
                new LoginPage(
                DriverFactory.getDriver());

        login.enterEmail("user@phptravels.com");
        login.enterPassword("demouser");
        login.clickLogin();
    }
}