package pack;

import org.example.LoginPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.example.IsuePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTest extends BaseTest{
    @ParameterizedTest
    @CsvSource(value = {
            "QA1, TestPassword2",
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void LogoutTest(String login, String password){
        driver.get("http://193.233.193.42:9091 ");
        loginPage=new LoginPage();
        loginPage.login(login,password);
        wait.until(ExpectedConditions.urlToBe("http://193.233.193.42:9091/dashboard?id=158-3"));
        isuePage=new IsuePage();
        isuePage.Logout();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='auth-button auth-button_wide auth-button_adaptive button_a5f0 button_a5f0 heightM_aa2f primary_fc6b buttonWithoutIcon_b3e8']")));
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://193.233.193.42:9091/hub/auth/login?response_type=token&client_id=66bd1800-0892-4052-9324-319e019ee07f&redirect_uri=http:%2F%2F193.233.193.42:9091%2Foauth&scope=66bd1800-0892-4052-9324-319e019ee07f%20Upsource%20TeamCity%20YouTrack%2520Slack%2520Integration%200-0-0-0-0&state=38c70771-2ce1-4d9c-a6ff-2e7ede88338d";
        //assertEquals(expectedUrl, actualUrl,"dc` uel");
        assertTrue(driver.findElement(By.xpath("//button[@class='auth-button auth-button_wide auth-button_adaptive button_a5f0 button_a5f0 heightM_aa2f primary_fc6b buttonWithoutIcon_b3e8']")).isDisplayed());
    }
}
