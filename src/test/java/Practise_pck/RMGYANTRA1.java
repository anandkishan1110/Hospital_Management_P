package Practise_pck;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.GenericUtilities.DataBaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtilitity;
import com.GenericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RMGYANTRA1 {

	public static void main(String[] args) throws Throwable {
		
		DataBaseUtility dbu=new DataBaseUtility();
		ExcelUtility eu=new ExcelUtility();
		FileUtility fu=new FileUtility();
		JavaUtilitity ju=new JavaUtilitity();
		WebDriverUtility wdu=new WebDriverUtility();
		try {
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		String TYURL = fu.readDataFromPropertyFile("tyurl");
		String TYUN = fu.readDataFromPropertyFile("tyun");
		String TYPWD = fu.readDataFromPropertyFile("typwd");
		d.get(TYURL);
		d.manage().window().maximize();
		d.findElement(By.xpath("//form[@class='form-signin']/descendant::input[@id='usernmae']")).sendKeys(TYUN);
		d.findElement(By.xpath("//form[@class='form-signin']/descendant::input[@id='inputPassword']")).sendKeys(TYPWD);
		d.findElement(By.xpath("//form[@class='form-signin']/descendant::button[@type='submit']")).click();
		Thread.sleep(5000);
		d.findElement(By.xpath("//a[.='Projects']")).click();
		d.findElement(By.xpath("//span[.='Create Project']")).click();
		Random r=new Random();
		int ran=r.nextInt(100);
		String pname="LKG"+ran;
		d.findElement(By.name("projectName")).sendKeys(pname);
		d.findElement(By.name("createdBy")).sendKeys("Raja");
		WebElement dd = d.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select s=new Select(dd);
		s.selectByValue("On Going");
		d.findElement(By.xpath("//input[@type='submit']")).click();
		dbu.connectToDbTY();
		String query="select * from project;";
		dbu.executeQueryAndGetData(query, pname, 4);
		}
		catch(Exception e) {
			
		}
		finally {
			dbu.closeDB();
			
		}
	}

	}


