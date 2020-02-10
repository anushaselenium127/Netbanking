package parameterizationtestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameterDemo {
	
 @Test
 @Parameters({"url","searchKey","pw"})
 
 public void login(String url,String searchKey,String pw) {
	 
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
	  WebDriver driver=new ChromeDriver();
	 driver.get(url);
	 //driver.findElement(By.xpath(url));
	 driver.findElement(By.name("txtUsername")).sendKeys(searchKey);
	 driver.findElement(By.name("txtPassword")).sendKeys(pw);
	 driver.findElement(By.id("btnLogin")).click();
	 
	 driver.close();

 }
 

}
