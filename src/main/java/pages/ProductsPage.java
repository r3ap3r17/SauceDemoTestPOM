package pages;

import data.CommonStrings;
import data.Timeouts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.menu.HamburgerMenu;

public class ProductsPage extends BasePage {
    private String url = CommonStrings.PRODUCTS_PAGE_URL;
    private final By menu = By.xpath("//button[@id='react-burger-menu-btn']");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyProductsPageUrl() {
        return waitForUrlChange(url, Timeouts.TIMEOUT_LONG);
    }

    public HamburgerMenu openMenu() {
        clickButton(menu);
        return new HamburgerMenu(driver);
    }
}
