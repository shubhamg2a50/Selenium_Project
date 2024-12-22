package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.time.Duration;

public class TextReadability {

    WebDriver driver;

    public TextReadability(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private By cardText = By.cssSelector(".card-text");

    public List<WebElement> getCardTextElements() {
        return driver.findElements(cardText);
    }

    public boolean verifyTextVisibility() {
        List<WebElement> texts = getCardTextElements();
        for (WebElement text : texts) {
            if (!text.isDisplayed()) {
                System.out.println("Text not visible: " + text.getText());
                return false;
            }
        }
        return true;
    }

    public boolean verifyTextReadability() {
        List<WebElement> texts = getCardTextElements();
        for (WebElement text : texts) {
            String textColor = text.getCssValue("color");
            String backgroundColor = text.getCssValue("background-color");

            if (textColor.equals("rgba(0, 0, 0, 0)") || backgroundColor.equals("rgba(255, 255, 255, 0)")) {
                System.out.println("Text readability issue: " + text.getText());
                return false;
            }
        }
        return true;
    }

    public void waitForTextElements() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cardText));
    }
}
