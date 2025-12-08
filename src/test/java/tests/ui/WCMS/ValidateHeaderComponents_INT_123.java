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

    private LoginPage loginPage;
    private HeaderComponentPage headerComponentPage;
    private static final String TEST_DATA_PATH = "src/main/resources/Jsons/validate-header-components-INT-123.json";
    private static final String TEST_CASE_ID = "INT-123";

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Use ConfigReader to get the base URL as per repo conventions
        String url = ConfigReader.getInstance().getProperty("url");
        driver.get(url);
    }

    @Test(description = "INT-123: Validate header components are visible after login")
    @Description("Verify that user can see all header components after successful login.")
    @Severity(SeverityLevel.NORMAL)
    public void validateHeaderComponents_INT_123() {
        try {
            // Load test data
            JSONObject testData = JsonFileReader.getTestData(TEST_DATA_PATH, TEST_CASE_ID);
            String username = (String) testData.getOrDefault("username", "sivasai.arava@gmail.com");
            String password = (String) testData.getOrDefault("password", "QAZqaz852@");

            loginPage = page.getInstance(LoginPage.class);
            headerComponentPage = page.getInstance(HeaderComponentPage.class);

            // Login flow (assuming loginPage.login exists as per repo pattern)
            loginPage.login(username, password);

            // Validate header components (single comprehensive method)
            headerComponentPage.validateHeaderComponents();

            // If no exception, test passes
            Assert.assertTrue(true, "Header components are visible and validated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during header component validation: " + e.getMessage());
        }
    }
}
