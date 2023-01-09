package test.Tests04_ProductsButton;

import data.CommonStrings;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.login.LoginPage;
import pages.all_products.ProductsPage;
import test.BaseTest;

public class AddAndRemoveItem extends BaseTest {
    WebDriver driver;
    String username = CommonStrings.STANDARD_USER;
    String password = CommonStrings.PASSWORD;

    @BeforeMethod
    public void setupTest() {
        driver = setupDriver();
    }
    @DataProvider(name = "test-data")
    public Object[][] dataProvFunc(){
        return new Object[][]{{"1"},{"2"},{"3"},{"4"},{"5"},{"6"}};
    }
    @Test(dataProvider = "test-data")
    public void addAndRemoveItem(String n) {
        LoginPage loginPage = new LoginPage(driver).openLoginPage();
        ProductsPage productsPage = loginPage.typePassword(password).typeUsername(username).clickLoginSuccess();

        productsPage.clickInventoryItemButton(n);
        Assert.assertEquals(productsPage.getItemButtonText(n), CommonStrings.REMOVE_ITEM_BUTTON);
        productsPage.clickInventoryItemButton(n);
        Assert.assertEquals(productsPage.getItemButtonText(n), CommonStrings.ADD_ITEM_BUTTON);
    }

    @AfterMethod(alwaysRun = true)
    public void quitTest() {
        quitDriver(driver);
    }
}
