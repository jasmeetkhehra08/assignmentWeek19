package com.naveenAutomation.Tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.naveenAutomation.Base.TestBase;
import com.naveenAutomation.Pages.AccountLogin;
import com.naveenAutomation.Pages.HomePage;
import com.naveenAutomation.Pages.MyAccountPage;
import com.naveenAutomation.Utils.ExcelUtils;

public class AccountLoginTest extends TestBase {

	SoftAssert sf;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		sf = new SoftAssert();
	}

	@Test(dataProvider = "LoginDataProvider")
	public void verifyloginfunctionality(String userName, String password) {
		HomePage homePage = new HomePage();
		AccountLogin accountLogin = homePage.clickLogin();
		MyAccountPage myAccountPage = accountLogin.loginWithValidCred(userName, password);
		sf.assertEquals(myAccountPage.verifyTitleTxt(), "My Account", "unable to login");
		
	}

	@DataProvider(name = "LoginDataProvider")
	public String[][] provideLoginData() throws IOException {
		String filePath = "./Test Data\\LoginDetails.xlsx";
		int rowCount = ExcelUtils.getRowCount(filePath, "Sheet1");
		int colCount = ExcelUtils.getColumnCount(filePath, "Sheet1", rowCount);
		String[][] loginData = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = ExcelUtils.getCellValue(filePath, "Sheet1", i, j);
			}
		}
		return loginData;
	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
}
