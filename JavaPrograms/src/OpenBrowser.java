import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class OpenBrowser {
     public static String expectedTitle="Google";
     
	public static void main(String[] args) throws InterruptedException {
		
           System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
		  //System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
          //WebDriver driver=new InternetExplorerDriver();
           WebDriver driver=new ChromeDriver();
          driver.get("https://google.com");
          Thread.sleep(3000);
          //driver.manage().window().maximize();
          String title=driver.getTitle();
          if(title.equals(expectedTitle)){
    	 
          //System.out.print("Title is :" +title);
          System.out.println("Testcase passed");
          
          }else {
        	  
              System.out.println("Testcase failed");
  
          }
          driver.close();
          
	}

}
