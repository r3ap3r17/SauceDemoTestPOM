package test.Tests04ProductsButton;

import data.CommonStrings;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import test.BaseTest;

public class AddItemsToCart extends BaseTest {
    WebDriver driver;
    String username = CommonStrings.STANDARD_USER;
    String password = CommonStrings.PASSWORD;

    @BeforeMethod
    public void setupTest() {
        driver = setupDriver();
    }

    @Test
    public void addItemsToCart() {
        LoginPage loginPage = new LoginPage(driver).openLoginPage();
        ProductsPage productsPage = loginPage.typePassword(password).typeUsername(username).clickLoginSuccess();

        for (int i = 1; i <= 6; i++) {
            productsPage.clickInventoryItemButton(i);
            Assert.assertEquals(productsPage.getCartItemNumber(), i);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void quitTest() {
        quitDriver(driver);
    }
}
