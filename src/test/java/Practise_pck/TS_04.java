package Practise_pck;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

public class TS_04 extends BaseClass{
	@Test(groups = "smoke")
	public void method7()
	{
		Reporter.log("method007", true);
	}
	@Test(groups = "regression")
	public void method8()
	{
		Reporter.log("method008",true);
	}

}
