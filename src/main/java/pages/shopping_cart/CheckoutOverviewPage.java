package pages.shopping_cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.all_products.ProductsPage;

public class CheckoutOverviewPage extends BasePage {
    private final By CheckoutOverviewTitle = By.xpath("//span[text()='Checkout: Overview']");
    private final By cancelButton = By.xpath("//button[@id='cancel']");
    private final By finishButton = By.xpath("//button[@id='finish']");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyCheckoutOverviewPage() {
        return isElementDisplayed(CheckoutOverviewTitle);
    }

    public ProductsPage clickCancelButton() {
        clickButton(cancelButton);
        return new ProductsPage(driver);
    }

    public CheckoutCompletePage clickFinishButton() {
        clickButton(finishButton);
        return new CheckoutCompletePage(driver);
    }
}
