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
import base.utils.JsonFileReader;
import tests.ui.base.BaseTest;
import pages.ui.ContactCreationPage;
import pages.ui.LoginPage;

public class InvalidEmailFormatRejection_TC_N002 extends BaseTest {

    private static final String TEST_DATA_PATH = "src/test/resources/testdata/invalid-email-format-rejection-data.json";
    private LoginPage loginPage;
    private ContactCreationPage contactCreationPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        // No URL provided in test data, assuming handled in BaseTest or via config
        // If login is required, perform login here
        try {
            loginPage = page.getInstance(LoginPage.class);
            // Hardcoded credentials for demonstration; ideally, fetch from config
            loginPage.login("sivasai.arava@gmail.com", "QAZqaz852@");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Login failed in @BeforeMethod: " + e.getMessage());
        }
    }

    @Test(description = "TC-N002: Verify system rejects invalid email formats and displays appropriate error message.")
    @Description("Verify system rejects invalid email formats and displays appropriate error message on contact creation.")
    @Severity(SeverityLevel.NORMAL)
    public void testInvalidEmailFormatRejection() {
        try {
            contactCreationPage = page.getInstance(ContactCreationPage.class);
            // Load test data
            JSONObject testDataRoot = JsonFileReader.readJsonFile(TEST_DATA_PATH);
            JSONArray testDataArray = (JSONArray) testDataRoot.get("testData");

            // Sample valid data for other fields
            String firstName = "John";
            String lastName = "Doe";
            String emailType = "Personal";
            String category = "Lead";

            for (Object obj : testDataArray) {
                JSONObject data = (JSONObject) obj;
                String invalidEmail = (String) data.get("email");
                String expectedError = (String) data.get("expectedError");
                String description = (String) data.get("description");

                boolean isErrorDisplayed = contactCreationPage.completeContactCreationWithInvalidEmail(
                        firstName, lastName, invalidEmail, emailType, category);

                Assert.assertTrue(isErrorDisplayed, "[" + description + "] Error message not displayed for invalid email: " + invalidEmail);
                // Optionally, verify the error message text if method is extended to return the actual message
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred in testInvalidEmailFormatRejection: " + e.getMessage());
        }
    }
}
