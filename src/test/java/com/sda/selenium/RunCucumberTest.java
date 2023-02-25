package com.sda.selenium;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com.sda.selenium",
        features = "src/test/resources/features/login.feature",
        plugin = {"pretty", "json:target/cucumber-reports.json",
                "html:target/cucumber-reports.html",
                "junit:target/cucumber-reports.xml"}
)
public class RunCucumberTest {
}
