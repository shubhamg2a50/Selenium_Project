package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.SignUp;

public class SignUpStep {
    WebDriver driver;
    SignUp signUpPage;

    @Given("I am on the demoBlaze homepage")
    public void i_am_on_the_demoBlaze_homepage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/index.html");
        signUpPage = new SignUp(driver);
    }

    @When("I click on the Sign Up option")
    public void i_click_on_the_sign_up_option() {
        signUpPage.clickOnSignUpSection();
    }

    @When("I enter the username {string} and password {string}")
    public void i_enter_the_username_and_password(String username, String password) {
        signUpPage.enterSignUpDetails(username, password);
    }

    @When("I click on the Sign Up button")
    public void i_click_on_the_sign_up_button() {
        signUpPage.clickOnSignUpButton();
    }

    @Then("an alert message should popup with the message {string}")
    public void an_alert_message_should_popup_with_the_message(String expectedAlertMessage) {
        String actualAlertMessage = signUpPage.handleAlertAndGetMessage();
        if (!actualAlertMessage.equals(expectedAlertMessage)) {
            throw new AssertionError("Expected: " + expectedAlertMessage + ", but got: " + actualAlertMessage);
        }
    }
    
    
}
