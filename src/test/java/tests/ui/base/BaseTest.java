package tests.ui.base;

import appium.util.DriverFactory;
import base.utils.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;
import pages.ui.BasePage;
import pages.ui.Page;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class BaseTest {

	public WebDriver driver;
	public Page page;
	public  static  String Env;
	public  static  String browserName;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public Logger log = Logger.getLogger(BaseTest.class);
	DriverFactory df;
	
	@BeforeClass(alwaysRun=true)
	@Parameters({"browser", "platform","env","updateJira","testExecutionId","sprintID"})
	public void setUpTest(String browser,  @Optional("local") String platform, @Optional("QA") String env,@Optional("false") boolean updateJira,@Optional("0000") String testExecutionId,@Optional("sprintID") String sprintID)
	{

		//Fetching Class name for Passing it to BrowserStack Execution.
		String className = this.getClass().getName();
		Env=env;
		browserName=browser;
		df = new DriverFactory();
		try {

			if(platform.equalsIgnoreCase("browserStack") || platform.equalsIgnoreCase("browserStackid"))
			{
				driver = df.generateDriverStack(platform, className, sprintID).initDriver(browser);
			}
			else
			{
				driver = df.generateDriver(platform).initDriver(browser);
			}


//		driver = df.generateDriver(platform).initDriver(browser);

			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener(log);
			e_driver.register(eventListener);
			driver = e_driver;
			page=new BasePage(driver);
			//TestListener.setListenerDriver(driver); //Not used anywhere
			//Updating Xray flag for Jira update
			if(updateJira==true) {
				ConfigReader.setValue("updateTestStatus", "true");
				ConfigReader.setValue("TestExecutionID", testExecutionId);
			}
			//Setting Base URL based on Environments
			ConfigReader.setValue("BASE_URL_MAE", ConfigReader.getValue(env+"MAE"));
			
			String value=ConfigReader.getValue(env);
			if(env.equals("QA"))
				ConfigReader.setValue("BASE_URL_WCMS_ASTM",value);
			else if(env.equals("DEV"))
				ConfigReader.setValue("BASE_URL_WCMS_ASTM",value);
			else if(env.equals("STG"))
				ConfigReader.setValue("BASE_URL_WCMS_ASTM",value);
			EnvironmentFileUtil.setUp(browser, platform,env);
			ScreenRecorderUtil.startRecord(className);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	/*public void setUpTest(
			String browser,
			@Optional("local") String platform,
			@Optional("QA") String env,
			@Optional("false") boolean updateJira,
			@Optional("0000") String testExecutionId,
			@Optional("sprintID") String sprintID,
			@Optional("desktop") String viewMode) { // viewMode = "desktop" or "mobile"

		String className = this.getClass().getName();
		Env = env;
		browserName = browser;
		df = new DriverFactory();

		try {
			// Initialize driver
			if (platform.equalsIgnoreCase("browserStack") || platform.equalsIgnoreCase("browserStackid")) {
				driver = df.generateDriverStack(platform, className, sprintID).initDriver(browser);
			} else {
				driver = df.generateDriver(platform).initDriver(browser);
			}

			// Mobile view handling for web
			if (viewMode.equalsIgnoreCase("mobile")) {
				if (browser.equalsIgnoreCase("chrome")) {
					// Chrome device emulation (iPhone X example)
					Map<String, Object> deviceMetrics = new HashMap<>();
					deviceMetrics.put("width", 375);
					deviceMetrics.put("height", 812);
					deviceMetrics.put("pixelRatio", 3.0);

					Map<String, Object> mobileEmulation = new HashMap<>();
					mobileEmulation.put("deviceMetrics", deviceMetrics);
					mobileEmulation.put("userAgent", "Mozilla/5.0 (iPhone; CPU iPhone OS 13_6 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.1.2 Mobile/15E148 Safari/604.1");

					ChromeOptions options = new ChromeOptions();
					options.setExperimentalOption("mobileEmulation", mobileEmulation);

					driver.quit(); // close previous driver
					driver = new org.openqa.selenium.chrome.ChromeDriver(options);
				} else {
					// Other browsers: just resize window to mobile dimensions
					driver.manage().window().setSize(new Dimension(375, 812));
				}
			} else {
				driver.manage().window().maximize();
			}

			// Event listener
			e_driver = new EventFiringWebDriver(driver);
			eventListener = new WebEventListener(log);
			e_driver.register(eventListener);
			driver = e_driver;

			// Page object
			page = new BasePage(driver);

			// Jira/Xray updates
			if (updateJira) {
				ConfigReader.setValue("updateTestStatus", "true");
				ConfigReader.setValue("TestExecutionID", testExecutionId);
			}

			// Base URLs
			ConfigReader.setValue("BASE_URL_MAE", ConfigReader.getValue(env + "MAE"));
			ConfigReader.setValue("BASE_URL_WCMS_ASTM", ConfigReader.getValue(env));

			// Environment setup
			EnvironmentFileUtil.setUp(browser, platform, env);

			// Start screen recording
			ScreenRecorderUtil.startRecord(className);

		} catch (Exception e) {
			log.error("Error in setUpTest: " + e.getMessage(), e);
			throw new RuntimeException("Failed to initialize test setup.", e);
		}
	}*/

	@AfterMethod(alwaysRun=true)
	public void Screenshot()
	{
		try {
			ScreenshotUtil.takeScreenshotForAllure(driver);
			ScreenRecorderUtil.stopRecord();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterClass(alwaysRun=true)
	public void TearDown()
	{
		driver.quit();
	}

}
