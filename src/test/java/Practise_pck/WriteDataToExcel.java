package Practise_pck;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\practise.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet("Sheet1").getRow(1).createCell(10).setCellValue("Rohan");
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\practise.xlsx");
		wb.write(fos);
		wb.close();

	}

}
