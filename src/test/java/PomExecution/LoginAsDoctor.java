package PomExecution;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GenericUtilities.BaseClass;
import com.hms.pom.DoctorLoginPage;
import com.hms.pom.HomePageHms;

public class LoginAsDoctor extends BaseClass{
    @Test
	public void login() throws Throwable {
		
		HomePageHms hp=new HomePageHms(driver);
		hp.doctorLogin();
		DoctorLoginPage doc=new DoctorLoginPage(driver);
		//Assert.fail();
		doc.loginAsDoctorByEnteringUnPwd(fu);
		
		
	}

}
