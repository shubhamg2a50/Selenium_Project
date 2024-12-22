package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CategoryLaptop {
    WebDriver driver;

    private By categoryLaptops = By.linkText("Laptops");
    private By productTitles = By.cssSelector("div.card.h-100 h4.card-title a");
    private By productContainer = By.cssSelector("div#tbodyid"); // Container for products

    public CategoryLaptop(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLaptopCategory() {
        driver.findElement(categoryLaptops).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(productTitles, "Sony vaio")); // Wait for a laptop product to load
    }

    public void waitForProductsToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(productContainer));
    }

    public List<WebElement> getProducts() {
        return driver.findElements(productTitles);
    }

    public boolean verifyProductsBelongToCategory(String categoryKeyword) {
        List<WebElement> products = getProducts();

        if (products.isEmpty()) {
            System.out.println("No products found in the category!");
            return false;
        }

        for (WebElement product : products) {
            String productName = product.getText();

            System.out.println("Product found: " + productName);

            if (!productName.toLowerCase().contains(categoryKeyword.toLowerCase()) &&
                !productName.toLowerCase().contains("vaio") &&
                !productName.toLowerCase().contains("macbook") &&
                !productName.toLowerCase().contains("dell")) {
                System.out.println("Unrelated product found: " + productName);
                return false;
            }
        }
        return true;
    }
}
