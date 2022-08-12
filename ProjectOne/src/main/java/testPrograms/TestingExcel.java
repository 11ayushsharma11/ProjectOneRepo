package testPrograms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestingExcel {

	public static void main(String[] args) throws Exception {
		
		readData();
		writeData();
		createAndWriteData();
		
	}
	
	private static void readData() throws Exception
	{
		FileInputStream fis = new FileInputStream("./Data/Excel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		
		int lastRowNumber = sheet.getLastRowNum();
		
		for(int i=0; i<=lastRowNumber; i++)
		{
			Row row = sheet.getRow(i);
			int lastCellNumber = row.getLastCellNum();
			for(int j=0; j<lastCellNumber; j++)
			{
				Cell cell = row.getCell(j);
				String value = cell.getStringCellValue();
				System.out.print(value+" ");
			}
			System.out.println();
		}
	}
	
	private static void writeData() throws Exception
	{
		FileInputStream fis = new FileInputStream("./Data/Excel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		
		Row row = sheet.createRow(12);
		Cell cell = row.createCell(0);
		cell.setCellValue("new Value");
		
		FileOutputStream fos = new FileOutputStream("./Data/Excel.xlsx");
		wb.write(fos);
		wb.close();
		
	}
	
	private static void createAndWriteData() throws Exception
	{
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("NewSheet1");
		
		Row row = sheet.createRow(11);
		Cell cell = row.createCell(0);
		cell.setCellValue("new Value");
		
		FileOutputStream fos = new FileOutputStream("./Data/NewExcel.xlsx");
		wb.write(fos);
		wb.close();
		fos.close();
		
	}
}
