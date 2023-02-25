package com.sda.selenium.pages;

import com.sda.selenium.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public final RemoteWebDriver driver;

    public BasePage() {
        this.driver = WebDriverManager.DRIVER;
        PageFactory.initElements(driver, this);
    }
}
