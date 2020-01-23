import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class alertHandling {

	public static void main(String[] args) throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
	        WebDriver driver=new ChromeDriver();
	       driver.get("http://demo.guru99.com/test/delete_customer.php");
	       Thread.sleep(3000);
	       WebElement customerId=driver.findElement(By.xpath("//input[@name='cusid']"));
	       customerId.sendKeys("53920");
	       WebElement submit=driver.findElement(By.xpath("//input[@name='submit']"));
	       submit.click();
	       driver.switchTo().alert().accept();
	       driver.close();
	}      

}
