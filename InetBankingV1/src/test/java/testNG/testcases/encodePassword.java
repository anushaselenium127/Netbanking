package testNG.testcases;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class encodePassword {

	public static void main(String[] args) {
           
		/*String str="test123";
		byte[] encodedString=Base64.encodeBase64(str.getBytes());
		System.out.println("encoded string :"+ new String(encodedString));
		
		byte[] decodedString=Base64.decodeBase64(encodedString);
		System.out.println("decoded string :"+ new String(decodedString));*/
		Logger logger=Logger.getLogger("encodePassword");
		PropertyConfigurator.configure("log4j.properties");
		
		
		logger.info("opening Browser");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  driver.get("https://demo.nopcommerce.com/");
		  driver.manage().window().maximize();
		  
			logger.info("Logging page");

		  driver.findElement(By.linkText("Log in")).click();
		  driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("test@gmail.com");
		  driver.findElement(By.id("Password")).sendKeys(decodeString("dGVzdDEyMw=="));
		  driver.findElement(By.xpath("//input[@value='Log in']")).click();
		  
			logger.info("Testcase passe");

	}
		  
          static String decodeString(String password) {
    	  byte[] decodedString=Base64.decodeBase64(password);
    	  return(new String(decodedString));
      
	}

}
