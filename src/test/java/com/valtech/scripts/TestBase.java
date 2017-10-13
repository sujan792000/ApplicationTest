package com.valtech.scripts;

import com.valtech.WebDriverFactory;
import com.valtech.util.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver webDriver;
    protected String websiteUrl;
    protected String browser;

    @BeforeClass
    public void init() {
        websiteUrl = PropertyLoader.loadProperty("site.url");
        browser = PropertyLoader.loadProperty("browser.name");

        webDriver = WebDriverFactory.getInstance(browser);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass()
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }


}
