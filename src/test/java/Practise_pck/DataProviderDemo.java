package Practise_pck;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtilities.ExcelUtility;

public class DataProviderDemo {
	@Test(dataProvider = "data")
	public void getData(String src,String res,String val)
	{
		Reporter.log("from-->"+src+"to-->"+res+"then--->"+val, true);
	}
	
	
	
@DataProvider
public Object[][] data() throws Throwable
{
	ExcelUtility eu=new ExcelUtility();
	Object[][] value = eu.readMultipleSetOfData("DP");
	return value;
	
}

}
