package testNG.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  driver.get("http://demo.guru99.com/test/drag_drop.html");
		  driver.manage().window().maximize();
		  WebElement source=driver.findElement(By.xpath("//*[@id='fourth']/a"));
		  
		  Thread.sleep(5000);
		  WebElement dest=driver.findElement(By.xpath("//*[@id='amt7']/li"));
		  
		  Actions actions=new Actions(driver);
		  //actions.dragAndDropBy(source, 109,40).build().perform();
		  actions.clickAndHold(source).moveToElement(dest).release().build().perform();
		  Thread.sleep(5000);
	}

}
