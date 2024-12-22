package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObject.Contact;

public class ContactStep {

	WebDriver driver;
	
	Contact contact;
	
	 @Given("I am on the Demoblaze homepage")
	public void i_am_on_the_demoblaze_homepage() {
		 
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.demoblaze.com/index.html");
		 contact = new Contact(driver);
	 }
	 
	 @When("I click on the {string} option")
	 public void i_click_on_the_option(String contactsection) {
	    contact.clickOn(contactsection);
	 }

	 @When("I enter {string} in the contact email field")
	 public void i_enter_in_the_contact_email_field(String email) {
	    contact.emailField(email);
	 }

	 @When("I enter {string} in the contact name field")
	 public void i_enter_in_the_contact_name_field(String name) {
	   contact.nameField(name);
	 }

	 @When("I enter {string} in the message field")
	 public void i_enter_in_the_message_field(String textmessage) {
	   contact.messageField(textmessage);
	 }

	 @When("I click on the {string} button")
	 public void i_click_on_the_button(String message) {
	    contact.clickSendMessageButton(message);
	 }

	 @Then("I should see an alert with the message {string}")
	 public void i_should_see_an_alert_with_the_message(String alert) {
		 Alert alert1 = driver.switchTo().alert();
	        String actualMessage = alert1.getText();
	        Object expectedMessage = alert;
			Assert.assertEquals(expectedMessage, actualMessage);
	        alert1.accept(); // Close the alert
	        driver.quit();
	 }

	
	  
}
