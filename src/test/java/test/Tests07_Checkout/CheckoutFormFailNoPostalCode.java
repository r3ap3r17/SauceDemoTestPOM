package test.Tests07_Checkout;

import data.CommonStrings;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.all_products.ProductsPage;
import pages.login.LoginPage;
import pages.shopping_cart.CheckoutPage;
import test.BaseTest;

public class CheckoutFormFailNoPostalCode extends BaseTest {
    WebDriver driver;
    String username = CommonStrings.STANDARD_USER;
    String password = CommonStrings.PASSWORD;

    @BeforeMethod
    public void setupTest() {
        driver = setupDriver();
    }

    @Test
    public void checkoutFormFailNoPostalCode() {
        LoginPage loginPage = new LoginPage(driver).openLoginPage();
        ProductsPage productsPage = loginPage.typePassword(password).typeUsername(username).clickLoginSuccess();

        CheckoutPage checkoutPage = productsPage.clickShoppingCart().clickCheckoutButton();
        String actualError = checkoutPage.typeFirstName("John").typeLastName("Doe").typePostalCode("")
                .clickContinueButtonFail().getErrorMessage();
        Assert.assertEquals(actualError, CommonStrings.CHECKOUT_ERROR_MSG_POSTALCODE);
    }

    @AfterMethod(alwaysRun = true)
    public void quitTest() {
        quitDriver(driver);
    }
}
