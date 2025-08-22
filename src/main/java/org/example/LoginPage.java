package org.example;

import org.openqa.selenium.By;
import org.example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage{
    private By submitButton = By.xpath("//button[@class='auth-button auth-button_wide auth-button_adaptive button_a5f0 button_a5f0 heightM_aa2f primary_fc6b buttonWithoutIcon_b3e8']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By emailField = By.xpath("//input[@id='username']");

    private  WebElement password = driver.findElement(passwordField);
    private  WebElement email = driver.findElement(emailField);
    private WebElement loginButton = driver.findElement(submitButton);

    public LoginPage(WebDriver driver) {
        super(driver);
    }
//button[@class="auth-button auth-button_wide auth-button_adaptive button_a5f0 button_a5f0 heightM_aa2f primary_fc6b buttonWithoutIcon_b3e8"]

public void login(String username,String password){
    driver.findElement(emailField).sendKeys(username);
    driver.findElement(passwordField).sendKeys(password);
    driver.findElement(submitButton).click();
}
}

/*package org.example;

import org.example.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(@class, 'auth-button')]")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(PropertyReader.getBaseUrl());
    }

    public DashboardPage login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        return new DashboardPage(driver);
    }

    public DashboardPage loginWithDefaultCredentials() {
        return login(PropertyReader.getUsername(), PropertyReader.getPassword());
    }
}

 */