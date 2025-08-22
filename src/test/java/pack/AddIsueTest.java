package pack;

import org.example.*;
import org.example.utils.WaitCustom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Execution(ExecutionMode.CONCURRENT)
public class AddIsueTest extends BaseTest{

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
    public void addIsueTest(){
        dashboardPage=new DashboardPage(driver);
        dashboardPage.projectOpen();
        redirectPage=new RedirectPage(driver);
        redirectPage.redirected();
        projectPage=new ProjectPage(driver);
        projectPage.AddTask();
        createIssuePage=new CreateIssuePage(driver);
        createIssuePage.CreateIssue(System.getProperty("add"));
        WaitCustom.waitForPageLoadComplete(driver);
        String actualTitle = projectPage.getIssueTitle();
        assertEquals(System.getProperty("add"), actualTitle, "Совпало");
    }
}
