package test.Tests01Login;

import data.CommonStrings;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import test.BaseTest;

public class FailedLoginLockedUser extends BaseTest {
    WebDriver driver;
    String username = CommonStrings.LOCKED_USER;
    String password = CommonStrings.PASSWORD;
    String error = CommonStrings.ERROR_MSG_LOCKED;

    @BeforeMethod
    public void setupTest() {
        driver = setupDriver();
    }

    @Test
    public void failedLoginLockedUser() {
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
