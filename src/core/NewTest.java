package core;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class NewTest {

	WebDriver driver;

	@BeforeTest
	public void beforeMethod() {
		String url = "https://demo.guru99.com/test/newtours/register.php";

		driver =new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Browser has Opened");
	}

	@Test
	public void homepage() {
		WebElement Username = driver.findElement(By.name("firstName"));
		Username.sendKeys("Ajay");

		WebElement lastname = driver.findElement(By.xpath("(//*[@maxlength='60'])[2]"));
		lastname.sendKeys("Gundekar");
		WebElement phone = driver.findElement(By.name("phone"));
		phone.sendKeys("49346374637");
		WebElement Email = driver.findElement(By.id("userName"));
		Email.sendKeys("Patil123@gmail.com");

	}
	@Test (priority = 1)
	public void Loginpage() {
		WebElement address = driver.findElement(By.name("address1"));
		address.sendKeys("At karavenagar , pune");
		WebElement city = driver.findElement(By.xpath("(//*[@maxlength='60'])[4]"));
		city.sendKeys("Pune");
		WebElement state = driver.findElement(By.name("state"));
		state.sendKeys("Maharashta");
		WebElement postelcode = driver.findElement(By.xpath("(//*[@maxlength='20'])[2]"));
		postelcode.sendKeys("11223");
		
		WebElement Country = driver.findElement(By.name("country"));
		Select country = new Select(Country);
		country.selectByValue("INDIA");
		
		System.out.println("Current page: " +driver.getCurrentUrl());
		System.out.println("Current title: "+driver.getTitle());
		System.out.println("Dropdown has successfuly");

	}
//	@Test(priority = 2)
//	public void DropDown() {
//		WebElement Country = driver.findElement(By.name("country"));
//		Select country = new Select(Country);
//		country.selectByValue("INDIA");
//		
//		System.out.println("Current page: " +driver.getCurrentUrl());
//		System.out.println("Current title: "+driver.getTitle());
//		System.out.println("Dropdown has successfuly");
//	}
	
	
	@Test (priority = 3)
	public void DragAndDrop() {

		String url2 = "https://nxtgenaiacademy.com/alertandpopup/";
		WebDriver driver = new FirefoxDriver();
		driver.get(url2);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Fire Browser has opened");
	}
	
	@Test (priority = 4)
	public void Alter() {
		WebElement Alert = driver.findElement(By.xpath("//*[@name='alertbox']"));
		Alert.click();

		Alert alert = driver.switchTo().alert();
		String validation = alert.getText();
		System.out.println(validation);
		alert.accept();
	}
	
	@Test(priority = 5)
	public void Alter2() {

		WebElement Confirmalertbox = driver.findElement(By.xpath("//*[@name='confirmalertbox']"));
		Confirmalertbox.click();

		Alert ale = driver.switchTo().alert();
		String Massege = ale.getText();
		System.out.println(Massege);
		ale.dismiss();

	}
	@Test(priority = 6)
	public void Alter3() {
		WebElement Promptalertbox = driver.findElement(By.xpath("//button[@name='promptalertbox1234']"));
		Promptalertbox.click();

		Alert alertbox = driver.switchTo().alert();
		String masse = alertbox.getText();
		System.out.println(masse);
		alertbox.sendKeys("No");
		alertbox.accept();

		System.out.println("Current page:" + driver.getCurrentUrl()+"Current title:"+ driver.getTitle());

		System.out.println("Popup has successfully");

	}

	@AfterTest
	public void afterMethod() {
		driver.quit();
	}

}
