package parameterized;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Para {
	
	WebDriver driver;
	
	String browser = "chrome";
	@BeforeTest
	public void browserlaunched() {
		
		
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firechrome")) {
			driver = new FirefoxDriver();
		}

		driver.get("http://only-testing-blog.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test (priority = 1)
	public void Homepage() {
		WebElement GrandParent1 = driver.findElement(By.name("gparent1"));
		GrandParent1.sendKeys("vijay");
		WebElement parent1 = driver.findElement(By.id("parent_1"));
		parent1.sendKeys("three");
		WebElement child = driver.findElement(By.name("child1"));
		child.sendKeys("Shubham");
		WebElement Grandparent2 = driver.findElement(By.id("gparent_2"));
		Grandparent2.sendKeys("Rahul");
		WebElement parent2 = driver.findElement(By.name("parent2"));
		parent2.sendKeys("pooja");
		WebElement child2 = driver.findElement(By.id("child_2"));
		child2.sendKeys("anu");
		
	}
	@Test (priority = 2)
	public void TooltipExample() {
		WebElement Name = driver.findElement(By.xpath("//*[@title='Enter You name']"));
		Name.sendKeys("Ajay");
		WebElement Surname = driver.findElement(By.xpath("//*[@class='s_name']"));
		Surname.sendKeys("Gundekar");
		WebElement address = driver.findElement(By.xpath("//*[@class='y_address']"));
		address.sendKeys("pune");
		
	}
	@Test (priority = 3)
	public void iframe1() {
		driver.switchTo().frame(2);
		
		WebElement cat = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
		cat.click();
		WebElement Dog = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
		Dog.click();
		WebElement Cow = driver.findElement(By.xpath("(//*[@type='checkbox'])[3]"));
		Cow.click();
		WebElement lion = driver.findElement(By.xpath("(//*[@type='checkbox'])[4]"));
		lion.click();
		WebElement tigerElement = driver.findElement(By.xpath("(//*[@type='checkbox'])[5]"));
		tigerElement.click();
		System.out.println("Iframe has opened");
	}
	@AfterTest
	public void Textbox() {
		WebElement firstName = driver.findElement(By.name("fname"));
		firstName.sendKeys("Sanket");
		WebElement lastName = driver.findElement(By.xpath("(//*[@id='text2'])[2]"));
		lastName.sendKeys("Rautpatil");
		WebElement ToHide = driver.findElement(By.name("To Hide"));
		ToHide.sendKeys("Car");
		WebElement Car = driver.findElement(By.xpath("(//*[@value='Car'])[2]"));
		Car.click();
		WebElement Male = driver.findElement(By.name("gender"));
		Male.click();
		// File Uploading
		WebElement ChooseFile = driver.findElement(By.name("img"));
		ChooseFile.isDisplayed();
		ChooseFile.sendKeys("C:\\Users\\Hp\\Pictures\\Screenshots\\Screenshot (2).png");
		System.out.println("File uploading has opened");
		
		WebElement slect = driver.findElement(By.name("FromLB"));
		Select select = new Select(slect);
		select.deselectByValue("India");
		System.out.println("DropDown has opened");
		
		WebElement alert = driver.findElement(By.xpath("(//*[@onclick='myFunction()'])[2]"));
		alert.click();
		
		//Popup handing
		Alert alert2 = driver.switchTo().alert();
		String massage = alert2.getText();
		System.out.println(massage);
		alert2.accept();
		System.out.println("Popup Hinding has successful");
		
		WebElement showalert = driver.findElement(By.xpath("(//*[@onclick='myFunction1()'])[2]"));
		showalert.isEnabled();
		Alert alert3 = driver.switchTo().alert();
		String mass = alert3.getText();
		System.out.println(mass);
		alert3.dismiss();
		
	}

}
