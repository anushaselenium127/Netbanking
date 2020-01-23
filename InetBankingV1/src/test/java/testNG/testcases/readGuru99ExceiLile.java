package testNG.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readGuru99ExceiLile {
     public void readExcel(String filepath,String fileName,String sheetName) throws IOException {
    	 System.out.println("File path :"+filepath);
    	 File file=new File(filepath+"\\"+fileName);
    	 System.out.println("Filepath :"+file);
		 FileInputStream inputstream=new FileInputStream(file);
	     Workbook guru99workbook=new XSSFWorkbook(inputstream);
		/* Workbook guru99workbook=null;;
		 String fileextensionname=fileName.substring(fileName.indexOf("."));
    	 System.out.println("File extension :"+fileextensionname);

		 if(fileextensionname.equals(".xslx")) {
			 
			 guru99workbook=new XSSFWorkbook(inputstream);
				 
		 }
		 else if(fileextensionname.equals(".xls")) {
			 
			 guru99workbook=new HSSFWorkbook(inputstream);
		 }*/
		  //guru99workbook=new XSSFWorkbook(inputstream);
		//XSSFSheet sheet=guru99workbook.getSheet(sheetName);
    	 System.out.println("workbook name :"+guru99workbook);
		 Sheet sheet=guru99workbook.getSheet(sheetName);
    	 System.out.println("Sheet Name :"+sheet); 
		 int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		 for(int i=0;i<=rowCount;i++) {
			 Row row=sheet.getRow(i);
			 for(int j=0;j<row.getLastCellNum();j++) {
				 System.out.print(row.getCell(j).getStringCellValue()+"||");
				 
			 }
			 System.out.println();
		 }
		 inputstream.close();
		 }
	public static void main(String...strings) throws IOException {
		
		readGuru99ExceiLile excelFile=new readGuru99ExceiLile();
		 //String filepath="C:\\Users\\arjun\\Desktop";
		 String filepath=System.getProperty("user.dir")+"\\ConfigurationFiles";
		//System.out.println("File path :"+filepath);
		excelFile.readExcel(filepath,"ExportExcel.xlsx","ExcelGuru99Demo");

	}

}

