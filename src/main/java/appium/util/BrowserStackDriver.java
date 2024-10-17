package appium.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import base.utils.ConfigReader;
import base.utils.ExcelDataConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.remote.MobileCapabilityType;

public class BrowserStackDriver implements IDriver {
	
	protected static RemoteWebDriver driver = null;
	static HashMap<String, String> dataMap = ExcelDataConfig.getMapData(ConfigReader.getValue("WebDataExcelPath"), "BScred");


	public CapabilityFactory capabilityFactory = new CapabilityFactory();
    public static final String USERNAME = dataMap.get("BS_Username");
	  public static final String AUTOMATE_KEY = dataMap.get("BS_Password");
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	  public String testcaseid;
	  public String sprintID;
	  
	  public BrowserStackDriver()
	  {
		  
	  }
	  
	  public BrowserStackDriver(String testcaseid, String sprintID) {
		  this.testcaseid = testcaseid;
		  this.sprintID = sprintID;

	}
	  
	@Override
	public WebDriver initDriver(String browserName) {
		   DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("browser", browserName);
		    if(browserName.equals("iPhone"))
		    {
		    caps.setCapability("device", "iPhone 8 Plus");
		    caps.setCapability("os_version", "11");
		    caps.setCapability("build", "Public Mobile - iOS Tests");
		    }
		    else if(browserName.equals("android"))
		    {
		    caps.setCapability("device", "Samsung Galaxy S8");
		    caps.setCapability("os_version", "7.0");
		    caps.setCapability("build", "Mobile Regression Sprint 1 to Sprint 4.6");
		    caps.setCapability("autoGrantPermissions", "true");
		    
		    caps.setCapability("ignoreUnimportantViews", true);
		    caps.setCapability("disableAndroidWatchers", true);
		    caps.setCapability("resetKeyboard", true);
		    caps.setCapability("unicodeKeyboard", true);
		     
		    }
			else if(browserName.equals("chrome_85"))
			{
				/*ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-plugins");
				options.setExperimentalOption("useAutomationExtension", false);
				options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));*/
				caps.setCapability("os_version", "10");
				caps.setCapability("resolution", "1920x1080");
				caps.setCapability("browser", "Chrome");
				caps.setCapability("browser_version", "85.0");
				caps.setCapability("os", "Windows");
				//caps.setCapability(ChromeOptions.CAPABILITY, options);
			//	caps.setCapability("name", "Public Smoke-85");// test name

				caps.setCapability("build", "Public Smoke -85");
			}

			else if(browserName.equals("chrome_84"))
			{
				caps.setCapability("os_version", "10");
				caps.setCapability("resolution", "1920x1080");
				caps.setCapability("browser", "Chrome");
				caps.setCapability("browser_version", "84.0");
				caps.setCapability("os", "Windows");
				caps.setCapability("buildName", "Public Smoke-84"); // test name
				//caps.setCapability("build", "BStack Build Number 1");
			}

			else if(browserName.equalsIgnoreCase("chrome"))
			{
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("browser", "Chrome");
				caps.setCapability("browser_version", "latest");
				caps.setCapability("resolution", "1920x1080");
				caps.setCapability("build", sprintID);
				caps.setCapability("name", "BStack Public");
				caps.setCapability("projectName", "Public_Regression"); // test name

			}

			else if(browserName.equalsIgnoreCase("edge"))
			{
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("browser", "Edge");
				caps.setCapability("browser_version", "latest");
				caps.setCapability("resolution", "1920x1080");
				caps.setCapability("build", sprintID);
				caps.setCapability("name", "BStack Public");
				caps.setCapability("projectName", "Public_Regression"); // test name

			}
		    caps.setCapability("realMobile", "true");
		    
		    caps.setCapability("project", "Public ASTM");
		    if(testcaseid != null)
		    	caps.setCapability("name", testcaseid);
		    else
		    	caps.setCapability("name", "DummyTest");
		    
		    caps.setCapability("acceptSslCerts", "true");
			try {
				driver = new RemoteWebDriver(new URL(URL), caps);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    return driver;
		    
	}


	

}
