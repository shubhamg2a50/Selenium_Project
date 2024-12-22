package pageObject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TitleValidation {
    WebDriver driver;

    @Before
    public void setup() {
      
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void validateWebPageTitle() {
      
        driver.get("https://www.demoblaze.com/index.html");

        String actualTitle = driver.getTitle();

        String expectedTitle = "STORE";

        Assert.assertEquals("Webpage title did not match!", expectedTitle, actualTitle);
    }

    @After
    public void tearDown() {
      
        driver.quit();
    }
}
