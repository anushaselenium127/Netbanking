package pom.InetBanking.Utilities;

//Listener class which is used to  generate extent reports

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pom.InetBanking_testcases.baseClass;


public class Reporting extends baseClass implements ITestListener {
	
	
	public ExtentReports extent;
	 public ExtentTest test;
	 public ExtentHtmlReporter htmlReporter;
	

	public void onTestStart(ITestResult result) {

		  String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		  String repName="Test-Report"+timeStamp+".html";
		  String path=System.getProperty("user.dir")+"\\test-output\\"+repName;
		  
		  htmlReporter=new ExtentHtmlReporter(path);
		  htmlReporter.loadConfig(System.getProperty("user.dir")+"\\extent-config.xml");
		  
		  htmlReporter.config().setDocumentTitle("Inet Banking test Project");   
		  htmlReporter.config().setReportName("Functional Test automation Report");
		  htmlReporter.config().setTheme(Theme.DARK);

		  
		  extent = new ExtentReports();
		  
		  extent.attachReporter(htmlReporter);
		  extent.setSystemInfo("Host","LocalHost");
		  extent.setSystemInfo("OS", "windows10");
		  extent.setSystemInfo("Tested By", "Anusha");
		  extent.setSystemInfo("Browser", "Chrome");




	}

	public void onTestSuccess(ITestResult result) {

		test=extent.createTest(result.getName());
		test.log(Status.PASS, "TEST CASE PASSED IS : "+result.getName());

	}

	public void onTestFailure(ITestResult result) {
		
		test=extent.createTest(result.getName());

		test.log(Status.FAIL, "TEST CASE FAILED IS : "+result.getName());
		test.log(Status.FAIL, "TEST CASE FAILED IS : "+result.getThrowable());
		
		TakesScreenshot ts=(TakesScreenshot)driver;
    	File source=ts.getScreenshotAs(OutputType.FILE);
    	
    	//after execution you could see a folder "FailedTestsScreenshots" under src
    	
    	String dest=System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png";
    	File finaldest=new File(dest);
    	try {
			FileUtils.copyFile(source, finaldest);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    
		
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";
		File f=new File(screenshotPath);
		
		if(f.exists()) {
			
			try {
				
				test.fail("Screenshotis below : "+test.addScreenCaptureFromPath(screenshotPath));
				
			}catch(Exception e) {
				
				e.printStackTrace();
			}
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		
		test=extent.createTest(result.getName());
		test.log(Status.PASS, "TEST CASE PASSED IS : "+result.getName());		
	}

	
	public void onFinish(ITestContext context) {
             extent.flush();		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
}
