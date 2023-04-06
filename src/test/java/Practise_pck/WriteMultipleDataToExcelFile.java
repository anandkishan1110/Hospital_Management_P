package Practise_pck;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteMultipleDataToExcelFile {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\practise.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int count = wb.getSheet("Sheet1").getLastRowNum();
		for(int i=1;i<=count;i++) {
			 wb.getSheet("Sheet1").getRow(i).createCell(6).setCellValue("Writing");
			 wb.getSheet("Sheet1").getRow(i).createCell(7).setCellValue("Write");
		}
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\practise.xlsx");
		wb.write(fos);
		wb.close();

	}

}
