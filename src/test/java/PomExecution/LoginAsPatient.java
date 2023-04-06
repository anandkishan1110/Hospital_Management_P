package PomExecution;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GenericUtilities.BaseClass;
import com.hms.pom.HomePageHms;
import com.hms.pom.PatientHomePage;
import com.hms.pom.PatientLoginPage;

public class LoginAsPatient extends BaseClass {
	@Test
	public void login() throws Throwable
	{
		
		HomePageHms l=new HomePageHms(driver);
		l.patientLogin();
		PatientLoginPage p=new PatientLoginPage(driver);
		p.loginAsPatientByEnteringUNPwd(fu);

		PatientHomePage php=new PatientHomePage(driver);
		php.clickOnMyProfile();
		php.clickOnLogout();
		

	}

}
