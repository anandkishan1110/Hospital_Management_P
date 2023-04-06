package Practise_pck;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingMultipleData {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\practise.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int count = wb.getSheet("Sheet1").getLastRowNum();
		for(int i=1;i<count;i++) {
			String data1 = wb.getSheet("Sheet1").getRow(i).getCell(0).getStringCellValue();
			String data2= wb.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue();
			System.out.println(data1+" "+data2);
	
		}
	}
}
