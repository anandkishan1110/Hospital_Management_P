package Practise_pck;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNgP1 {
	@Test(priority = 1,invocationCount = 3)
	public void createCustomer()
	{
		Reporter.log("Create Customer", true);
	}
	
	@Test(priority = 2,dependsOnMethods = "createCustomer")
	public void modifyCustomer()
	{
		Reporter.log("Modify Customer", true);
	}
	
	@Test(priority = 3,dependsOnMethods = "modifyCustomer")
	public void deleteCustomer()
	{
		Reporter.log("Delete Customer", true);
	}

}
