package testNG.testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class guru99_TC_Class1 {
	public String baseUrl="http://www.demo.guru99.com/v4/";
	public static WebDriver driver;
	String expectedTitle="";
	
	@Test(groups= {"Bonding","Strong_Ties"})
	public void tc00Setup() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get(baseUrl);
	}
	@Test(groups= {"Bonding"})
	public void tc01LaunchUrl() {
		WebElement aTitle=driver.findElement(By.xpath("//h2[@class='barone']"));
	    Assert.assertTrue(aTitle.isDisplayed(),"No title");
	    System.out.println("Title Displayed");
	}
	@Test(groups= {"Bonding","Strong_Ties"})
	public void tc02EnterCredentials() {
		WebElement userName=driver.findElement(By.xpath("//input[@name='uid']"));
		userName.sendKeys("mngr239573");
		WebElement passwd=driver.findElement(By.xpath("//input[@name='password']"));
		passwd.sendKeys("AhYpevA");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}
	@Test(groups= {"Strong_Ties"})
	public void tc03VerifyLoggedin() {
		WebElement managerPage=driver.findElement(By.linkText("Manager"));
	    Assert.assertTrue(managerPage.isDisplayed(),"Not logged Correctly");
	    System.out.println("Loggedin manager Page");
	}
	@Test(groups= {"Bonding"})
	public void tc04VerifyLinks() {
		WebElement customerLink=driver.findElement(By.linkText("New Customer"));
	    Assert.assertTrue(customerLink.isDisplayed(),"No Links");
	    System.out.println("Links existed");
		
	}
	@AfterTest
   public void teardown() {
	 driver.quit();
  }
}
