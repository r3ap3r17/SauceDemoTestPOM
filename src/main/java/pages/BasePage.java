package pages;

import data.Timeouts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    WebDriver driver;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Open url
    protected void openUrl(String url) {
        driver.get(url);
    }

    // Returns current url
    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Waits for WebElement
    protected boolean waitForUrlChange(String url, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.urlToBe(url));
    }

    // Waits until element is visible | locator
    protected WebElement waitForWebElement(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Waits until element is visible | WebElement
    protected WebElement waitForWebElement(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Clears text from WebElement
    private void clearFromWebElement(WebElement element) {
        waitForWebElement(element, Timeouts.TIMEOUT_MEDIUM).clear();
    }
    // Types text to WebElement
    private void typeToWebElement(WebElement element, String text) {
        waitForWebElement(element, Timeouts.TIMEOUT_MEDIUM).sendKeys(text);
    }
    // Clears WebElement and types new value to it
    private void clearAndTypeToWebElement(WebElement element, String text) {
        clearFromWebElement(element);
        typeToWebElement(element, text);
    }

    // Clicks WebElement
    private void clickWebELement(WebElement element) {
        waitForWebElement(element, Timeouts.TIMEOUT_MEDIUM).click();
        //element.click();
    }

    // Returns text from WebElement
    private String getTextFromWebElement(WebElement element) {
        return waitForWebElement(element, Timeouts.TIMEOUT_MEDIUM).getText();
        //element.getText();
    }

    // Clicks Button
    protected void clickButton(By locator) {
        WebElement btn = driver.findElement(locator);
        clickWebELement(btn);
    }

    // Types to input
    protected void typeToInput(By locator, String text) {
        WebElement input = driver.findElement(locator);
        clearAndTypeToWebElement(input, text);
    }

    // Returns text from element
    protected String getElementText(By locator) {
        WebElement txt = driver.findElement(locator);
        return getTextFromWebElement(txt);
    }

}
