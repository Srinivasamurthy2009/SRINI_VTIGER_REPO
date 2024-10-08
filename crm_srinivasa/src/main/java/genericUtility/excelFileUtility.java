
//2. Second class - to get the excel file related details in the scripts.
package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import net.bytebuddy.asm.Advice.Return;

public class excelFileUtility {
//To Read data from Excel sheet.	
	 public String readDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	 {
	 FileInputStream fis= new FileInputStream("./configAppData/testScriptData.xlsx");
	 Workbook wb = WorkbookFactory.create(fis);
	 String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	 wb.close();
	 return data;	 

     }
	 
//To get the row count.	 
	 public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException
	 {
		 FileInputStream fis = new FileInputStream("./configAppData/testScriptData.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		 int rowCount = wb.getSheet(sheetName).getLastRowNum();
		 wb.close();
		 return rowCount;
		 
	 }

	 
//To write the data back to excel sheet.
	 public void writeDataIntoExcelFile(String sheetName, int rowNum, int cellNum) throws IOException
	 {
		 FileInputStream fis = new FileInputStream("./configAppData/testScriptData.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		 wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		 
		 FileOutputStream fos = new FileOutputStream("./configAppData/testScriptData.xlsx");
		 wb.write(fos);
		 wb.close();
	 }
	 
	 
	 
}



