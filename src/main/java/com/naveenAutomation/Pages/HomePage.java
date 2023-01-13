package com.naveenAutomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomation.Base.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Login']")
	WebElement loginBtn;

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccount;

	@FindBy(css = "head>title")
	WebElement verifyTitletext;

	public LoginAccountPage clickLoginPage() {
		myAccount.click();
		loginBtn.click();
		return new LoginAccountPage();

	}

	public AccountLogin clickLogin() {
		myAccount.click();
		loginBtn.click();
		return new AccountLogin();

	}
	
	public String verifyPageTitle() {
		return verifyTitletext.getText();
	}
}
