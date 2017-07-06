package com.gymondo.testcases;

import com.gymondo.helper.BrowserFactory;
import com.gymondo.page.LoginPage;
import com.gymondo.page.RegisterPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class VerifyValifRegistration {
    WebDriver driver;
    @Before
    public void initTest () {
        driver = BrowserFactory.startBrowser("chrome", "https://www.gymondo.de/");
    }

    @Test
    public void checkValidRegistration() {
        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        registerPage.register_gymondo(null);
    }
}
