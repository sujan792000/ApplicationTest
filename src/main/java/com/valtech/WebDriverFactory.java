package com.valtech;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Arrays;

public class WebDriverFactory {
    public static final String FIREFOX = "firefox";
    public static final String CHROME = "chrome";
    public static final String INTERNET_EXPLORER = "ie";
    public static final String SAFARI = "safari";

    public static WebDriver getInstance(String browserName) {
            WebDriver driver = null;
            if (browserName.equals(CHROME)) {
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
                ChromeOptions option = new ChromeOptions();
                option.addArguments("disable-infobars");
                option.addArguments("disable-extensions");
                option.addArguments("no-sandbox");
                //   option.addArguments("--start-maximized");
                option.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
                capabilities.setCapability(ChromeOptions.CAPABILITY, option);
                driver = new ChromeDriver(capabilities);

            }
            return driver;
    }
}
