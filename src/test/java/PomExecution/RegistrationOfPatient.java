package PomExecution;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.hms.pom.HomePageHms;
import com.hms.pom.PatientLoginPage;
import com.hms.pom.PatientRegistrationPage;
@Listeners(com.GenericUtilities.ListenerImplementation.class)
public class RegistrationOfPatient extends BaseClass{
     @Test
     public void patientRegistration()throws Throwable
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
	Assert.assertEquals(data, data1);
	 {
		System.out.println("Registration done");
	}
	
	}

}
