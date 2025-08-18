package org.example;

import org.openqa.selenium.By;
import org.example.BasePage;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage{
    private By submitButton = By.xpath("//button[@class='auth-button auth-button_wide auth-button_adaptive button_a5f0 button_a5f0 heightM_aa2f primary_fc6b buttonWithoutIcon_b3e8']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By emailField = By.xpath("//input[@id='username']");

    private  WebElement password = driver.findElement(passwordField);
    private  WebElement email = driver.findElement(emailField);
    private WebElement loginButton = driver.findElement(submitButton);
//button[@class="auth-button auth-button_wide auth-button_adaptive button_a5f0 button_a5f0 heightM_aa2f primary_fc6b buttonWithoutIcon_b3e8"]

public void login(String username,String password){
    driver.findElement(emailField).sendKeys(username);
    driver.findElement(passwordField).sendKeys(password);
    driver.findElement(submitButton).click();
}
}
