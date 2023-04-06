package PomExecution;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.hms.pom.ContactPage;
import com.hms.pom.HomePageHms;
@Listeners(com.GenericUtilities.ListenerImplementation.class)
public class ContactQuery extends BaseClass {
    @Test
	public void contactQuery() throws Throwable 
    {
		HomePageHms hp=new HomePageHms(driver);
		hp.contactLogin();
		ContactPage cp=new ContactPage(driver);
		cp.fillContactsDetails(ju);
		String d1="Your information succesfully submitted";
		String d2=wdu.getTextAlert(driver);
		Assert.assertEquals(d1, d2);
		Reporter.log("Query send Successfully");
	
	}

}
