package org.automation.test.base;
import java.io.BufferedReader;
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
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseSelenium {
	public int defaultWaitPeriod;
	public WebDriver driver;
	private Properties properties;
	protected final String propertyFilePath = "C:/Automation/DataDriverAutomation/src/test/java/org/automation/test/configuration/configuration.properties";
	// protected final String propertyFilePath=
	// "C:/Automation/walletHubLatest/walletHubLatest/src/com/wallet/Configuration/Configuration.properties";

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

	public void moveToElementAndClick(By ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ele));
		Actions action = new Actions(driver);
		WebElement actionName = driver.findElement(ele);
		action.moveToElement(actionName).click().perform();
	}

	public void click(By by) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
		Thread.sleep(1000);
	}
	

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(100,450)");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
