package testNG.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		  driver.manage().window().maximize();
		  driver.findElement(By.id("txtUsername")).sendKeys("Admin");;
		  driver.findElement(By.id("txtPassword")).sendKeys("admin123"); 
		  driver.findElement(By.id("btnLogin")).click();
		  
		  Actions actions=new Actions(driver);
		  WebElement admin=driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b"));
		  WebElement userMgt=driver.findElement(By.xpath("//*[@id=\"menu_admin_UserManagement\"]"));
		  WebElement users=driver.findElement(By.xpath("//*[@id=\"menu_admin_viewSystemUsers\"]"));
		  
		  
		  /*actions.moveToElement(admin).build().perform();
		  actions.moveToElement(userMgt).build().perform();
		  actions.moveToElement(users).click().build().perform();*/
		  
		  actions.moveToElement(admin).moveToElement(userMgt).moveToElement(users).click().build().perform();


 
	}

}
