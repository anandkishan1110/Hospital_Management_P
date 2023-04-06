package Patient_Module;

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

public class BookAppointment {
	public static void main(String[]arg) throws Throwable {
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
		//maximize the browser
		wdu.maximizeWindow(d);
		//click on patient link
		d.findElement(By.xpath("//h3[.='Patients']/../descendant::a[.='Click Here']")).click();
		//enter the username
		String UN = fu.readDataFromPropertyFile("un");
		d.findElement(By.name("username")).sendKeys(UN);
		//enter the password
		String PWD = fu.readDataFromPropertyFile("pwd");
		d.findElement(By.name("password")).sendKeys(PWD);
		//click on submit button
		d.findElement(By.name("submit")).click();
		//click on appointment module
		d.findElement(By.xpath("//a[@href='book-appointment.php']")).click();
		//click on doctor specialization
        d.findElement(By.name("Doctorspecialization")).click();
        //select the doctor specialization
        WebElement doct = d.findElement(By.name("Doctorspecialization"));
        wdu.select(doct, "Kango");
        //select the doctor specialization
        d.findElement(By.id("doctor")).click();
        WebElement doctor = d.findElement(By.id("doctor"));
        wdu.select(doctor, "546");
        //select the date
        d.findElement(By.name("appdate")).click();
        Thread.sleep(2000);
        d.findElement(By.xpath("//td[.='29']")).click();
        //select the time
        d.findElement(By.id("timepicker1")).click();
        //click on submit
        d.findElement(By.name("submit")).click();
        Thread.sleep(5000);
        //handle the alert popup
        wdu.acceptAlert(d);
		
		//click on appointment module
		d.findElement(By.xpath("//span[contains(text(),' Appointment History ')]")).click();
		//validate
		String eResult="USER | APPOINTMENT HISTORY";
		String aResult = d.findElement(By.xpath("//h1[@class='mainTitle']")).getText();
		if(eResult.equals(aResult)) {
			System.out.println("user appointment is done");
		}else {
			System.out.println("user appointment not done");
		}
		//close the browser
		d.quit();
		
	}
	

}
