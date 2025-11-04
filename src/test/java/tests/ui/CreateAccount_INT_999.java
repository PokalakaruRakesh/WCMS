package tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import base.utils.JsonFileReader;
import pages.ui.CreateAccountPage;

public class CreateAccount_INT_999 {

    @Test(description = "INT-999: Verify account creation flow and confirmation message")
    @Description("Verify that a user can create an account successfully and a confirmation message is displayed.")
    @Severity(SeverityLevel.NORMAL)
    @Step("Steps: Navigate to Create Account → Fill Details → Submit → Verify Confirmation Message")
    public void testCreateAccount_INT_999() {
        // Load test data
        String testDataPath = "src/main/resources/Jsons/create-account-INT-999.json";
        JSONObject testData = JsonFileReader.getTestData(testDataPath, "INT-999");

        // Extract explicit parameters from test data
        String firstName = (String) testData.get("firstName");
        String lastName = (String) testData.get("lastName");
        String email = (String) testData.get("email");
        String password = (String) testData.get("password");
        String confirmPassword = (String) testData.get("confirmPassword");

        // Initialize Page Object
        CreateAccountPage createAccountPage = page.getInstance(CreateAccountPage.class);

        // Call the comprehensive flow method
        createAccountPage.completeCreateAccountFlow(firstName, lastName, email, password, confirmPassword);

        // Assertion: Confirmation message should be displayed
        Assert.assertTrue(createAccountPage.isConfirmationMessageDisplayed(), "Account creation confirmation message was not displayed.");
    }
}
