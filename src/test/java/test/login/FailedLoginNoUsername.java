package test.login;

import data.CommonStrings;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import test.BaseTest;

public class FailedLoginNoUsername extends BaseTest {
    WebDriver driver;
    String username = "";
    String password = CommonStrings.PASSWORD;
    String error = CommonStrings.ERROR_MSG_USERNAME;

    @BeforeMethod
    public void setupTest() {
        driver = setupDriver();
    }

    @Test
    public void failedLoginNoUsername() {
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
