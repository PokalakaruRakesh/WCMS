package appium.util;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

public class LanunchAndroidBrowser {

	public static void main(String[] args) throws MalformedURLException {

		// 1
		DriverFactory df = new DriverFactory();
		//DriverFactory df1 = new DriverFactory();
		WebDriver weblocal = df.generateDriver("local").initDriver("chrome");
		//WebDriver android = df1.generateDriver("android").initDriver("chrome");
		
		// 2 Lanunch browser
		weblocal.get("https://integration-5ojmyuq-s6kzaedwzvi6o.us-3.magentosite.cloud/");
		//android.get("https://integration-5ojmyuq-s6kzaedwzvi6o.us-3.magentosite.cloud/");
	}			
}
