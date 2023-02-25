package com.sda.selenium.steps;

import com.sda.selenium.pages.AuthenticationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;

public class AuthenticationStepdefs {

    AuthenticationPage authenticationPage = new AuthenticationPage();

    @And("I provide email address {string}")
    public void iProvideEmailAddress(String emailAddress) {
        authenticationPage.provideEmailAddress(emailAddress);
    }

    @And("I provide password {string}")
    public void iProvidePassword(String passwordPhrase) {
        authenticationPage.providePassword(passwordPhrase);
    }

    @And("I click Sign in button")
    public void iClickSignInButton() {
        authenticationPage.clickSignInButton();
    }

    @Then("I am logged in successfully")
    public void iAmLoggedInSuccessfully() {
        System.out.println("Zrob konto.");
    }

    @Then("I see error message {string}")
    public void iSeeErrorMessage(String expectedErrorMessage) {
        String visibleErrorMsg = authenticationPage.getErrorMsg();

        assertThat("Visible error message is not as expected", visibleErrorMsg.contains(expectedErrorMessage));
    }
}
