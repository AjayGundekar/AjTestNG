package Screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Screenshot {
	WebDriver driver;
  @Test
  public void Screen() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement username= driver.findElement(By.name("username"));
		username.sendKeys("Admin");
		
		WebElement pass = driver.findElement(By.name("password"));
		pass.sendKeys("admin123");
		
		WebElement click = driver.findElement(By.xpath("//*[type='submit']"));
		click.click();
		Thread.sleep(3000);

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			Thread.sleep(10000);
			FileHandler.copy(screenshot, new File("File/Screenshot.png"));
			System.out.println("Screenshot captured succesfully");
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}
  }
}
