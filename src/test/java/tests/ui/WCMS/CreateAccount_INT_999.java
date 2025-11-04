package tests.ui.WCMS;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import base.utils.JsonFileReader;
import org.json.simple.JSONObject;
import tests.ui.base.BaseTest;
import pages.ui.CreateAccountPage;

public class CreateAccount_INT_999 extends BaseTest {

    @Test(description = "INT-999: Verify account creation flow and confirmation message")
    @Description("Verify that a user can successfully create an account and confirmation message is displayed.")
    @Severity(SeverityLevel.NORMAL)
    public void testCreateAccount_INT_999() {
        try {
            // Load test data from JSON
            String testDataPath = "src/main/resources/Jsons/create-account-INT-999.json";
            JSONObject testData = JsonFileReader.getTestData(testDataPath, "INT-999");

            // Extract required fields explicitly
            String firstName = (String) testData.get("firstName");
            String lastName = (String) testData.get("lastName");
            String email = (String) testData.get("email");
            String password = (String) testData.get("password");
            String confirmPassword = (String) testData.get("confirmPassword");

            // Use comprehensive Page Object method for account creation
            CreateAccountPage createAccountPage = page.getInstance(CreateAccountPage.class);
            createAccountPage.completeCreateAccountFlow(firstName, lastName, email, password, confirmPassword);

            // Assert confirmation message is displayed
            Assert.assertTrue(createAccountPage.isConfirmationMessageDisplayed(), "Account confirmation message was not displayed!");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during account creation test: " + e.getMessage());
        }
    }
}
