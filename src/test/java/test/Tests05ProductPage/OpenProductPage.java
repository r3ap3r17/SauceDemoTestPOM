package test.Tests05ProductPage;

import data.CommonStrings;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductItemPage;
import pages.ProductsPage;
import test.BaseTest;

public class OpenProductPage extends BaseTest {
    WebDriver driver;
    String username = CommonStrings.STANDARD_USER;
    String password = CommonStrings.PASSWORD;

    @BeforeMethod
    public void setupTest() {
        driver = setupDriver();
    }

    @DataProvider(name = "test-data")
    public Object[][] dataProvFunc(){
        return new Object[][]{{"0"},{"1"},{"2"},{"3"},{"4"},{"5"}};
    }

    @Test(dataProvider ="test-data")
    public void addItemsToCart(String n) {
        LoginPage loginPage = new LoginPage(driver).openLoginPage();
        ProductsPage productsPage = loginPage.typePassword(password).typeUsername(username).clickLoginSuccess();

        String title = productsPage.getProductTitle(n);
        ProductItemPage itemPage = productsPage.clickOnProduct(n);
        Assert.assertTrue(itemPage.verifyProductItemPage(title), "Fail to open item Page !");
    }

    @AfterMethod(alwaysRun = true)
    public void quitTest() {
        quitDriver(driver);
    }
}
