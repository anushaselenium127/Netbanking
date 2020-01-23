package Llisteners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class extentReports {
	 
	 public WebDriver driver;
	 
     public ExtentReports extent;
	 public ExtentTest test;
	 public ExtentHtmlReporter htmlReporter;
	
 @BeforeTest
 public void setExtent() {
	 
	  
	  String path=System.getProperty("user.dir")+"\\test-output\\myreport.html";
	  System.out.println(path);

	  htmlReporter=new ExtentHtmlReporter(path);
	  htmlReporter.config().setDocumentTitle("Automation Report");   
	  htmlReporter.config().setReportName("Functional Report");
	  htmlReporter.config().setTheme(Theme.DARK);

	  
	  extent = new ExtentReports();
	  
	  extent.attachReporter(htmlReporter);
	  System.out.println(path);

	  extent.setSystemInfo("Host","LocalHost");
	  extent.setSystemInfo("OS", "windows10");
	  extent.setSystemInfo("Tested By", "Anusha");
	  extent.setSystemInfo("Browser", "Chrome");
	  System.out.println(path);


   }
    @AfterTest
     public void endReport() {
	  
	     extent.flush();
	     driver.quit();
    }
    @BeforeMethod
    public void setUp() {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.get("https://demo.nopcommerce.com/");
	    driver.manage().window().maximize();
	 	 
    }
    @Test
    public void titleTest() {
    	test=extent.createTest("titleTest");
    	String title=driver.getTitle();
    	Assert.assertEquals(title,"nopCommerce demo store");
    	
    }
    
    @Test
    public void logoTest() {
    	
    	test=extent.createTest("logTest");
    	boolean logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
    	Assert.assertTrue(logo);
    }
    
    @Test
    public void loginTest() {
    	
    	test=extent.createTest("loginTest");
    	Assert.assertTrue(false);
    	
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
    	
    	if(result.getStatus() == ITestResult.FAILURE) {
    		
    		test.log(Status.FAIL, "TEST CASE FAILED IS : "+result.getName());
    		test.log(Status.FAIL, "TEST CASE FAILED IS : "+result.getThrowable());
    		
    		String screenShotPath=extentReports.getScreenShot(driver, result.getName());
    		test.addScreenCaptureFromPath(screenShotPath); //adding screen shot

    	}else if(result.getStatus() == ITestResult.SKIP){
    		
    		test.log(Status.SKIP, "TEST CASE SKIPPED IS : "+result.getName());

    	}else if(result.getStatus() == ITestResult.SUCCESS){
    		
    		test.log(Status.PASS, "TEST CASE PASSED IS : "+result.getName());

    	}
    	
    }
    
    public static String getScreenShot(WebDriver driver,String screenShotName) throws IOException {
    	
    	//String dateName=new String("yyyyMMddhhmmss").
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File source=ts.getScreenshotAs(OutputType.FILE);
    	
    	//after execution you could see a folder "FailedTestsScreenshots" under src
    	
    	String dest=System.getProperty("user.dir")+"/Screenshots/"+screenShotName+".png";
    	File finaldest=new File(dest);
    	FileUtils.copyFile(source, finaldest);
    	return dest;
    	
    }
    
    
   
    
    
}
