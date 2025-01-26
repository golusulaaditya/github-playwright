package com.qa.onlineTesting.tests;
import com.qa.onlineTesting.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    @Test
    public void homePageTitleTest() {
        String actualTitlePage = homePage.getHomePageTitle();
        Assert.assertEquals(actualTitlePage, prop.getProperty("actualTitle"));
    }

    @Test
    public void contactCustomerServiceTest() {
        String enquiryMessage = homePage.getEnquiry();
        Assert.assertEquals(enquiryMessage, prop.getProperty("actualEnquiryMessage"));
    }

    @Test
    public void doSingleRoomBookingTest() {
        String roomBookedMessage = homePage.bookSingleRoom444();
        Assert.assertEquals(roomBookedMessage, prop.getProperty("bookingMessage"));
    }


}