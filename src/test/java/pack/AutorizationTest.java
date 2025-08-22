package pack;
import org.example.LoginPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutorizationTest extends BaseTest{

@Test
public void  loginTest(){
    driver.get(System.getProperty("url"));
loginPage=new LoginPage(driver);
loginPage.login(System.getProperty("login"),System.getProperty("password"));
wait.until(ExpectedConditions.urlToBe("http://193.233.193.42:9091/dashboard?id=158-3")
);
String actualUrl = driver.getCurrentUrl();
String expectedUrl = "http://193.233.193.42:9091/dashboard?id=158-3";
assertEquals(expectedUrl, actualUrl, "ii");

    }
}
