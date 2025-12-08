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
    private static final String TEST_DATA_PATH = "src/main/resources/Jsons/validate-header-components-INT-123-data.json";

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Use ConfigReader to load URL as per critical rule
        String url = ConfigReader.getInstance().getProperty("url");
        driver.get(url);
    }

    @Test(description = "INT-123: Validate header components are visible and functional")
    @Description("Verify that user can see all header components after login as per INT-123.")
    @Severity(SeverityLevel.NORMAL)
    public void validateHeaderComponents_INT_123() {
        try {
            // Initialize Page Objects
            loginPage = page.getInstance(LoginPage.class);
            headerComponentPage = page.getInstance(HeaderComponentPage.class);

            // Load test data (extract username/password from config or test data as needed)
            JSONObject loginTestData = JsonFileReader.getTestData("src/main/resources/Jsons/TC-N001-login-data.json", "login");
            String username = loginTestData.get("username").toString();
            String password = loginTestData.get("password").toString();

            // Login
            loginPage.login(username, password);

            // Validate header components (single comprehensive method)
            headerComponentPage.validateHeaderComponents();

            // If no exception, test passes
            Assert.assertTrue(true, "User should be able to see the header components successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during header components validation: " + e.getMessage());
        }
    }
}
