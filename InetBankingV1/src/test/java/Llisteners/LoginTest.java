package Llisteners;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class LoginTest {
	
  @Test
  public void loginMail() {
	  
	  //System.out.println("this is login by mail");
	  Assert.assertTrue(true);
	  
  }
  @Test
  public void loginByFacebook() {
	  
	  //System.out.println("this is login by facebook");
	  Assert.assertEquals("true", "tr");
	  
  }
  
  @Test
  public void loginByTwitter() {
	  
	  //System.out.println("this is login by twitter");
	  Assert.assertTrue(true);
	  
  }

}
