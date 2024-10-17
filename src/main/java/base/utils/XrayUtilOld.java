package base.utils;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class XrayUtilOld {
	
	static String baseURI="http://xray.cloud.xpand-it.com/api/v1";
	private static String clientID = getXrayKeyCodes("xrayclientid");
	private static String clientSecret = getXrayKeyCodes("xrayclientsecret");
	
	private static EncryptionUtil xrayCipher = new EncryptionUtil(getXrayKeyCodes("xrayencryptionkey"));
	
	//ASTM Jira
	static String Authentication ="{ \"client_id\": \""+xrayCipher.decrypt(clientID)+"\",\"client_secret\": \""+xrayCipher.decrypt(clientSecret)+"\" }";
	static String Token;
	
	private static String getXrayKeyCodes(String key) {
		File file = new File("src\\test\\resources\\keycodes.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		try {
			prop.load(fileInput);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return prop.getProperty(key);

	}
	
	public static String getTestRun(String testkey) 
	{
		String testExecutionID= ConfigReader.getValue("TestExecutionID");  //"22254";
		RestAssured.baseURI= baseURI;
		Response rs=given().contentType(ContentType.JSON).body(Authentication).when().post("/authenticate").then().extract().response();
		Token=rs.asString();
		Response vs=  given().headers("Authorization","Bearer " + Token.replaceAll("^\"|\"$", "")).queryParam("query", "{ getTestExecution(issueId:\""+testExecutionID+"\") { issueId tests(limit: 100) { results { issueId jira(fields: [\"key\"]) } } } }").when().get("/graphql").then().extract().response();
		JsonPath js= new JsonPath(vs.asString());
		int count=js.getInt("data.getTestExecution.tests.results.size()");
		String issueID="";
	
		for (int i =0; i<count;i++) 
		{
			String getkey=js.getString("data.getTestExecution.tests.results["+i+"].jira.key");
			
			if (getkey.equals(testkey)) 
			{
				issueID=js.getString("data.getTestExecution.tests.results["+i+"].issueId");
				break;
			}
		}
		Response testRun=  given().headers("Authorization","Bearer " + Token.replaceAll("^\"|\"$", "")).queryParam("query", "{ getTestRun( testIssueId: \""+issueID+"\", testExecIssueId: \""+testExecutionID+"\") { id status { name color description } gherkin examples { id status { name color description } } } }").when().get("/graphql").then().extract().response();
		JsonPath testRunJS= new JsonPath(testRun.asString());
		System.out.println("TestRun ID: "+testRunJS.getString("data.getTestRun.id"));
		String testRunID =testRunJS.getString("data.getTestRun.id");
		return testRunID;
		
		}
	
	public static void updateTestRun(String testRunID,String status) 
	{
		Response updateTestResult=  given().headers("Authorization","Bearer " + Token.replaceAll("^\"|\"$", "")).queryParam("query", "mutation {updateTestRunStatus( id: \""+testRunID+"\", status: \""+status+"\")}").body("{ \"query\":\"mutation {updateTestRunStatus( id: \""+testRunID+"\", status: \""+status+"\")}\"}").when().post("/graphql").then().extract().response();
		System.out.println(updateTestResult.asString());
	}
	
	
	
}