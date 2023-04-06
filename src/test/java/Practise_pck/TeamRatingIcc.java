package Practise_pck;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TeamRatingIcc {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		d.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> team = d.findElements(By.xpath("//tbody/tr/td[2]"));
		ArrayList<String>list=new ArrayList<String>();
		for(int i=0;i<team.size();i++) {
			list.add(team.get(i).getText());
		}
        for(String myTeam:list) {
        	String rating="//span[.='"+myTeam+"']/../following-sibling::td[3]";
        	String Rating=d.findElement(By.xpath(rating)).getText();
        	System.out.println("team--> "+myTeam+" ->(rating is) ->"+Rating);
        }
        d.close();
	}

}
