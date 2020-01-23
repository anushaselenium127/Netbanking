package testNG.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softassertionDemo {
	
	SoftAssert softassert1=new SoftAssert();
	SoftAssert softassert2=new SoftAssert();

 
	@Test
  public void demo1() {
		
		softassert1.assertEquals("welcome", "wel");
		softassert1.assertAll();
  }
	
	@Test
	  public void demo2() {
			
		softassert2.assertEquals("welcome", "welcome");
		softassert2.assertAll();
	  }
}
