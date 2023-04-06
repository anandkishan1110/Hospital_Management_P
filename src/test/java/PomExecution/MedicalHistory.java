package PomExecution;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.hms.pom.HomePageHms;
import com.hms.pom.MedicalHistoryPage;
import com.hms.pom.PatientHomePage;
import com.hms.pom.PatientLoginPage;
public class MedicalHistory extends BaseClass{
    @Test()
	public void medicalHistory() throws Throwable {
		HomePageHms hp=new HomePageHms(driver);
		hp.patientLogin();
		PatientLoginPage plp=new PatientLoginPage(driver);
		plp.loginAsPatientByEnteringUNPwd(fu);
		PatientHomePage php=new PatientHomePage(driver);
		php.clickOnMedicalHistory();
		MedicalHistoryPage mhp=new MedicalHistoryPage(driver);
		mhp.clickOnActionIcon();
		Reporter.log("User is able see their medical history",true);
		Assert.fail();
	}

}
