package appium.util;

/**
 * Determines which browser is being used and sets the driver accordingly.
 */
public class DriverFactory
{
    public  IDriver generateDriver(String typeOfDriver)
    
    {
    	if (typeOfDriver.equalsIgnoreCase("local"))
    	{
    		return new LocalWebDriver();
    	}
    	else if (typeOfDriver.equalsIgnoreCase("remote"))
    	{
    		return new RemoteDriver();
    	}
    	else if (typeOfDriver.equalsIgnoreCase("android"))
    	{
    		return new AndroidBowserDriver();
    	}
    	return null;
    }
    
public IDriver generateDriverStack(String typeOfDriver, String testcaseid, String sprintID)
    
    {
   
    	if (typeOfDriver.equalsIgnoreCase("browserStack"))
    	{
    		return new BrowserStackDriver();
    	}
    	else if (typeOfDriver.equalsIgnoreCase("browserStackid"))
    	{
    		return new BrowserStackDriver(testcaseid, sprintID);
    	}
    	return null;
    }
}