package test.Tests03_MenuLinks;

import data.CommonStrings;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.menu.HamburgerMenu;
import test.BaseTest;

public class OpenLogoutLink extends BaseTest {
    WebDriver driver;
    String username = CommonStrings.STANDARD_USER;
    String password = CommonStrings.PASSWORD;

    @BeforeMethod
    public void setupTest() {
        driver = setupDriver();
    }

    @Test
    public void openLogoutLink() {
        LoginPage loginPage = new LoginPage(driver).openLoginPage();
        ProductsPage productsPage = loginPage.typePassword(password).typeUsername(username).clickLoginSuccess();
        HamburgerMenu menu = productsPage.openMenu();

        LoginPage page = menu.clickLogOutLink();
        Assert.assertTrue(page.verifyLoginPageUrl(), "Login page is not displayed !");
    }

    @AfterMethod(alwaysRun = true)
    public void quitTest() {
        quitDriver(driver);
    }
}