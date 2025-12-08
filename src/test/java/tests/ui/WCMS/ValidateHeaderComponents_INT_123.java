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
        try {
            String url = ConfigReader.getInstance().getApplicationUrl();
            driver.get(url);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to load application URL in @BeforeMethod");
        }
    }

    @Test(description = "INT-123: Validate header components after login")
    @Description("INT-123: User should be able to see the header components successfully after logging in.")
    @Severity(SeverityLevel.NORMAL)
    public void validateHeaderComponents_INT_123() {
        try {
            // Load test data for valid user
            JSONObject testData = JsonFileReader.getTestData(TEST_DATA_PATH, "testUsers");
            // Use the first standard user for login
            JSONObject validUser = (JSONObject) ((org.json.simple.JSONArray)testData).get(0);
            String username = (String) validUser.get("username");
            String password = (String) validUser.get("password");

            loginPage = page.getInstance(LoginPage.class);
            headerComponentPage = page.getInstance(HeaderComponentPage.class);

            loginPage.login(username, password);
            boolean headerVisible = headerComponentPage.validateHeaderComponentsVisible();

            Assert.assertTrue(headerVisible, "Header components are not visible after login as expected.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred in validateHeaderComponents_INT_123: " + e.getMessage());
        }
    }
}
