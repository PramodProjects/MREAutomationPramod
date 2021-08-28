package com.mre.qa.base;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.mre.qa.utils.ReadConfig;
import com.mre.qa.utils.TestUtils;
import com.mre.qa.utils.WebEventListener;


public class TestBase {

	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static Logger logger;
	ReadConfig readConfig = new ReadConfig();

	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browserName) throws InterruptedException {

		//String browserName = readConfig.getBrowser();

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();

		}

		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
			driver = new FirefoxDriver();

		}

		// Initiating logger
		logger = Logger.getLogger("MRE");
		PropertyConfigurator.configure("Log4j.properties");

		// Webdriver Event firing
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(readConfig.getURL());
		logger.info("URL Opened");
		Thread.sleep(20000);

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
