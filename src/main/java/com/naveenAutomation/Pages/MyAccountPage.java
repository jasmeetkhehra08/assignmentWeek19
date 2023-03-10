package com.naveenAutomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.naveenAutomation.Base.TestBase;

public class MyAccountPage extends TestBase{

	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement verifyTitletext;
	
	@FindBy(xpath = "//a[text()='Edit your account information']")
	WebElement editAccountInfo;
	
	@FindBy(xpath = "//a[text()='Edit Account']")
	WebElement editAccount;
	
	@FindBy(css= "i.fa.fa-check-circle")
	WebElement verifyAlertText;
	
	@FindBy(css= "div.list-group a:last-of-type")
	WebElement logout;
	
	@FindBy(xpath = "//a[text()='Address Book']")
	WebElement addressBook;
	
	public String verifyTitleTxt() {
		return verifyTitletext.getText();
	}
	
	public MyAccountInformation editAccountInfo() {
		editAccountInfo.click();
		return new MyAccountInformation();
	}
	
	public MyAccountInformation editAccount() {
		editAccount.click();
		return new MyAccountInformation();
	}
	
	public String verifyAlertText() {
		return verifyAlertText.getText();
	}
	
	public AccountLogout logout() {
		logout.click();
		return new AccountLogout();
	}
	
	public AddressBookPage addressBook() {
		addressBook.click();
		return new AddressBookPage();
	}
	
	
}
