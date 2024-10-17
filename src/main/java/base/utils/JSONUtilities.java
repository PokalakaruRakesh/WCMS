package base.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class JSONUtilities {

	public static String jsonPayloadPath = "C:\\Users\\Swapnil\\codebase\\Latest\\tx_automate_TestNG_baseline\\src\\main\\resources\\ConfigFiles\\DUMMYFILENAME.json";
	//public static String body = null;

	public static JsonPath getJsonPath(Response response) {
		String path = response.asString();
		return new JsonPath(path);
	}

	public static Object getValueFromJson(Response res, String path) throws Exception {
		String json = res.asString();
		System.out.println("Response as String: "+json);
		return new JsonPath(json).getString(path);

	}

	public static String getValueFromJsonArray(JsonPath jsonRes, String key) {
	
		
		List<Object> getJsonEntries = jsonRes.getList(key);
		int entriesInJsonArray = getJsonEntries.size();
		System.out.println("No.of entries in Json: "+ entriesInJsonArray);


		return  String.valueOf(entriesInJsonArray);

	}

	public static String generateStringFromResource(String path) throws IOException {

		return new String(Files.readAllBytes(Paths.get(path)));

	}

	@SuppressWarnings("unchecked")
	public static List<Object> JSONArrayReader(String jsonncontentInString, String pathInJson, String jsonFile) throws IOException {
		
		List<Object> jsonEntries = null;
		try {
			//Reader reader = new FileReader(jsonFile);
			//Object jsonObject = parser.parse(reader);
			JsonPath jsonPathObject = new JsonPath(jsonncontentInString); 
			System.out.println("Printing json Object: "+jsonPathObject);
			
			jsonEntries = jsonPathObject.getList(pathInJson);
			int jsonEntryCount = jsonEntries.size();
			System.out.println("JSONArrayReader Function - No.of Entries in JsonPath: "+ jsonEntryCount);

		}
		catch (Exception e) {
			System.out.println("Exception Block");
			e.printStackTrace();
		}
		return jsonEntries;
	}
	
	@SuppressWarnings("unchecked")
	public static JsonPath JSONArrayReaderJsonPath(String jsonncontentInString, String pathInJson, String jsonFile) throws IOException {
		
		List<Object> jsonEntries = null;
		JsonPath jsonPathObject = null;
		try {
			//Reader reader = new FileReader(jsonFile);
			//Object jsonObject = parser.parse(reader);
			jsonPathObject = new JsonPath(jsonncontentInString); 
			System.out.println("Printing json Object: "+jsonPathObject);
			
			jsonEntries = jsonPathObject.getList(pathInJson);
			int jsonEntryCount = jsonEntries.size();
			System.out.println("JSONArrayReader Function - No.of Entries in JsonPath: "+ jsonEntryCount);

		}
		catch (Exception e) {
			System.out.println("Exception Block");
			e.printStackTrace();
		}
		return jsonPathObject;
	}
	
	
	
	public static String getValueFromJsonPath(JsonPath jsonPathObject, String pathString ) {
   	 
   	 return jsonPathObject.getString(pathString).toString();
   	 
    }
	
//	private static boolean isJsonValid(String inputJosn) throws JsonParseException, IOException  {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.enable(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY);
//        JsonFactory factory = mapper.getFactory();
//        JsonParser parser = factory.createParser(inputJosn);
//        JsonNode jsonObj = mapper.readTree(parser);
//        System.out.println(jsonObj.toString());
//
//
//        return true;
//    }

	//	public static JSONArray getJsonArrayResponse(String path) throws MalformedURLException, IOException, APIException {
	//
	//		JSONArray runDetailsinPlan= (JSONArray) client.sendGet("get_tests/"+runID); 
	//		return runDetailsinPlan;
	//
	//	}

}
