package pack;

import org.example.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.example.IsuePage;
import org.example.LoginPage;
import java.util.List;
import org.example.utils.WaitCustom;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CopyIsueTest extends BaseTest{
    @Test
    public void CopyIsueTest(){
        String login = "QA1";//поправить пути
        String password = "TestPassword2";
        driver.get("http://193.233.193.42:9091 ");
        loginPage=new LoginPage();
        loginPage.login(login,password);
        WaitCustom.waitForPageLoadComplete(driver);
        isuePage=new IsuePage();
        List<WebElement> elementsbefore=isuePage.count();
        isuePage.copyIssue();
        List<WebElement> elementafter = driver.findElements(By.xpath("//a[@class='link_bf7 link_66c issues-list-widget__issue-summary']"));
        assertNotEquals(elementafter.size(),elementsbefore.size());
    }
}
