package test.Tests07_Checkout;

import data.CommonStrings;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.all_products.ProductsPage;
import pages.login.LoginPage;
import pages.shopping_cart.CheckoutOverviewPage;
import pages.shopping_cart.CheckoutPage;
import test.BaseTest;

public class CheckoutFormSuccess extends BaseTest {
    WebDriver driver;
    String username = CommonStrings.STANDARD_USER;
    String password = CommonStrings.PASSWORD;

    @BeforeMethod
    public void setupTest() {
        driver = setupDriver();
    }

    @Test
    public void checkoutFormSuccess() {
        LoginPage loginPage = new LoginPage(driver).openLoginPage();
        ProductsPage productsPage = loginPage.typePassword(password).typeUsername(username).clickLoginSuccess();

        CheckoutPage checkoutPage = productsPage.clickShoppingCart().clickCheckoutButton();
        CheckoutOverviewPage overviewPage = checkoutPage
                .typeFirstName("John").typeLastName("Doe").typePostalCode("111").clickContinueButtonSuccess();
        Assert.assertTrue(overviewPage.verifyCheckoutOverviewPage(), "Failed to confirm order info !");
    }

    @AfterMethod(alwaysRun = true)
    public void quitTest() {
        quitDriver(driver);
    }
}
