package testNG.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDeno {
  @Test
  public void loginTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
	  WebDriver driver=new ChromeDriver();
	  driver.get("http://newtours.demoaut.com/");
	  driver.manage().window().maximize();
	  
	  WebElement userName=driver.findElement(By.xpath("//input[@name='userName']"));
	  WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
	  
	 /* Assert.assertTrue(userName.isDisplayed());
	  userName.sendKeys("mercury");*/
	  
	  Assert.assertFalse(userName.isDisplayed());
	  userName.sendKeys("mercury");
	 
	  
	  Assert.assertTrue(password.isDisplayed());
	  password.sendKeys("mercury");

	  
	  driver.findElement(By.name("login")).click();
	  
	  //System.out.println(driver.getTitle());
	  String expTitle="Find a Flight: Mercury Tours:";
	  
	  Assert.assertEquals(driver.getTitle(), expTitle);
	  
	  driver.close();
	  
	  
  }
  
}
