import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RobotClassDemo {

	public static void main(String[] args) {
	   System.setProperty("webdriver.gecko.marionette","C:\\Users\\arjun\\Desktop\\geckodriver.exe");
       WebDriver driver=new FirefoxDriver();
       driver.get("http://newtours.demoaut.com/");
	}

}
