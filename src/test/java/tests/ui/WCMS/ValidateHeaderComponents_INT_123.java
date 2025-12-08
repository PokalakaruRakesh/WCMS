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
    private JSONObject testData;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Use ConfigReader to get the base URL as per repo convention
        String url = ConfigReader.getInstance().getProperty("baseUrl");
        driver.get(url);
        // Load test data for INT-123
        testData = JsonFileReader.getTestData("src/main/resources/Jsons/validate-header-components-INT-123.json", "INT-123");
    }

    @Test(description = "INT-123: Validate header components are visible after login")
    @Description("Verify that user can see all header components after successful login as per INT-123.")
    @Severity(SeverityLevel.NORMAL)
    public void validateHeaderComponents_INT_123() {
        try {
            loginPage = page.getInstance(LoginPage.class);
            headerComponentPage = page.getInstance(HeaderComponentPage.class);

            // Extract username and password from test data
            String username = (String) testData.getOrDefault("username", "sivasai.arava@gmail.com");
            String password = (String) testData.getOrDefault("password", "QAZqaz852@");

            // Login
            loginPage.login(username, password);

            // Validate header components using comprehensive method
            headerComponentPage.validateHeaderComponents();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
