package Practise_pck;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadTheDataFromExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\practise.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		System.out.println(data);

	}

}
