package com.rest.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import base.utils.ConfigReader;

public class RestUtils {

	//	private static FileInputStream fs = null;
	//	private static Workbook workbook = null;
	//	private static Sheet sheet=null;
	//
	//	private static int columnToLookTestCaseID = Integer.parseInt(ConfigReader.getValue("columnToLookTestCaseID"));
	//	private static String testDatafilePath = ConfigReader.getValue("APIDataExcelPath");
	//	
	//	private static String excelextensionxlsx = ".xlsx";
	//	private static String excelextensionxls = ".xls";



	public static String setAPITestEnvironment(HashMap<String, String> dataMap) {

		String testEnvironment = ConfigReader.getValue("Environment");
		if(testEnvironment.contains("DEV")) {
//			ExtentTestManager.stepInfo("Setting up base URI to Dev Environment for API Test: "+dataMap.get("DevURI"));
			return dataMap.get("DevURI");

		}
		else if(testEnvironment.contains("TEST")) {
//			ExtentTestManager.stepInfo("Setting up base URI to Test Environment for API Test: "+dataMap.get("TestURI"));
			return dataMap.get("TestURI");

		}
		else if(testEnvironment.contains("STAG")) {
//			ExtentTestManager.stepInfo("Setting up base URI to Dev Environment for API Test: "+dataMap.get("TestURI"));
			return dataMap.get("TestURI");

		}
		else {
//			ExtentTestManager.stepInfo("Incorrect Environment Details Provided. Setting up base URI to Default(TEST) Environment for API Test: "+dataMap.get("TestURI"));
			return dataMap.get("TestURI");
		}

	}

	public static void setAuthType(HashMap<String, String> dataMap) {

		System.out.println("Authorization: "+dataMap.get("AuthorizationType"));
		if(dataMap.get("AuthorizationType").equalsIgnoreCase("BasicAuth")) {
			String userName = dataMap.get("UserName");
			String password = dataMap.get("Password");
//			ExtentTestManager.stepInfo("Setting up Basic Authentication for API Test.");
			RequestUtil.setBasicAuth(userName, password);   
		}

		//Add Code after oauth Handling

	}

	public static void fetchHeaders(HashMap<String, String> dataMap) {
		try {
			String headerKeys=dataMap.get("HeaderKeys");
			String headerValues=dataMap.get("HeaderValues");

			System.out.println("headerKeys:"+headerKeys);
			System.out.println("headerValues:"+headerValues);

			List<String> keyList = Arrays.asList(headerKeys.split(","));
			List<String> valueList = Arrays.asList(headerValues.split(","));

			HashMap<String, String> headerMap = new HashMap<>(); 

			//Create Map Object for header-value key pairing 
			for(int i=0;i<keyList.size();i++) {
				headerMap.put(keyList.get(i),valueList.get(i));
			}

			System.out.println("headerMap Size: "+headerMap.size()+", headerMap  : " + headerMap); 

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
