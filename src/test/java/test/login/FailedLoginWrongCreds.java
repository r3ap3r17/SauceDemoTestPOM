package test.login;

import data.CommonStrings;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import test.BaseTest;

public class FailedLoginWrongCreds extends BaseTest {
    WebDriver driver;
    String username;
    String password;
    String error = CommonStrings.ERROR_MSG_WRONG_CREDS;

    @BeforeMethod
    public void setupTest() {
        driver = setupDriver();
        username = CommonStrings.STANDARD_USER;
        password = CommonStrings.PASSWORD + "#!@#!@$";
    }

    @Test
    public void SuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();

        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        // loginPage.clickLoginFail() returns obj from LoginPage class
        Assert.assertEquals(loginPage.clickLoginFail().getErrorMessage(), CommonStrings.ERROR_MSG_WRONG_CREDS);
    }

    @AfterMethod(alwaysRun = true)
    public void quitTest() {
        quitDriver(driver);
    }
}
