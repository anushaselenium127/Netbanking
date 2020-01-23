package testNG.testcases;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileDownloadDemo {

	public static void main(String[] args) throws InterruptedException {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		 driver.get("http://demo.automationtesting.in/FileDownload.html");
		  driver.manage().window().maximize();
		  driver.findElement(By.id("textbox")).sendKeys("testing");
		  driver.findElement(By.id("createTxt")).click();
		  driver.findElement(By.id("link-to-download")).click();
	
		  Thread.sleep(5000);
		  
		  if(isFileExist("C://Users/arjun/Downloads/info.txt")){
			  
			  System.out.println("File Exist");
			  }
		  else {
			  
			  System.out.println("File not Exist");

		  }
		  
          if(isFileExist("C://Users/arjun/Downloads/info.pdf")){
			  
			  System.out.println("File Exist");
			  }
		  else {
			  
			  System.out.println("File not Exist");

		  }

		  
		  driver.findElement(By.id("pdfbox")).sendKeys("Testing Example for pdf download");
		  driver.findElement(By.id("createPdf")).click();
		  driver.findElement(By.id("pdf-link-to-download")).click();

	}
	static boolean isFileExist(String path) {
		File f=new File(path);
		
		if(f.exists()) {
			
			return true;
		}else {
			
			return false;
		}
			
		
		
		
	}

}
