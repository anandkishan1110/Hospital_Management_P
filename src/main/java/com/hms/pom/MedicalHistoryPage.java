package com.hms.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MedicalHistoryPage {
      @FindBy(xpath="//tbody/tr/descendant::i")
      private WebElement actionIcon;
      
      public MedicalHistoryPage(WebDriver driver) {
    	  PageFactory.initElements(driver,this);
    	  
      }

	public WebElement getActionIcon() {
		return actionIcon;
	}
      public void clickOnActionIcon() {
    	  actionIcon.click();
      }
}
