package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact {

	WebDriver driver;
	
	public Contact(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Contact']")
	WebElement contactSection;
	
	@FindBy(xpath = "//input[@id='recipient-email']")
	WebElement contactEmail;
	
	@FindBy(xpath = "//input[@id='recipient-name']")
	WebElement contactName;
	
	@FindBy(xpath = "//textarea[@id='message-text']")
	WebElement entermessage;
	
	@FindBy(xpath = "//button[normalize-space()='Send message']")
	WebElement sendbtn;
	
	public void clickOn(String contactsection) {
		contactSection.click();
	}
	
	public void emailField(String email) {
		contactEmail.sendKeys(email);
	}
	
	public void nameField(String name) {
		contactName.sendKeys(name);
	}
	
	public void messageField(String textmessage) {
		entermessage.sendKeys(textmessage);
	}
	
//	public void clickSendMessageButton(String message) {
//		sendbtn.click();
//	}

	public void clickSendMessageButton(String message) {
		// TODO Auto-generated method stub
		sendbtn.click();
	}
	
	
	
}
