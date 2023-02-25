package com.sda.selenium;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class WebDriverManager {

    public static RemoteWebDriver DRIVER; //static, że będzie mogła być szerowana pomiędzy obiektami

    public static void startDriver() { // void nic nie zwraca
        switch (getBrowserName()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                DRIVER = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "drivers/chromedriver.exe");// dograc drivera
                DRIVER = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "drivers/chromedriver.exe");// dograc drivera
                DRIVER = new EdgeDriver();
                break;
            case "safari":
                //safari driver doesn't need to set up system property
                DRIVER = new SafariDriver();
                break;
            case "browserStack":
                System.out.println("Browser Stack setup needed!");
                break;
            default:
                throw new IllegalStateException("Unsupported browser!");
        }
        DRIVER.manage().window().maximize();
    }

    public static void destroyDriver() {
        DRIVER.quit();
    }

    public static String getBrowserName() {
        return System.getProperty("browserName", "chrome");
    }

    private static void embedScreenshot(Scenario scenario) {
        byte[] screenshot = DRIVER.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "screenshot");
    }

    private static void saveScreenshotFile(Scenario scenario) throws IOException {
        File srcFile = ((TakesScreenshot) DRIVER).getScreenshotAs(OutputType.FILE);
        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        FileUtils.copyFile(srcFile, new File(currentPath + "/screenshots/" + scenario.getName() + ".png"));
    }

    public static void processExecutedScenario(Scenario scenario) throws IOException {
        if (scenario.isFailed() && DRIVER != null) {
            embedScreenshot(scenario);
            saveScreenshotFile(scenario);
        }
        destroyDriver();
    }

}
