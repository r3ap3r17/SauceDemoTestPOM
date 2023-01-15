package pages.shopping_cart;

import data.CommonStrings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.all_products.ProductsPage;

public class CheckoutCompletePage extends BasePage {
    private final By backHomeButton = By.xpath("//button[@id='back-to-products']");
    private String checkoutCompleteLocator = "//div[@id='checkout_complete_container']/div[text()='%s']";
    private final By checkoutCompleteMessage = By.xpath(String.format(checkoutCompleteLocator, CommonStrings.CHECKOUT_COMPLETE_MESSAGE));

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyCheckoutCompletePage() {
        return isElementDisplayed(checkoutCompleteMessage);
    }

    public ProductsPage clickBackHomeButton() {
        clickButton(backHomeButton);
        return new ProductsPage(driver);
    }
}
