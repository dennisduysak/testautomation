package com.gymondo.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage (WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[1]/div/div/div/div[1]")
    WebElement register_button;

    public void register_gymondo(String[] data) {
        List<WebElement> products2 = driver.findElements(By.cssSelector(".top-section-btn"));
        for (WebElement we :products2) {
            we.getText();
        }

        WebElement products = driver.findElement(By.xpath("//div[@class='btn-signup btn-signup--full btn-signup-secondary']/div"));
        register_button.click();
    }


}
