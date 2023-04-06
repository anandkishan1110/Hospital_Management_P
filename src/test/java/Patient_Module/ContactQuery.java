package Patient_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.DataBaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtilitity;
import com.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactQuery {

	public static void main(String[] args) throws Throwable {
		DataBaseUtility dbu=new DataBaseUtility();
		ExcelUtility eu=new ExcelUtility();
		FileUtility fu=new FileUtility();
		JavaUtilitity ju=new JavaUtilitity();
		WebDriverUtility wdu=new WebDriverUtility();
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		String URL = fu.readDataFromPropertyFile("url");
		String UN=fu.readDataFromPropertyFile("un");
		String PWD=fu.readDataFromPropertyFile("pwd");
		d.get(URL);
		d.findElement(By.xpath("//div[@class='top-nav']/descendant::a[@href='contact.php']")).click();
		d.findElement(By.xpath("//form[@name='contactus']/descendant::input[@name='fullname']")).sendKeys("Manju");
		d.findElement(By.xpath("//form[@name='contactus']/descendant::input[@name='fullname']/following::input[@name='emailid']")).sendKeys("manju@123gmail.com");
		d.findElement(By.xpath("//form[@name='contactus']/descendant::input[@name='fullname']/following::input[@name='mobileno']")).sendKeys("9204660078");
		d.findElement(By.xpath("//form[@name='contactus']/descendant::input[@name='fullname']/following::textarea[@name='description']")).sendKeys("need help call me");
		d.findElement(By.xpath("//form[@name='contactus']/descendant::input[@name='fullname']/following::input[@name='submit']")).click();
		String popmsg = wdu.getTextAlert(d);
		String amsg="Your information succesfully submitted";
		if(popmsg.equals(amsg)) {
			System.out.println("query submitted sucessfully");
		}else {
			System.out.println("query not submitted successfully");
		}
		wdu.acceptAlert(d);
		d.navigate().back();
		d.navigate().back();
		d.findElement(By.xpath("//h3[.='Admin Login']/../descendant::a")).click();
		d.findElement(By.xpath("//body[@class='login']/descendant::input[@name='username']")).sendKeys(UN);
		d.findElement(By.xpath("//body[@class='login']/descendant::input[@name='password']")).sendKeys(PWD);
		d.findElement(By.name("submit")).click();
		d.findElement(By.xpath("//p[@class='links cl-effect-1']/descendant::a[@href='unread-queries.php']")).click();
		JavascriptExecutor j=(JavascriptExecutor) d;
		j.executeScript("0,window.scrollTo(0,document.body.scrollHeight)");
		d.findElement(By.xpath("//tbody/tr[last()]/descendant::a[@title='View Details']")).click();
		d.findElement(By.name("adminremark")).sendKeys("You will be contacted soon");
		d.findElement(By.name("update")).click();
		String conmsg = wdu.getTextAlert(d);
		String expected="Admin Remark updated successfully.";
		if(conmsg.equals(expected)) {
			System.out.println("Contacted done");
		}else {
			System.out.println("Not contacted yet");
		}
		d.switchTo().alert().accept();
		d.quit();
	}

}
