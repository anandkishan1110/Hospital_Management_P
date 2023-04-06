package com.hms.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.FileUtility;

public class AdminLoginPage {
	@FindBy(name="username")
	private WebElement unTb;
	
	@FindBy(name="password")
	private WebElement pwdTb;
	
	@FindBy(name="submit")
	private WebElement submitBtn;
	
	
	public AdminLoginPage(WebDriver driver) {
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
	
	public void loginAsAdminByEnteringUnPwd(FileUtility fu) throws Throwable {
		unTb.sendKeys(fu.readDataFromPropertyFile("aun"));
		pwdTb.sendKeys(fu.readDataFromPropertyFile("apwd"));
		submitBtn.click();
		
	}

}
