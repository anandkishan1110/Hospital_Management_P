package Patient_Module;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class RetryDemo {
	@Test(retryAnalyzer = com.GenericUtilities.RetryAnalyser.class)
	public void createPatient()
	{
		Reporter.log("Patient Created",true);
		Assert.fail();
		
	}

}
