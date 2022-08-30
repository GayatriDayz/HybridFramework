package org.automation.test.testcases;


import org.automation.test.base.baseSelenium;
import org.automation.test.datagenerators.dataGenerators;
import org.automation.test.pages.loginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class loginFb extends baseSelenium {

	//baseSelenium base = new baseSelenium();
	loginPage lp=new loginPage();

	@Test(dataProvider = "LoginDemo", dataProviderClass = dataGenerators.class)
	public void loginToFb(String username, String password) throws Exception {
		
		logger = extent.createTest("Login to fb");		
		logger.info("Starting application and opening fb if credentials are valid");
		driver.get("https://fb.com/");
		loginPage lp= PageFactory.initElements(driver, loginPage.class);
		lp.enterUsername(username);
		lp.enterPassword(password);
		lp.clickLogin();
		logger.pass("Login success");
		Thread.sleep(20000);
	}
	
	@Test(priority=2)
	public void logOut() {
		logger.info("Logging out from fb");
		logger.fail("Logout failed");
	}
	
}
