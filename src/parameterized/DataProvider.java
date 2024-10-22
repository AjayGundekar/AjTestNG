package parameterized;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DataProvider {
	WebDriver driver;
	
  @Test(dataProvider = "Datadata")
  public void DataProvideropen(String n, String s) {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://only-testing-blog.blogspot.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  
	  
	  
  }

  @org.testng.annotations.DataProvider
  public Object[][] Datadata() {
	  Object [][] data = new Object[3][2];
	  
	  data [0][0]= "";
	  data [0][1]= "";
	  
	  data [1][0]= "";
	  data [1][1]= "";
	  
	  data [2][0]= "";
	  data [2][1]= "";
	  
	  return data;
    
  }
}
