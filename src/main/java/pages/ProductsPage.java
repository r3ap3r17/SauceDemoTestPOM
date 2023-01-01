package pages;

import data.CommonStrings;
import data.Timeouts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.menu.HamburgerMenu;

public class ProductsPage extends BasePage {
    private final String url = CommonStrings.PRODUCTS_PAGE_URL;
    private final By menu = By.xpath("//button[@id='react-burger-menu-btn']");
    private String productContainerButton = "//div[@class='inventory_list']/div[@class='inventory_item'][%s]//button";
    private final By cartItemsNumberSpan = By.xpath("//div[@id='shopping_cart_container']//span[@class='shopping_cart_badge']");
    private String productItemTitle = "//a[@id='item_%s_title_link']/div[@class='inventory_item_name']";
    private final By productsPageMainTitle = By.xpath("//span[@class='title']");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyProductsPageUrl() {
        return waitForUrlChange(url, Timeouts.TIMEOUT_LONG);
    }
    public boolean verifyProductsPage() {
        return isElementDisplayed(productsPageMainTitle);
    }

    public HamburgerMenu openMenu() {
        clickButton(menu);
        return new HamburgerMenu(driver);
    }

    public String getCartItemNumber() {
        return getElementText(cartItemsNumberSpan);
    }

    public String getItemButtonText(String n) {
        By btn = By.xpath(String.format(productContainerButton, n));
        return getElementText(btn);
    }

    public void clickInventoryItemButton(String n) {
        By btn = By.xpath(String.format(productContainerButton, n));
        clickButton(btn);
    }

    public ProductItemPage clickOnProduct(String n) {
        By btn = By.xpath(String.format(productItemTitle, n));
        clickButton(btn);
        return new ProductItemPage(driver);
    }
    public String getProductTitle(String n) {
        By title = By.xpath(String.format(productItemTitle, n));
        return getElementText(title);
    }

}
