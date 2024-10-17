package com.rest.util;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ResponseUtil {

	public static String ENDPOINT;
	public ResponseUtil() {}
	public static ResponseSpecBuilder RESPONSE_BUILDER;
    public static ResponseSpecification RESPONSE_SPECIFICATION;
    
	/**
	* Validates the HTTP response code returned by Rest Assured matches a specified HTTP Status Code
	*
	* @param
	* expectedCode the expected HTTP status code
	* @param
	* response RestAssured Response class
	*/
  
    public static void assertHTTPStatusCode(final Response response, final Integer expectedCode)
	{
	
	assertThat(String.format("HTTP Status code was not %s as expected.", expectedCode.toString()),
	response.getStatusCode(), is(expectedCode));
	}

	/**
	* Returns the String value of the requested JSON field name from a RestAssured Response object.
	*
	* @param
	* response RestAssured Response class
	* @param
	* fieldName Requested JSON field name
	*
	* @return
	* String value of field requested
	*/
	
	public static String getStatus(JsonPath jp) {

		String status = jp.get("status");
		return status;
		
	}	
	
	public static String extractJSONResponseFieldString(final Response response, final String fieldName)
	{

	return response.path(fieldName);
	}

	/**
	* Returns the Boolean value of the requested JSON field name from a RestAssured Response object.
	*
	* @param
	* response RestAssured Response class
	* @param
	* fieldName Requested JSON field name
	*
	* @return
	* Boolean value of field requested
	*/
	public static Boolean extractJSONResponseFieldBoolean(final Response response, final String fieldName)
	{

	return response.path(fieldName);
	}

	/**
	* Returns the int value of the requested JSON field name from a RestAssured Response object.
	*
	* @param
	* response RestAssured Response class
	* @param
	* fieldName Requested JSON field name
	*
	* @return
	* int value of field requested
	*/
	public static int extractJSONResponseFieldInt(final Response response, final String fieldName)
	{

	return response.path(fieldName);
	}
	
	
	//Returns JsonPath object
    public static JsonPath getJsonPath (Response res) {
        String json = res.asString();
        //System.out.print("returned json: " + json +"\n");
        return new JsonPath(json);
    }
	
	
//    public static void setBody(String inputFile) throws Exception {
//		
//		FileInputStream fileInputStream = new FileInputStream(new File(inputFile));
//		RequestSpecification requestSpecification;
//		requestSpecification.body(IOUtils.toString(fileInputStream, "UTF-8"));
//	}
//    
//    public static String getBody(String inputFile) throws Exception {
//		
//		FileInputStream fileInputStream = new FileInputStream(new File(inputFile));
//		RequestSpecification requestSpecification;
//		return requestSpecification.body(IOUtils.toString(fileInputStream, "UTF-8"));
//	}
	
	
	public static void setResponseSpecification() {
        RESPONSE_BUILDER = new ResponseSpecBuilder();
        RESPONSE_BUILDER.expectStatusCode(200);
//        RESPONSE_BIILDER.expectResponseTime(lessThan(3L), TimeUnit.MINUTES);
        RESPONSE_BUILDER.expectContentType(ContentType.JSON);
        RESPONSE_SPECIFICATION = RESPONSE_BUILDER.build();
    }
	
	public static ResponseSpecification getResponseSpecification() {
		return given().then().spec(RESPONSE_SPECIFICATION);
    }
	
	
	public static Response getResponse(RequestSpecification reqSpec, String type, String endPoint) {
		
        RequestUtil.REQUEST_SPECIFICATION.spec(reqSpec);
        Response response = null;
        if (type.equalsIgnoreCase("get")) {
            response = given().spec(RequestUtil.REQUEST_SPECIFICATION).get(endPoint);
        } else if (type.equalsIgnoreCase("post")) {
            response = given().spec(RequestUtil.REQUEST_SPECIFICATION).post(endPoint);
        } else if (type.equalsIgnoreCase("put")) {
            response = given().spec(RequestUtil.REQUEST_SPECIFICATION).put(endPoint);
        } else if (type.equalsIgnoreCase("delete")) {
            response = given().spec(RequestUtil.REQUEST_SPECIFICATION).delete(endPoint);
        } else {
            System.out.println("Type is not Matching");
        }
        
        response.then().extract();
        return response;
    }
	

}

