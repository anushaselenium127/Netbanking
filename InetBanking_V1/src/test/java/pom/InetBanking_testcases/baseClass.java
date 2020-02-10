package pom.InetBanking_testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.InetBanking.Utilities.readConfig;


public class baseClass {
	
	readConfig readconfig=new readConfig();
	public String baseUrl=readconfig.getApplicationURL();
	public String userName=readconfig.getUserName();
	public String password=readconfig.getPassword();
	public String chropath=readconfig.getChropath();
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	@Parameters("browser")

	public void setup(String br) {
		
		logger=Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")) {
			
			WebDriverManager.chromedriver().clearPreferences();
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver",readconfig.getChropath());
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			
		}else if(br.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			
			//System.setProperty("webdriver.firefox.marionette",readconfig.getFirefoxpath());
			driver=new FirefoxDriver();
			
		}if(br.equals("IE")) {
			
			System.setProperty("webdriver.chrome.driver",readconfig.getIEpath());
			driver=new InternetExplorerDriver();
			
		}
		
		driver.get(baseUrl);

	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver,String name) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		//after execution you could see a folder "FailedTestsScreenshots" under src
		
		String path=System.getProperty("user.dir")+"/Screenshots/"+name +".png";
		File dest=new File(path);
		
		FileUtils.copyFile(source,dest);

				
	}

}
