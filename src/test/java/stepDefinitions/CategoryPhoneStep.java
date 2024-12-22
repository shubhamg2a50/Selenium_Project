package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.CategoryPhone;

import java.time.Duration;

public class CategoryPhoneStep {
    WebDriver driver;
    CategoryPhone categoryFilter;

    @Given("User launches browser and opens DemoBlaze homepage")
    public void user_launches_browser_and_opens_demoblaze_homepage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/index.html");
        categoryFilter = new CategoryPhone(driver);
    }

    @When("User clicks on the Phones category")
    public void user_clicks_on_the_phones_category() {
        categoryFilter.clickPhonesCategory();
    }

    @Then("Only products related to Phones are displayed")
    public void only_products_related_to_phones_are_displayed() {
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        boolean areProductsValid = categoryFilter.verifyProductsBelongToCategory("Phone");
        Assert.assertTrue("Some products do not belong to the Phones category!", areProductsValid);
    }
    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
}
