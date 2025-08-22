package org.example;

import org.example.BasePage;
import org.example.utils.WaitCustom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateIssuePage extends BasePage {

    private By create = By.xpath("//button[@data-test='submit-button']");
    private By nameProject = By.xpath("//textarea[@placeholder='Заголовок']");



    @FindBy(xpath = "//textarea[@placeholder='Заголовок']")
    private WebElement titleField;

    @FindBy(xpath = "//button[@data-test='submit-button']")
    private WebElement createButton;

    public CreateIssuePage(WebDriver driver) {
        super(driver);
    }

    public void CreateIssue(String name){
        driver.findElement(nameProject).sendKeys(name);
        driver.findElement(create).click();
}
    /*public CreateIssuePage(WebDriver driver) {
        super(driver);
    }



    public ProjectPage createIssue(String title) {
        titleField.sendKeys(title);
        createButton.click();
        return new ProjectPage(driver);
    }

     */
}