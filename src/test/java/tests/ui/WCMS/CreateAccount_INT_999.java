package tests.ui.WCMS;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.ui.CreateAccountPage;
import src.main.java.base.utils.JsonFileReader;
import org.json.simple.JSONObject;
import tests.ui.base.BaseTest;

public class CreateAccount_INT_999 extends BaseTest {

    @Test(description = "INT-999: Verify account creation flow and confirmation message")
    @Description("Verify that a user can create an account successfully and confirmation message is displayed as per INT-999.")
    @Severity(SeverityLevel.NORMAL)
    public void testCreateAccount_INT_999() {
        try {
            // Load test data for INT-999
            String testDataPath = "src/main/resources/Jsons/create-account-INT-999.json";
            JSONObject testData = JsonFileReader.getTestData(testDataPath, "INT-999");

            // Extract required fields explicitly (example fields, adjust as per actual JSON)
            String firstName = (String) testData.get("firstName");
            String lastName = (String) testData.get("lastName");
            String email = (String) testData.get("email");
            String password = (String) testData.get("password");
            String confirmPassword = (String) testData.get("confirmPassword");

            // Get the Page Object instance
            CreateAccountPage createAccountPage = page.getInstance(CreateAccountPage.class);

            // Call the comprehensive method for the create account flow
            createAccountPage.completeCreateAccountFlow_INT_999(firstName, lastName, email, password, confirmPassword);

            // Assertion: Confirmation message should be displayed
            Assert.assertTrue(createAccountPage.isConfirmationMessageDisplayed(), "Account creation confirmation message was not displayed.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during Create Account test: " + e.getMessage());
        }
    }
}
