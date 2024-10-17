package base.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


public class JsonFileReader {

	protected ObjectMapper objectMapper = null;

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

}
