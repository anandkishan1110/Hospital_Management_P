package Patient_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtilitity;
import com.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterPatient {

	public static void main(String[] args) throws Throwable {
		FileUtility fu=new FileUtility();
		JavaUtilitity ju=new JavaUtilitity();
		WebDriverUtility wdu=new WebDriverUtility();
		ExcelUtility eu=new ExcelUtility();
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		String URL = fu.readDataFromPropertyFile("url");
		
		d.get(URL);
		d.findElement(By.xpath("//h3[.='Patients']/../descendant::a[.='Click Here']")).click();
		d.findElement(By.xpath("//a[@href='registration.php']")).click();
		int rd = ju.random();
		d.findElement(By.name("full_name")).sendKeys("Rana Naidu");
		d.findElement(By.name("address")).sendKeys("Netflix");
		d.findElement(By.name("city")).sendKeys("Bengaluru");
		d.findElement(By.xpath("//label[@for='rg-male']"));
		d.findElement(By.id("email")).sendKeys("rana@"+rd+"gmail.com");
		d.findElement(By.id("password")).sendKeys("123456");
		d.findElement(By.id("password_again")).sendKeys("123456");
		d.findElement(By.id("submit")).click();
		wdu.acceptAlert(d);
		System.out.println("Registration Done");
		d.quit();

	}

}
