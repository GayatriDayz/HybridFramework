package org.automation.test.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class loginPage {

	//static WebDriver driver;
	//public WebDriver driver;
	@FindBy(id = "email")
	WebElement username;

	@FindBy(id = "pass")
	WebElement password;

	@FindBy(xpath = "//button[text()='Log In']")
	WebElement loginBtn;
	
//	public static WebDriver getDriver() {
//
//		return driver;
//
//	}
//
//	public loginPage() {
//		driver = loginPage.getDriver();
//		PageFactory.initElements(driver, this);
//	}
//	
	
	
//	public loginPage(WebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver, this); // this means this class
//	}

	public void enterUsername(String uname) {
		username.sendKeys(uname);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickLogin() {
		loginBtn.click();
	}
}
