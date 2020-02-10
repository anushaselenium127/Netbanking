package parameterizationtestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dataproviderUtil {

			public static ArrayList<Object[]> dataSet() throws IOException {
		  
			  FileInputStream file=new FileInputStream("C:\\Users\\arjun\\Desktop\\eclipse\\DataDrivenTest\\CalculatorData.xlsx");
			  XSSFWorkbook workbook=new XSSFWorkbook(file);
			  XSSFSheet sheet=workbook.getSheetAt(0);
			  int row_count=sheet.getLastRowNum();
			  ArrayList<Object[]> mydata=new ArrayList<Object[]>();
			  
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
				  
				 // XSSFCell mv=row.getCell(4);
				  //Double matValue=mv.getNumericCellValue();
				  
				  Object[] ob= {princ,roi,period,freq};
				  mydata.add(ob);
				  
				  
			  }			  
			  return mydata;
	
	}

}
