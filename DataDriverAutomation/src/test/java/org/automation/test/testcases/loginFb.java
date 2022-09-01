package org.automation.test.testcases;

import java.util.HashMap;

import org.automation.test.datagenerators.dataGenerators;
import org.automation.test.pages.loginPage;
import org.automation.test.utility.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.azentio.generic.BaseSelenium;
//import com.azentio.generic.TestData;

public class loginFb extends BaseSelenium {

	// baseSelenium base = new baseSelenium();
	loginPage lp = new loginPage();
	//HashMap<String, String> inputDataMap = new HashMap<String, String>();

	@Test(dataProvider = "LoginDemo", dataProviderClass = dataGenerators.class)
	public void loginToFb(String username, String password) throws Exception {

		logger = extent.createTest("Login to fb");
		logger.info("Starting application and opening fb if credentials are valid");
		driver.get("https://fb.com/");
		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		lp.enterUsername(username);
		lp.enterPassword(password);
		lp.clickLogin();
		logger.pass("Login success");
		Thread.sleep(20000);

	}
//	@Test(dataProvider = "get-test-data-method")
//	public void verifyLogin(HashMap<String, String> testData) {
//		driver.get("https://fb.com/");
//		inputDataMap = TestData.extractTestDataintoMap(testData.get("INPUT_DATA"));
//		lp.enterUsername(inputDataMap.get("username"));
//		lp.enterPassword(inputDataMap.get("password"));
//		lp.clickLogin();
//
//	}

}