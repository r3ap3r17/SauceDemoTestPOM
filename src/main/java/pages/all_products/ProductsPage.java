package pages.all_products;

import data.CommonStrings;
import data.Timeouts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.shopping_cart.ShoppingCartPage;
import pages.menu.HamburgerMenu;

public class ProductsPage extends BasePage {
    private final String url = CommonStrings.PRODUCTS_PAGE_URL;
    private final By menu = By.xpath("//button[@id='react-burger-menu-btn']");

    // String template with %s being index of a div with button
    private String productContainerButton = "//div[@class='inventory_list']/div[@class='inventory_item'][%s]//button";
    private final By cartItemsNumberSpan = By.xpath("//div[@id='shopping_cart_container']//span[@class='shopping_cart_badge']");

    // String template with %s being product item index
    private String productItemTitle = "//a[@id='item_%s_title_link']/div[@class='inventory_item_name']";
    private final By productsPageMainTitle = By.xpath("//span[@class='title']");
    private final By shopingCart = By.xpath("//div[@id='shopping_cart_container']/a");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyProductsPageUrl() {
        return waitForUrlChange(url, Timeouts.TIMEOUT_LONG);
    }
    public boolean verifyProductsPage() {
        return isElementDisplayed(productsPageMainTitle);
    }

    // Clicks hamburger menu
    public HamburgerMenu openMenu() {
        clickButton(menu);
        return new HamburgerMenu(driver);
    }

    // Returns String value of cart item number span
    public String getCartItemNumber() {
        return getElementText(cartItemsNumberSpan);
    }

    // Returns Button text
    public String getItemButtonText(String n) {
        By btn = By.xpath(String.format(productContainerButton, n));
        return getElementText(btn);
    }

    // Clicks button with n being index of product item div
    public void clickInventoryItemButton(String n) {
        By btn = By.xpath(String.format(productContainerButton, n));
        clickButton(btn);
    }

    // Clicks on product title, n being index of product item div
    // Returns product item page obj
    public ProductItemPage clickOnProduct(String n) {
        By btn = By.xpath(String.format(productItemTitle, n));
        clickButton(btn);
        return new ProductItemPage(driver);
    }

    // Returns product item title
    public String getProductTitle(String n) {
        By title = By.xpath(String.format(productItemTitle, n));
        return getElementText(title);
    }

    // Clicks Shopping Cart Button and returns Cart page
    public ShoppingCartPage clickShoppingCart() {
        clickButton(shopingCart);
        return new ShoppingCartPage(driver);
    }
}
