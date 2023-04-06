package Practise_pck;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Olyampic {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		d.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		List<WebElement> team = d.findElements(By.xpath("//span[@data-cy='country-name']"));
		for(int i=0;i<team.size();i++) {
			String data = team.get(i).getText();
			System.out.println("Team"+" "+data);
		}

	}

}
