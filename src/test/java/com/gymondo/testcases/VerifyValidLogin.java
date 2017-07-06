package com.gymondo.testcases;

import com.gymondo.helper.BrowserFactory;
import com.gymondo.page.LoginPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class VerifyValidLogin {

    WebDriver driver;
    @Before
    public void initTest () {
        driver = BrowserFactory.startBrowser("chrome", "https://www.gymondo.de/");
    }

    @Test
    public void checkValidUser() {
        LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);
        login_page.login_gymondo_sucesful("abcd@gmail.com","12345678");
    }

    @Test
    public void checkNotValidUser() throws InterruptedException {
        LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);
        login_page.login_gymondo_not_sucesful("abc@gmail.com","12345678");
    }
}
