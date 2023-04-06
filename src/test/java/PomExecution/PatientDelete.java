package PomExecution;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.hms.pom.AdminHomePage;
import com.hms.pom.AdminLoginPage;
import com.hms.pom.HomePageHms;
import com.hms.pom.PatientLoginPage;
import com.hms.pom.PatientRegistrationPage;
@Listeners(com.GenericUtilities.ListenerImplementation.class)
public class PatientDelete extends BaseClass {
	@Test(priority = 1)
	public void deletePatient() throws Throwable
	{
		HomePageHms hp=new HomePageHms(driver);
		hp.patientLogin();
		PatientLoginPage plp=new PatientLoginPage(driver);
		plp.registrtionPatient();
		PatientRegistrationPage prp=new PatientRegistrationPage(driver);
		prp.fillRegistrationTextFiled(ju);
		String data = wdu.getTextAlert(driver);
		String data1="Successfully Registered. You can login now";
		wdu.acceptAlert(driver);
		Assert.assertEquals(data,data1);
		Reporter.log("Registration done",true);
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		Reporter.log("Registration done",true);
	}
	@Test(priority = 2)
	public void adminLogin()throws Throwable
	{
		HomePageHms hp=new HomePageHms(driver);
		hp.adminLogin();
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.loginAsAdminByEnteringUnPwd(fu);
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.clickOnManageUser();
		wdu.scrollBarAction(driver);
		driver.findElement(By.xpath("//tbody/tr[last()]/descendant::td[last()]")).click();
		wdu.acceptAlert(driver);
		ahp.clickOnMyProfileDD();
		ahp.clickOnLogout();
		Reporter.log("Logout admin successfully after deleting", true);
	}
	@Test(priority = 3)
	public void patientLogin()throws Throwable
	{
		HomePageHms hp=new HomePageHms(driver);
		hp.patientLogin();
		PatientLoginPage plp=new PatientLoginPage(driver);
		plp.loginRandom(ju);
		Reporter.log("Patient deleted suucessfully",true);

	}
}
