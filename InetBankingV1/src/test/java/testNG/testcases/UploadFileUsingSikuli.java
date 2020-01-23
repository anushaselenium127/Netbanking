package testNG.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class UploadFileUsingSikuli {

	public static void main(String[] args) throws InterruptedException {
      
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  driver.get("http://demo.automationtesting.in/Register.html");
		  driver.manage().window().maximize();
		  
		  WebElement chooseFile=driver.findElement(By.xpath("//*[@id='imagesrc']"));

		 // Thread.sleep(2000);
		  JavascriptExecutor js=((JavascriptExecutor) driver);
		  js.executeScript("arguments[0].click();",chooseFile);
		  
		  //have to try this scriptin Java Programs by adding jar file
		  
		 // driver.findElement(By.xpath("//*[@id='imagesrc']")).click();
		  
		 /* String filepath="C:\\Users\\arjun\\Desktop\\eclipse\\DataDrivenTest\\";
		  String imgFile="C:\\Users\\arjun\\Desktop\\eclipse\\DataDrivenTest\\";
		  
		  
		  Screen s=new Screen();
		  
		  Pattern fileInputTextBox=new Pattern(filepath+"ImgText.PNG");
		  //System.out.println(fileInputTextBox);
		  Pattern openButton=new Pattern(filepath+"ImgOpen.PNG");
		 		  
		  s.wait(fileInputTextBox, 20);
		  s.type(fileInputTextBox, imgFile+"Demo.txt");
		  s.click(openButton);*/
		 
	}

}
