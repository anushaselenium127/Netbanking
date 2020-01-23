package Llisteners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;




@Listeners(RealGuru99TimeReport.class)

public class testGuru99RealReport {
	 
    @Test

    public void testRealReportOne(){

        Assert.assertTrue(true);

    }   

    @Test

    public void testRealReportTwo(){

        Assert.assertTrue(false);

    }
    @Test(dependsOnMethods="testRealReportTwo")

    public void testRealReportThree(){
        

    }

}
