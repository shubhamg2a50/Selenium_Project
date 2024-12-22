package stepDefinitions;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Login;

public class LoginStep {

    WebDriver driver;
    Login login;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 

        login = new Login(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I launch browser and navigate to the login page")
    public void i_launch_browser_and_navigate_to_the_login_page() {
        driver.get("https://www.demoblaze.com/index.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(login.loginSection)); 
    }

    @When("I click on the Log in section")
    public void i_clicked_on_log_in_sectionn() {
        login.loginButton();
    }

    @When("I enter valid username {string} into username field")
    public void i_enter_valid_username_into_username_field(String string) {
        login.setUsername(string);
    }

    @And("I enter valid password {string} into password field")
    public void i_enter_valid_password_into_password_field(String string) {
        login.setPassword(string);
    }

    @And("I click on login button")
    public void i_click_on_login_button() {
        login.clickOnLogin();
    }

    @Then("i successfully login")
    public void i_successfully_login() {
        Assert.assertTrue(driver.getCurrentUrl().contains("index.html"));
    }
}
