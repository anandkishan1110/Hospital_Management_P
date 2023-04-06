package Practise_pck;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMT {

	public static void main(String[] args) throws Throwable {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disabled-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();
		driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
		WebElement from=driver.findElement(By.xpath("//input[@id='fromCity']"));
		from.sendKeys("Bengalore");
		driver.findElement(By.xpath("//p[.='Bengaluru, India']")).click();
		WebElement to=driver.findElement(By.xpath("//input[@id='toCity']"));
		to.sendKeys("Mangalore");
		driver.findElement(By.xpath("//p[.='Mangalore, India']")).click();
		Date cdate=new Date();
		String[] d=cdate.toString().split(" ");
		String day=d[0];
		String month=d[1];
		String date=d[2];
		String year=d[5];
		String travelDate=day+" "+month+" "+date+" "+year;
		driver.findElement(By.xpath("//div[@aria-label='"+travelDate+"']")).click();
		String rday="Thu";
		String rmonth="Jun";
		String rdate="15";
		String ryear="2023";
		String returnDate=rday+" "+rmonth+" "+rdate+" "+ryear;
		for(; ;) {
			try {
				driver.findElement(By.xpath("//div[@aria-label='"+returnDate+"']")).click();
				break;
			}catch(Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
         Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='lbl_inputlatoBold appendBotton5']")).click();
		driver.findElement(By.xpath("//li[@data-cy='adults-6']")).click();
		driver.findElement(By.xpath("button[.='APPLY']")).click();
		driver.findElement(By.xpath("//a[.='Search']")).click();



	}

}
