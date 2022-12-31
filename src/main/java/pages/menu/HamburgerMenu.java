package pages.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.LoginPage;
import pages.ProductsPage;

public class HamburgerMenu extends BasePage {
    private final By closeBtn = By.xpath("//button[@id='react-burger-cross-btn']");
    private final By menuContainer = By.xpath("//div[@class='bm-menu-wrap']");
    private final By allItemsLink = By.xpath("//a[@id='inventory_sidebar_link']");
    private final By aboutLink = By.xpath("//a[@id='about_sidebar_link']");
    private final String aboutUrl = getElementAttribute(aboutLink, "href");
    private final By logOutLink = By.xpath("//a[@id='logout_sidebar_link']");
    public HamburgerMenu(WebDriver driver) {
        super(driver);
    }

    // Returns aria-hidden attribute value (false if not displayed, true if displayed)
    public boolean isMenuDisplayed() {
        return getElementAttribute(menuContainer, "aria-hidden").equals("false");
    }
    public void closeMenu() {
        clickButton(closeBtn);
    }
    public ProductsPage clickAllItemsLink() {
        clickButton(allItemsLink);
        return new ProductsPage(driver);
    }
    public boolean clickAboutLink() {
        clickButton(aboutLink);
        return getCurrentUrl().equals(aboutUrl);
    }
    public LoginPage clickLogOutLink() {
        clickButton(logOutLink);
        return new LoginPage(driver);
    }
}
