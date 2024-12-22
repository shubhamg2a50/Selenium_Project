package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.TextReadability;

public class TextReadabilityStep {

    WebDriver driver;
    TextReadability textReadability;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        textReadability = new TextReadability(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I launch the demoBlaze website")
    public void i_launch_the_demoBlaze_website() {
        driver.get("https://www.demoblaze.com/index.html");
        textReadability.waitForTextElements(); 
    }

    @When("I verify the visibility of all card text elements")
    public void i_verify_the_visibility_of_all_card_text_elements() {
        boolean isVisible = textReadability.verifyTextVisibility();
        System.out.println("Text are visible properly: " + isVisible);
        if (!isVisible) {
            throw new AssertionError("Some text elements are not visible.");
        }
    }

    @Then("all card text elements should be visible and readable")
    public void all_card_text_elements_should_be_visible_and_readable() {
        boolean isReadable = textReadability.verifyTextReadability();
        System.out.println("Texts are well readable:" + isReadable);
        if (!isReadable) {
            throw new AssertionError("Some card text elements are not readable.");
        }
    }
}
