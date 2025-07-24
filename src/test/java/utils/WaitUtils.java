package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static final int default_timeout = Integer.parseInt(ConfigReader.readProperty("waitTimeout"));

    private static WebDriverWait getWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(default_timeout));
    }

    public static void waitForUrlToBe(WebDriver driver, String expectedUrl) {
        getWait(driver).until(ExpectedConditions.urlToBe(expectedUrl));
    }

    public static void waitForUrlToContain(WebDriver driver, String partialUrl) {
        getWait(driver).until(ExpectedConditions.urlContains(partialUrl));
    }

    public static void waitForClickAbility(WebDriver driver, WebElement element) {
        getWait(driver).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForVisibility(WebDriver driver, WebElement element) {
        getWait(driver).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForTextToBePresentInElement(WebDriver driver, WebElement element, String expectedText) {
        getWait(driver).until(ExpectedConditions.textToBePresentInElement(element, expectedText));
    }
}

