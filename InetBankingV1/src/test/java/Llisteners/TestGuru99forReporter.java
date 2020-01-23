package Llisteners;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;
import testNG.testcases.Guru99Reporter;
@Listeners(value=Guru99Reporter.class)

public class TestGuru99forReporter {
	
    @Test(priority=0,description="testReporterOne")

    public void testReporterOne(){

        //Pass test case

        Assert.assertTrue(true);

    }

    

    @Test(priority=1,description="testReporterTwo")

    public void testReporterTwo(){

        //Fail test case

        Assert.assertTrue(false);

    }
}
