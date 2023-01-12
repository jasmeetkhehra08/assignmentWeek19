package com.naveenAutomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.Base.TestBase;

public class LoginAccountPage extends TestBase{

	public LoginAccountPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "input[name='email']")
	WebElement email;

	@FindBy(css = "input[name='password']")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	private void enterEmail() {
		email.sendKeys("khehrajass@gmail.com");
	}

	private void enterPassword() {
		password.sendKeys("Qwerty");
	}
	public MyAccountPage login() {
		enterEmail();
		enterPassword();
		loginBtn.click();
		return new MyAccountPage();
	}
}
