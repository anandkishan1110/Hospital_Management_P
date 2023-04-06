package com.hms.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageHms {
	@FindBy(xpath="//h3[.='Patients']/../descendant::a[.='Click Here']")
	private WebElement patientLink;
	
	@FindBy(xpath="//h3[.='Doctors Login']/../descendant::a")
	private WebElement doctorLink;
	
	@FindBy(xpath="//h3[.='Admin Login']/../descendant::a[.='Click Here']")
	private WebElement adminLink;
	
	@FindBy(xpath="//a[@href='contact.php']")
	private WebElement contactBtn;
	
	public WebElement getContactBtn() {
		return contactBtn;
	}

	public HomePageHms(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPatientLink() {
		return patientLink;
	}

	public WebElement getDoctorLink() {
		return doctorLink;
	}

	public WebElement getAdminLink() {
		return adminLink;
	}
	 
	
	public void patientLogin()
	{
		patientLink.click();
	}
	 
	public void doctorLogin()
	{
		doctorLink.click();
	}
	
	public void adminLogin()
	{
		adminLink.click();
	}
	
	public void contactLogin()
	{
		contactBtn.click();
	}

}
