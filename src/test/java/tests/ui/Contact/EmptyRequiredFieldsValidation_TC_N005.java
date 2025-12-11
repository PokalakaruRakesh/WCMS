package tests.ui.Contact;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import base.utils.ConfigReader;
import base.utils.JsonFileReader;
import org.json.simple.JSONObject;
import pages.ui.ContactCreationPage;
import tests.ui.base.BaseTest;

public class EmptyRequiredFieldsValidation_TC_N005 extends BaseTest {

    private ContactCreationPage contactCreationPage;
    private static final String TEST_DATA_PATH = "src/test/resources/testdata/tc-n005-empty-required-fields-validation-data.json";

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        try {
            String url = ConfigReader.getInstance().getApplicationUrl();
            driver.get(url);
            // Assumes user is already logged in and navigated to contact creation screen as per preconditions
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception during @BeforeMethod: " + e.getMessage());
        }
    }

    @Test(description = "TC-N005: Empty Required Fields Validation")
    @Description("Verify system prevents saving a contact when required fields are left empty.")
    @Severity(SeverityLevel.NORMAL)
    public void testEmptyRequiredFieldsValidation_TC_N005() {
        try {
            contactCreationPage = page.getInstance(ContactCreationPage.class);

            // Load test data
            JSONObject testData = JsonFileReader.readJsonFromFile(TEST_DATA_PATH);
            JSONObject inputData = (JSONObject) testData.get("inputData");
            JSONObject otherFields = (JSONObject) inputData.get("otherFields");

            String phone = otherFields.getOrDefault("phone", "").toString();
            String company = otherFields.getOrDefault("company", "").toString();
            String position = otherFields.getOrDefault("position", "").toString();

            // Attempt to save with empty required fields (Name, Email)
            contactCreationPage.completeEmptyRequiredFieldsValidation(phone, company, position);

            // Assert error messages for required fields
            Assert.assertTrue(contactCreationPage.isFirstNameErrorDisplayed(), "First Name required error message not displayed.");
            Assert.assertTrue(contactCreationPage.isEmailErrorDisplayed(), "Email required error message not displayed.");

            String firstNameError = contactCreationPage.getFirstNameErrorText();
            String emailError = contactCreationPage.getEmailErrorText();

            // Expected error messages from test data
            String expectedFirstNameError = "The field First Name is required.";
            String expectedEmailError = "Email is required."; // Adjust if actual error message differs

            Assert.assertEquals(firstNameError.trim(), expectedFirstNameError, "First Name error message mismatch.");
            Assert.assertEquals(emailError.trim(), expectedEmailError, "Email error message mismatch.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception in testEmptyRequiredFieldsValidation_TC_N005: " + e.getMessage());
        }
    }
}
