package pages;

import data.CommonStrings;
import data.Timeouts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.menu.HamburgerMenu;

public class ProductsPage extends BasePage {
    private String url = CommonStrings.PRODUCTS_PAGE_URL;
    private final By menu = By.xpath("//button[@id='react-burger-menu-btn']");
    private String productContainerButton = "//div[@class='inventory_list']/div[@class='inventory_item'][%d]//button";
    private By cartItemsNumberSpan = By.xpath("//div[@id='shopping_cart_container']//span[@class='shopping_cart_badge']");
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

    public int getCartItemNumber() {
        return Integer.parseInt(getElementText(cartItemsNumberSpan));
    }

    public String getItemButtonText(int n) {
        By btn = By.xpath(String.format(productContainerButton, n));
        return getElementText(btn);
    }

    public void clickInventoryItemButton(int n) {
        By btn = By.xpath(String.format(productContainerButton, n));
        clickButton(btn);
    }

}
