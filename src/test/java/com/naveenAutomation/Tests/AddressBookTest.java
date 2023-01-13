package com.naveenAutomation.Tests;


import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.naveenAutomation.Base.TestBase;
import com.naveenAutomation.Pages.AddressBookPage;
import com.naveenAutomation.Pages.HomePage;
import com.naveenAutomation.Pages.LoginAccountPage;
import com.naveenAutomation.Pages.MyAccountPage;

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
		HomePage homePage = new HomePage();
		LoginAccountPage loginAccountPage = homePage.clickLoginPage();
		MyAccountPage myAccountPage = loginAccountPage.login();
		AddressBookPage addressBookPage = myAccountPage.addressBook();
		String locatorForEdit = "table.table.table-bordered.table-hover td a:first-of-type";
		// updating first address
		addressBookPage.clickEditButtonInWebTable("L8G0T1", By.cssSelector(locatorForEdit));
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
