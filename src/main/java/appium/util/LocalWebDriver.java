package appium.util;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import base.utils.ConfigReader;

public class LocalWebDriver implements IDriver {
	
	protected static WebDriver driver = null;

    public CapabilityFactory capabilityFactory = new CapabilityFactory();

	@Override
	public WebDriver initDriver(String browserName) {
		
		if(browserName.equals("firefox"))
		{
			/*Commenting this code because handling new drivers by WebdriverManger*/
//			System.setProperty(ConfigReader.getValue("FirefoxDriver"), ConfigReader.getValue("FirefoxDriverPath"));
			WebDriverManager.firefoxdriver().setup();
			FirefoxDriver firefox = new FirefoxDriver(OptionsManager.getFirefoxOptions());
			firefox.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//	firefox.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
			firefox.manage().window().maximize();
			firefox.manage().deleteAllCookies();
			return firefox;
		}
		if (browserName.equals("chrome"))
		{
			/*Commenting this code because handling new drivers by WebdriverManger*/
//		System.setProperty(ConfigReader.getValue("ChromeDriver"), ConfigReader.getValue("ChromeDriverPath"));
			WebDriverManager.chromedriver().setup();
			ChromeDriver chrome=new ChromeDriver(OptionsManager.getChromeOptions());
			chrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			chrome.manage().window().maximize();
			chrome.manage().deleteAllCookies();
			return chrome;

		}
		if (browserName.equals("IE"))
		{
				System.setProperty(ConfigReader.getValue("IEDriver"), ConfigReader.getValue("IEDriverPath"));
				driver=new InternetExplorerDriver(OptionsManager.getIEOptions());
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
			return driver;
		}
		if (browserName.equalsIgnoreCase("edge"))
		{
			/*Commenting this code because handling new drivers by WebdriverManger*/
//			System.setProperty(ConfigReader.getValue("EdgeDriver"), ConfigReader.getValue("EdgeDriverPath"));
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(OptionsManager.getEdgeOptions());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			return driver;
		}
		else 
		{
			/*Commenting this code because handling new drivers by WebdriverManger*/
//			System.setProperty(ConfigReader.getValue("ChromeDriver"), ConfigReader.getValue("ChromeDriverPath"));
			WebDriverManager.chromedriver().setup();
			ChromeDriver chrome=new ChromeDriver();
			chrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//chrome.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			chrome.manage().window().maximize();
			chrome.manage().deleteAllCookies();
			return chrome;
		}


	}

}
