package com.hms.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.JavaUtilitity;

public class PatientRegistrationPage {
	@FindBy(name="full_name")
	private WebElement fullNameTf;
	
	@FindBy(name="address")
	private WebElement addressTf;
	
	@FindBy(name="city")
	private WebElement cityTf;
	
	@FindBy(xpath="//label[@for='rg-male']")
	private WebElement gender;
	
	@FindBy(id="email")
	private WebElement emailTf;
	
	@FindBy(id="password")
	private WebElement pwdTf;
	
	@FindBy(name="password_again")
	private WebElement pwdAgainTf;
	
	@FindBy(name="submit")
	private WebElement submitBtn;
	
	
	public PatientRegistrationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
    public WebElement getSubmitBtn() {
    	return submitBtn;
    }
    
	public WebElement getFullNameTf() {
		return fullNameTf;
	}


	public WebElement getAddressTf() {
		return addressTf;
	}


	public WebElement getCityTf() {
		return cityTf;
	}


	public WebElement getGender() {
		return gender;
	}


	public WebElement getEmailTf() {
		return emailTf;
	}


	public WebElement getPwdTf() {
		return pwdTf;
	}


	public WebElement getPwdAgainTf() {
		return pwdAgainTf;
	}
	
	public void fillRegistrationTextFiled(JavaUtilitity ju) {
		fullNameTf.sendKeys("Raman Raghav");
		addressTf.sendKeys("Navi Mumbai");
		cityTf.sendKeys("Mumbai");
		gender.click();
		emailTf.sendKeys("ramanraghav"+ju.random()+"@gmail.com");
		pwdTf.sendKeys("741258");
		pwdAgainTf.sendKeys("741258");
		submitBtn.click();
		
	}

	
	

}
