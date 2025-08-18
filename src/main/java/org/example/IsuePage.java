package org.example;

import org.openqa.selenium.By;
import org.example.utils.WaitCustom;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.List;


public class IsuePage extends BasePage{
private By newIsue =  By.xpath("//a[@href='newIssue?project=QA']");
private By deleteButton = By.ById.xpath("//span[text()='Удалить задачу']");
private By isueOption = By.xpath("//button[@class='ring-ui-button_bc66 ring-ui-heightS_de02 ring-ui-active_c5fe ring-ui-withIcon_b32b']");
private By clone=By.xpath("//span[text()='Клонировать задачу']");
private By options=By.xpath("//button[@class='ring-ui-manager-anchorClassName_c327 ring-ui-manager-resetButton_bf14']");
private By logout = By.xpath("//button[text()='Выйти']");
private By project = By.xpath("//a[@href='projects']");
private By qaProject = By.xpath("//a[@href='projects/0-1']");
private By nameProject = By.xpath("//textarea[@placeholder='Заголовок']");
private By create = By.xpath("//button[@data-test='submit-button']");
private By copiedIsue=By.xpath("//span[text()='1newTest']");
//private By issueTitle = By.xpath("//a[@class='link_bf7 link_66c issues-list-widget__issue-summary']");
private By issueTitle = By.xpath("//span[text()='newadded']");


        public  void Logout(){
        driver.findElement(options).click();
        WaitCustom.waitForElementClickable(driver,logout).click();
}

public  void AddTask(String name){
        driver.findElement(project).click();
        WaitCustom.waitForElementClickable(driver,qaProject).click();
        WaitCustom.waitForElementClickable(driver,newIsue).click();
        WaitCustom.waitForPageLoadComplete(driver);
        driver.findElement(nameProject).sendKeys(name);
        driver.findElement(create).click();
}
        public String getIssueTitle() {
                return driver.findElement(issueTitle).getText();
        }
        public void deleteIssue(){
                driver.findElement(project).click();
                WaitCustom.waitForElementClickable(driver,qaProject).click();
                WaitCustom.waitForElementClickable(driver,copiedIsue).click();
                WaitCustom.waitForElementClickable(driver,isueOption).click();
                WaitCustom.waitForElementClickable(driver,deleteButton).click();
                driver.findElement(project).click();
                WaitCustom.waitForPageLoadComplete(driver);
                WaitCustom.waitForElementClickable(driver,qaProject).click();
        }
        public List<WebElement> count(){
                driver.findElement(project).click();
                WaitCustom.waitForElementClickable(driver,qaProject).click();
                List<WebElement> isuebefore = driver.findElements(By.xpath("//a[@class='link_bf7 link_66c issues-list-widget__issue-summary']"));
                return isuebefore;
        }
        public void copyIssue(){
                driver.findElement(project).click();
                WaitCustom.waitForElementClickable(driver,qaProject).click();
                WaitCustom.waitForElementClickable(driver,copiedIsue).click();
                WaitCustom.waitForElementClickable(driver,isueOption).click();
                WaitCustom.waitForElementClickable(driver,clone).click();
                driver.findElement(project).click();
                WaitCustom.waitForPageLoadComplete(driver);
                WaitCustom.waitForElementClickable(driver,qaProject).click();


        }
}
