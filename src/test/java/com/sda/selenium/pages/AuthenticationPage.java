package com.sda.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthenticationPage extends BasePage {
    @FindBy(how = How.ID, using = "email")
    WebElement emailField;

    @FindBy(how = How.ID, using = "passwd")
    WebElement passwdField;

    @FindBy(how = How.ID, using = "SubmitLogin")
    WebElement signInButton;

    @FindBy(how = How.CLASS_NAME, using = "alert")
    WebElement errorMessage;

    public void provideEmailAddress(String emailAddress) {
        emailField.clear();
        emailField.sendKeys(emailAddress);
    }

    public void providePassword(String password) {
        passwdField.clear();
        passwdField.sendKeys(password);
    }

    public void clickSignInButton(){
        signInButton.click();
    }

    public String getErrorMsg() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }
}
