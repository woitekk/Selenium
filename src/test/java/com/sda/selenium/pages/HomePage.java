package com.sda.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {
    private final String HOME_PAGE_URL = "http://automationpractice.com/index.php";

    @FindBy(how = How.CSS, using = "a.login")
    WebElement signInLink;
    public void openHomePage(){
        driver.get(HOME_PAGE_URL);
    }

    public void clickSignInLink(){
        signInLink.click();
    }
}
