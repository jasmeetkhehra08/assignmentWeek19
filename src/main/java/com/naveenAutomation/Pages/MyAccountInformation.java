package com.naveenAutomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

import com.naveenAutomation.Base.TestBase;

public class MyAccountInformation extends TestBase {

	public MyAccountInformation() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input[name='firstname']")
	WebElement firstNameField;
	
	@FindBy(css = "input[name='lastname']")
	WebElement lastNameField;
	
	@FindBy(css = "input[type='email']")
	WebElement emailField;
	
	@FindBy(css = "input[type='tel']")
	WebElement phoneNumberField;
	
	@FindBy(css = "input[type='submit']")
	WebElement continueBtn;
	
	public String verifyFirstNameField() {
		return firstNameField.getText();	
	}
	
	public String verifyLastNameField() {
		return lastNameField.getText();	
	}
	
	public String verifyEmailField() {
		return emailField.getText();	
	}
	
	public String verifyPhoneNumberField() {
		return phoneNumberField.getText();	
	}
	

	//validate personal details
	@FindBy(css = "input[value='J']")
	WebElement firstName;
	
	@FindBy(css = "input[value='K']")
	WebElement lastName;
	
	@FindBy(css = "input[value='khehrajass@gmail.com']")
	WebElement email;
	
	@FindBy(css = "input[value='7894561230']")
	WebElement phoneNumber;
	
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

public MyAccountPage navigateTomyAccountPage() {
	continueBtn.click();
	return new MyAccountPage();
}

public String verifyTitle() {
	return driver.getTitle();
}

@AfterMethod
public void teardown() {
	quitBrowser();
}
}

