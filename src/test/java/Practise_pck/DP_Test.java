package Practise_pck;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DP_Test {
	@Test(dataProviderClass = DataProviderDemo.class,dataProvider = "data")
	public void getData(String src,String dst,String location)
	{
		Reporter.log("from--->"+src+"to-->"+dst+"-->Location "+location, true);
	}

}
