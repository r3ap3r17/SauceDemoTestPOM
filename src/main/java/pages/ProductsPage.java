package pages;

import data.CommonStrings;
import data.Timeouts;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private String url = CommonStrings.PRODUCTS_PAGE_URL;
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyProductsPageUrl() {
        return waitForUrlChange(url, Timeouts.TIMEOUT_LONG);
    }
}
