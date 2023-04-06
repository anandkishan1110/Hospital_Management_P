package Practise_pck;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

public class TS_01 extends BaseClass{
	@Test(groups = "smoke")
	public void method1()
	{
		Reporter.log("method01", true);
		Assert.fail();
	}
	@Test
	public void method2()
	{
		Reporter.log("method02", true);
	}

}
