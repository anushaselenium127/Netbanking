import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BootstrapDropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
	     driver.get("https://www.automationtestinginsider.com/2019/12/bootstrap-dropdown-example_12.html");
	     //Thread.sleep(3000);
	     driver.manage().window().maximize();
	     
	     driver.findElement(By.xpath("//button[@id='bootstrapmenu']")).click();
	     List<WebElement> options = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));
	     for(WebElement ele:options) {
	    	 String value=ele.getText();
	    	 System.out.println(value);
	    	 if(value.equalsIgnoreCase("contact us")) {
	    	 ele.click();	 
	    	 break;
	    	 }
	     }
	     driver.close();
	}

}

