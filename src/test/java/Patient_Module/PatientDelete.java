package Patient_Module;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.GenericUtilities.DataBaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtilitity;
import com.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PatientDelete {

	public static void main(String[] args) throws Throwable {
		DataBaseUtility dbu=new DataBaseUtility();
		ExcelUtility eu=new ExcelUtility();
		FileUtility fu=new FileUtility();
		JavaUtilitity ju=new JavaUtilitity();
		WebDriverUtility wdu=new WebDriverUtility();
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		String URL=fu.readDataFromPropertyFile("url");
		String UN=fu.readDataFromPropertyFile("un");
		String PWD=fu.readDataFromPropertyFile("pwd");
		d.get(URL);
		wdu.maximizeWindow(d);
		d.findElement(By.xpath("//h3[.='Patients']/../descendant::a[.='Click Here']")).click();
		d.findElement(By.xpath("//a[contains(text(),'Create an account')]")).click();
		d.findElement(By.name("full_name")).sendKeys("Sridhar");
		d.findElement(By.xpath("//div[@class='box-register']/descendant::input[@name='address']")).sendKeys("23 Dawkavas Road Bel Layout Anjanagar");
		d.findElement(By.xpath("//div[@class='form-group']/following::input[@name='city']")).sendKeys("Banagalore");
		d.findElement(By.xpath("//div[@class='form-group']/following::label[@for='rg-male']")).click();
		int r = ju.random();
		//Random ran=new Random();
		//int r = ran.nextInt(1000);
		String nam="sridhar@"+r+"gmail.com";
		System.out.println(nam);
		d.findElement(By.xpath("//div[@class='form-group']/descendant::input[@name='email']")).sendKeys(nam);
		d.findElement(By.xpath("//div[@class='form-group']/descendant::input[@name='password']")).sendKeys("123456");
		d.findElement(By.xpath("//div[@class='form-group']/descendant::input[@name='password_again']")).sendKeys("123456");
		d.findElement(By.xpath("//div[@class='form-actions']/descendant::button[@name='submit']")).click();
		String alertmessage = wdu.getTextAlert(d);
		//Alert alertmessage = d.switchTo().alert();
		//alertmessage.getText();
		String expectedmessage="Successfully Registered. You can login now";
		if(alertmessage.equals(expectedmessage)) {
			System.out.println("Account is created");
		}else {
			System.out.println("Account is not created");
		}
		wdu.acceptAlert(d);
		d.navigate().back();
		d.navigate().back();
		d.navigate().back();
		d.findElement(By.xpath("//h3[.='Admin Login']/../descendant::a")).click();
		d.findElement(By.xpath("//body[@class='login']/descendant::input[@name='username']")).sendKeys(UN);
		d.findElement(By.xpath("//body[@class='login']/descendant::input[@name='password']")).sendKeys(PWD);
		d.findElement(By.name("submit")).click();
		WebElement user = d.findElement(By.xpath("//span[.=' Users ']"));
		wdu.mousehover(d, user);
		d.findElement(By.xpath("//li[@class='open']/descendant::a[@href='manage-users.php']")).click();
		JavascriptExecutor j=(JavascriptExecutor) d;
		j.executeScript("0,window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(3000);
		d.findElement(By.xpath("//tbody/tr[last()]/descendant::td[last()]")).click();
		//d.findElement(By.xpath("//td[.='sridhar@444gmail.com']/following-sibling::td/descendant::i[@class='fa fa-times fa fa-white']")).click();
		d.switchTo().alert().accept();
		d.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
		d.findElement(By.xpath("//a[@href='logout.php']")).click();
		d.findElement(By.xpath("//h3[.='Patients']/../descendant::a[.='Click Here']")).click();
		d.findElement(By.name("username")).sendKeys(nam);
		d.findElement(By.name("password")).sendKeys("123456");
		d.findElement(By.name("submit")).click();
		String invalid = d.findElement(By.xpath("//body[@class='login']/descendant::span[.='Invalid username or password']")).getText();
		System.out.println(invalid);
		System.out.println("user deleted successfully");
		d.quit();
	}

}
