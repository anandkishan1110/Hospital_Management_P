package com.hms.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.JavaUtilitity;

public class ContactPage {
    @FindBy(name="fullname")
    private WebElement nameTf;
    
    @FindBy(name="emailid")
    private WebElement emailTf;
    
    @FindBy(name="mobileno")
    private WebElement mobileTf;
    
    @FindBy(name="description")
    private WebElement descriptionTf;
    
    @FindBy(name="submit")
    private WebElement submitBtn;
    
    public WebElement getNameTf() {
		return nameTf;
	}

	public WebElement getEmailTf() {
		return emailTf;
	}

	public WebElement getMobileTf() {
		return mobileTf;
	}

	public WebElement getDescriptionTf() {
		return descriptionTf;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public ContactPage(WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
    }
    
    public void fillContactsDetails(JavaUtilitity ju) {
    	nameTf.sendKeys("Tony"+ju.random());
    	emailTf.sendKeys("tony"+ju.random()+"@gmail.com");
    	mobileTf.sendKeys("7894561"+ju.random());
    	descriptionTf.sendKeys("Need ambulance");
    	submitBtn.click();
    }
    
}
