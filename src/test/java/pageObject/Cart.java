package pageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Cart {
    WebDriver driver;

    // Product-related locators
    private By productLink = By.xpath("//a[normalize-space()='Iphone 6 32gb']"); // Product link
    private By addToCartButton = By.xpath("//a[normalize-space()='Add to cart']"); // Add to cart button
    
    // Cart-related locators
    private By cartLink = By.xpath("//a[@id='cartur']"); 
    private By cartItems = By.cssSelector("#tbodyid > tr"); 
    private By cartProductName = By.xpath("//td[normalize-space()='Iphone 6 32gb']"); 
    private By cartProductPrice = By.xpath("//td[normalize-space()='790']"); 

    public Cart(WebDriver driver) {
        this.driver = driver;
    }

    // Step 1: Select the product
    public void selectProduct() {
        driver.findElement(productLink).click();
    }

    // Step 2 & 3: Add the product to the cart and handle alert
    public void addToCart() {
        driver.findElement(addToCartButton).click();
        handleAlert(); 
        
    }

    private void handleAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
          
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();
            String alertMessage = alert.getText(); 
            System.out.println("Alert message: " + alertMessage); 
            alert.accept(); 
        } catch (Exception e) {
            System.out.println("No alert present.");
        }
    }

    public void openCart() {
        driver.findElement(cartLink).click();
    }

    public List<WebElement> getCartItems() {
        return driver.findElements(cartItems);
    }

    public boolean verifyProductInCart(String expectedProductName, int expectedPrice) {
        List<WebElement> items = getCartItems();

        for (WebElement item : items) {
            String productName = item.findElement(cartProductName).getText();
            int productPrice = Integer.parseInt(item.findElement(cartProductPrice).getText());

            System.out.println("Product in cart - Name: " + productName + ", Price: " + productPrice);

            if (productName.equalsIgnoreCase(expectedProductName) && productPrice == expectedPrice) {
                return true; 
            }
        }
        return false; 
    }
}
