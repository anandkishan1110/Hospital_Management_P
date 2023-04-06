package PomExecution;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.hms.pom.HomePageHms;
import com.hms.pom.PatientBookAppointmentPage;
import com.hms.pom.PatientHomePage;
import com.hms.pom.PatientLoginPage;
@Listeners(com.GenericUtilities.ListenerImplementation.class)
public class BookAppointmentPatient extends BaseClass{
    @Test
	public void bookAppointmenr() throws Throwable {
		
		HomePageHms hp=new HomePageHms(driver);
		hp.patientLogin();
		PatientLoginPage pl=new PatientLoginPage(driver);
		pl.loginAsPatientByEnteringUNPwd(fu);
		PatientHomePage ph=new PatientHomePage(driver);
		ph.clickOnAppointmentLink();
		PatientBookAppointmentPage pba=new PatientBookAppointmentPage(driver);
		pba.fillAppointmentDetail(wdu);
		wdu.acceptAlert(driver);
		Reporter.log("Appointment Done",true);
	}

}
