package org.example;

import org.example.utils.WaitCustom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedirectPage extends BasePage {
    private By qaProject = By.xpath("//a[@href='projects/0-1']");

    public RedirectPage(WebDriver driver) {
        super(driver);
    }

    public void redirected() {
    driver.findElement(qaProject).click();
    WaitCustom.waitForPageLoadComplete(driver);
}
}
