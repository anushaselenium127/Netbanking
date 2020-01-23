
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
	public static void main(String[] args) throws InterruptedException {
		
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
       driver.get("http://demo.guru99.com/test/newtours/");
       Thread.sleep(3000);
       WebElement linkHome=driver.findElement(By.linkText("Home"));
       WebElement tdHome=driver.findElement(By.xpath("//html/body/div"+ "/table/tbody/tr/td" + "/table/tbody/tr/td"+ "/table/tbody/tr/td" +"/table/tbody/tr"));
       String homeColor=tdHome.getCssValue("background-color");
       System.out.print("Before Hover  :" +homeColor);
       Actions builder=new Actions(driver);
       Action mouseOverHome=builder.moveToElement(linkHome).build();
       mouseOverHome.perform();
       homeColor=tdHome.getCssValue("background-color");
       System.out.print("After Hover  :" +homeColor);
       WebElement userName=driver.findElement(By.xpath("//input[@name='userName']"));
       Action seriesofActions=(Action) builder.moveToElement(userName).click().keyDown(userName,Keys.SHIFT).sendKeys("tutorial").keyUp(userName,Keys.SHIFT).doubleClick().contextClick().build();
       seriesofActions.perform();

       driver.close();

	}

}
