package com.hms.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	@FindBy(xpath="//span[contains(text(),' Appointment History ')]")
	private WebElement appointmentHistoryBtn;
	
	 @FindBy(xpath="//span[@class='username']")
	private WebElement myProfileDD;
	    
    @FindBy(xpath="//a[@href='logout.php']")
    private WebElement logoutBtn;
    
    @FindBy(xpath="(//a[@href='manage-users.php'])[2]")
    private WebElement manageUserLink;
    
    public WebElement getManageUserLink() {
		return manageUserLink;
	}

	public AdminHomePage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }

	public WebElement getAppointmentHistoryBtn() {
		return appointmentHistoryBtn;
	}

	public WebElement getMyProfileDD() {
		return myProfileDD;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
    
    public void clickOnAppointmentHistory() {
    	appointmentHistoryBtn.click();
    }
    
    public void clickOnManageUser() {
    	manageUserLink.click();
    }
    public void clickOnMyProfileDD() {
    	myProfileDD.click();
    }
    
    public void clickOnLogout() {
    	logoutBtn.click();
    }
}
