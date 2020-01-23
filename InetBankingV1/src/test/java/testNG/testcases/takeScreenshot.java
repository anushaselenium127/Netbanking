package testNG.testcases;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class takeScreenshot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  driver.get("http://demo.guru99.com/test/guru99home/");
		  driver.manage().window().maximize();
		  WebElement img=driver.findElement(By.xpath("//div[@class='rt-logo-block']//a//img"));
		  Screenshot screenshot = new AShot().takeScreenshot(driver,img);
		  
		  ImageIO.write(screenshot.getImage(),"png", new File("C://Users/arjun/Desktop/Screenshot.png"));
		  File f=new File ("C://Users/arjun/Desktop/Screenshot.png");
		  
		  if(f.exists()) {
		  System.out.println("file exists") ;
		  }else {
		  System.out.println("file not exists") ;

		  }
		    
		  
		  driver.close();
		  }

	public File getScreenshotAs(OutputType<File> file) {
		// TODO Auto-generated method stub
		return null;
	}

}
