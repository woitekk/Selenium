package com.sda.selenium.steps;

import com.sda.selenium.pages.GooglePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;

public class GoogleStepdefs {

    GooglePage googlePage = new GooglePage();
    @Given("Google page is opened.")
    public void googlePageIsOpened() {
        googlePage.openGooglePage();

        System.out.println("Google page was opened.");
    }

    @When("I click accept all button.")
    public void iClickAcceptAllButton() {
        googlePage.clickOnAcceptAllButton();

        System.out.println("User click accept all button.");
    }

    @And("I search for phrase {string}.")
    public void iSearchForPhrase(String searchPhrase) {
        googlePage.searchForPhrase(searchPhrase);

        System.out.println("User search for phrase: " + searchPhrase);
    }

    @Then("I see search results.")
    public void iSeeSearchResults() {
        googlePage.verifyThatSearchResultsAreVisible();
        System.out.println("User is able to see search results.");
    }

    @And("I press enter button")
    public void iPressEnterButton() {
        googlePage.pressOnlyEnter();

    }

    @Then("I don't see search results.")
    public void iDonTSeeSearchResults() {
        assertThat("Search results should not be visible but they are presented.", !googlePage.isSearchResultsVisible());
    }
}
