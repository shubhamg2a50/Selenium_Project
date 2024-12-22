package pageObject;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='loginusername']")
    WebElement Username;

    @FindBy(xpath = "//input[@id='loginpassword']")
    WebElement password;

    @FindBy(xpath = "//button[normalize-space()='Log in']")
    WebElement loginbtn;

    @FindBy(id = "login2") 
	public
    WebElement loginSection;

    public void loginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginSection));  // Ensure it's clickable
        loginButton.click();
    }

    public void setUsername(String str) {
        Username.sendKeys(str);
    }

    public void setPassword(String str) {
        password.sendKeys(str);
    }

    public void clickOnLogin() {
        loginbtn.click();
    }
}
