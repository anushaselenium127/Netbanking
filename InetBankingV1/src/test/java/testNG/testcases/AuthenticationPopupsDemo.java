package testNG.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopupsDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  //  https://username:password@test.com  to avoid authentication popups
		  driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		  driver.manage().window().maximize();
		
	}

}
