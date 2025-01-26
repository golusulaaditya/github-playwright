package com.qa.onlineTesting.pages;
import com.microsoft.playwright.options.BoundingBox;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {

    private final Page page;

    private final String search = "input[name='search']";
    private final String searchIcon = "div#search button";
    private final String searchPageHeader = "div#content h1";
    private final String loginLink = "a:text('Login')";
    private final String myAccountLink = "a[title='My Account']";

    public HomePage(Page page) {
        this.page = page;
    }

    public String getHomePageTitle() {
        String title =   page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Welcome to Restful Booker Platform")).textContent();
        System.out.println("page title: " + title);
        return title;
    }

    public String getEnquiry() {
        page.getByTestId("ContactName").click();
        page.getByTestId("ContactName").fill("Aditya");
        page.getByTestId("ContactName").press("Tab");
        page.getByTestId("ContactEmail").fill("aditya@test.com");
        page.getByTestId("ContactEmail").press("Tab");
        page.getByTestId("ContactPhone").fill("078787876566");
        page.getByTestId("ContactSubject").click();
        page.getByTestId("ContactSubject").fill("Car parking ");
        page.getByTestId("ContactDescription").click();
        page.getByTestId("ContactDescription").fill("Hi there,\n\ni would like to know if there is car parking.\n\nThank you.");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
       String enquiryMessage = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Thanks for getting in touch Aditya!")).textContent();
        System.out.println("enquiry message is: " + enquiryMessage);
        return enquiryMessage;
    }

    public String bookSingleRoom444() {
        page.locator(".col-sm-7 > .btn").first().click();
        Locator startDate = page.locator("#root > div > div > div:nth-child(4) > div > div:nth-child(2) > div.col-sm-6 > div > div.rbc-month-view > div:nth-child(2) > div.rbc-row-content > div:nth-child(2) > div:nth-child(2) > div > div");
        Locator endDate = page.locator("#root > div > div > div:nth-child(4) > div > div:nth-child(2) > div.col-sm-6 > div > div.rbc-month-view > div:nth-child(4) > div.rbc-row-content > div:nth-child(4) > div:nth-child(2) > div > div");
        BoundingBox startBox = startDate.boundingBox();
        BoundingBox endBox = endDate.boundingBox();


        if (startBox != null && endBox != null) {
            // Drag from start date to end date
            page.mouse().move(startBox.x + startBox.width / 2, startBox.y + startBox.height / 2); // Move to start date
            page.mouse().down(); // Press mouse button
            page.mouse().move(endBox.x + endBox.width / 2, endBox.y + endBox.height / 2); // Drag to end date
            page.mouse().up(); // Release mouse button
        } else {
            System.out.println("Unable to locate start or end date elements.");
        }
        page.getByPlaceholder("Firstname").click();
        page.getByPlaceholder("Firstname").fill("Aditya");
        page.getByPlaceholder("Lastname").click();
        page.getByPlaceholder("Lastname").fill("Golusula");
        page.getByPlaceholder("Lastname").press("Tab");
        page.locator("input[name=\"email\"]").fill("aditya@test.com");
        page.locator("input[name=\"email\"]").press("Tab");
        page.locator("input[name=\"phone\"]").fill("07545454566543");
   //     page.locator("#root > div > div > div:nth-child(6) > div > div:nth-child(2) > div.col-sm-6 > div > div.rbc-month-view > div:nth-child(6) > div.rbc-row-content > div:nth-child(2) > div:nth-child(2) > div > div").
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Book").setExact(true)).click();

        String bookingConfirmation =  page.locator("body > div.ReactModalPortal > div > div > div:nth-child(1) > div.col-sm-6.text-center > h3").textContent();
        System.out.println("Booking Confirmation: " + bookingConfirmation);
        return bookingConfirmation;
    }














}