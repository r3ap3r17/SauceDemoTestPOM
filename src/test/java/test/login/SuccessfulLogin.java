package test.login;

import data.CommonStrings;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
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
    public void successfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();

        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        ProductsPage productsPage = loginPage.clickLoginSuccess();
        Assert.assertTrue(productsPage.verifyProductsPageUrl(), "Login failed !");

//        2nd Way
//        boolean pageCHeck = loginPage.clickLogin().verifyProductsPageUrl();
//        Assert.assertTrue(pageCHeck, "Login failed !");
    }

    @AfterMethod(alwaysRun = true)
    public void quitTest() {
        quitDriver(driver);
    }
}
