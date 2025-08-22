package org.example;

import org.example.utils.WaitCustom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage extends BasePage{
    private By options=By.xpath("//button[@class='ring-ui-manager-anchorClassName_c327 ring-ui-manager-resetButton_bf14']");
    private By logout = By.xpath("//button[text()='Выйти']");

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public  void Logout(){
        driver.findElement(options).click();
        WaitCustom.waitForElementClickable(driver,logout).click();
    }
}
