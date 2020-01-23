package testNG.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertwithOKCancelButton {

	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  driver.get("http://demo.automationtesting.in/Alerts.html");
		  driver.manage().window().maximize();
		  driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();
		  driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();
		  String ExpTextOK="You pressed Ok";
		  driver.switchTo().alert().accept();
		  String ActTextOK=driver.findElement(By.xpath("//*[@id=\"demo\"]")).getText();
		  if(ActTextOK.equals(ExpTextOK)) {
			  
			  System.out.println("test passed");
		  }
		  
		  driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();
		  String ExpTextCancel="You Pressed Cancel";
		  driver.switchTo().alert().dismiss();
		  String ActTextCancel=driver.findElement(By.xpath("//*[@id=\"demo\"]")).getText();
		  if(ActTextCancel.equals(ExpTextCancel)) {
			  
			  System.out.println("test passed");
		  }
		  
		  //Send Keys
		  driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
		  driver.findElement(By.xpath("//*[@id=\"Textbox\"]/button")).click();
		  driver.switchTo().alert().sendKeys("test");
		  driver.switchTo().alert().accept();
		  String ActTxt=driver.findElement(By.xpath("//*[@id=\"demo1\"]")).getText();
		  System.out.println(ActTxt);
		  if(ActTxt.contains("test")==true) {
			  
			  System.out.println("test passed");
			  
		  }
		  
		  driver.close();
		  
	}

}
