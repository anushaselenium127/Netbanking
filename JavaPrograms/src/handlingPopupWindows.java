import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlingPopupWindows {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
       driver.get("http://demo.guru99.com/popup.php");
       driver.manage().window().maximize();
       Thread.sleep(3000);
       String mainWindow=driver.getWindowHandle();
       driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
       Set<String> s1=driver.getWindowHandles();
       Iterator<String> i1=s1.iterator();
       while(i1.hasNext()) {
    	   String childWindow=i1.next();
    	   if(!mainWindow.equalsIgnoreCase(childWindow)) {
    		   driver.switchTo().window(childWindow);
    		   driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("gaurav.3n@gmail.com");
    		   driver.findElement(By.name("btnLogin")).click();
    		   driver.close();
    		   
    	   }
    	   //driver.switchTo().window(mainWindow);
    	   driver.close();
     }
     
	}

}
