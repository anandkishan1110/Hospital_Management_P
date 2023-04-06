package Patient_Module;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.GenericUtilities.DataBaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtilitity;
import com.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PatientBookA {

	public static void main(String[] args) throws Throwable {
		DataBaseUtility dbu=new DataBaseUtility();
		ExcelUtility eu=new ExcelUtility();
		FileUtility fu=new FileUtility();
		JavaUtilitity ju=new JavaUtilitity();
		WebDriverUtility wdu=new WebDriverUtility();
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		String URL = fu.readDataFromPropertyFile("url");
		String DUN=fu.readDataFromPropertyFile("dun");
		String DPWD=fu.readDataFromPropertyFile("dpwd");
		d.get(URL);
		wdu.maximizeWindow(d);
		d.findElement(By.xpath("//h3[.='Doctors Login']/../descendant::a")).click();
		d.findElement(By.name("username")).sendKeys(DUN);
		d.findElement(By.name("password")).sendKeys(DPWD);
		d.findElement(By.name("submit")).click();
		//d.findElement(By.xpath("//h2[contains(text(),' Book My Appointment')]/following::a")).click();
		WebElement dd = d.findElement(By.xpath("//i[@class='icon-arrow']"));
		wdu.mousehover(d, dd);
		d.findElement(By.xpath("//ul[@class='sub-menu']/descendant::span[contains(text(),' Add Patient')]")).click();
		HashMap<String, String> map = eu.readMultipleData("Sheet1");
//		FileInputStream f=new FileInputStream(".\\src\\test\\resources\\practise.xlsx");
//		Workbook wb = WorkbookFactory.create(f);
//		Sheet sh = wb.getSheet("Sheet1");
//		HashMap<String, String>map=new HashMap<String,String>();
//		for(int i=0;i<=sh.getLastRowNum();i++)
//		{
//			String key=sh.getRow(i).getCell(0).getStringCellValue();
//			String value=sh.getRow(i).getCell(1).getStringCellValue();
//			map.put(key, value);
//		}
		for(Entry<String, String> set:map.entrySet()) {
			d.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			
		}
		d.findElement(By.name("submit")).submit();
		d.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
		d.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-dark']/descendant::a[contains(text(),'Log Out')]")).click();
		System.out.println("appointment done sucessfully");
		d.quit();
	}

}
