package Practise_pck;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationTest {
	@BeforeSuite
	public void connectDB()
	{
		Reporter.log("Connect to DataBase", true);
	}
	@AfterSuite
	public void disconnectToDb()
	{
		Reporter.log("Disconnect to DataBase", true);
	}
	@BeforeTest
	public void openBrowser()
	{
		Reporter.log("Open Browser",true);
	}
	@AfterTest
	public void closeBrowser()
	{
		Reporter.log("Close Browser", true);
	}
	@Test
	public void execute1()
	{
		Reporter.log("Execute Data1", true);
	}
	@Test
	public void execute2()
	{
		Reporter.log("Execute Data2", true);
	}
	@BeforeMethod
	public void login()
	{
		Reporter.log("Login To Application", true);
	}
	@AfterMethod
	public void logout()
	{
		Reporter.log("LogOut to application", true);
	}
	

}
