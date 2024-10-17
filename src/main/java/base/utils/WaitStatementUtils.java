package base.utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatementUtils {
	

	public static void implicitWaitForSeconds(WebDriver driver, int time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);	}
	
	
	
	
	public static void implicitWaitForMinutes(WebDriver driver, int time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.MINUTES);
	}
	
	
	
	public static boolean explicitWaitForVisibility(final WebDriver driver, WebElement element)
	{
		
		return explicitWaitForVisibility(driver,element,10);
		
	}
	
	 public static boolean explicitWaitForVisibility(final WebDriver driver, final WebElement webElement, final int timeout)
	    {
	        try {
	            new WebDriverWait(driver, timeout).pollingEvery(Duration.ofMillis(500))
	                    .until(ExpectedConditions.visibilityOf(webElement));
	        }
	        catch (Exception e) {
	        	System.out.println("Exception in Explicit Wait: "+e.toString());
	            return false;
	        }

	        return true;
	    }

    public static boolean explicitWaitForInVisibility(final WebDriver driver, final WebElement webElement, final int timeout)
    {
        try {
            new WebDriverWait(driver, timeout).pollingEvery(Duration.ofMillis(500))
                    .until(ExpectedConditions.invisibilityOf(webElement));
        }
        catch (Exception e) {
            System.out.println("Exception in Explicit Wait: "+e.toString());
            return false;
        }

        return true;
    }
	
	
	public static boolean waitForNumberOfElementsToBe(final WebDriver driver, final String cssSelector, final int numberOfElementsExpected)
    {
        return waitForNumberOfElementsToBe(driver,cssSelector,numberOfElementsExpected,10);
    }

    
    public static boolean waitForNumberOfElementsToBe(final WebDriver driver, final String cssSelector, final int numberOfElementsExpected, final int timeout)
    {
        try {
            new WebDriverWait(driver, timeout).pollingEvery(Duration.ofMillis(500))
                    .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(cssSelector),numberOfElementsExpected));
        }
        catch (Exception e) {
            return false;
        }

        return true;
    }
    
    public static boolean waitForElementToBeClickable(final WebDriver driver, final WebElement webElement)
    {
    	try
    	{
    	new WebDriverWait(driver, 10).pollingEvery(Duration.ofMillis(500))
         .until(ExpectedConditions.elementToBeClickable(webElement));
    	System.out.println("Element "+webElement+"is clickable");
    	return true;
    	}
    	catch (Exception ex) {
    		System.out.println("Element "+webElement+"is not clickable");
        	return false;
		}
    }

    public static boolean waitForElementToBeClickable(final WebDriver driver, final WebElement webElement, final int timeout)
    {
        try {
        	//new WebDriverWait(driver,10).until(ExpectedConditions.or(ExpectedConditions.invisibilityOf(getMaskClass()),ExpectedConditions.elementToBeClickable(element)));
            new WebDriverWait(driver, timeout).pollingEvery(Duration.ofMillis(500))
                    .until(ExpectedConditions.and(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='mask-cover']"))),ExpectedConditions.elementToBeClickable(webElement)));
            System.out.println("Element "+webElement+"is clickable against mask");
        }
        catch (Exception e) {
        	try
        	{
        	new WebDriverWait(driver, timeout).pollingEvery(Duration.ofMillis(500))
             .until(ExpectedConditions.elementToBeClickable(webElement));
        	System.out.println("Element "+webElement+"is clickable");
        	return true;
        	}
        	catch (Exception ex) {
        		System.out.println("Element "+webElement+"is not clickable");
            	return false;
			}
        }

        return true;
    }

    /**
     * Method used to wait till the loader disappear
     * @param driver
     * @return
     */
    public static boolean waitForLoaderToBeInvisible(final WebDriver driver)
    {
        long timeout=30;
        try {
            System.out.println("Searching for Loader");
            driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
            new WebDriverWait(driver, timeout).pollingEvery(Duration.ofMillis(500))
                    .until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='mask-cover']"))));
            driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
            System.out.println("Loader is invisible");
        }
        catch (Exception e) {

                System.out.println("Loader not found");
                return false;
            }


        return true;
    }
    
    public static boolean waitForElementAttributeToBe(final WebDriver driver, By locator, String attribute, String value, int timeout)
    {
        try {
            new WebDriverWait(driver, timeout).pollingEvery(Duration.ofMillis(500))
                    .until(ExpectedConditions.attributeToBe(locator, attribute, value));
        }
        catch (Exception e) {
            return false;
        }

        return true;
    }
	
    public static boolean presenceOfElementLocatedWait(final WebDriver driver, final String webElement)
    {

        return presenceOfElementLocatedWait(driver,webElement,10);
    }

    public static boolean presenceOfElementLocatedWait(final WebDriver driver, final String webElement, final int timeout)
    {
        try {
            new WebDriverWait(driver, timeout).pollingEvery(Duration.ofMillis(500))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(webElement)));
        }
        catch (Exception e) {
            return false;
        }

        return true;
    }
    public static boolean waitForElementStaleness(final WebDriver driver, final WebElement webElement)
    {
        return waitForElementStaleness(driver, webElement, 10);
    }

    public static boolean waitForElementStaleness(final WebDriver driver, final WebElement webElement, final int timeout)
    {
        try {
            new WebDriverWait(driver, timeout).pollingEvery(Duration.ofMillis(500))
                    .until(ExpectedConditions.stalenessOf(webElement));
        }
        catch (Exception e) {
            return false;
        }

        return true;
    }
	
}










