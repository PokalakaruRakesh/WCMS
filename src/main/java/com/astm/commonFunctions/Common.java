package com.astm.commonFunctions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import com.db.util.QueryUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.qameta.allure.Step;

public class Common {


/**
 * Match the String with Equals
 * @param validationOnPage
 * @param actualText
 * @param expectedText
 * @return True/False
 */
	public static boolean verifyElementTextOnPage(String validationOnPage, String actualText, String expectedText) {

		return actualText.equals(expectedText);

	}
/**
 * Match the String with contains
 * @param validationOnPage
 * @param actual
 * @param expected
 * @return True/False
 */
	public static boolean verifyContentOnPage(String validationOnPage, String actual, String expected) {

		return actual.contains(expected);

	}
	
	/**
	 * Check Visibility of Element
	 * @param driver
	 * @param locator
	 * @return True/False
	 */
	public static boolean isWebElementDisplayed(WebDriver driver,By locator) {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(locator));
			WebElement elm = driver.findElement(locator);
			return elm.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}
	
	public static boolean clickonWebElement(WebDriver driver,By locator) {
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(locator));
			WebElement elm = driver.findElement(locator);
			if(elm.isDisplayed()==true)
				elm.click();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		

	}
	
	
	/**
	 * Select Value from Drop down
	 * @param element
	 * @param value
	 * @return 
	 */
		public static boolean selectValueInDropdown(WebElement element, String value) {
			try {
				Select select = new Select(element);
				select.selectByVisibleText(value);
				System.out.println(select.getFirstSelectedOption().getText());
				return true;
			} catch (Exception e) {
				e.getStackTrace();
			}
			return false;
		}
		
	/**
	 * Get the Selected Option from Dropdown
	 * @param element
	 * @return String
	 */
			public static String getSelectedValuefromDropDown(WebElement element) {
				try {
					Select select = new Select(element);
					System.out.println(select.getFirstSelectedOption().getText());
					return select.getFirstSelectedOption().getText();
				} catch (Exception e) {
					e.getStackTrace();
				}
				return null;
			}
			
		
		public static boolean SelectValueDropDownByIndex(WebElement element,int index) 
		{
			try {
				Select select = new Select(element);
				select.selectByIndex(index);
				 return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
	
	public static boolean clearTxtFieldsendKeys(WebDriver driver,By locator,String keys) 
	{
		try {
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(keys);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	
	
}

	public static String getElementText(WebElement ele) {
		try {
			return ele.getText();	
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
		
	public static String getElementTextByAttribute(WebElement ele, String attribute) {
		try {
			return ele.getAttribute(attribute);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Step("Exception Occured in Test: Message: {message}  ")
	public static void reportFailAssert(String message, Exception realCause){
		try {
		Assert.fail(message, realCause);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean validateDateFormat(String date){

		// Store date format in String buffer
		StringBuffer sBuffer = new StringBuffer(date);
		String mon;
		String dd;
		String year;

		// Store the Date in String Buffer and Break down the date
		// 0,2 - Month
		// 3,5 - Date
		// 6,10 - Year
		mon = sBuffer.substring(0,2);
		dd = sBuffer.substring(3,5);
		year = sBuffer.substring(6,10);

		if(mon.matches("0[1-9]|1[0-2]") && dd.matches("0[1-9]|[12][0-9]|3[01]") && year.matches("(19|20)\\d\\d"))
		{
		System.out.println("Date Format matched.");
		return true;
		}
		else
		{
		System.out.println("Date Format didn't matched.");
		return false;
		}
		}

	/*
	 * This method converts the list of Webelements into List of String
	 * It uses the getText() to get the text from weblement if exists
	 */
	public static List<String> getListOfTextFromListOfWebelements(List<WebElement> elementsList, WebDriver driver) 
	{

		List<String> dropdownValue = new ArrayList<String>();
		for(WebElement item:elementsList) 
		{ 
			if(item.getText().isEmpty()==false)
				dropdownValue.add(item.getText());
		}
		return dropdownValue;
	}

	public static List<Map<String, Object>> resultForDBquery(String query, Connection connection)
	{List<Map<String, Object>> dbResultList = new ArrayList<Map<String, Object>>();

		try
		{
			Assert.assertNotNull(connection, "connection is not establish.");
			QueryUtil util = new QueryUtil();
			ResultSet result = util.executeQuery(connection, query);
			dbResultList = util.convertMulitpleDBResultToHashMap(result);
			return dbResultList;

		}
		catch (Exception e)
		{
			e.printStackTrace();
			WCMSICommon.reportFailAssert("Failed to get data from database by query", e);
		}

		return dbResultList ;
	}
	public static boolean isElementDisplayed(WebDriver driver, By locator) {
		try {
			ReusableMethods.scrollToElement(driver,locator);
			ScreenshotUtil.takeScreenshotForAllure(driver);
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locator));
			WebElement elm = driver.findElement(locator);
			return elm.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}
}