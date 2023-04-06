package Patient_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.GenericUtilities.DataBaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtilitity;
import com.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PatientBookAppointmentToDoctorAppointment {

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
		d.get(URL);
		//maximize the window
		wdu.maximizeWindow(d);
		//click on patient link module
		d.findElement(By.xpath("//h3[.='Patients']/../descendant::a[.='Click Here']")).click();
		//enter the username
		String UN=fu.readDataFromPropertyFile("un");
		d.findElement(By.name("username")).sendKeys(UN);
		//enter the password
		String PWD=fu.readDataFromPropertyFile("pwd");
		d.findElement(By.name("password")).sendKeys(PWD);
		//click on submit button
		d.findElement(By.name("submit")).click();
		//click on appointment link module
		d.findElement(By.xpath("//a[@href='book-appointment.php']")).click();
        //click on doctor specialization
		d.findElement(By.name("Doctorspecialization")).click();
		//select doctor specialization
		WebElement doct = d.findElement(By.name("Doctorspecialization"));
		wdu.select(doct, "Kango");
        d.findElement(By.id("doctor")).click();
        //select the doctor
        WebElement doctor = d.findElement(By.id("doctor"));
        wdu.select(doctor, "546");
        //select the date
        d.findElement(By.name("appdate")).click();
        d.findElement(By.xpath("//td[.='18']")).click();
        //select the time
        d.findElement(By.id("timepicker1")).click();
        //click on submit
        d.findElement(By.name("submit")).click();
        Thread.sleep(5000);
        //handle the alert
        wdu.acceptAlert(d);
		//logout as patient
		d.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
		d.findElement(By.xpath("//a[@href='logout.php']")).click();
		//login as doctor
		d.findElement(By.xpath("//h3[.='Doctors Login']/../descendant::a[.='Click Here']")).click();
		//enter the username
		String DUN = fu.readDataFromPropertyFile("dun");
		d.findElement(By.name("username")).sendKeys(DUN);
		//enter the password
		String DPWD = fu.readDataFromPropertyFile("dpwd");
		d.findElement(By.name("password")).sendKeys(DPWD);
		//click on submit button
		d.findElement(By.name("submit")).click();
		//click on doctor my appointment module
		d.findElement(By.xpath("//a[@href='appointment-history.php']")).click();
		//validate
		String aResult = d.findElement(By.xpath("//h1[@class='mainTitle']")).getText();
		String eResult="DOCTOR | APPOINTMENT HISTORY";
		if(aResult.equals(eResult)) {
		System.out.println("Data flow between patient to doctor module");
		}else {
			System.out.println("Data does not flow between patient to doctor module");
		}
		
        d.quit();
	}

}
