package PomExecution;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.hms.pom.AdminHomePage;
import com.hms.pom.AdminLoginPage;
import com.hms.pom.DoctorHomePage;
import com.hms.pom.DoctorLoginPage;
import com.hms.pom.HomePageHms;
import com.hms.pom.PatientBookAppointmentPage;
import com.hms.pom.PatientHomePage;
import com.hms.pom.PatientLoginPage;
@Listeners(com.GenericUtilities.ListenerImplementation.class)
public class SystemTesting extends BaseClass {
		@Test(priority = 1)
		public void bookAppointmentPatient() throws Throwable
		{
		HomePageHms hp=new HomePageHms(driver);
		hp.patientLogin();
		PatientLoginPage plp=new PatientLoginPage(driver);
		plp.loginAsPatientByEnteringUNPwd(fu);
		PatientHomePage php=new PatientHomePage(driver);
		php.clickOnAppointmentLink();
		PatientBookAppointmentPage pba=new PatientBookAppointmentPage(driver);
		pba.fillAppointmentDetail(wdu);
		wdu.acceptAlert(driver);
		pba.clickOnAppointmentLinkButton();
		String aResult="USER | APPOINTMENT HISTORY";
		String eResult=driver.findElement(By.xpath("//h1[@class='mainTitle']")).getText();
		if(eResult.equals(aResult)) {
			Reporter.log("user appointment history is displayed with details",true);
		}else {
			Reporter.log("user appointment history is not displayed with details",true);
		}
		php.clickOnMyProfile();
	    php.clickOnLogout();
		}
      @Test(priority = 2)
      public void doctorLogin()throws Throwable
      {
 
        HomePageHms hp=new HomePageHms(driver);
        hp.doctorLogin();
		DoctorLoginPage dlp=new DoctorLoginPage(driver);
		dlp.loginAsDoctorByEnteringUnPwd(fu);
		DoctorHomePage dhp=new DoctorHomePage(driver);
		dhp.clickOnDoctorAppointmentHistory();
		String aName=driver.findElement(By.xpath("//tbody/tr[last()]/descendant::td[.='ANNA']")).getText();
		String eName="ANNA";
		if(aName.equals(eName)) {
			Reporter.log("Appointment is there in doctor my appointment history",true);
		}else
		{
			Reporter.log("Appointment is not there in doctor my appointment history",true);
		}
		dhp.myProfileDD();
		dhp.logOutAsDoctor();
      }
      @Test(priority = 3)
      public void adminLogin()throws Throwable
      {
    	HomePageHms hp=new HomePageHms(driver);
		hp.adminLogin();
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.loginAsAdminByEnteringUnPwd(fu);
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.clickOnAppointmentHistory();
		String data1=driver.findElement(By.xpath("//tbody/tr[last()]/descendant::td[.='ANNA']")).getText();
		String data2="ANNA";
		if(data1.equals(data2)) {
			Reporter.log("Pass", true);
		}else {
			Reporter.log("Fail", true);
		}
		
	}

}
