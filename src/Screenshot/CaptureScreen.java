package Screenshot;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class CaptureScreen {
	WebDriver driver;

	@BeforeTest
	public void login() {
		String url = "https://www.functionize.com/h/test-automation?utm_source=google&utm_medium=paid%20search&utm_campaign=automated%20web%20testing&utm_term=automated%20web%20testing&utm_campaign=Z+-+India+-+Automated+Web+Testing&utm_source=adwords&utm_medium=ppc&hsa_acc=5488573823&hsa_cam=16375912712&hsa_grp=133300773506&hsa_ad=583785827749&hsa_src=g&hsa_tgt=kwd-304942589907&hsa_kw=automated%20web%20testing&hsa_mt=p&hsa_net=adwords&hsa_ver=3&gad=1&gclid=Cj0KCQjwwvilBhCFARIsADvYi7IBEfV5uoKDXH2pfAFmoYS2MJeAzfF8jV4G7GA6NAgS3ZbqVdZ2mQMaAp6SEALw_wcB";

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//System.out.println("Browser has opened title"+driver.getTitle());
		
		
	}
	@Test 
	public void HomePage() {
		
		WebElement firstname = driver.findElement(By.name("firstname"));
		firstname.sendKeys("Ajay");
		
		WebElement lastName = driver.findElement(By.xpath("(//*[@inputmode='text'])[2]"));
		lastName.sendKeys("Patil");
		
		WebElement Email =driver.findElement(By.name("email"));
		Email.sendKeys("ajay222@gmail.com");
		
		
		WebElement Phone = driver.findElement(By.xpath("//*[@inputmode='tel']"));
		Phone.sendKeys("473437946389439585");
	}
	@Test (priority = 2)
	public void Setp() {
		WebElement CompanyName = driver.findElement(By.xpath("(//*[@inputmode='text'])[3]"));
		CompanyName.sendKeys(" ");
		
		WebElement Jobrol = driver.findElement(By.name("job_role"));
		Select select = new Select(Jobrol);
		select.selectByValue("Software Engineer");
		
		WebElement Testing = driver.findElement(By.id("biggest_software_challenge-e6941a0e-690e-4617-8e6e-50f486bddd59"));
		Select test = new Select(Testing);
		test.selectByIndex(8);
		
		WebElement Submit = driver.findElement(By.name("hs_context"));
		Submit.click();
		
	}


   @AfterMethod
	public void screenshot() {

		File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		try {
			org.openqa.selenium.io.FileHandler.copy(scrfile, new File("File/Screenshot.jpg"));
			System.out.println("Screenshot has been successeful");

		} catch (IOException e) {
			System.out.println("Excepation handing");
			e.printStackTrace();
		}

	}

}
