package PomExecution;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.hms.pom.DoctorHomePage;
import com.hms.pom.DoctorLoginPage;
import com.hms.pom.HomePageHms;
import com.hms.pom.PatientBookAppointmentPage;
import com.hms.pom.PatientHomePage;
import com.hms.pom.PatientLoginPage;
@Listeners(com.GenericUtilities.ListenerImplementation.class)
public class PatientBookAppointmentToDoctorAppointment extends BaseClass {
    @Test(priority = 1)
	public void patientLogin() throws Throwable {
		HomePageHms hp=new HomePageHms(driver);
        wdu.maximizeWindow(driver);
        hp.patientLogin();
        PatientLoginPage plp=new PatientLoginPage(driver);
        plp.loginAsPatientByEnteringUNPwd(fu);
        PatientHomePage php=new PatientHomePage(driver);
        php.clickOnAppointmentLink();
        PatientBookAppointmentPage pba=new PatientBookAppointmentPage(driver);
        pba.fillAppointmentDetail(wdu);
        wdu.acceptAlert(driver);
        Reporter.log("Appointment Done",true);
        pba.clickOnProfileDD();
        pba.clickOnLogOut();
    }
    @Test(priority = 2)
    public void docLogin()throws Throwable
    {
    	HomePageHms hp=new HomePageHms(driver);
        hp.doctorLogin();
        DoctorLoginPage dlp=new DoctorLoginPage(driver);
        dlp.loginAsDoctorByEnteringUnPwd(fu);
        DoctorHomePage dhp=new DoctorHomePage(driver);
        dhp.clickOnDoctorAppointmentHistory();
        String ename = driver.findElement(By.xpath("//tbody/tr[last()]/descendant::td[.='ANNA']")).getText();
        String aname="ANNA";
        Assert.assertEquals(ename, aname);
        Reporter.log("Patient details is there with entire details",true);
        
	}

}
