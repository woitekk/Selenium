package com.sda.selenium.steps;

import com.sda.selenium.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomeStepdefs {
    HomePage homePage = new HomePage();
    @Given("Home page is opened")
    public void homePageIsOpened() {
        homePage.openHomePage();
        System.out.println("Home page was opened.");
    }

    @When("I click Sign in link in top menu")
    public void iClickSignInLinkInTopMenu() {
        homePage.clickSignInLink();
    }
}
