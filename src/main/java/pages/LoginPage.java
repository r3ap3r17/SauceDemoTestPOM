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

    public LoginPage openLoginPage() {
        openUrl(url);
        return this;
    }

    public boolean verifyLoginPageUrl() {
        return waitForUrlChange(url, Timeouts.TIMEOUT_LONG);
    }

    public void typeUsername(String username) {
        typeToInput(usernameInput, username);
    }

    public void typePassword(String password) {
        typeToInput(passwordInput, password);
    }

    public ProductsPage clickLoginSuccess() {
        clickButton(loginButton);
        return new ProductsPage(driver);
    }
    public LoginPage clickLoginFail() {
        clickButton(loginButton);
        return this;
    }

    public String getErrorMessage() {
        return getElementText(errorBox);
    }
}
