package pages.shopping_cart;

import data.CommonStrings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.all_products.ProductsPage;

import java.text.DecimalFormat;

public class CheckoutOverviewPage extends BasePage {
    private final By CheckoutOverviewTitle = By.xpath("//span[text()='Checkout: Overview']");
    private final By cancelButton = By.xpath("//button[@id='cancel']");
    private final By finishButton = By.xpath("//button[@id='finish']");
    private final By itemPrice = By.xpath("//div[@class='summary_subtotal_label']");
    private final By itemTax = By.xpath("//div[@class='summary_tax_label']");
    private final By itemTotal = By.xpath("//div[@class='summary_total_label']");

    private static final DecimalFormat dfSharp = new DecimalFormat("#.##");

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

    // Extracts double from String
    public double getDoubleFromString(By locator) {
        return Double.parseDouble(getElementText(locator).replaceAll("[^\\d.]", ""));
    }

    // Returns Item Price
    public double getPrice() {
        return getDoubleFromString(itemPrice);
    }

    // Returns Tax
    public double getTax() {
        return getDoubleFromString(itemTax);
    }

    // Returns Total
    public double getTotal() {
        return getDoubleFromString(itemTotal);
    }

    // Checks if tax is correct
    public boolean verifyTax() {
        double res = this.getPrice() / CommonStrings.TAX;
        res = (double) res;
        return Math.round(res * 100.0) / 100.0 == this.getTax();
    }

    // Checks if total is correct
    public boolean verifyTotal() {
        System.out.println(this.getPrice());
        System.out.println(this.getTax());
        System.out.println(this.getTotal());
        System.out.println(this.getPrice() + this.getTax());
        double res = this.getPrice() + this.getTax();
        return Math.round(res * 100.0) / 100.0 == this.getTotal();
    }
}
