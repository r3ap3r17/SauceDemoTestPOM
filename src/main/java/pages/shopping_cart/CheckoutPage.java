package pages.shopping_cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class CheckoutPage extends BasePage {
    private final By checkoutPageTitle = By.xpath("//span[text()='Checkout: Your Information']");
    private final By cancelOrderButton = By.xpath("//button[@id='cancel']");
    private final By continueOrderButton = By.xpath("//input[@id='continue']");
    private final By firstNameInput = By.xpath("//input[@id='first-name']");
    private final By lastNameInput = By.xpath("//input[@id='last-name']");
    private final By postalCodeInput = By.xpath("//input[@id='postal-code']");

    private final By errorBox = By.xpath("//h3[@data-test='error']");
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    // Verifies Checkout Page title
    public boolean verifyCheckoutPage() {
        return isElementDisplayed(checkoutPageTitle);
    }

    // Clicks on Cancel button, returns to Shopping Cart
    public ShoppingCartPage clickCancelButton() {
        clickButton(cancelOrderButton);
        return new ShoppingCartPage(driver);
    }

    public CheckoutOverviewPage clickContinueButtonSuccess() {
        clickButton(continueOrderButton);
        return new CheckoutOverviewPage(driver);
    }

    public CheckoutPage clickContinueButtonFail() {
        clickButton(continueOrderButton);
        return this;
    }

    public CheckoutPage typeFirstName(String firstName) {
        typeToInput(firstNameInput, firstName);
        return new CheckoutPage(driver);
    }

    public CheckoutPage typeLastName(String lastName) {
        typeToInput(lastNameInput, lastName);
        return new CheckoutPage(driver);
    }

    public CheckoutPage typePostalCode(String postalCode) {
        typeToInput(postalCodeInput, postalCode);
        return new CheckoutPage(driver);
    }

    public String getErrorMessage() {
        return getElementText(errorBox);
    }
}
