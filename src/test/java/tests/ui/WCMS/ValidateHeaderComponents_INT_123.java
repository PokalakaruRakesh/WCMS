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
import pages.ui.HeaderComponentsPage;
import tests.ui.base.BaseTest;

public class ValidateHeaderComponents_INT_123 extends BaseTest {

    private LoginPage loginPage;
    private HeaderComponentsPage headerComponentsPage;
    private JSONObject testData;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Use ConfigReader to load the URL as per repository conventions
        String url = ConfigReader.getProperty("url");
        driver.get(url);
        // Load test data for INT-123
        testData = JsonFileReader.getTestData("src/test/resources/testdata/INT-123-data.json", "INT-123");
    }

    @Test(description = "INT-123: Validate header components after login")
    @Description("User should be able to see the header components successfully after logging in.")
    @Severity(SeverityLevel.NORMAL)
    public void validateHeaderComponentsAfterLogin() {
        try {
            loginPage = page.getInstance(LoginPage.class);
            headerComponentsPage = page.getInstance(HeaderComponentsPage.class);

            // Extract credentials from test data if available, else use hardcoded fallback
            String username = testData.containsKey("username") ? (String) testData.get("username") : "sivasai.arava@gmail.com";
            String password = testData.containsKey("password") ? (String) testData.get("password") : "QAZqaz852@";

            // Login using the LoginPage's comprehensive login method
            loginPage.login(username, password);

            // Validate all header components are visible using the comprehensive method
            headerComponentsPage.validateHeaderComponentsVisible();

            // If no exception, consider test passed
            Assert.assertTrue(true, "Header components are displayed as expected after login.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
