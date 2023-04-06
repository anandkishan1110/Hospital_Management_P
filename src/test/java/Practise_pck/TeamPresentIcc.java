package Practise_pck;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TeamPresentIcc {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> team = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		System.out.println("Enter the team name");
		String eTeam=sc.nextLine();
		boolean flag=false;
	for(WebElement data:team) {
		String text=data.getText();
		if(text.equals(eTeam)) {
			System.out.println("present");
			flag=true;
			break;
	}
	}
	if(!flag) {
		System.out.println("not present");
	}
	driver.close();
	}
	}