package testNG.testcases;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;

public class Guru99Reporter implements IReporter{
  

public void generateReport(List<XmlSuite> arg0, List<ISuite> arg1, String outputDirectory) {
  for(ISuite isuite:arg1) {
	  Map<String, ISuiteResult> results=isuite.getResults();
	  Set<String> keys=results.keySet();
	  for(String key:keys) {
		  ITestContext context=results.get(key).getTestContext();
		  System.out.println("Suite Name  :"+context.getName()
		                     +"\nReport output directory  :"+context.getOutputDirectory()
		                     +"\nSuite Name   :"+context.getSuite().getName()
		                     +"\nStart Date time for execution  :"+context.getStartDate()
		                     +"\nEnd date time for execution   :"+context.getEndDate());
		  
		  IResultMap resultMap=context.getFailedTests();
		  Collection<ITestNGMethod> failedMethods=resultMap.getAllMethods();
		  System.out.println("----------ALL FAILED  METHODS--------");
		  for(ITestNGMethod itestNGmethod:failedMethods) {
			 System.out.println("TESTCASE NAME   :"+itestNGmethod.getMethodName()
			                    +"\nDescription   :"+itestNGmethod.getDescription()
			                    +"\nPriority     :"+itestNGmethod.getPriority()
			                    +"\nDate        :"+new Date(itestNGmethod.getDate()));
			  
		  }
	  }
  }	
}
}
