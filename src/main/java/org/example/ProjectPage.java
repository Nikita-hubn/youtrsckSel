package org.example;

import org.example.utils.WaitCustom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProjectPage extends BasePage{

    private By create = By.xpath("//button[@data-test='submit-button']");
    private By copiedIsue=By.xpath("//span[text()='1newTest']");
    private By newIsue =  By.xpath("//a[@href='newIssue?project=QA']");
    private By issueTitle = By.xpath("//span[text()='newadded']");

    public ProjectPage(WebDriver driver) {
        super(driver);
    }


    public  void AddTask(){
        WaitCustom.waitForElementClickable(driver,newIsue).click();
        WaitCustom.waitForPageLoadComplete(driver);
    }
    public void openIssue(){
        driver.findElement(copiedIsue).click();
    }
    public String getIssueTitle() {
        return driver.findElement(issueTitle).getText();
    }

    public List<WebElement> count(){
        List<WebElement> isuebefore = driver.findElements(By.xpath("//a[@class='link_bf7 link_66c issues-list-widget__issue-summary']"));
        return isuebefore;
    }
    }
