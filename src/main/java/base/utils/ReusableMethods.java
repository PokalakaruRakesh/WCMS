package base.utils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.qameta.allure.Step;

public class ReusableMethods {
	
static ExcelDataConfig edc;
static Object[][] obj;

	public static Object[][] getMapData(String filepath, String sheetName) {
		int mapKeyRow = 0;
		int mapValueRow = 0;
		edc = new ExcelDataConfig(filepath);
		int sheetNO = edc.getSheetIndex(sheetName);
		int rowcount = edc.getRowCount(sheetName);
		Object[][] obj = new Object[rowcount - 1][1];

		for (int i = 1; i < rowcount; i++) {
			Map<String, String> datamap = new HashMap<String, String>();
			int cellCount = edc.getCellCount(sheetNO, i);
			for (int j = 0; j < cellCount; j++) {
				datamap.put(edc.readExcelData(sheetNO, mapKeyRow, j), edc.readExcelData(sheetNO, mapValueRow + i, j));
			}
			obj[i - 1][0] = datamap;
		}
		return obj;
	}

	public static Object[][] getMapData(String filepath, String sheetName,String TestId) {
		int mapKeyRow = 0;
		int mapValueRow = 0;
		edc = new ExcelDataConfig(filepath);
		int sheetNO = edc.getSheetIndex(sheetName);
		int rowcount = edc.getRowCount(sheetName);
		Object[][] obj = new Object[1][1];

		for (int i = 1; i < rowcount; i++) {
			Map<String, String> datamap = new HashMap<String, String>();
			int cellCount = edc.getCellCount(sheetNO, i);
			if(edc.readExcelData(sheetNO, i, 0).equalsIgnoreCase(TestId)) {
				for (int j = 0; j < cellCount; j++) {
					datamap.put(edc.readExcelData(sheetNO, mapKeyRow, j), edc.readExcelData(sheetNO, mapValueRow + i, j));
				}
				obj[0][0] = datamap;
			}


		}
		return obj;
	}
	
	public static void scrollIntoView(WebElement element, WebDriver driver)
	{
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", element);
		
	}
	public static boolean scrollToElement(WebDriver driver, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(false);", element);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * 
	 * This method returns the list of the options value in the Dropdown
	 * 
	 */
	public static List<String> getListOfOptionsValueInDropdown(WebElement element, WebDriver driver) 
	{
		Select select = new Select(element);
		List<WebElement> dropdownOptions = select.getOptions();
		
		List<String> dropdownValue = new ArrayList<String>();
         for(WebElement item:dropdownOptions) 
         { 
           dropdownValue.add(item.getText());
            }
		return dropdownValue;
	}
	
	@Step("Hover and  Click Mouse over: {hoverElementName}")
	public static void mouseHoverAndClick(WebDriver driver, WebElement hoverOverElement, String hoverElementName) throws Exception {
		Actions action =    new Actions(driver);
        action.moveToElement(hoverOverElement).perform();
        WaitStatementUtils.explicitWaitForVisibility(driver, hoverOverElement);
        action.click(hoverOverElement).perform();
	}
	
	@Step("Hovering Mouse over: {hoverElementName}")
	public static void mouseHover(WebDriver driver, WebElement hoverOverElement, String hoverElementName) throws Exception {
		Actions action =    new Actions(driver);
        action.moveToElement(hoverOverElement).perform();
  	}
	
	/* 
	 * This method first hovers over element1 then on element2
	 */
	public static void mouseHover(WebDriver driver, WebElement hoverOverElement1, WebElement hoverOverElement2) throws Exception {
		Actions action =    new Actions(driver);
        action.moveToElement(hoverOverElement1).moveToElement(hoverOverElement2).build().perform();
  	}
	
	public static boolean mouseHoverAndClickWithAction(WebDriver driver, WebElement hoverOverElement, String hoverElementName) {
		try {
			Actions action =    new Actions(driver);
			action.moveToElement(hoverOverElement).perform();
			WaitStatementUtils.explicitWaitForVisibility(driver, hoverOverElement);
			action.click(hoverOverElement).perform();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	public static boolean mouseHoverWithAction(WebDriver driver, WebElement hoverOverElement, String hoverElementName) throws Exception {
		try {
			Actions action =    new Actions(driver);
			action.moveToElement(hoverOverElement).perform();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
  	}	

	
	public static boolean moveToElementAndClick(WebDriver driver, WebElement element) {
		try {
			Actions action =    new Actions(driver);
			WaitStatementUtils.waitForElementToBeClickable(driver, element);
			action.moveToElement(element).click().build().perform();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	/*
	 * MEthod to switch to window using index
	 * 
	 */
	public static void switchToWindowIndex(WebDriver driver,int index) {
	    Set<String> windowHandles = driver.getWindowHandles();
	    List<String> windowStrings = new ArrayList<>(windowHandles);
	    String reqWindow = windowStrings.get(index);
	    driver.switchTo().window(reqWindow);
	}
	
	public static boolean validateJavaDate(String strDate) {
		/* Check if date is 'null' */
		if (strDate.trim().equals("")) {
			return true;
		}
		/* Date is not 'null' */
		else {
			/*
			 * Set preferred date format, For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.
			 */
			SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-mm-dd");
			sdfrmt.setLenient(false);
			/*
			 * Create Date object parse the string into date
			 */
			try {
				Date javaDate = sdfrmt.parse(strDate);
				System.out.println(strDate + " is valid date format");
			}
			/* Date format is invalid */
			catch (ParseException e) {
				System.out.println(strDate + " is Invalid Date format");
				return false;
			}
			/* Return true if date format is valid */
			return true;
		}
	}
	public static void pageUPOrpageDown(WebDriver driver, String option) {

		Actions a = new Actions(driver);
		if(option.equalsIgnoreCase("down")){
			//scroll down a page
			a.sendKeys(Keys.PAGE_DOWN).build().perform(); }
		else if(option.equalsIgnoreCase("up")){
			// scroll up a page
			a.sendKeys(Keys.PAGE_UP).build().perform();}
		else{
			System.out.println("option is not enter");
		}

	}
	public static void scrollToTheTop(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,-250)", "Top");

	}
	public static boolean scrollToElement(WebDriver driver, By locator) {
		try {
			WebElement elm = driver.findElement(locator);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(false);", elm);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public static void deleteFolder(String filePath){
		File folder = new File(filePath);
		if (folder.exists()) {
			File[] files = folder.listFiles();
			if (files != null) {
				for (File file : files) {
					if (file.isDirectory()) {
						deleteFolder(filePath);
					} else {
						file.delete();
					}
				}
			}
			folder.delete();
		}
	}
	public static void deleteFilesInsideFolder(String filePath) {
		File folder = new File(filePath);
		if (folder.exists() && folder.isDirectory()) {
			File[] files = folder.listFiles();
			if (files != null) {
				for (File file : files) {
					if (file.isDirectory()) {
						deleteFilesInsideFolder(file.getAbsolutePath());
					} else {
						file.delete();
					}
				}
			}
		}
	}
	public static String pickLatestFileFromDownloads(String downloadFolder) {
		//String currentUsersHomeDir = System.getProperty("user.home");
		//String downloadFolder = currentUsersHomeDir + File.separator + "Downloads" + File.separator;
		File dir = new File(downloadFolder);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			System.out.println("There is no file in the folder");
		}
		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		String k = lastModifiedFile.toString();
		System.out.println(lastModifiedFile);
		Path p = Paths.get(k);
		String file = p.getFileName().toString();
		return file;
	}
	public static List<File> getAllFilesFromDownloads(String downloadFolder) {
		File dir = new File(downloadFolder);
		File[] files = dir.listFiles();
		List<File> fileList = new ArrayList<>();

		if (files == null || files.length == 0) {
			System.out.println("There are no files in the folder");
		} else {
			for (File file : files) {
				if (file.isFile()) {
					fileList.add(file);
				}
			}
		}

		return fileList;
	}
	public static boolean checkIfFileExists(String downloadFolder, String fileName) {
		File dir = new File(downloadFolder);
		File[] files = dir.listFiles();

		if (files != null) {
			for (File file : files) {
				if (file.isFile() && file.getName().contains(fileName)) {
					return true; // File exists
				}
			}
		}
		return false; // File doesn't exist
	}
}
