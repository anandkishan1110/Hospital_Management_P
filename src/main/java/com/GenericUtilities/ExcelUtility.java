package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * This method is used to read data from excel file
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return
	 * @throws Throwable
	 * @author kishan
	 */
	public String readdataFromExcel(String sheetName,int rowNum,int celNum)throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		String value=sh.getRow(rowNum).getCell(celNum).getStringCellValue();
		return value;
		
	}
	/**
	 * This method is used to get LastRowNumber
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 * @author kishan
	 */
	public int getLastRowNo(String sheetName) throws Throwable {
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count=sh.getLastRowNum();
		return count;
		
	}
	/**
	 * This method is used to write data into excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws Throwable
	 * @author kishan
	 */
	public void writeDataIntoExcel(String sheetName,int rowNum,int celNum,String data)throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);	
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		sh.getRow(rowNum).createCell(celNum).setCellValue(data);
		FileOutputStream fos=new FileOutputStream(IpathConstants.ExcelPath);
		wb.write(fos);
	}
	/**
	 * This method is used to read multiple data from excel file
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 * @author kishan
	 */
	
	public HashMap<String,String> readMultipleData(String sheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int count=sh.getLastRowNum();
		HashMap<String,String>map=new HashMap<String,String>();
		for(int i=0;i<=count;i++)
		{
			String key=sh.getRow(i).getCell(0).getStringCellValue();
			String value=sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
	
	
	public Object[][] readMultipleSetOfData(String sheet)throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int lastRow = sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();
		Object [][]obj=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;    
	}
}


