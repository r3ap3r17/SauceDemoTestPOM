package pages;

import data.Timeouts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {
    private final By cartTitle = By.xpath("//span[text()='Your Cart']");
    private final By continueShoppingButton = By.xpath("//button[@id='continue-shopping']");
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    public boolean verifyShoppingCartPage() {
        return isElementDisplayed(cartTitle);
    }
    public ProductsPage clickContinueShoppingButton() {
        clickButton(continueShoppingButton);
        return new ProductsPage(driver);
    }
}
