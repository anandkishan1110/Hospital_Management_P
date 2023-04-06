package Patient_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PatientLogin {

	public static void main(String[] args) throws Throwable {
		FileUtility fu=new FileUtility();
		WebDriverUtility wdu=new WebDriverUtility();
		ExcelUtility eu=new ExcelUtility();
		WebDriverManager.chromedriver().setup();
		//open the browser
		WebDriver d=new ChromeDriver();
		//enter the url
		String URL = fu.readDataFromPropertyFile("url");
		String UN = fu.readDataFromPropertyFile("un");
		String PWD=fu.readDataFromPropertyFile("pwd");
		d.get(URL);
		//maximize the window
		wdu.maximizeWindow(d);
		//click on patient link module
		d.findElement(By.xpath("//h3[.='Patients']/../descendant::a[.='Click Here']")).click();
		//enter the username
		d.findElement(By.name("username")).sendKeys(UN);
		//enter the password
		d.findElement(By.name("password")).sendKeys(PWD);
		//click on submit button
		d.findElement(By.name("submit")).click();
		//logout as patient
		d.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
		d.findElement(By.xpath("//a[@href='logout.php']")).click();
		System.out.println("Login Logout Sucessfully");
		d.quit();

	}

}
