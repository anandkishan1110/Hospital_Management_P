package com.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public DataBaseUtility dbu=new DataBaseUtility();
	public ExcelUtility eu=new ExcelUtility();
	public static FileUtility fu=new FileUtility();
	public static WebDriverUtility wdu=new WebDriverUtility();
	public static JavaUtilitity ju=new JavaUtilitity();
	public  WebDriver driver;
	public static WebDriver edriver;
	
	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable
	{
	dbu.connectToDbTY();	
	Reporter.log("connect to database",true);
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configBC(/*String BROWSER*/) throws Throwable
	{
		String BROWSER = fu.readDataFromPropertyFile("browser");
		String URL = fu.readDataFromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			Reporter.log("Invalid browser",true);
		}
		edriver=driver;
		wdu.maximizeWindow(driver);
		driver.get(URL);
	}
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable
	{
		//String UN = fu.readDataFromPropertyFile("un");
		//String PWD=fu.readDataFromPropertyFile("pwd");
//		HomePageHms hp=new HomePageHms(driver);
//		hp.patientLogin();
//		PatientLoginPage plp=new PatientLoginPage(driver);
//		plp.loginAsPatientByEnteringUNPwd(fu);
	}
	@AfterMethod(alwaysRun = true)
	public void configAM()
	{
//		PatientHomePage php=new PatientHomePage(driver);
//		php.clickOnMyProfile();
//		php.clickOnLogout();
	}
	@AfterClass(alwaysRun = true)
	public void configAC()
	{
		driver.quit();
	}
	@AfterSuite(alwaysRun = true)
	public void configAS() throws Throwable
	{
		dbu.closeDB();
	}

}
