package tests.api.base;

import org.testng.annotations.BeforeMethod;

import com.rest.util.RequestUtil; //import astm.base.restAPI.ResponseUtil;

import base.utils.ConfigReader;
import io.qameta.allure.Step;

public class BaseTestAPI {
	
	
	@Step("Reset Endpoint")
	@BeforeMethod
	public void beforeMethod() {
		RequestUtil.resetEndpoint();
		//ConfigReader.isAPITest = true;
	
	}
}
