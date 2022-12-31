package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

    // Initialises WebDriverManager
    protected WebDriver setupDriver() {
        return WebDriverManager.firefoxdriver().create();
    }

    // Quits WebDriver
    protected void quitDriver(WebDriver driver) {
        driver.quit();
    }
}
