package Practise_pck;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

public class TS_03 extends BaseClass{
	@Test
	public void method5()
	{
		Reporter.log("method05", true);
	}
	@Test(groups = {"smoke","regression"})
	public void method6()
	{
		Reporter.log("method06", true);
	}

}
