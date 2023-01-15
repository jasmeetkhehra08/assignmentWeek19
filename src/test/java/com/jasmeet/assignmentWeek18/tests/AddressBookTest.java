package com.jasmeet.assignmentWeek18.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.jasmeet.assignmentWeek18.pages.AddressBookPage;
import com.naveenAutomation.Base.TestBase;
import com.naveenAutomationLogin.pages.homePage;
import com.naveenAutomationLogin.pages.loginAccountPage;
import com.naveenAutomationLogin.pages.myAccountPage;

public class AddressBookTest extends TestBase {

	SoftAssert sf;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		sf = new SoftAssert();

	}

	@Test
	public void verifyAddressBook() {
		// login
		homePage homePage = new homePage();
		loginAccountPage loginAccountPage = homePage.clickLoginPage();
		myAccountPage myAccountPage = loginAccountPage.login();
		AddressBookPage addressBookPage = myAccountPage.addressBook();
		String locatorForEdit = "table.table.table-bordered.table-hover td a:first-of-type";
		// updating first address
		addressBookPage.clickEditButtonInWebTable("C1N1N0", By.cssSelector(locatorForEdit));
		addressBookPage.updateAddressBook("Parul", "Verma", "XYZ", "2089", "15st", "Milton", "L8G0T1", "Canada",
				"Ontario");

		sf.assertEquals(addressBookPage.getTextFromSuccessAlert(), "Your address has been successfully updated",
				"Address not updated!");
		// updating second address
		addressBookPage.clickEditButtonInWebTable("M15M20", By.cssSelector(locatorForEdit));
		addressBookPage.updateAddressBook("j", "K", "", "123", "", "montreal", "L4L090", "Québec", "Canada");

		// validating success banner
		sf.assertEquals(addressBookPage.getTextFromSuccessAlert(), "Your address has been successfully updated",
				"Address not updated!");
		sf.assertAll();
	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
}
