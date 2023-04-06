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

public class MedicalHistory {

	public static void main(String[] args) throws Throwable {
		DataBaseUtility dbu=new DataBaseUtility();
		ExcelUtility eu=new ExcelUtility();
		FileUtility fu=new FileUtility();
		JavaUtilitity ju=new JavaUtilitity();
		WebDriverUtility wdu=new WebDriverUtility();
		WebDriverManager.chromedriver().setup();
		//open the browser
		WebDriver d=new ChromeDriver();
		//enter the url
		String URL = fu.readDataFromPropertyFile("url");
		String UN=fu.readDataFromPropertyFile("un");
		String PWD=fu.readDataFromPropertyFile("pwd");
		d.get(URL);
		//maximize the application
		wdu.maximizeWindow(d);
		//click on patient link
		d.findElement(By.xpath("//h3[.='Patients']/../descendant::a[.='Click Here']")).click();
		//enter the username
		d.findElement(By.name("username")).sendKeys(UN);
		//enter the password
		d.findElement(By.name("password")).sendKeys(PWD);
		//click on submit
		d.findElement(By.name("submit")).click();
		//click on medical history button
		d.findElement(By.xpath("//span[.=' Medical History ']")).click();
		//click on medical history action button
		d.findElement(By.xpath("//i[@class='fa fa-eye']")).click();
		String aResult="USERS | MEDICAL HISTORY";
		String result = d.findElement(By.xpath("//h1[@class='mainTitle']")).getText();
		if(aResult.equals(result)) {
		System.out.println("Patient is able to see their medical history");
		}
		else {
			System.out.println("Patient is not able to see their medical history");
		}
		Thread.sleep(5000);
		d.quit();

	}

}
