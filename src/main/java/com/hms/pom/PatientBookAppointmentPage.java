package com.hms.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

public class PatientBookAppointmentPage {
	@FindBy(name="Doctorspecialization")
	private WebElement doctDDBtn;
	
	@FindBy(id="doctor")
	private WebElement doctorName;
	
	@FindBy(name="appdate")
	private WebElement date;
	
	@FindBy(xpath="//td[.='29']")
	private WebElement dateSelect;
	
	@FindBy(id="timepicker1")
	private WebElement time;
	
	@FindBy(name="submit")
	private WebElement submitBtn;
	
	@FindBy(xpath="//span[contains(text(),' Appointment History ')]")
	private WebElement appointmentHistoryBtn;
	
	@FindBy(xpath="//i[@class='ti-angle-down']")
	private WebElement profileDD;
	
	@FindBy(xpath="//a[@href='logout.php']")
	private WebElement logoutBtn;
	
	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getProfileDD() {
		return profileDD;
	}

	public PatientBookAppointmentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAppointmentHistoryBtn() {
		return appointmentHistoryBtn;
	}

	public WebElement getDoctDDBtn() {
		return doctDDBtn;
	}

	public WebElement getDoctorName() {
		return doctorName;
	}

	public WebElement getDate() {
		return date;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public WebElement getTime() {
		return time;
	}
	
	public WebElement getDateSelect() {
		return dateSelect;
	}
	
	public void fillAppointmentDetail(WebDriverUtility wdu) {
		doctDDBtn.click();
		WebElement element=doctDDBtn;
		wdu.select(element, "Kango");
		//doctorName.click();
		WebElement e=doctorName;
		wdu.select(e, "546");
		date.click();
		dateSelect.click();
		time.click();
		submitBtn.click();
		
	}
	public void clickOnAppointmentLinkButton() {
		appointmentHistoryBtn.click();
	}
	
	public void clickOnProfileDD() {
		profileDD.click();
	}
	
	public void clickOnLogOut() {
		logoutBtn.click();
	}

}
