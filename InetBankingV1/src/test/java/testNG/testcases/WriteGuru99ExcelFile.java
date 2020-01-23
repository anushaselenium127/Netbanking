package testNG.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteGuru99ExcelFile {
	 public void writeExcel(String filepath,String fileName,String sheetName,String[] dataTowrite) throws IOException {
    	 File file=new File(filepath+"\\"+fileName);
		 FileInputStream inputstream=new FileInputStream(file);
	     Workbook guru99workbook=new XSSFWorkbook(inputstream);
		 Sheet sheet=guru99workbook.getSheet(sheetName);
		 int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		 Row row=sheet.getRow(0);
		 Row newRow=sheet.createRow(rowCount+1);
		 for(int j=0;j<row.getLastCellNum();j++) {
			 Cell cell=newRow.createCell(j);
			 cell.setCellValue(dataTowrite[j]);
			 
		 }
		 inputstream.close();
		 FileOutputStream outputstream=new FileOutputStream(file);
		 guru99workbook.write(outputstream);
		 outputstream.close();
	 }

	public static void main(String[] args) throws IOException {
        String[] valueToWrite= {"E","Noida"};
		String filepath=System.getProperty("user.dir")+"\\ConfigurationFiles";
        WriteGuru99ExcelFile objExcel=new WriteGuru99ExcelFile();
        objExcel.writeExcel(filepath,"ExportExcel.xlsx","ExcelGuru99Demo",valueToWrite);
	}

}
