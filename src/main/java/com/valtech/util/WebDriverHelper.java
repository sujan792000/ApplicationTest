package com.valtech.util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class WebDriverHelper {

    public static void mouseHoverOverAndClickElement(String locator, WebDriver driver) {
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.cssSelector(locator));
        builder.moveToElement(element).click(element).build().perform();
    }

    public static void navigateToURL(String url, WebDriver driver) {
        driver.navigate().to(url);
    }

    public static void waitFor(long timer) {
        try {
            Thread.sleep(timer);
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread sleep exception occurred...", e);
        }
    }

    public static int getElementCount(final By locator, WebDriver driver) {
        int elementCount = 0;
        try {
            elementCount = driver.findElements(locator).size();
        } catch (final TimeoutException e) {

        } catch (final NoSuchElementException e) {
        }
        return elementCount;
    }

    public static void clickLinkText(final String link, WebDriver driver) {
        driver.findElement(By.linkText(link)).click();
    }

    public static void goBack(WebDriver driver) {
            driver.navigate().back();

    }
    public static String getWindowTitle(WebDriver driver) {
        final Set<String> wh = driver.getWindowHandles();
        final Object[] windowsHandlers = wh.toArray();

        String mainWindowHandle = driver.getWindowHandles().iterator().next();
        String windowTitle = "";

        for (int i = 0; i < wh.size(); ) {
            driver.switchTo().window(windowsHandlers[i].toString());
            WebDriverHelper.waitFor(3000);
            windowTitle = driver.getTitle();
            break;
        }
        driver.switchTo().window(mainWindowHandle);
        return windowTitle;
    }

}
