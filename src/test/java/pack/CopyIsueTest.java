package pack;

import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.example.LoginPage;

import java.io.IOException;
import java.util.List;
import org.example.utils.WaitCustom;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
@Execution(ExecutionMode.CONCURRENT)
public class CopyIsueTest extends BaseTest{

    @BeforeEach
    public void setUp() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("testdata.properties"));
        driver.get(System.getProperty("url"));
        loginPage=new LoginPage(driver);
        loginPage.login(System.getProperty("login"),System.getProperty("password"));
        wait.until(ExpectedConditions.urlToBe("http://193.233.193.42:9091/dashboard?id=158-3"));
    }

    @Test
    @ResourceLock("GROUP_1")
    public void CopyIsueTest(){
        redirectPage=new RedirectPage(driver);
        redirectPage.redirected();
        projectPage=new ProjectPage(driver);
        projectPage.openIssue();
        issueDetailPage=new IssueDetailPage(driver);
        List<WebElement> elementsbefore=projectPage.count();
        issueDetailPage.copyIssue();
        List<WebElement> elementafter = driver.findElements(By.xpath("//a[@class='link_bf7 link_66c issues-list-widget__issue-summary']"));
        assertNotEquals(elementafter.size(),elementsbefore.size());
    }
}
