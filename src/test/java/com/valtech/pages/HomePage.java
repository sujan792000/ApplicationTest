package com.valtech.pages;

import com.valtech.Pages;
import com.valtech.scripts.TestBase;
import com.valtech.util.WebDriverHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePage extends TestBase {
    @BeforeClass
    public void testInit() {

        // Load the page in the browser
        webDriver.get(websiteUrl);

    }

    @Test(priority = 1)
    public void questionOneAndTwo() {
        //Number of latest articles total should be 3

        Assert.assertEquals(Pages.latestNewsArticleTotal(webDriver),3);

        //Clicking about us link
        Pages.clickEachLink(webDriver,"About");
        WebDriverHelper.waitFor(1000);
        //Verifying the H1 tag
        Assert.assertEquals(WebDriverHelper.getWindowTitle(webDriver),
                "where experiences are engineered - valtech");

        //Clicking services
        Pages.clickEachLink(webDriver,"Services");
        WebDriverHelper.waitFor(1000);
        //Verifying the H1 tag
        Assert.assertEquals(WebDriverHelper.getWindowTitle(webDriver),
                "where experiences are engineered - valtech");
        //Clicking work

        Pages.clickEachLink(webDriver,"Work");
        WebDriverHelper.waitFor(1000);
        //Verifying the H1 tag
        Assert.assertEquals(WebDriverHelper.getWindowTitle(webDriver),
                "where experiences are engineered - valtech");
    }

    @Test(priority = 2)
    public void question3(){
        //navigate to contact page
        WebDriverHelper.navigateToURL(websiteUrl+"about/contact-us/",webDriver);
        WebDriverHelper.waitFor(1000);

        //Verifying number of offices
        Assert.assertEquals(Pages.getNumberOfOffices(webDriver),36);

    }

}
