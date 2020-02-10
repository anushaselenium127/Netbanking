package pom.InetBanking_testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pom.InetBanking.Utilities.XLUtils;
import pom.InetBanking_pageObjects.loginPage;

public class TC_LoginDDT_002 extends baseClass {
	
	@Test(dataProvider="loginData")
	public void loginDDT(String uname,String pw) throws IOException, InterruptedException {
		
		loginPage lp=new loginPage(driver);
		lp.setUserName(uname);
		logger.info("username provided");
		lp.setpw(pw);
		logger.info("password provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			
			captureScreenshot(driver,"LoginDDT");
			logger.info("Screenshot taken");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Test data wrong....Testcase passed");
			logger.warn("testdata failed with wrong username");
			
			Assert.assertTrue(false);
			
		}else {
			
			Assert.assertTrue(true);
			logger.info("clicking logout");
			Thread.sleep(3000);
			lp.clickLogout();
			Thread.sleep(5000);

			logger.info("logout done");
			//logger.info("accepting alert");
			//driver.switchTo().alert().getText();
			////driver.switchTo().alert().accept();
			//logger.info("Accepted alert");
			//driver.switchTo().defaultContent();
			driver.get(baseUrl);
			//logger.info("Moved login page");
			//logger.warn("Login Failed");
		}
		
	}	
		
	
	public boolean isAlertPresent() {
		try {
			
		driver.switchTo().alert();
		return true;
		
		}catch(NoAlertPresentException e){
			
			return false;
		}
	}
	

	
	
	@DataProvider(name="loginData")
	String [][] getData() throws IOException{
		
		String path=System.getProperty("user.dir")+"//src//test//java//pom//InetBanking//testdata//MiniprojectData.xlsx";
		logger.info(path);
		
		int rownum=XLUtils.getRowCount(path, "sheet1");
		int colcount=XLUtils.getCellCount(path, "sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			
		  for(int j=0;j<colcount;j++) {
				  
		   logindata[i-1][j] =XLUtils.getCellData(path, "sheet1", i, j);
		  //We are storing xlfile data into two dimensional array so the rowvalue started in xcel is 1 and in array is '0'
		  //so we redused array rownumber -1(i-1)
		
		}
	}
		
    return logindata;

 }

}











