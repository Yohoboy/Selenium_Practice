package dataFromJSON;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromMObileCompanyExcel
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		
		
			
		
		FileInputStream fis = new FileInputStream("C:\\SeleniumExternalData\\MobileCompanySheet.xlsx");
		try 
		{
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet("CompInfo");
			int rowCount = sheet.getLastRowNum();
			
			for(int i = 1; i <= rowCount; i++)
			{
				Row row = sheet.getRow(i);
				String column1 = row.getCell(0).toString();
				String column2 = row.getCell(1).toString();
				String column3 = row.getCell(2).toString();
				
				System.out.println(column1+" "+column2+" "+column3);
				
			}
			
			
		} 
		catch (EncryptedDocumentException | IOException e)
		{
			
			e.printStackTrace();
		}
		

		
		
		
	}

}
