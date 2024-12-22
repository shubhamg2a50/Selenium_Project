package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.CategoryLaptop;

import java.time.Duration;

public class CategoryLaptopStep {
    WebDriver driver;
    CategoryLaptop categoryFilter;

    @Given("I launch browser and opens DemoBlaze homepage")
    public void user_launches_browser_and_opens_demoblaze_homepage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/index.html");
        categoryFilter = new CategoryLaptop(driver);
    }

    @When("User clicks on the Laptop category")
    public void user_clicks_on_the_laptop_category() {
        categoryFilter.clickLaptopCategory();
        categoryFilter.waitForProductsToLoad(); // Wait for products to load
    }

    @Then("Only products related to Laptop are displayed")
    public void only_products_related_to_laptop_are_displayed() {
        boolean areProductsValid = categoryFilter.verifyProductsBelongToCategory("Laptop");
        Assert.assertTrue("Some products do not belong to the Laptop category!", areProductsValid);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
