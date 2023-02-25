package com.sda.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GooglePage extends BasePage {

    private final String GOOGLE_URL = "https://www.google.com/";

    @FindBy(how = How.ID, using = "L2AGLb")
    WebElement acceptAllButton;

    @FindBy(how = How.NAME, using = "q")
    WebElement searchInputField;

    @FindBy(how = How.ID, using = "rcnt")
    WebElement searchResultsContainer;

    public void openGooglePage() {
        driver.get(GOOGLE_URL);
    }

    public void clickOnAcceptAllButton() {
        acceptAllButton.click();
    }

    public void searchForPhrase(String phrase) {
        searchInputField.clear();
        searchInputField.sendKeys(phrase);
        searchInputField.sendKeys(Keys.ENTER);
    }

    public void pressOnlyEnter() {
        searchInputField.sendKeys(Keys.ENTER);
    }

    public void verifyThatSearchResultsAreVisible(){
       // searchResultsContainer.isDisplayed();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(searchResultsContainer));

    }

    public boolean isSearchResultsVisible(){
        List<WebElement> searchResultsElements = driver.findElements(By.id("rcnt"));
        return searchResultsElements.size() > 0;
    }
}
