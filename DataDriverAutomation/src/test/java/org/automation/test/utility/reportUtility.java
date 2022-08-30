package org.automation.test.utility;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class reportUtility {

	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter  spark = new ExtentSparkReporter ("extentReport.html");
	// spark.config().setTheme(Theme.DARK);
	// spark.config().setDocumentTitle("MyReport");
	// extent.attachReporter(spark);
	
	@BeforeTest
	public void v2() {
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("MyReport");
		extent.attachReporter(spark);
		//reports.endTest();
//		spark.log(Status.PASS,"Test Passed");
//		spark.log(LogStatus.FAIL,"Test Failed");
//		spark.log(LogStatus.SKIP,"Test Skipped");
//		spark.log(LogStatus.INFO,"Test Info");
	}

//	@Test
//	public void v1() {
//		ExtentTest test = extent.createTest("Launch browser");
//		test.log(Status.PASS, "Browser Launch Success");
//		test.pass("Browser Launch Success");
//	}
//	
//	@Test
//	public void v4() {
//		ExtentTest test = extent.createTest("Verify login");
//		test.info("Login success");
//		test.pass("Login Launch Success");
//		test.warning("Login window for FB");
//	}
	
	@AfterTest
	public void v3() {
		extent.flush();
	}
}