package com.hms.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.FileUtility;

public class DoctorLoginPage {
      @FindBy(name="username")
      private WebElement unTb;
      
      @FindBy(name="password")
      private WebElement pwdTb;
      
      @FindBy(name="submit")
      private WebElement submitBtn;
      
      
      public DoctorLoginPage(WebDriver driver) {
    	  PageFactory.initElements(driver, this);
      }


	public WebElement getUnTb() {
		return unTb;
	}


	public WebElement getPwdTb() {
		return pwdTb;
	}


	public WebElement getSubmitBtn() {
		return submitBtn;
	}
      
      public void loginAsDoctorByEnteringUnPwd(FileUtility fu) throws Throwable {
    	  unTb.sendKeys(fu.readDataFromPropertyFile("dun"));
    	  pwdTb.sendKeys(fu.readDataFromPropertyFile("dpwd"));
    	  submitBtn.click();
      }
}
