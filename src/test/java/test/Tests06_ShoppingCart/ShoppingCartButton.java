package test.Tests06_ShoppingCart;

import data.CommonStrings;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.login.LoginPage;
import pages.all_products.ProductsPage;
import pages.shopping_cart.ShoppingCartPage;
import test.BaseTest;

public class ShoppingCartButton extends BaseTest {
    WebDriver driver;
    String username = CommonStrings.STANDARD_USER;
    String password = CommonStrings.PASSWORD;

    @BeforeMethod
    public void setupTest() {
        driver = setupDriver();
    }

    @Test
    public void openShoppingCart() {
        LoginPage loginPage = new LoginPage(driver).openLoginPage();
        ProductsPage productsPage = loginPage.typePassword(password).typeUsername(username).clickLoginSuccess();

        ShoppingCartPage cart = productsPage.clickShoppingCart();
        Assert.assertTrue(cart.verifyShoppingCartPage(), "Shopping Cart page is not displayed !");
    }

    @AfterMethod(alwaysRun = true)
    public void quitTest() {
        quitDriver(driver);
    }
}
