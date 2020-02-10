import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrokenLinkTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\arjun\\Desktop\\chromedriver.exe");
		 ChromeOptions options=new ChromeOptions();
		 options.setHeadless(true);
		 ChromeDriver driver=new ChromeDriver(options);
		 //WebDriver driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.get("http://newtours.demoaut.com/");
		 Thread.sleep(5000);
		 List<WebElement> links=driver.findElements(By.tagName("a"));
		 System.out.println("Total Links :"+links.size());
		 
		 for(int i=0;i<links.size();i++) {
			 WebElement element=links.get(i);
			 String url=element.getAttribute("href");
			 URL link=new URL(url);
			 HttpURLConnection con= (HttpURLConnection) link.openConnection();
			 Thread.sleep(2000);
			 con.connect();
			 int respCode=con.getResponseCode();
			 if(respCode>=400) {
				 System.out.println(url+" :This is broken link");
			 }
				 else
				 {
				 System.out.println(url +"  :This is valid link");	 
				 }
			 
		 }
		 driver.close();
	}

}
