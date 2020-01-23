import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class FileUploadUsingSikuli {

	public static void main(String[] args) throws FindFailed {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
		
		 String filepath="C:\\Users\\arjun\\Desktop\\eclipse\\DataDrivenTest\\";
		  String imgFile="C:\\Users\\arjun\\Desktop\\eclipse\\DataDrivenTest\\";
		  
		  Pattern fileInputTextBox=new Pattern("C:\\Users\\arjun\\Desktop\\eclipse\\DataDrivenTest\\ImgText.PNG");
		  //System.out.println(fileInputTextBox);
		  Pattern openButton=new Pattern("C:\\Users\\arjun\\Desktop\\eclipse\\DataDrivenTest\\ImgOpen.PNG");
		  
		  Screen s=new Screen();

		  WebDriver driver=new ChromeDriver();
		  driver.get("http://demo.guru99.com/test/image_upload/index.php");
		  driver.manage().window().maximize();
		  
		  driver.findElement(By.xpath("//*[@id='photoimg']")).click();
		  
		  s.wait(fileInputTextBox, 20);
		  s.type(fileInputTextBox, imgFile + "Demo.txt");
		  s.click(openButton);

	}

}
