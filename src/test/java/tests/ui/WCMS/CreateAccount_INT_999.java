package tests.ui.WCMS;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONObject;
import base.utils.JsonFileReader;
import pages.ui.CreateAccountPage;
import tests.ui.base.BaseTest;

public class CreateAccount_INT_999 extends BaseTest {

    @Test(description = "INT-999: Create account - Ensure account creation process works as expected.")
    @Description("To ensure the account creation process works as expected and confirmation message is displayed.")
    @Severity(SeverityLevel.NORMAL)
    public void testCreateAccount_INT_999() {
        // Load test data from JSON
        String testDataPath = "src/main/resources/Jsons/create-account-INT-999.json";
        JSONObject testData = JsonFileReader.getTestData(testDataPath, "INT-999");

        // Extract parameters explicitly from test data
        String firstName = (String) testData.get("firstName");
        String lastName = (String) testData.get("lastName");
        String email = (String) testData.get("email");
        String password = (String) testData.get("password");
        String confirmPassword = (String) testData.get("confirmPassword");

        // Get the CreateAccountPage instance
        CreateAccountPage createAccountPage = page.getInstance(CreateAccountPage.class);

        // Call the comprehensive method to complete the account creation flow
        createAccountPage.completeCreateAccountFlow(firstName, lastName, email, password, confirmPassword);

        // Assert that confirmation message is displayed
        Assert.assertTrue(createAccountPage.isConfirmationMessageDisplayed(), "Account creation confirmation message was not displayed.");
    }
}
