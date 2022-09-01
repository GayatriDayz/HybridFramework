//package com.azentio.generic;
//
//import java.io.File;
//import java.io.IOException;
//import org.automation.test.utility.Helper;
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestResult;
//import org.testng.Reporter;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//
//public class Reporting {
//
//	static WebDriver driver;
//
//	public static void setUpSuite() {
//		ExtentSparkReporter spark = new ExtentSparkReporter(new File(
//				System.getProperty("user.dir") + "/Report/DemoReport+" + Helper.getCurrentDateTime() + ".html"));
//		try {
//			Global.extent = new ExtentReports();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		spark.config().setTheme(Theme.DARK);
//		spark.config().setDocumentTitle("MyReport");
//		Global.extent.attachReporter(spark);
//	}
//
//	public static void tearDownMethod(ITestResult result) throws IOException {
//		Reporter.log("Test is about to end", true);
//
//		if (result.getStatus() == ITestResult.FAILURE) {
//			Helper.captureScreenshot(driver);
//			Global.logger.fail("Test Failed",
//					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
//
//		} else if (result.getStatus() == ITestResult.SUCCESS) {
//			Global.logger.pass("Test Passed",
//					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
//		} else if (result.getStatus() == ITestResult.SKIP) {
//			Global.logger.skip("Test Skipped",
//					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
//		}
//		Global.extent.flush();
//		Reporter.log("Test Completed >> Report Generated", true);
//	}
//
//}
