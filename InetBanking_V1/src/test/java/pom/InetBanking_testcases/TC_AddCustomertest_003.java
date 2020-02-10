package pom.InetBanking_testcases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import junit.framework.Assert;
import pom.InetBanking_pageObjects.addNewCustomer;
import pom.InetBanking_pageObjects.loginPage;


public class TC_AddCustomertest_003 extends baseClass{
	
	@Test
	public void addnewcustomer() throws InterruptedException {
		
		loginPage lp=new loginPage(driver);
		lp.setUserName(userName);
		lp.setpw(password);
		lp.clickSubmit();
		Thread.sleep(3000);
		
		addNewCustomer addcust=new addNewCustomer(driver);
		logger.info("providing custmor details");
		Thread.sleep(3000);
		addcust.addNewCustomer();
		Thread.sleep(3000);
		addcust.setName("Anusha");
		addcust.custgender();
		addcust.custDob("12","12","1987");
		addcust.custAddress("INDIA");
		addcust.custCity("Hyd");
		addcust.custState("AP");
		addcust.custpinNo("342432");
		addcust.custtelNo("33254354");
		
		String email=randomString()+"gmail.com";
		addcust.custemailId(email);
		addcust.submitClick();
		
		logger.info("Customer datails provided");
		Thread.sleep(3000);
		
		String res= driver.switchTo().alert().getText(); 
		//driver.getPageSource().contains("Could not connect");
		System.out.println(res);
		
		Assert.assertEquals("Please fill all fields", res);
		logger.info("added customer");
		/*if(res!=null) {
			
			Assert.assertTrue(true);
			}else {
				
			Assert.assertTrue(false);	
			}*/
	}
	
	public String randomString() {
		
		String generatedstring=RandomStringUtils.randomAlphabetic(6);
		return generatedstring;
	}

}
