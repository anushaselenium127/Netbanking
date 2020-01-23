import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class Pagination {
     public static int totalNames=0;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
	     driver.get("https://datatables.net/");
	     //Thread.sleep(3000);
	     driver.manage().window().maximize();
	     int noPages=driver.findElements(By.cssSelector("#example_paginate>span>a")).size();
	     System.out.println("Total pages :"+noPages);
	  
	     List<WebElement> Numbers=driver.findElements(By.cssSelector("#example_paginate>span>a"));
	    for(int i=1;i<=noPages;i++) {
	    	
	    	driver.findElement(By.cssSelector("#example_paginate>span>a:nth-child("+i+")")).click();
	       List<WebElement> names= driver.findElements(By.cssSelector("#example>tbody>tr>td:nth-child(1)"));
	       
	       for(WebElement ele:names) {
	    	 String value=ele.getText();
	    	 System.out.println(value);
	    	 totalNames++;
	       
	       }
	     }
	    	
	     System.out.println("total names : "+totalNames);
	     String displayCount=driver.findElement(By.id("example_info")).getText().split(" ")[5];
	     //Assert.assertEquals(displayCount,totalNames);
	     System.out.println("Total Names:"+displayCount);
	     driver.close(); 
	}
	
}