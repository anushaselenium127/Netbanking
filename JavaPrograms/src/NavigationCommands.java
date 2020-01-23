import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands {

	public static void main(String[] args) throws InterruptedException {
		
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.techlistic.com/");
        //Thread.sleep(3000);
        driver.manage().window().maximize();
        String title=driver.getTitle();
        System.out.println("title  :" +title);
        if(title.equalsIgnoreCase("techlistic")) {
        	System.out.println("passed");
        }else {
        	
        	System.out.println("failed");        }
    	    driver.close();

	}

}

