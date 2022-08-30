package org.automation.test.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseSelenium {
	public int defaultWaitPeriod;
	public WebDriver driver;
	private Properties properties;
	protected final String propertyFilePath = "C:/Automation/DataDriverAutomation/src/test/java/org/automation/test/configuration/configuration.properties";
	// protected final String propertyFilePath=
	// "C:/Automation/walletHubLatest/walletHubLatest/src/com/wallet/Configuration/Configuration.properties";
	public ExtentReports extent;
	public ExtentTest logger;

	@BeforeSuite(alwaysRun = true)
	public void setUpSuite() {
		ExtentSparkReporter spark = new ExtentSparkReporter(
				new File(System.getProperty("user.dir") + "/Report/DemoReport.html"));
		extent = new ExtentReports();
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("MyReport");
		extent.attachReporter(spark);
	}

	@BeforeSuite(alwaysRun = true)
	public void ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	@BeforeTest(alwaysRun = true)
	public void setupBeforeSuite() throws Exception {
		// String readFromConfigFile = System.getProperty("user.dir")+
		// "/src/com/wallet/Configuration/walletHub-configuration.properties";

		// properties = new Properties();
		String BrowserURL = properties.getProperty("BrowserURL");
		String BrowserName = properties.getProperty("BroserName");
		String DriverPath = properties.getProperty("DriverPath");

		if (BrowserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", DriverPath);
			driver = new FirefoxDriver();
		} else if (BrowserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", DriverPath);
			driver = new ChromeDriver();
			// WebDriverManager.chromedriver().setup();
		} else if (BrowserName.equalsIgnoreCase("Internet Explorer")) {
			System.setProperty("webdriver.ie.driver", DriverPath);
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		// driver.get(BrowserURL);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@AfterMethod
	public void flushReport() {
		extent.flush();
	}

}
