package com.valtech;

import com.valtech.util.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class Pages {


    public static int latestNewsArticleTotal(WebDriver driver){
        By latestNews = By.cssSelector("bloglisting-compact");
        return WebDriverHelper.getElementCount(latestNews,driver);
    }

    public static void clickEachLink(WebDriver driver, String linkName){
        WebDriverHelper.clickLinkText(linkName,driver);
    }

    public static void clickingContactUsBanner(WebDriver driver){
        String  banner = ".CTA--job>.CTA-banner-3>.contact>.active";
        WebDriverHelper.mouseHoverOverAndClickElement(banner,driver);
    }

    public static int getNumberOfOffices(WebDriver driver){
        By offices = By.cssSelector(".office");
        return WebDriverHelper.getElementCount(offices,driver);
    }
}
