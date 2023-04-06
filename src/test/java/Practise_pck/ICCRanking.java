package Practise_pck;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICCRanking {

	public static void main(String[] args) {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
	  List<WebElement> rank = driver.findElements(By.xpath("//tbody/tr/td[1]"));
	  List<WebElement> team = driver.findElements(By.xpath("//tbody/tr/td[2]"));
	  List<WebElement> matches = driver.findElements(By.xpath("//tbody/tr/td[3]"));
	  List<WebElement> points = driver.findElements(By.xpath("//tbody/tr/td[4]"));
	  List<WebElement> rating = driver.findElements(By.xpath("//tbody/tr/td[5]"));
	  for(int i=0;i<rank.size();i++) {
		  System.out.println("Ranking"+" "+rank.get(i).getText()+" "+"TeamName"+" "+team.get(i).getText()+" "+"Matches"+" "+matches.get(i).getText()+" "+"Point"+" "+points.get(i).getText()+" "+"Rating"+" "+rating.get(i).getText());
	  }
	  driver.close();

	}

}
