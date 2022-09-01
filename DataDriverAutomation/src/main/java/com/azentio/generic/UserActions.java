//package com.azentio.generic;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//
//public class UserActions extends BaseSelenium {
//
//	public void moveToElementAndClick(By ele) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ele));
//		Actions action = new Actions(driver);
//		WebElement actionName = driver.findElement(ele);
//		action.moveToElement(actionName).click().perform();
//	}
//
//	public void click(By by) throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//		wait.until(ExpectedConditions.elementToBeClickable(by));
//		driver.findElement(by).click();
//		Thread.sleep(1000);
//	}
//
//	public void scrollDown() {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(100,450)");
//	}
//
//	public static void clickElement(WebElement ele, String label) {
//		try {
//			ele.click();
//			// Reporting.("PASS", "Sucessfully click on " + label);
//		} catch (Exception e) {
//			// Reporting.("FAIL", "Sucessfully click on " + label + " -- Exception ---> " +
//			// e.getMessage() );
//
//		}
//
//	}
//
////	public static void enterText(WebElement ele, String label, String strValue) {
////		try {
////			ele.sendKeys(strValue);
////			Reporting.writeHTMLLogs("PASS", "Sucessfully enter  " + strValue + " in " + label);
////		} catch (Exception e) {
////			Reporting.writeHTMLLogs("FAIL", "Failed to enter  " + strValue + " in " + label);
////
////		}
////
////	}
//
//}
