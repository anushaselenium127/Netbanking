package pom.InetBanking_testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pom.InetBanking_pageObjects.loginPage;

public class TC_loginTest_001 extends baseClass {
	
	@Test
	public void loginTest() throws IOException {
		
		driver.get(baseUrl);
		logger.info("Opened URL");
		loginPage lp=new loginPage(driver);
		lp.setUserName(userName);
		lp.setpw(password);
		lp.clickSubmit();
		logger.info("logged in");
		
		
		if(driver.getTitle().equalsIgnoreCase("GTPL Bank Manager HomePage")) {
			
			Assert.assertTrue(true);
			logger.info("test passed");
			
		}else {
			
			captureScreenshot(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("test failed.....Screenshot Taken...");
		}
		
	}

}
