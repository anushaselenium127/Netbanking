package testNG.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatadrivenTestCalculator {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\arjun\\Desktop\\chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.htmlMagic?classic=true");
		  driver.manage().window().maximize();
		  
		  FileInputStream file=new FileInputStream("C:\\Users\\arjun\\Desktop\\eclipse\\DataDrivenTest\\CalculatorData.xlsx");
		  XSSFWorkbook workbook=new XSSFWorkbook(file);
		  XSSFSheet sheet=workbook.getSheetAt(0);
		  int row_count=sheet.getLastRowNum();
		  
		  for(int i=1;i<=row_count;i++) {
			  
			  XSSFRow row=sheet.getRow(i);
			  
			  XSSFCell principle=row.getCell(0);
			  int princ=(int)principle.getNumericCellValue();
			  
			  XSSFCell rateofInterest=row.getCell(1);
			  int roi=(int)rateofInterest.getNumericCellValue();
			  
			  XSSFCell per=row.getCell(2);
			  int period=(int)per.getNumericCellValue();
			  
			  XSSFCell frequency=row.getCell(3);
			  String freq=frequency.getStringCellValue();
			  
			  XSSFCell mv=row.getCell(4);
			  Double matValue=mv.getNumericCellValue();
			  
			  
			  driver.findElement(By.id("principal")).sendKeys(String.valueOf(princ));
			  driver.findElement(By.id("interest")).sendKeys(String.valueOf(roi));
			  driver.findElement(By.id("tenure")).sendKeys(String.valueOf(period));
			  
			  Select periodCombo=new Select(driver.findElement(By.id("tenurePeriod")));
			  periodCombo.selectByVisibleText("year(s)");
			  Select fq=new Select(driver.findElement(By.id("frequency")));
              fq.selectByVisibleText(freq);
              
             driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();
              
			 //System.out.println(driver.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText());
			 String act_Value= driver.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText();
			 
             driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[2]/img")).click();

			  if(Double.parseDouble(act_Value)==matValue) {
				  
				  System.out.println("Testcase Passed");  
				  
			  }	 else {
				  
				  System.out.println("Testcase Failed");  

			  } 
	             driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[2]/img")).click();
			  
		  }
			 driver.close();

	}
	 // driver.close();


}
