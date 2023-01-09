package pages.shopping_cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.all_products.ProductsPage;

public class ShoppingCartPage extends BasePage {
    // Cart page main title
    private final By cartTitle = By.xpath("//span[text()='Your Cart']");

    // When clicked, returns Products page
    private final By continueShoppingButton = By.xpath("//button[@id='continue-shopping']");

    // When clicked, returns checkout form
    private final By checkoutButton = By.xpath("//button[@id='checkout']");


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    // Verifies that Cart page title is displayed meaning we are on Cart page
    public boolean verifyShoppingCartPage() {
        return isElementDisplayed(cartTitle);
    }

    // Clicks Continue Shopping Button and returns products page
    public ProductsPage clickContinueShoppingButton() {
        clickButton(continueShoppingButton);
        return new ProductsPage(driver);
    }

    // Clicks Checkout Button and returns Checkout form page
    public CheckoutPage clickCheckoutButton() {
        clickButton(checkoutButton);
        return new CheckoutPage(driver);
    }
}
