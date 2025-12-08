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
import pages.ui.HeaderComponentsPage;
import tests.ui.base.BaseTest;
import org.json.simple.JSONObject;

public class ValidateHeaderComponents_INT_123 extends BaseTest {

    private LoginPage loginPage;
    private HeaderComponentsPage headerComponentsPage;
    private static final String TEST_DATA_PATH = "src/main/resources/Jsons/validate-header-components-INT-123.json";

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        try {
            String url = ConfigReader.getApplicationUrl();
            driver.get(url);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to load application URL in @BeforeMethod");
        }
    }

    @Test(description = "INT-123: Validate header components are visible after login")
    @Description("User should be able to see the header components successfully after logging in.")
    @Severity(SeverityLevel.NORMAL)
    public void validateHeaderComponentsAfterLogin_INT_123() {
        try {
            // Load test data (if needed in future, currently no dynamic data required)
            JSONObject testData = JsonFileReader.getTestData(TEST_DATA_PATH, "INT-123");
            // Hardcoded credentials as per locator context (replace with config/testdata if needed)
            String username = "sivasai.arava@gmail.com";
            String password = "QAZqaz852@";

            loginPage = page.getInstance(LoginPage.class);
            headerComponentsPage = page.getInstance(HeaderComponentsPage.class);

            loginPage.login(username, password);

            boolean headerVisible = headerComponentsPage.validateHeaderComponentsVisible();
            Assert.assertTrue(headerVisible, "Header components are not visible after login!");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred in validateHeaderComponentsAfterLogin_INT_123: " + e.getMessage());
        }
    }
}
