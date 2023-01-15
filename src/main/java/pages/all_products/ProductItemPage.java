package pages.all_products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class ProductItemPage extends BasePage {
    private By productTitle = By.xpath("//div[@class='inventory_details_name large_size']");
    private By backToProductsButton = By.xpath("//button[@id='back-to-products']");
    public ProductItemPage(WebDriver driver) {
        super(driver);
    }

    // Returns true if getProductTitle() is equal with title you provided
    public boolean verifyProductItemPage(String title) {
        return getProductTitle().equals(title);
    }

    // returns product title
    public String getProductTitle() {
        return getElementText(productTitle);
    }

    // Clicks Back to Products button
    public void clickBackToProductsButton() {
        clickButton(backToProductsButton);
    }
}
