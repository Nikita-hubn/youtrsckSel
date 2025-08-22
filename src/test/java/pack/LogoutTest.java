package pack;

import org.example.LoginPage;
import org.example.LogoutPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTest extends BaseTest {

    @BeforeEach
    public void setUp() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("testdata.properties"));
        driver.get(System.getProperty("url"));
        loginPage=new LoginPage(driver);
        loginPage.login(System.getProperty("login"),System.getProperty("password"));
        wait.until(ExpectedConditions.urlToBe("http://193.233.193.42:9091/dashboard?id=158-3"));
    }

    @Test
    public void LogoutTest() throws IOException {
        logoutPage = new LogoutPage(driver);
        logoutPage.Logout();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='auth-button auth-button_wide auth-button_adaptive button_a5f0 button_a5f0 heightM_aa2f primary_fc6b buttonWithoutIcon_b3e8']")));
        assertTrue(driver.findElement(By.xpath("//button[@class='auth-button auth-button_wide auth-button_adaptive button_a5f0 button_a5f0 heightM_aa2f primary_fc6b buttonWithoutIcon_b3e8']")).isDisplayed());
    }
}
