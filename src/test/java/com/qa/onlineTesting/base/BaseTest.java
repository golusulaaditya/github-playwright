package com.qa.onlineTesting.base;

import com.microsoft.playwright.Page;
import com.qa.onlineTesting.factory.PlaywrightFactory;
import com.qa.onlineTesting.pages.HomePage;
import com.qa.onlineTesting.reports.ExtentManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    PlaywrightFactory pf;
    Page page;
    protected HomePage homePage;
    protected Properties prop;

    @BeforeTest
    public void setup() {
        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        page = pf.initBrowser(prop);
        homePage = new HomePage(page);
        ExtentManager.setExtent();
    }

    @AfterTest
    public void tearDown() {
        page.context().browser().close();
        ExtentManager.endReport();
    }
}