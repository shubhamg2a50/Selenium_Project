package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.Cart;

import java.time.Duration;

public class CartStep {
    WebDriver driver;
    Cart productCartPage;

    @When("User selects a product and adds it to the cart")
    public void user_selects_a_product_and_adds_it_to_the_cart() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/index.html");

        productCartPage = new Cart(driver);

        productCartPage.selectProduct(); // Step 1: Click on the product
        productCartPage.addToCart(); // Step 2 & 3: Add to cart and handle alert
    }

    @Then("The product {string} priced at {int} is displayed in the cart")
    public void the_product_is_displayed_in_the_cart(String expectedProductName, int expectedPrice) {
        productCartPage.openCart(); // Step 4: Open the cart
        boolean isProductInCart = productCartPage.verifyProductInCart(expectedProductName, expectedPrice); // Step 5: Verify product

        Assert.assertTrue("The product is not present in the cart!", isProductInCart);

        driver.quit();
    }
}
