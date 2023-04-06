package com.hms.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtilitity;

public class PatientLoginPage {
	@FindBy(name="username")
	private WebElement unTb;
	
	@FindBy(name="password")
	private WebElement pwdTb;
	
	@FindBy(name="submit")
	private WebElement submitBtn;
	
	@FindBy(xpath="//a[@href='registration.php']")
	private WebElement regisLink;
	
	
	public PatientLoginPage(WebDriver driver)
	{
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
	
	public WebElement getRegisLink() {
		return regisLink;
	}
	
	public void loginAsPatientByEnteringUNPwd(FileUtility fu) throws Throwable
	{
		unTb.sendKeys(fu.readDataFromPropertyFile("un"));
		pwdTb.sendKeys(fu.readDataFromPropertyFile("pwd"));
		submitBtn.click();
	}
	
	public void loginRandom(JavaUtilitity ju) {
		unTb.sendKeys("ramanraghav"+ju.random()+"@gmail.com");
		pwdTb.sendKeys("741258");
		submitBtn.click();
	}
	
	public void registrtionPatient() {
		regisLink.click();
	}

}
