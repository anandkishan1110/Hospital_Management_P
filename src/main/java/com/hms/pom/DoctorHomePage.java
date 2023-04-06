package com.hms.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorHomePage {

		    @FindBy(xpath="//a[@href='appointment-history.php']")
		    private WebElement appointmentLink;
		    
		    @FindBy(xpath="(//a[@href='edit-profile.php'])[2]")
		    private WebElement editProfile;
		    
		    @FindBy(xpath="//i[@class='ti-angle-down']")
			private WebElement myProfileDD;
		    
		    @FindBy(xpath="//a[@href='logout.php']")
			private WebElement logoutBtn;
		    
		    public DoctorHomePage(WebDriver driver) {
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

			public WebElement getEditProfile() {
				return editProfile;
			}
		    
		    
		    public void clickOnDoctorAppointmentHistory() {
		    	appointmentLink.click();
		    }
		    
           public void clickOnEditProfile() {
        	   editProfile.click();
           }
           public void myProfileDD() {
        	   myProfileDD.click();
           }
           public void logOutAsDoctor() {
        	   logoutBtn.click();
           }
	}


