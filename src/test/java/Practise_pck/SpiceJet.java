package Practise_pck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJet {

	public static void main(String[] args) throws Throwable {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver(option);
		d.get("https://www.spicejet.com/");
	    
	    d.findElement(By.xpath("//div[@data-testid='one-way-radio-button']")).click();
	    Thread.sleep(5000);
	    d.findElement(By.xpath("//div[text()='From']/../descendant::input")).sendKeys("Ben");
	    d.findElement(By.xpath("//div[text()='To']/../descendant::input")).sendKeys("Man");
	   

	}

}
