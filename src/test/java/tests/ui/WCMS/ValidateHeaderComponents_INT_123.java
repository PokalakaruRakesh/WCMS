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
        // Use ConfigReader to get the application URL
        String url = ConfigReader.getInstance().getApplicationUrl();
        driver.get(url);
        // Load test data for INT-123
        testData = JsonFileReader.getTestData("src/test/resources/testdata/INT-123-data.json", "INT-123");
    }

    @Test(description = "INT-123: Validate header components after login")
    @Description("User should be able to log in and see the header components successfully.")
    @Severity(SeverityLevel.NORMAL)
    public void validateHeaderComponents_INT_123() {
        try {
            loginPage = page.getInstance(LoginPage.class);
            headerComponentPage = page.getInstance(HeaderComponentPage.class);

            // Extract login credentials from test data if present, else use defaults
            String username = testData.containsKey("username") ? (String) testData.get("username") : "sivasai.arava@gmail.com";
            String password = testData.containsKey("password") ? (String) testData.get("password") : "QAZqaz852@";

            // Login flow (assumes LoginPage has login method)
            loginPage.login(username, password);

            // Validate header components (single comprehensive method)
            headerComponentPage.validateHeaderComponents();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
