package tests.ui.contacts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import base.utils.ConfigReader;
import base.utils.JsonFileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import pages.ui.ContactCreationPage;
import tests.ui.base.BaseTest;

import java.io.IOException;

public class EmptyRequiredFieldsValidation_TC_N005 extends BaseTest {

    private static final String TEST_DATA_PATH = "src/test/resources/testdata/tc-n005-empty-required-fields-validation-data.json";
    private JSONArray testDataArray;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException, ParseException {
        String url = ConfigReader.getInstance().getProperty("url");
        driver.get(url);
        // Load test data for all scenarios
        JSONObject testDataRoot = JsonFileReader.readJsonFile(TEST_DATA_PATH);
        testDataArray = (JSONArray) testDataRoot.get("testData");
    }

    @Test(description = "TC-N005: Empty Required Fields Validation - Verify system prevents saving a contact when required fields are left empty.")
    @Description("Verify system prevents saving a contact when required fields (Name and Email) are left empty and displays appropriate error messages.")
    @Severity(SeverityLevel.NORMAL)
    public void testEmptyRequiredFieldsValidation() {
        try {
            ContactCreationPage contactCreationPage = page.getInstance(ContactCreationPage.class);

            for (Object obj : testDataArray) {
                JSONObject scenario = (JSONObject) obj;
                JSONObject input = (JSONObject) scenario.get("input");
                JSONArray expectedErrors = (JSONArray) scenario.get("expectedErrors");

                // Extract input fields (Name, Email, etc.)
                String firstName = input.get("name") != null ? input.get("name").toString() : "";
                String email = input.get("email") != null ? input.get("email").toString() : "";
                // For this test, only First Name and Email are required; others can be ignored or filled as needed

                // Leave First Name and Email as per scenario, optionally fill others
                // The comprehensive method in ContactCreationPage handles this
                contactCreationPage.validateEmptyRequiredFields(
                        input.get("last_name") != null ? input.get("last_name").toString() : "",
                        input.get("category") != null ? input.get("category").toString() : ""
                );

                // Assertion: Check error messages for required fields
                for (Object errorObj : expectedErrors) {
                    JSONObject error = (JSONObject) errorObj;
                    String field = error.get("field").toString();
                    String expectedMsg = error.get("message").toString();
                    if (field.equalsIgnoreCase("name") || field.equalsIgnoreCase("first_name")) {
                        String actualMsg = contactCreationPage.getFirstNameErrorMessage();
                        Assert.assertEquals(actualMsg.trim(), expectedMsg.trim(),
                                "First Name error message mismatch for scenario: " + scenario.get("description"));
                    } else if (field.equalsIgnoreCase("email")) {
                        String actualMsg = contactCreationPage.getEmailErrorMessage();
                        Assert.assertEquals(actualMsg.trim(), expectedMsg.trim(),
                                "Email error message mismatch for scenario: " + scenario.get("description"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during Empty Required Fields Validation test: " + e.getMessage());
        }
    }
}
