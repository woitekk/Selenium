package com.sda.selenium.steps;

import com.sda.selenium.model.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstStepdefs {

    User user = new User();
    @Given("This is entry conditions")
    public void thisIsEntryConditions() {
        System.out.println("We are inside given step.");
        System.out.println("User name is " + user.getName());
    }

    @When("This is action step")
    public void thisIsActionStep() {
        System.out.println("We are inside when step.");
    }

    @Then("This is verification step")
    public void thisIsVerificationStep() {
        System.out.println("We are inside then step.");
    }

    @Then("This is another verification step")
    public void thisIsAnotherVerificationStep() {
        System.out.println("We are inside second step.");
    }
}
