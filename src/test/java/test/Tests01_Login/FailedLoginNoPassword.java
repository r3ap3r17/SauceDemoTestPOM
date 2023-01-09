package test.Tests01_Login;

import data.CommonStrings;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.login.LoginPage;
import test.BaseTest;

public class FailedLoginNoPassword extends BaseTest {
    WebDriver driver;
    String username = CommonStrings.STANDARD_USER;
    String password = "";
    String error = CommonStrings.LOGIN_ERROR_MSG_PASSWORD;

    @BeforeMethod
    public void setupTest() {
        driver = setupDriver();
    }

    @Test
    public void failedLoginNoPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();

        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        // loginPage.clickLoginFail() returns obj from LoginPage class
        Assert.assertEquals(loginPage.clickLoginFail().getErrorMessage(), error);
    }

    @AfterMethod(alwaysRun = true)
    public void quitTest() {
        quitDriver(driver);
    }
}
