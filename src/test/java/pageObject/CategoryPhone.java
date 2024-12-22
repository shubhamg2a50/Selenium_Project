package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CategoryPhone {
    WebDriver driver;

    private By categoryPhones = By.linkText("Phones");
    private By productTitles = By.cssSelector("div.card.h-100 h4.card-title a");

    public CategoryPhone(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPhonesCategory() {
        driver.findElement(categoryPhones).click();
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
                !productName.toLowerCase().contains("galaxy") &&  
                !productName.toLowerCase().contains("iphone") &&
                !productName.toLowerCase().contains("nokia") &&
                !productName.toLowerCase().contains("nexus") &&
                !productName.toLowerCase().contains("sony") && 
                !productName.toLowerCase().contains("htc")) {
                System.out.println("Unrelated product found: " + productName);
                return false;
            }
        }
        return true;
    }
}
