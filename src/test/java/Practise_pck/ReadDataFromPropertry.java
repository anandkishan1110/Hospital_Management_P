package Practise_pck;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromPropertry {

	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL=p.getProperty("url");
		String UN = p.getProperty("un");
		String PWD=p.getProperty("pwd");
		System.out.println(URL);
		System.out.println(UN);
		System.out.println(PWD);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(By.name("username")).sendKeys(UN);
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys(PWD);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//driver.quit();
		
		
		

	}

}
