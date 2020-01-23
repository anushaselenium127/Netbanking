package Llisteners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class TestListener implements ITestListener{ //we can use extends TestListenerAdapter
  @Test
  public void f() {
  }

public void onTestStart(ITestResult result) {
	
	System.out.println(result.getName()+" testcase started ");	
}

public void onTestSuccess(ITestResult result) {
	System.out.println("The Name of the testcase passed :" +result.getName());	
}

public void onTestFailure(ITestResult result) {
      
	System.out.println("The Name of the testcase faied :" +result.getName());
	
}

public void onTestSkipped(ITestResult result) {
	
	System.out.println("The Name of the testcase skipped :" +result.getName());	
}

public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	
}

public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	
}

public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	
}
}
