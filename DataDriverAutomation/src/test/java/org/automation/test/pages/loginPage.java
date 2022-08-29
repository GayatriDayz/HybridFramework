package org.automation.test.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class loginPage {

	//public WebDriver driver;
	@FindBy(id = "email")
	WebElement username;

	@FindBy(id = "pass")
	WebElement password;

	@FindBy(xpath = "//button[text()='Log In']")
	WebElement loginBtn;

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
