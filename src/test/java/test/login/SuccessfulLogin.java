package test.login;

import data.CommonStrings;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import test.BaseTest;

public class SuccessfulLogin extends BaseTest {
    WebDriver driver;
    String username;
    String password;

    @BeforeMethod
    public void setupTest() {
        driver = setupDriver();
        username = CommonStrings.STANDARD_USER;
        password = CommonStrings.PASSWORD;
    }

    @Test
    public void SuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();

        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.clickLogin();
    }

    @AfterMethod(alwaysRun = true)
    public void quitTest() {
        quitDriver(driver);
    }
}
