package com.naveenAutomation.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.naveenAutomation.Base.TestBase;
import com.naveenAutomation.Pages.AccountLogout;
import com.naveenAutomation.Pages.HomePage;
import com.naveenAutomation.Pages.LoginAccountPage;
import com.naveenAutomation.Pages.MyAccountPage;

public class AccountLogoutTest extends TestBase {

	SoftAssert sf;
	@BeforeMethod
	public void setUp() {
		launchBrowser();
		sf =new SoftAssert();
	}
	
	@Test
	public void verifyLogoutFunctionality() {
		HomePage homePage = new HomePage();
		LoginAccountPage loginAccountPage= homePage.clickLoginPage();
		MyAccountPage myAccountPage=loginAccountPage.login();
		sf.assertEquals(myAccountPage.verifyTitleTxt(), "My Account", "unable to login");
		AccountLogout accountLogout=myAccountPage.logout();
		accountLogout.logoutFromAccount();
		sf.assertEquals(homePage.verifyPageTitle(), "Your Store", "unable to logout");
	sf.assertAll();
	}

	
	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
}

