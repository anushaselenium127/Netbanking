package Llisteners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Llisteners.TestListener.class)

public class testListener_TestCases {
	public String baseUrl="http://www.demo.guru99.com/v4/";
	public static WebDriver driver;
	String expectedTitle="";
  @Test
  public void login() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get(baseUrl);
	  WebElement userName=driver.findElement(By.xpath("//input[@name='uid']"));
		userName.sendKeys("mngr239573");
		WebElement passwd=driver.findElement(By.xpath("//input[@name='password']"));
		passwd.sendKeys("AhYpevA");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
  }
  @Test
  public void TestToFail()				
  {		
      System.out.println("This method to test fail");					
      Assert.assertTrue(false);			
  }		

}
