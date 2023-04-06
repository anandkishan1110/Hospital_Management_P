package PomExecution;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GenericUtilities.BaseClass;
import com.hms.pom.AdminHomePage;
import com.hms.pom.AdminLoginPage;
import com.hms.pom.DoctorLoginPage;
import com.hms.pom.HomePageHms;
import com.hms.pom.PatientHomePage;
import com.hms.pom.PatientLoginPage;

public class LoginAsAdmin extends BaseClass {
    @Test(priority = 1,groups = "smoke")
	public void loginAdmin() throws Throwable {

		HomePageHms hp=new HomePageHms(driver);
		hp.adminLogin();
		AdminLoginPage al=new AdminLoginPage(driver);
		al.loginAsAdminByEnteringUnPwd(fu);
		
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.clickOnMyProfileDD();
		ahp.clickOnLogout();
		Reporter.log("Login as Admin done", true);
		

	}
   @Test(priority = 2,groups = "smoke")
   public void loginPatient()throws Throwable
   {
	   HomePageHms l=new HomePageHms(driver);
		l.patientLogin();
		PatientLoginPage p=new PatientLoginPage(driver);
		p.loginAsPatientByEnteringUNPwd(fu);

		PatientHomePage php=new PatientHomePage(driver);
		php.clickOnMyProfile();
		php.clickOnLogout();
		Reporter.log("Login as Patient",true);
		
   }
   @Test(priority = 3,groups = "smoke")
   public void loginDoctor()throws Throwable
   {
	   HomePageHms hp=new HomePageHms(driver);
		hp.doctorLogin();
		DoctorLoginPage doc=new DoctorLoginPage(driver);
		doc.loginAsDoctorByEnteringUnPwd(fu);
		Reporter.log("Login as Doctor", true);
		
   }
   
}
