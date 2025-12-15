package tests.ui;

import base.utils.ConfigReader;
import base.utils.JsonFileReader;
import base.utils.WaitStatementUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import pages.ui.ContactCreationPage;
import pages.ui.LoginPage;
import tests.ui.base.BaseTest;
import java.io.FileReader;
import java.util.Iterator;

public class VerifyInvalidEmailFormatRejection_TC_N002 extends BaseTest {

    private static final String TEST_DATA_PATH = "src/main/resources/Jsons/TC-N002-data.json";
    private ContactCreationPage contactCreationPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeTest() {
        driver.get(ConfigReader.getProperty("crm.url")); // Assumes property exists; else hardcode or fetch from test data
        loginPage = page.getInstance(LoginPage.class);
        contactCreationPage = page.getInstance(ContactCreationPage.class);
        // Login and navigate to contact creation screen as per preconditions
        // Credentials could be from config or static for this test
        loginPage.login(ConfigReader.getProperty("crm.username"), ConfigReader.getProperty("crm.password"));
        // Navigate to Contacts > Create
        // Assumes navigation is handled inside LoginPage or via direct URL
        // If not, add navigation here as per actual app flow
    }

    @DataProvider(name = "invalidEmailData")
    public Object[][] invalidEmailData() throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject data = (JSONObject) parser.parse(new FileReader(TEST_DATA_PATH));
        JSONArray emailCases = (JSONArray) data.get("emailFieldTestData");
        Object[][] result = new Object[emailCases.size()][];
        int i = 0;
        for (Object obj : emailCases) {
            JSONObject emailCase = (JSONObject) obj;
            String description = (String) emailCase.get("description");
            String input = (String) emailCase.get("input");
            String expectedError = emailCase.get("expectedError") == null ? null : (String) emailCase.get("expectedError");
            result[i++] = new Object[]{description, input, expectedError};
        }
        return result;
    }

    @Test(dataProvider = "invalidEmailData")
    @Description("TC-N002: Verify system rejects invalid email formats and displays appropriate error message.")
    @Severity(SeverityLevel.NORMAL)
    public void verifyInvalidEmailFormatRejection(String description, String emailInput, String expectedError) {
        try {
            // Use static valid values for required fields except email
            String firstName = "TestFirst";
            String lastName = "TestLast";
            String emailType = "Personal";

            contactCreationPage.createContactWithInvalidEmail(firstName, lastName, emailInput, emailType);
            String actualError = contactCreationPage.getInvalidEmailErrorMessage();

            if (expectedError != null && !expectedError.isEmpty()) {
                Assert.assertTrue(actualError != null && actualError.toLowerCase().contains("invalid"),
                        "[" + description + "] Expected error message for invalid email, but got: '" + actualError + "'");
            } else {
                Assert.assertTrue(actualError == null || actualError.trim().isEmpty(),
                        "[" + description + "] Expected no error for valid email, but got: '" + actualError + "'");
            }
        } catch (Exception e) {
            Assert.fail("Exception occurred in test: " + description + ", Exception: " + e.getMessage(), e);
        }
    }
}
