package com.hms.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientHomePage {
	@FindBy(xpath="//a[@href='book-appointment.php']")
	private WebElement appointmentLink;
	
	@FindBy(xpath="//a[@href='appointment-history.php']")
	private WebElement appointmentHistory;
	
	@FindBy(xpath="//a[@href='manage-medhistory.php']")
	private WebElement medicalHistory;
	
	public WebElement getMedicalHistory() {
		return medicalHistory;
	}

	@FindBy(xpath="//a[@href='edit-profile.php']")
	private WebElement editProfileLink;
	
	@FindBy(xpath="//span[@class='username']")
	private WebElement myProfileDD;
	
	@FindBy(xpath="//a[@href='logout.php']")
	private WebElement logoutBtn;
	
	
	public PatientHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

    public WebElement getMyProfileDD() {
    	return myProfileDD;
    }
	public WebElement getAppointmentLink() {
		return appointmentLink;
	}


	public WebElement getAppointmentHistory() {
		return appointmentHistory;
	}


	public WebElement getEditProfileLink() {
		return editProfileLink;
	}
     
	
	public void clickOnAppointmentLink() {
		appointmentLink.click();
	}
	
	public void clickOnAppointmentHistory() {
		appointmentHistory.click();
	}
	
	public void clickOnEditProfile() {
		editProfileLink.click();
	}
	
	public void clickOnMyProfile() {
		myProfileDD.click();
	}
	
	public void clickOnLogout() {
		logoutBtn.click();
	}
	
	public void clickOnMedicalHistory() {
		medicalHistory.click();
	}
}
