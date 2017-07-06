package com.gymondo.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    public static WebDriver driver;

    public static WebDriver startBrowser(String browserName, String url) {
        if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver","./driver/geckodriver");
            driver = new FirefoxDriver();
        }
        else if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);

        return driver;
    }
}
