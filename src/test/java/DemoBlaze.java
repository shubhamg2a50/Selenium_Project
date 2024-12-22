import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoBlaze {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.demoblaze.com/index.html");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//a[normalize-space()='Log in'])[1]")).click();
		
		//driver.findElement(By.xpath("//a[text()='Samsung galaxy s6']")).click();
	}
}
