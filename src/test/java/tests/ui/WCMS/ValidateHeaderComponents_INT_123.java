package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import base.utils.ConfigReader;
import base.utils.JsonFileReader;
import pages.ui.LoginPage;
import pages.ui.HeaderComponentPage;
import tests.ui.base.BaseTest;
import org.json.simple.JSONObject;

public class ValidateHeaderComponents_INT_123 extends BaseTest {

    private static final String TEST_DATA_PATH = "src/main/resources/Jsons/validate-header-components-INT-123-data.json";
    private String appUrl;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        try {
            // Always use ConfigReader for URL if available
            appUrl = ConfigReader.getInstance().getApplicationUrl();
            driver.get(appUrl);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to load application URL in @BeforeMethod");
        }
    }

    @Test(description = "INT-123: Validate header components after login")
    @Description("User should be able to see the header components successfully after logging in.")
    @Severity(SeverityLevel.NORMAL)
    public void validateHeaderComponentsAfterLogin() {
        try {
            // Load test data for INT-123 (first positive scenario)
            JSONObject testData = JsonFileReader.getTestData(TEST_DATA_PATH, 0); // 0 = first data item
            String username = (String) testData.get("username");
            String password = (String) testData.get("password");

            LoginPage loginPage = page.getInstance(LoginPage.class);
            HeaderComponentPage headerComponentPage = page.getInstance(HeaderComponentPage.class);

            // Login flow (assume loginPage.login exists and is the comprehensive method)
            loginPage.login(username, password);

            // Validate header components (comprehensive method)
            boolean areHeadersPresent = headerComponentPage.validateHeaderComponents();

            Assert.assertTrue(areHeadersPresent, "Header components are not displayed as expected after login.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during header component validation test: " + e.getMessage());
        }
    }
}
