package pages.shopping_cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class CheckoutOverviewPage extends BasePage {
    private final By CheckoutOverviewTitle = By.xpath("//span[text()='Checkout: Overview']");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyCheckoutOverviewPage() {
        return isElementDisplayed(CheckoutOverviewTitle);
    }
}
