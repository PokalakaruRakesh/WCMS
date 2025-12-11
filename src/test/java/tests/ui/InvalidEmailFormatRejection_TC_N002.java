package tests.ui;

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
import base.utils.ConfigReader;
import base.utils.JsonFileReader;
import tests.ui.base.BaseTest;

import java.io.FileReader;

public class InvalidEmailFormatRejection_TC_N002 extends BaseTest {

    private LoginPage loginPage;
    private ContactCreationPage contactCreationPage;
    private static final String TEST_DATA_PATH = "src/test/resources/testdata/invalid-email-format-rejection-data.json";

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        try {
            String url = ConfigReader.getInstance().getProperty("url");
            driver.get(url);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to load URL in @BeforeMethod");
        }
    }

    @Test(description = "TC-N002: Verify system rejects invalid email formats and displays appropriate error message.")
    @Description("Verify system rejects invalid email formats and displays appropriate error message when creating a contact.")
    @Severity(SeverityLevel.NORMAL)
    public void testInvalidEmailFormatRejection() {
        try {
            loginPage = page.getInstance(LoginPage.class);
            contactCreationPage = page.getInstance(ContactCreationPage.class);

            // 1. Login (precondition)
            // Fetch login credentials from config or test data as per repo standards
            String username = ConfigReader.getInstance().getProperty("username");
            String password = ConfigReader.getInstance().getProperty("password");
            loginPage.login(username, password);

            // 2. Navigate to Contact Creation screen
            // This step is assumed to be handled by navigation after login or via a method in the page object if needed
            // If navigation is required, add navigation method here

            // 3. Load test data
            JSONObject testData = JsonFileReader.getTestData(TEST_DATA_PATH);
            JSONArray invalidEmailTestCases = (JSONArray) testData.get("invalidEmailTestCases");

            // 4. Loop through invalid email test cases
            for (Object obj : invalidEmailTestCases) {
                JSONObject emailCase = (JSONObject) obj;
                String label = (String) emailCase.get("label");
                String invalidEmail = (String) emailCase.get("email");
                String expectedError = (String) emailCase.get("expectedError");

                // Use static valid data for other required fields
                String firstName = "TestFirst";
                String lastName = "TestLast";
                String emailDesc = "Personal";
                String category = "Lead";

                // Complete contact creation with invalid email
                contactCreationPage.completeContactCreationWithInvalidEmail(firstName, lastName, invalidEmail, emailDesc, category);

                // Assert error message
                String actualError = contactCreationPage.getEmailFormatErrorMessage();
                Assert.assertNotNull(actualError, "[" + label + "] Error message should be displayed for invalid email: " + invalidEmail);
                Assert.assertTrue(actualError.contains(expectedError), "[" + label + "] Expected error: '" + expectedError + "', but got: '" + actualError + "'");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred in testInvalidEmailFormatRejection: " + e.getMessage());
        }
    }
}
