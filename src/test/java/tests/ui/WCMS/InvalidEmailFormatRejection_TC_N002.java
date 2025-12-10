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
import pages.ui.ContactCreationPage;
import pages.ui.LoginPage;
import base.utils.JsonFileReader;
import base.utils.ConfigReader;
import tests.ui.base.BaseTest;

import java.io.FileReader;

public class InvalidEmailFormatRejection_TC_N002 extends BaseTest {

    private static final String TEST_DATA_PATH = "src/test/resources/testdata/invalid-email-format-rejection-data.json";
    private JSONObject testData;
    private JSONArray invalidEmails;
    private String expectedErrorMessage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        try {
            // Load test data
            JSONParser parser = new JSONParser();
            testData = (JSONObject) parser.parse(new FileReader(TEST_DATA_PATH));
            invalidEmails = (JSONArray) testData.get("invalidEmails");
            expectedErrorMessage = (String) testData.get("expectedErrorMessage");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to load test data for Invalid Email Format Rejection");
        }
        // Load URL from ConfigReader (as per repo convention)
        driver.get(ConfigReader.getInstance().getProperty("appUrl"));
    }

    @Test(description = "TC-N002: Verify system rejects invalid email formats and displays appropriate error message.")
    @Description("Verify system rejects invalid email formats and displays appropriate error message on the contact creation screen.")
    @Severity(SeverityLevel.NORMAL)
    public void testInvalidEmailFormatRejection() {
        try {
            // Step 1: Login (precondition)
            LoginPage loginPage = page.getInstance(LoginPage.class);
            // Use valid credentials (replace with actual values or fetch from config/testdata)
            String username = ConfigReader.getInstance().getProperty("validUsername");
            String password = ConfigReader.getInstance().getProperty("validPassword");
            loginPage.login(username, password);

            // Step 2: Navigate to Contact Creation Screen (precondition)
            // This step may be implemented in the LoginPage or HomePage, or may require direct navigation
            // For this example, assume direct navigation after login
            driver.get(ConfigReader.getInstance().getProperty("contactCreationUrl"));

            // Step 3: For each invalid email, attempt to create contact and verify error
            ContactCreationPage contactCreationPage = page.getInstance(ContactCreationPage.class);
            String firstName = "TestFirst";
            String lastName = "TestLast";
            String emailType = "Personal";
            String category = "Lead";

            for (Object obj : invalidEmails) {
                JSONObject emailObj = (JSONObject) obj;
                String invalidEmail = (String) emailObj.get("value");
                String description = (String) emailObj.get("description");
                boolean isErrorDisplayed = contactCreationPage.createContactWithInvalidEmailAndVerifyError(
                        firstName, lastName, invalidEmail, emailType, category);
                Assert.assertTrue(isErrorDisplayed, "[" + description + "] Error message not displayed for invalid email: " + invalidEmail);
                // Optionally, verify the specific error message text if available
                // String actualErrorMsg = contactCreationPage.getEmailErrorMessage();
                // Assert.assertEquals(actualErrorMsg, expectedErrorMessage, "Error message text mismatch for: " + invalidEmail);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during Invalid Email Format Rejection test: " + e.getMessage());
        }
    }
}
