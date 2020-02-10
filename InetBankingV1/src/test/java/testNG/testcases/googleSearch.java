package testNG.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class googleSearch {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\arjun\\Desktop\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		 driver.get("http://www.google.com");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        
	}

}
