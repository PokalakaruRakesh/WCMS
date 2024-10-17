package appium.util;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidBowserDriver implements IDriver {

	protected static AndroidDriver<AndroidElement> driver = null;


	@Override
	public WebDriver initDriver(String browserName) {
		try {

    		// 1 Create Device Capabilities.
    		DesiredCapabilities cap = new DesiredCapabilities();

    		// 2 Setup a device name. This capability is currently ignored, but remains required on Android.		
    		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "ZZ22228LVV");
    		
    		// 3 Setup a name of Android web browser to automate.
    		cap.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
    		//cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "");
    						
    		// 4 Create an Android driver to initiate the session to Appium server. 
    		URL url = new URL("http://0.0.0.0:4723/wd/hub");					
    		
    		driver = new AndroidDriver<AndroidElement>(url, cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    	return driver;
	}
	
}
