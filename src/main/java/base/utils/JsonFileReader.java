package base.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


public class JsonFileReader {

	protected ObjectMapper objectMapper = null;
	private String JiraID;
	/**
	 * This method reads json file under resources folder and return input stream
	 * 
	 * @param fileName
	 * @return fis
	 */
	public FileInputStream readJson(String fileName) {
		try {
			String path = getClass().getClassLoader().getResource("jsons/" + fileName).getFile();
			String decodedPath = URLDecoder.decode(path, "UTF-8");
			FileInputStream fis = new FileInputStream(decodedPath);
			return fis;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			
			
			
			
		}
		return null;
	}

	/**
	 * This method reads json under resources folder and maps JSON objects to POJO
	 * 
	 * @param fileName
	 * @param clazz
	 * @return t
	 */
	public <T> T readJsonAndGetObject(String fileName, Class<T> clazz) {
		try {
			T t = null;
			String path = getClass().getClassLoader().getResource("jsons/" + fileName).getFile();
			String decodedPath = URLDecoder.decode(path, "UTF-8");
			FileInputStream fis = new FileInputStream(decodedPath);
			objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			objectMapper.setSerializationInclusion(Include.NON_NULL);
			t = objectMapper.readValue(fis, clazz);
			fis.close();
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * This method reads json under resources folder and maps JSON objects to POJO
	 * 
	 * @param fileName
	 * @param clazz
	 * @return t
	 */
	public <T> T readJsonAndSetObject(String fileName, Class<T> clazz) {
		try {
			T t = null;
			String path = getClass().getClassLoader().getResource("jsons/" + fileName).getFile();
			String decodedPath = URLDecoder.decode(path, "UTF-8");
			FileInputStream fis = new FileInputStream(decodedPath);
			objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			objectMapper.setSerializationInclusion(Include.NON_NULL);
			t = objectMapper.readValue(fis, clazz);
			fis.close();
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public JsonObject readJsonData() throws FileNotFoundException {

		String filePath = getClass().getClassLoader().getResource("jsons/" + JiraID + ".json").getFile().replaceFirst("\\/", "");
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObject = (JsonObject) jsonParser.parse(new FileReader(filePath));

		return jsonObject.getAsJsonObject(JiraID);
	}
	public JsonObject readJsonData(String JsonfileName, String JsonPrimeElement) throws FileNotFoundException {

		String filePath = getClass().getClassLoader().getResource("jsons/" + JsonfileName + ".json").getFile().replaceFirst("\\/", "");
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObject = (JsonObject) jsonParser.parse(new FileReader(filePath));

		return jsonObject.getAsJsonObject(JsonPrimeElement);
	}
	public void setJiraID(String JiraID) {
		this.JiraID = JiraID;
	}
	public String getJsonString(String JsonElement) throws FileNotFoundException { return readJsonData().get(JsonElement).getAsString();}
	public String getJsonString(String JsonfileName, String JsonPrimeElement, String JsonElement) throws FileNotFoundException { return readJsonData(JsonfileName, JsonPrimeElement).get(JsonElement).getAsString();}
}
