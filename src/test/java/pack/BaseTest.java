package pack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.IOException;
import java.time.Duration;

abstract public class BaseTest {
protected WebDriver driver;
protected LoginPage loginPage;
protected RedirectPage redirectPage;
protected ProjectPage  projectPage;
protected IssueDetailPage issueDetailPage;
protected DashboardPage dashboardPage;
protected CreateIssuePage createIssuePage;
protected WebDriverWait wait;
protected LogoutPage logoutPage;

    @BeforeAll
    public static void setupDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() throws IOException {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        }


    @AfterEach
    public void tearDown() {
        if (this.driver != null) {
            this.driver.quit();
        }

    }
}



