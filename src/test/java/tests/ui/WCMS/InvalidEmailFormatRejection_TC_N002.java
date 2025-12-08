package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import base.utils.ConfigReader;
import base.utils.JsonFileReader;
import pages.ui.LoginPage;
import pages.ui.ContactCreationPage;
import tests.ui.base.BaseTest;

public class InvalidEmailFormatRejection_TC_N002 extends BaseTest {

    private LoginPage loginPage;
    private ContactCreationPage contactCreationPage;
    private static final String TEST_DATA_PATH = "src/test/resources/testdata/tc-n002-invalid-email-format-rejection-data.json";

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        try {
            String url = ConfigReader.getInstance().getProperty("url");
            driver.get(url);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to load application URL in @BeforeMethod");
        }
    }

    @Test(description = "TC-N002: Verify system rejects invalid email formats and displays appropriate error message.")
    @Description("Verify system rejects invalid email formats and displays appropriate error message on contact creation.")
    @Severity(SeverityLevel.NORMAL)
    public void testInvalidEmailFormatRejection() {
        try {
            // Step 1: Login (precondition)
            loginPage = page.getInstance(LoginPage.class);
            String username = ConfigReader.getInstance().getProperty("username");
            String password = ConfigReader.getInstance().getProperty("password");
            loginPage.login(username, password);

            // Step 2: Navigate to Contact Creation
            // Assume navigation is via UI after login (e.g., click Contacts > Create)
            // If needed, navigation can be added here using page objects
            // For this example, we assume user is navigated to contact creation screen after login

            contactCreationPage = page.getInstance(ContactCreationPage.class);

            // Step 3: Load test data
            JSONObject testDataRoot = JsonFileReader.readJsonFile(TEST_DATA_PATH);
            JSONArray testDataArray = (JSONArray) testDataRoot.get("testData");

            // Use fixed valid values for required fields
            String firstName = "TestFirst";
            String lastName = "TestLast";
            String emailType = "Personal";
            String category = "Lead";

            for (Object obj : testDataArray) {
                JSONObject data = (JSONObject) obj;
                String email = (String) data.get("email");
                String expectedError = (String) data.get("expectedError");
                String description = (String) data.get("description");

                boolean errorDisplayed = contactCreationPage.createContactWithInvalidEmail(
                        firstName, lastName, email, emailType, category);

                Assert.assertTrue(errorDisplayed, "[" + description + "] Error message not displayed for invalid email: " + email);
                // Optionally, verify the actual error message text if method is extended to return the message
                // String actualError = contactCreationPage.getEmailErrorMessage();
                // Assert.assertEquals(actualError, expectedError, "[" + description + "] Error message mismatch.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred in testInvalidEmailFormatRejection: " + e.getMessage());
        }
    }
}
