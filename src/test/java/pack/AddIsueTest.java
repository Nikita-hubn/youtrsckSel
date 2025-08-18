package pack;

import org.example.IsuePage;
import org.example.LoginPage;
import org.example.utils.WaitCustom;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddIsueTest extends BaseTest{
    @ParameterizedTest
    @CsvSource(value = {
            "QA1, TestPassword2, newadded",
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void addIsueTest(String login, String password,String name){
        driver.get("http://193.233.193.42:9091 ");
        loginPage=new LoginPage();
        loginPage.login(login,password);
        wait.until(ExpectedConditions.urlToBe("http://193.233.193.42:9091/dashboard?id=158-3"));
        isuePage=new IsuePage();
        isuePage.AddTask(name);
        WaitCustom.waitForPageLoadComplete(driver);
        String actualTitle = isuePage.getIssueTitle();
        assertEquals(name, actualTitle, "Совпало");
    }
}
