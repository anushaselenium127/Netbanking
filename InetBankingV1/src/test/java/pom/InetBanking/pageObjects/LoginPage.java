package pom.InetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPage {
	public String baseUrl="https://google.com";
	public static WebDriver driver;
	
	@Test
	public void setup() {
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.get(baseUrl);
	}
	@Test
   public void teardown() {
	   driver.quit();
   }
  
}
