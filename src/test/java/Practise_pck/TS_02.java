package Practise_pck;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

public class TS_02 extends BaseClass {
	@Test
	public void method3()
	{
		Reporter.log("method03", true);
	}
	@Test(groups = "regression")
	public void method4()
	{
		Reporter.log("method04", true);
	}

}
