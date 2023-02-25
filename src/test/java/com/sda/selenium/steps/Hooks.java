package com.sda.selenium.steps;

import com.sda.selenium.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario){
        WebDriverManager.startDriver();
       System.out.println("Browser is starting now.");
       System.out.println("This is title of scenario: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {

        WebDriverManager.processExecutedScenario(scenario);
        System.out.println("Browser is closed.");
        System.out.println("This is result of scenario: " + scenario.getStatus());
    }
}
