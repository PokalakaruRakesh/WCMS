package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import base.utils.ConfigReader;
import base.utils.JsonFileReader;
import org.json.simple.JSONObject;
import pages.ui.LoginPage;
import pages.ui.HeaderComponentPage;
import tests.ui.base.BaseTest;

public class ValidateHeaderComponents_INT_123 extends BaseTest {

    private String testDataPath = "src/main/resources/Jsons/validate-header-components-INT-123-data.json";
    private JSONObject testData;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Use ConfigReader to load the base URL as per repository rules
        String url = ConfigReader.getInstance().getProperty("url");
        driver.get(url);
        // Load test data for INT-123
        testData = JsonFileReader.getTestData(testDataPath, "INT-123");
    }

    @Test(description = "INT-123: Validate header components after login")
    @Description("User should be able to see the header components successfully after logging in.")
    @Severity(SeverityLevel.NORMAL)
    public void validateHeaderComponentsAfterLogin() {
        try {
            LoginPage loginPage = page.getInstance(LoginPage.class);
            HeaderComponentPage headerComponentPage = page.getInstance(HeaderComponentPage.class);

            // Extract valid user credentials from test data
            JSONObject validUser = null;
            for (Object userObj : (org.json.simple.JSONArray) testData.get("testData")) {
                JSONObject user = (JSONObject) userObj;
                if ("Valid user with standard access".equals(user.get("description"))) {
                    validUser = user;
                    break;
                }
            }
            Assert.assertNotNull(validUser, "Valid user data not found in test data!");
            String username = (String) validUser.get("username");
            String password = (String) validUser.get("password");

            // Login
            loginPage.login(username, password);

            // Validate header components
            boolean headerComponentsPresent = headerComponentPage.validateHeaderComponents();
            Assert.assertTrue(headerComponentsPresent, "Header components are not displayed as expected after login.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during header component validation: " + e.getMessage());
        }
    }
}
