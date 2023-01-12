package com.naveenAutomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.naveenAutomation.Base.TestBase;

public class MyAccountInformation extends TestBase {

	public MyAccountInformation() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "input[name='firstname']")
	WebElement firstName;
	
	@FindBy(css = "input[name='lastname']")
	WebElement lastName;
	
	@FindBy(css = "input[type='email']")
	WebElement email;
	
	@FindBy(css = "input[type='tel']")
	WebElement phoneNumber;
	
	@FindBy(css = "input[type='submit']")
	WebElement continueBtn;

	public String validateFirstName() {
		return firstName.getText();	
	}
	
	public String validateLastName() {
		return lastName.getText();	
	}
	
	public String validateEmail() {
		return email.getText();	
	}
	
	public String validatePhoneNumber() {
		return phoneNumber.getText();	
	}

public MyAccountPage updatePhoneNumber() {
	continueBtn.click();
	return new MyAccountPage();
}
}