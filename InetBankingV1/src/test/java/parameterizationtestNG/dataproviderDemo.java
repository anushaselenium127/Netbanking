package parameterizationtestNG;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataproviderDemo {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
	
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
   	 driver=new ChromeDriver();
	 driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.htmlMagic?classic=true");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	 //driver.get("http://newtours.demoaut.com");	 
	
	}
	
	@DataProvider
	public Iterator<Object[]> getdata() throws IOException{
		
		ArrayList<Object[]> testData=dataproviderUtil.dataSet();
		return testData.iterator();
		
	}
	
	@Test(dataProvider="getdata")
	public void calculate(int princ,int roi,int period,String fq) {
		
		  //driver.findElement(By.id("principal")).clear();;
		  driver.findElement(By.id("principal")).sendKeys(String.valueOf(princ));
		
		  //driver.findElement(By.id("interest")).clear();;
		  driver.findElement(By.id("interest")).sendKeys(String.valueOf(roi));
		  
		  //driver.findElement(By.id("tenure")).clear();
		  driver.findElement(By.id("tenure")).sendKeys(String.valueOf(period));
		  
		  Select periodCombo=new Select(driver.findElement(By.id("tenurePeriod")));
		  periodCombo.selectByVisibleText("year(s)");
		  Select fq1=new Select(driver.findElement(By.id("frequency")));
          fq1.selectByVisibleText(fq);
        
       driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();
        
		 System.out.println(driver.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText());
		 //String act_Value= driver.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText();
		 
    //   driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[2]/img")).click();
		//System.out.printl(driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[2]/img")).getText());
		
	}
	
	@AfterMethod	
	public void teardown() {
		
		//driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[2]/img")).click();
		driver.close();
	}

}
