package testNG.testcases;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class hashMapDemo {
	
	public static HashMap<String , String> loginData() {
		
		HashMap<String , String> hm=new HashMap<String , String>();
		hm.put("x", "mercury@mercury");
		hm.put("y", "mercury@mercury1");
	   

		return hm;


	}

	public static void main(String[] args) {

		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  driver.get("http://newtours.demoaut.com/");
		  driver.manage().window().maximize();
		  
			
			//int i=hm.size();
		   
			
		  //String data[]=hm.get("i").split("@");
		  String data[]=loginData().get("x").split("@");
		  System.out.println(   data[0]  );
		  
		  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(data[0]);
		  driver.findElement(By.xpath("//input[@type='password']")).sendKeys(data[1]);
		  driver.findElement(By.name("login")).click();
		  
		  driver.findElement(By.linkText("Name")).click();
		
		
	}

}
