package com.naveenAutomationWeek18.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenAutomation.Base.TestBase;
import com.naveenAutomationLogin.pages.AccountCreatedPage;
import com.naveenAutomationLogin.pages.YourStorePage;
import com.naveenAutomationLogin.pages.registerAccountPage;

public class AccountCreatedTest extends TestBase {
	SoftAssert sf;
	@BeforeMethod
	public void setUp() {
		launchBrowser();
		sf =new SoftAssert();
	}
	
	@Test
	public void registrationSuccessful() {
		YourStorePage homePage = new YourStorePage();
		registerAccountPage registerAccountPage= homePage.clickRegisterPage();
		AccountCreatedPage AccountCreatedPage= registerAccountPage.register("J", "K", "j@gmail.com", "7894561230","qwerty","qwerty");
		sf.assertEquals(AccountCreatedPage.accountCreatedTxt(), "Your Account Has Been Created!", "no account has been account");
	}

	
	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
}
