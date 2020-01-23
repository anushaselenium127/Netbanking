package testNG.testcases;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class NewTest {
	public String baseUrl="http://demo.guru99.com/test/newtours/";
	public static WebDriver driver;
	String expectedTitle="Welcome: Mercury Tours";
	
	@BeforeTest
	public void setup() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
	  driver=new ChromeDriver();
	/*System.setProperty("webdriver.gecko.driver", "C:\\Users\\arjun\\Desktop\\eclipse\\Drivers\\geckodriver.exe" );
        // DesiredCapabilities capabilities=DesiredCapabilities.firefox();
         //capabilities.setCapability("marionette", true);
		FirefoxOptions options=new FirefoxOptions();
		options.setLegacy(true);
		driver=new FirefoxDriver(options);*/

	}
	@AfterTest
   public void teardown() {
	 driver.quit();
	}
	
	@BeforeMethod
	public void verifyTitle() throws IOException {
		driver.get(baseUrl);
		String title=driver.getTitle();
		System.out.println("Title  :"+title);
		Assert.assertEquals(expectedTitle,title);
		//Screenshot screenshot= new AShot().takeScreenshot(driver);
		//ImageIO.write(screenshot.getImage(), "jpg",new File("C:\\Users\\arjun\\Desktop\\screenshot.jpg"));
		

	}
	@Test(priority=0)
	public void supportTitle() {
		//driver.get(baseUrl);
		driver.findElement(By.linkText("SUPPORT")).click();
		String supportTitle=driver.getTitle();
		System.out.println("Register Title  :"+supportTitle);
	}
	@Test(priority=1)
	public void registerTitle() throws InterruptedException {
		//driver.get(baseUrl);
		driver.findElement(By.linkText("REGISTER")).click();
		String regTitle=driver.getTitle();
		System.out.println("Register Title  :"+regTitle);
		Thread.sleep(3000);
	}
	@AfterMethod
	public void goHomePage() {
		driver.findElement(By.linkText("Home")).click();	
	}
}
