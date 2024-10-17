package base.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import TestListeners.ExtentTestManager;
//import base.utils.ConfigReader;

//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {

	private static XSSFWorkbook workbook;
	private static Workbook wb = null;
	private static XSSFSheet sheet;
	private static Sheet st=null;
	private static XSSFRow row;
	private static XSSFCell cell;
	private FileOutputStream fileOut;
	private FileInputStream fis;
	public String excelPath;

	private static FileInputStream fs = null;

	private static int columnToLookTestCaseID = Integer.parseInt(ConfigReader.getValue("columnToLookTestCaseID"));
	private static String testDatafilePath = ConfigReader.getValue("APIDataExcelPath");

	private static String excelextensionxlsx = ".xlsx";
	private static String excelextensionxls = ".xls";

	static ExcelDataConfig edc;
	static HashMap<String, String> obj;

	public static HashMap<String, String> getMapData(String filepath, String sheetName) {
		int mapKeyRow = 0;
		int mapValueRow = 0;
		edc = new ExcelDataConfig(filepath);
		int sheetNO = edc.getSheetIndex(sheetName);
		int rowcount = edc.getRowCount(sheetName);
		//Object[][] obj = new Object[rowcount - 1][1];
		HashMap<String, String> datamap = new HashMap<String, String>();

		for (int i = 1; i < rowcount; i++) {
			int cellCount = edc.getCellCount(sheetNO, i);
			for (int j = 0; j < cellCount; j++) {
				datamap.put(edc.readExcelData(sheetNO, mapKeyRow, j), edc.readExcelData(sheetNO, mapValueRow + i, j));
			}

		}
		return datamap;
	}


	/**
	 * 
	 * @param excelpath
	 * 
	 * This is Constructor
	 */

	public 	ExcelDataConfig(String excelpath) {
		this.excelPath = excelpath;
		try {
			File src = new File(excelpath);
			fis = new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);

			fis.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}			

	/**
	 * 
	 * @param sheetNo
	 * @param rowNo
	 * @param columnNO
	 * @return columnData
	 * 
	 * This method is used to Extract data from Column
	 * 
	 */
	public String readExcelData(int sheetNo, int rowNo, int columnNO) {

		sheet = workbook.getSheetAt(sheetNo);
		DataFormatter formatter = new DataFormatter();
		String data = formatter.formatCellValue(sheet.getRow(rowNo).getCell(columnNO));
		//String data = sheet1.getRow(rowNo).getCell(columnNO).getStringCellValue();
		return data;
	}

	public int getColumnCount(String sheetName)
	{
		// check if sheet exists
		if (!isSheetExist(sheetName))
			return -1;
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);

		if (row == null)
			return -1;

		return row.getLastCellNum();

	}
	
	
	/**
	 * 
	 * @param sheetIndex
	 * @param rowNO
	 * @return cellCount
	 * 
	 * This method use to Get Column count of Row 
	 * 
	 */
	public int getCellCount(int sheetIndex, int rowNO) {
		int cell = workbook.getSheetAt(sheetIndex).getRow(rowNO).getLastCellNum();
		return cell;
	}


	/**
	 * This method is use to Get Row Count of Sheet
	 * 
	 * @param sheetName
	 * @return rowCount
	 * 
	 * 
	 * 
	 */
	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			System.out.println("SheetName not Found");
			return 0;
		} else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}

	}

	/**
	 * 
	 * @param sheetName
	 * @return sheetIndex
	 * 
	 * This method is used to get sheetIndex
	 * 
	 */

	public int getSheetIndex(String sheetName) 
	{
		int index=0;
		index = workbook.getSheetIndex(sheetName);
		if (index == -1)
		{
			System.out.println("SheetName not Found");
			return 0;
		} 
		else 
		{
			return index;
		}
	} 



	/**
	 * 
	 * @param sheetname
	 * @return boolean
	 * 
	 * This method is used to Add sheet
	 */
	public boolean addSheet(String sheetname) {

		try {
			workbook.createSheet(sheetname);
			fileOut = new FileOutputStream(excelPath);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param sheetName
	 * @return boolean
	 * 
	 * This method is used to remove the Sheet
	 */

	public boolean removeSheet(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return false;
		try {
			workbook.removeSheetAt(index);
			fileOut = new FileOutputStream(excelPath);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();

			return false;

		}
		return true;
	}


	/**
	 * 
	 * @param sheetName
	 * @return boolean  
	 *
	 *This method is use to Check if Sheet exist or not
	 *
	 */


	public boolean isSheetExist(String sheetName)
	{
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1)
		{
			index=workbook.getSheetIndex(sheetName.toUpperCase());
			if(index==-1)
				return false;
			else
				return true;
		}
		else
			return true;
	}
	/**
	 * This Method is used to Insert new Column
	 * @param sheetName
	 * @param colName
	 * @return
	 *  true/false added or not
	 */

	public boolean addColumn(String sheetName, String colName) {

		try
		{
			fis = new FileInputStream(excelPath);
			workbook = new XSSFWorkbook(fis);
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1)
			{
				return false;
			}
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			if (row == null) 
			{
				row = sheet.createRow(0);
			}
			if (row.getLastCellNum() == -1) 
			{
				cell = row.createCell(0);
			}
			else 
			{
				cell = row.createCell(row.getLastCellNum());
			}
			cell.setCellValue(colName);
			fileOut = new FileOutputStream(excelPath);
			workbook.write(fileOut);
			fileOut.close();

		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}

		return true;

	}

	// returns true if data is set successfully else false
	/**
	 * This Method is used to Write in Cell
	 * @param sheetName
	 * @param colName
	 * @param rowNum
	 * @param data
	 * @return
	 * 
	 * true/false written or not
	 */
	public boolean setCellData(String sheetName, String colName, int rowNum, String data) {
		try 
		{
			fis = new FileInputStream(excelPath);
			workbook = new XSSFWorkbook(fis);
			if (rowNum <= 0) 
			{
				return false;
			}
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1) 
			{
				return false;
			}

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			int colNum = -1;
			for (int i = 0; i < row.getLastCellNum(); i++)
			{
				if (row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum = i;
			}
			if (colNum == -1) 
			{
				return false;
			}
			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);
			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);
			cell.setCellValue(data);
			fileOut = new FileOutputStream(excelPath);
			workbook.write(fileOut);
			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	// Common Excel Utilities - Keyword Driven

	public static HashMap<String, String> getTestDataWithTestCaseID(String sheetName,String testCaseID) {
		boolean found = false;
		boolean isfirstRow = false;
		Row firstrow = null;
		// Initialize class
		// Get Path and Sheet Name from Property File
		final HashMap<String, String> currentRowData = new HashMap<String, String>();
		init(testDatafilePath, sheetName);
		Iterator<Row> rowIterator = st.iterator();
		try {
			//int iCellCounter = 0;
			while (rowIterator.hasNext()) {
				Row row =  rowIterator.next();
				if(!isfirstRow){
					firstrow = row;
					isfirstRow = true;
				}
				if (row.getCell(columnToLookTestCaseID).getStringCellValue().equalsIgnoreCase(testCaseID)) {
					found = true;
					for (int i = 0; i < row.getLastCellNum(); i++) {
						String cellValue = row.getCell(i).getStringCellValue();
						if(cellValue == null){
							cellValue = "";
						}
						cellValue = getUniqueString(cellValue);
						currentRowData.put(firstrow.getCell(i).getStringCellValue(), cellValue);
					}
					break;
				} 

			} 

			fs.close();

		} catch (Exception e) {
			//LogUtil.errorLog(ExcelDataUtil.class, "caught exception", e);
			e.printStackTrace();
			System.out.println("Caught Exception in Excel Util");
		}
		if (!found)
			//LogUtil.infoLog(ExcelDataUtil.class, "No data found with given key-> " + testCaseID);

			System.out.println("No Data Found with Given KEY.");

		return currentRowData;

	}

	public static String getUniqueString(String string){
		return string.replaceAll("UNIQUE",""+System.currentTimeMillis());
	}

	public static Sheet init(String filePath, String sheetName) {
		String fileExtensionName = filePath.substring(filePath.indexOf('.'));
		try {
			fs = new FileInputStream(filePath);
			if (fileExtensionName.equals(excelextensionxlsx)) {
				// If it is xlsx file then create object of XSSFWorkbook class
				wb = new XSSFWorkbook(fs);
			}
			// Check condition if the file is xls file
			else if (fileExtensionName.equals(excelextensionxls)) {
				// If it is xls file then create object of XSSFWorkbook class
				wb = new HSSFWorkbook(fs);
			}
			st = wb.getSheet(sheetName);
			
		} catch (Exception e) {
			//LogUtil.errorLog(ExcelDataUtil.class, EXCEPTIONCAUGHT, e);
			System.out.println("Exception in initBlock");
		}
		return st;

	}

	public static List<String> getDataList(String filepath, String sheetName) {
		int mapKeyRow = 0;
		int mapValueRow = 0;
		edc = new ExcelDataConfig(filepath);
		int sheetNO = edc.getSheetIndex(sheetName);
		int rowcount = edc.getRowCount(sheetName);
		//Object[][] obj = new Object[rowcount - 1][1];
		List<String> dataList = new ArrayList<>();

		for (int i = 1; i < rowcount; i++) {
			int cellCount = edc.getCellCount(sheetNO, i);
			for (int j = 0; j < cellCount; j++) {
				dataList.add(edc.readExcelData(sheetNO, mapValueRow + i, j));
			}

		}
		return dataList;
	}








}
