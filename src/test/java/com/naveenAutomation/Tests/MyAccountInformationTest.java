package com.naveenAutomation.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenAutomation.Base.TestBase;
import com.naveenAutomation.Pages.HomePage;
import com.naveenAutomation.Pages.LoginAccountPage;
import com.naveenAutomation.Pages.MyAccountInformation;
import com.naveenAutomation.Pages.MyAccountPage;

public class MyAccountInformationTest extends TestBase {

	SoftAssert sf;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		sf = new SoftAssert();
	}

	@Test
	public void ValidateAccountInfoFields() {
		// login
		HomePage homePage = new HomePage();
		LoginAccountPage loginAccountPage = homePage.clickLoginPage();
		MyAccountPage myAccountPage = loginAccountPage.login();
		MyAccountInformation myAccountInformation = myAccountPage.editAccount();
		sf.assertEquals(myAccountInformation.verifyTitle(), "My Account Information", "Page title does not match");
		String firstName= myAccountInformation.validateFirstName();
		String lastName=myAccountInformation.validateLastName();
		String email = myAccountInformation.validateEmail();
		String phoneNumber =myAccountInformation.validatePhoneNumber();
		myAccountInformation.navigateTomyAccountPage();
		myAccountPage.editAccountInfo();
		
		sf.assertEquals(myAccountInformation.verifyFirstNameField(), firstName, "field empty or information does not match");
		sf.assertEquals(myAccountInformation.verifyLastNameField(), lastName, "field empty or information does not match");
		sf.assertEquals(myAccountInformation.verifyEmailField(), email,"field empty or information does not match");
		sf.assertEquals(myAccountInformation.verifyPhoneNumberField(), phoneNumber,"field empty or information does not match");
		myAccountInformation.navigateTomyAccountPage();
		sf.assertAll();
	}
	
	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
}