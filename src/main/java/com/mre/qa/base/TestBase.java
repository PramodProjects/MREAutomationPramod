package com.mre.qa.base;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
	@Parameters({ "browser", "platform" })
	public void setUp(String browserName, String platformName, Method name) throws InterruptedException {

		if (browserName.equals("saucechrome")) {
			System.out.println("browser name is : " + browserName);
			String methodName = name.getName();

			MutableCapabilities sauceOpts = new MutableCapabilities();
			sauceOpts.setCapability("name", methodName);
			// sauceOpts.setCapability("build", "Java-W3C-Examples");
			// sauceOpts.setCapability("build", "build-1234");
			// sauceOpts.setCapability("seleniumVersion", "3.141.59");
			// sauceOpts.setCapability("username", "pramodmd1");
			// sauceOpts.setCapability("accessKey", "3eac108f-02f8-486e-bf01-f6b10d758045");

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("sauce:options", sauceOpts);
			cap.setCapability("browserName", "chrome");
			cap.setCapability("browserVersion", "latest");
			cap.setCapability("platformName", platformName);

//		if (browserName.equals("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			cap.setCapability("browserName", "chrome");
//		} else if (browserName.equals("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			cap.setCapability("browserName", "firefox");

			// https://naveenanimation20:f418309b-b7b4-424d-825c-0d4a78b90bb5@ondemand.us-west-1.saucelabs.com:443/wd/hub
			try {

				driver = new RemoteWebDriver(new URL(
						"https://pramodmd1:3eac108f-02f8-486e-bf01-f6b10d758045@ondemand.apac-southeast-1.saucelabs.com:443/wd/hub"),
						cap);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

		else if (browserName.equals("saucefirefox")) {

			System.out.println("browser name is : " + browserName);
			String methodName = name.getName();

			MutableCapabilities sauceOpts = new MutableCapabilities();
			sauceOpts.setCapability("name", methodName);
			// sauceOpts.setCapability("build", "Java-W3C-Examples");
			// sauceOpts.setCapability("build", "build-1234");
			// sauceOpts.setCapability("seleniumVersion", "3.141.59");
			// sauceOpts.setCapability("username", "pramodmd1");
			// sauceOpts.setCapability("accessKey", "3eac108f-02f8-486e-bf01-f6b10d758045");

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("sauce:options", sauceOpts);
			cap.setCapability("browserName", "firefox");
			cap.setCapability("browserVersion", "latest");
			cap.setCapability("platformName", platformName);

//			if (browserName.equals("chrome")) {
//				WebDriverManager.chromedriver().setup();
//				cap.setCapability("browserName", "chrome");
//			} else if (browserName.equals("firefox")) {
//				WebDriverManager.firefoxdriver().setup();
//				cap.setCapability("browserName", "firefox");

			// https://naveenanimation20:f418309b-b7b4-424d-825c-0d4a78b90bb5@ondemand.us-west-1.saucelabs.com:443/wd/hub
			try {

				driver = new RemoteWebDriver(new URL(
						"https://pramodmd1:3eac108f-02f8-486e-bf01-f6b10d758045@ondemand.apac-southeast-1.saucelabs.com:443/wd/hub"),
						cap);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

		else {
			// String browserName = readConfig.getBrowser();

			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
				driver = new ChromeDriver();

			}

			else if (browserName.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
				driver = new FirefoxDriver();

			}
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

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
