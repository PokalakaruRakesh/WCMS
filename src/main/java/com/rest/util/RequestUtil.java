package com.rest.util;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import base.utils.ConfigReader;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestUtil {
	
	//Global Setup Variables
	public static String ENDPOINT;
	public static String PATH;
    public static RequestSpecBuilder REQUEST_BUILDER;
    public static RequestSpecification REQUEST_SPECIFICATION;
    public static PreemptiveBasicAuthScheme basicAuth;
    public static String path;
    public static String jsonPathTerm;
    public static ContentType contType;
    RestAssured restAssured;
    RequestSpecification requestSpecification;
    String resourceBaseURI;
    String resourceEndpoint;
    String endPoint;
    HashMap<String, String> dataMap = null;
    private String testCase_id;
    private String environment;

    //Sets Base URI
    public static void setBaseURI(String baseUri){
        PATH = baseUri;
    }
    
   //Gets Base URI
    public static String getBaseURI(){
        return PATH;
    }
    
   //Reset Base URI (after test)
    public static void resetBaseURI (){
        RestAssured.baseURI = null;
    }

    public static void setEndPoint(String endPoint) {
        ENDPOINT = endPoint;
    }
    
    public static String getEndPoint() {
        return ENDPOINT;
    }
    
  //Reset Base URI (after test)
    public static void resetEndpoint(){
        ENDPOINT = null;
    }

    public RequestUtil(HashMap<String, String> map, String tc_id, String env) {
        restAssured = new RestAssured();
        requestSpecification = RestAssured.given();
        dataMap = map;
        testCase_id = tc_id;
        environment = env;
    }
    //Sets base path
    //public static void setBasePath(String basePathTerm){
    //RestAssured.basePath = basePathTerm;
    //}
       
    //Reset base path
    //public static void resetBasePath(){
    //    RestAssured.basePath = null;
    //}

    
    //Sets ContentType
//    public static void setContentType(ContentType type){
//    	RequestSpecification contType = given().contentType(type);
//    }

   //Gets ContentType
//    public static RequestSpecification getContentType(){
//        return contType;
//    }
   @Step("Setting endpoint")
   public void setEndpointValue() {
       this.endPoint = getApiBaseUrl(environment, dataMap.get("Module")) + dataMap.get("Endpoint");
       restAssured.baseURI = getApiBaseUrl(environment, dataMap.get("Module")) + dataMap.get("Endpoint");

   }
    @Step("Generating and setting the Token")
    public void generateToken() {
        try {
            String username = ConfigReader.getValue(environment + "_" + dataMap.get("API_TYPE") + "_Username");
            System.out.println(username);
            String password = ConfigReader.getValue(environment + "_" + dataMap.get("API_TYPE") + "_Password");
            String input = null;
            input = readFile("\\src\\test\\resources\\token\\token_payload.txt");
            Response response = RestAssured.given().auth().preemptive().basic(username, password).body(input)
                    .contentType("application/x-www-form-urlencoded").when()
                    .post(ConfigReader.getValue(environment + "_" + dataMap.get("API_TYPE") + "_Token_URL")).then()
                    .extract().response();
            String token = response.jsonPath().getString("access_token");
            setBearerAuthentication(token);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Step("Passing Parameter {0} with value {1}")
    public void settingParameter(String parameter, String value) {
        requestSpecification.queryParam(parameter, value);
    }
    //Sets basic auth
	public static void setBasicAuth(String username,String password) {
	
		PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName(username);
        auth.setPassword(password);
        basicAuth = auth;
	}
	
	//Gets basic auth
	public static PreemptiveBasicAuthScheme getBasicAuth() {
		return basicAuth;
	}
    @Step("Using Bearer token")
    public void setBearerAuthentication(String token) {
        requestSpecification.header("Authorization", "Bearer " + token);
//                .header("Content-Type","application/json");
    }
	
	// Sets headers
	public static void setHeader(RequestSpecification reqSpc, HashMap<String, String> head) {
		
		reqSpc.headers(head);
		//RequestSpecification requestSpec = given().header(key, value);
	}
	
	//Gets headers
    public static RequestSpecification getHeader(RequestSpecification reqSpc, HashMap<String, String> head) {
		
		return reqSpc.headers(head);
		//RequestSpecification requestSpec = given().header(key, value);
	}
	
	
	public static RequestSpecification createQueryParam (RequestSpecification resSpc, String param, String value) {
		return resSpc.queryParam(param, value);
	}

//	public static RequestSpecification createQueryParam (RequestSpecification resSpc, Map<String, String> queryMap) {
//		return resSpc.queryParams(queryMap);
//	}

	public static RequestSpecification createPathParam (RequestSpecification resSpc, String param, String value) {
		return resSpc.pathParam(param, value);
	}

//	public static RequestSpecification createPathParam (RequestSpecification resSpc, Map<String, String> queryMap) {
//		return resSpc.pathParams(queryMap);
//	}

	
	public static void buildRequestSpecification() {
    	
//      AuthenticationScheme authScheme = RestAssured.basic("user1", "user");
  	
      REQUEST_BUILDER = new RequestSpecBuilder();
      REQUEST_BUILDER.setBaseUri(ENDPOINT);
      REQUEST_BUILDER.setAuth(basicAuth);
      REQUEST_BUILDER.addHeader("Accept", "*/*");
//      REQUEST_BUILDER.setContentType(ContentType.JSON);
      REQUEST_SPECIFICATION = REQUEST_BUILDER.build();
    }

    public static RequestSpecification getRequestSpecification() {
    	
    	return given().spec(REQUEST_SPECIFICATION);
    }

    @Step("Executed GET ")
    public Response executeGETAPIRequest() {
        Response response = requestSpecification.get(endPoint);
//        Allure.addAttachment("Response", response.asInputStream());
        return response;
    }
    public String getApiBaseUrl(String env, String type) {
        try {
            return ConfigReader.getValue(env + "_" + type + "_API");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private static String readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }
}