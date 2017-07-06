package com.gymondo.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.ID, using = "login-form__mail")
    WebElement username;

    @FindBy(how = How.ID, using = "login-form__secret")
    WebElement password;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[1]/div/div/div/div[2]")
    WebElement button;

    @FindBy(how = How.XPATH, using = "//*[@id=\"home-login-form\"]/div[5]")
    WebElement submit_button;

    public void login_gymondo_sucesful(String user, String pw) {
        button.click();
        username.sendKeys(user);
        password.sendKeys(pw);
        submit_button.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"paymentFunnel\"]/div[6]/div[2]/div/div[1]/div[1]/div[2]/div[2]/gym-logged-user/span")));

        WebElement webElement = driver.findElement(By.xpath("//*[@id=\"paymentFunnel\"]/div[6]/div[2]/div/div[1]/div[1]/div[2]/div[2]/gym-logged-user/span"));

        Assert.assertTrue("Nutzer nicht erfolgreich eingeloggt", webElement.getText().contains(user));
    }

    public void login_gymondo_not_sucesful(String user, String pw) throws InterruptedException {
        button.click();
        username.sendKeys(user);
        password.sendKeys(pw);
        submit_button.click();

        Thread.sleep(2000);

        String error_message = driver.findElement(By.xpath("//*[@id=\"home-login-form\"]/div[5]")).getText();

        String expected_message = "Login ist fehlgeschlagen";
        Assert.assertEquals(expected_message, error_message);
    }





}
