package org.example;

import org.example.utils.WaitCustom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {
    private By project = By.xpath("//a[@href='projects']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void projectOpen() {
        driver.findElement(project).click();
        WaitCustom.waitForPageLoadComplete(driver);
    }
}
