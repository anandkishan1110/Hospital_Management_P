package Patient_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.DataBaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtilitity;
import com.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SystemScenario {

	public static void main(String[] args) throws Throwable {
		DataBaseUtility dbu=new DataBaseUtility();
		ExcelUtility eu=new ExcelUtility();
		FileUtility fu=new FileUtility();
		JavaUtilitity ju=new JavaUtilitity();
		WebDriverUtility wdu=new WebDriverUtility();
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		String URL = fu.readDataFromPropertyFile("url");
		d.get(URL);
		d.findElement(By.xpath("//h3[.='Patients']/../descendant::a[.='Click Here']")).click();
		wdu.maximizeWindow(d);
		String UN = fu.readDataFromPropertyFile("un");
		String PWD = fu.readDataFromPropertyFile("pwd");
		d.findElement(By.name("username")).sendKeys(UN);
		d.findElement(By.name("password")).sendKeys(PWD);
		d.findElement(By.name("submit")).click();
		d.findElement(By.xpath("//span[contains(text(),' Appointment History ')]")).click();
		String eResult="USER | APPOINTMENT HISTORY";
		String aResult = d.findElement(By.xpath("//h1[@class='mainTitle']")).getText();
		if(eResult.equals(aResult)) {
			System.out.println("user appointment history is displayed with details");
		}else {
			System.out.println("user appointment history is not displayed with details");
		}
		d.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
		d.findElement(By.xpath("//a[@href='logout.php']")).click();
		d.findElement(By.xpath("//h3[.='Doctors Login']/../descendant::a[.='Click Here']")).click();
		String DUN = fu.readDataFromPropertyFile("dun");
		d.findElement(By.name("username")).sendKeys(DUN);
		String DPWD=fu.readDataFromPropertyFile("dpwd");
		d.findElement(By.name("password")).sendKeys(DPWD);
		d.findElement(By.name("submit")).click();
		d.findElement(By.xpath("//a[@href='appointment-history.php']")).click();
		String data1 = d.findElement(By.xpath("//h1[@class='mainTitle']")).getText();
		String data2="DOCTOR | APPOINTMENT HISTORY";
		if(data1.equals(data2)) {
			System.out.println("Doctor appointment history will displayed with details");
		}
		else {
			System.out.println("Doctor appointment history will displayed with details");
		}
		d.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
		d.findElement(By.xpath("//a[@href='logout.php']")).click();
		d.findElement(By.xpath("//h3[.='Admin Login']/../descendant::a[.='Click Here']")).click();
		String AUN = fu.readDataFromPropertyFile("aun");
		d.findElement(By.name("username")).sendKeys(AUN);
		String APWD = fu.readDataFromPropertyFile("apwd");
		d.findElement(By.name("password")).sendKeys(APWD);
		d.findElement(By.name("submit")).click();
		d.findElement(By.xpath("//span[contains(text(),' Appointment History ')]")).click();
		String data3 = d.findElement(By.xpath("//h1[@class='mainTitle']")).getText();
        String data4="PATIENTS | APPOINTMENT HISTORY";
        if(data3.equals(data4)) {
        	System.out.println("Appintment Histroy page is displayed with Details");
        }else {
        	System.out.println("Appintment Histroy page is not displayed with Details");
        }
        d.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
		d.findElement(By.xpath("//a[@href='logout.php']")).click();
		d.quit();
	}

}
