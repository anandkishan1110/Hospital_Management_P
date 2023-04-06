package Practise_pck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.GenericUtilities.DataBaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtilitity;
import com.GenericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RMGYANTRA {

	public static void main(String[] args) throws Throwable {
		//Connection con=null;
		//ResultSet result=null;
		DataBaseUtility dbu=new DataBaseUtility();
		ExcelUtility eu=new ExcelUtility();
		FileUtility fu=new FileUtility();
		JavaUtilitity ju=new JavaUtilitity();
		WebDriverUtility wdu=new WebDriverUtility();
		try {
			WebDriverManager.chromedriver().setup();
			WebDriver d=new ChromeDriver();
			String URL = fu.readDataFromPropertyFile("tyurl");
			d.get(URL);
			wdu.maximizeWindow(d);
			String UN = fu.readDataFromPropertyFile("tyun");
			d.findElement(By.xpath("//form[@class='form-signin']/descendant::input[@id='usernmae']")).sendKeys(UN);
			String PWD = fu.readDataFromPropertyFile("typwd");
			d.findElement(By.xpath("//form[@class='form-signin']/descendant::input[@id='inputPassword']")).sendKeys(PWD);
			d.findElement(By.xpath("//form[@class='form-signin']/descendant::button[@type='submit']")).click();
			Thread.sleep(5000);
			d.findElement(By.xpath("//a[.='Projects']")).click();
			d.findElement(By.xpath("//span[.='Create Project']")).click();
			int rn = ju.random();
			String pname="LKG8"+rn;
			d.findElement(By.name("projectName")).sendKeys(pname);
			d.findElement(By.name("createdBy")).sendKeys("Raja");
			WebElement dd = d.findElement(By.xpath("(//select[@name='status'])[2]"));
			wdu.select(dd, "On Going");
			d.findElement(By.xpath("//input[@type='submit']")).click();
			//Driver driver=new Driver();
			dbu.connectToDbTY();
			//DriverManager.registerDriver(driver);
			//con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			String query="select * from project;";
			String str = dbu.executeQueryAndGetData(query, pname, 4);
//			Statement state = con.createStatement();
//			
//			result = state.executeQuery(query);
//			boolean flag=false;
//			while(result.next()) {
//				String data = result.getString(4);
//				System.out.println(data);
//				if(data.equalsIgnoreCase(pname)) {
//					flag=true;
//					break;
//				}
//			}
//			if(flag) {
//				System.out.println("project created");
//			}else {
//				System.out.println("project not created");
//			}
//
		}
		catch(Exception e) {

		}
		finally {
			dbu.closeDB();
			
			
		}
      
    
	}

}
