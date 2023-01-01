package pages;

import data.CommonStrings;
import data.Timeouts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final String url = CommonStrings.LOGIN_PAGE_URL;
    private final By usernameInput = By.xpath("//input[@id='user-name']");
    private final By passwordInput = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//input[@id='login-button']");
    private final By errorBox = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Opens Login page and returns LoginPage obj
    public LoginPage openLoginPage() {
        openUrl(url);
        return this;
    }

    // Verifies LoginPage url
    public boolean verifyLoginPageUrl() {
        return waitForUrlChange(url, Timeouts.TIMEOUT_LONG);
    }

    // Types username to username input
    public LoginPage typeUsername(String username) {
        typeToInput(usernameInput, username);
        return this;
    }

    // Types password to username input
    public LoginPage typePassword(String password) {
        typeToInput(passwordInput, password);
        return this;
    }

    // Clicks login and returns ProductPage
    public ProductsPage clickLoginSuccess() {
        clickButton(loginButton);
        return new ProductsPage(driver);
    }

    // Clicks login and returns LoginPage
    public LoginPage clickLoginFail() {
        clickButton(loginButton);
        return this;
    }

    // Returns text from error message box
    public String getErrorMessage() {
        return getElementText(errorBox);
    }
}
