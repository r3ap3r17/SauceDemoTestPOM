package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductItemPage extends BasePage {
    private By productTitle = By.xpath("//div[@class='inventory_details_name large_size']");
    private By backtoProductsButton = By.xpath("//button[@id='back-to-products']");

    public ProductItemPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyProductItemPage(String title) {
        return getProductTitle().equals(title);
    }

    public String getProductTitle() {
        return getElementText(productTitle);
    }

    public void clickBacktoProductsButton() {
        clickButton(backtoProductsButton);
    }
}
