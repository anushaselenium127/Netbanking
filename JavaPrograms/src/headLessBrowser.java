import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class headLessBrowser {

	public static void main(String[] args) {
		
		 System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\arjun\\\\Desktop\\\\chromedriver.exe");
		 ChromeOptions options=new ChromeOptions();
		 options.setHeadless(true);
		 ChromeDriver driver=new ChromeDriver(options);
		  driver.get("http://www.google.com");
		  String title = driver.getTitle();
		  System.out.print(title);
	}

}
