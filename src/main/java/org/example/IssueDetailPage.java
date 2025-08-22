package org.example;

import org.example.utils.WaitCustom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class IssueDetailPage extends BasePage {
    private By deleteButton = By.ById.xpath("//span[text()='Удалить задачу']");
    private By isueOption = By.xpath("//button[@class='ring-ui-button_bc66 ring-ui-heightS_de02 ring-ui-active_c5fe ring-ui-withIcon_b32b']");
    private By clone=By.xpath("//span[text()='Клонировать задачу']");
    private By issueTitle = By.xpath("//span[text()='newadded']");

    public IssueDetailPage(WebDriver driver) {
        super(driver);
    }

    /*
    public IssueDetailPage(WebDriver driver) {
        super(driver);
    }
    */

    public void deleteIssue() {
        driver.findElement(isueOption).click();
        WaitCustom.waitForElementClickable(driver, deleteButton).click();
    }
        /*driver.findElement(project).click();
        WaitCustom.waitForPageLoadComplete(driver);
        WaitCustom.waitForElementClickable(driver,qaProject).click();
    }

    public String getIssueTitle() {
        return issueTitle.getText();
    }
         */
        public void copyIssue() {
            driver.findElement(issueTitle).click();
            WaitCustom.waitForElementClickable(driver, clone).click();
            /*
            driver.findElement(project).click();
            WaitCustom.waitForPageLoadComplete(driver);
            WaitCustom.waitForElementClickable(driver,qaProject).click();
             */
        }
}