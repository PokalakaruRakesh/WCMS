package tests.ui;

import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.ui.CreateAccountPage;
import base.utils.JsonFileReader;
import org.testng.Assert;

public class CreateAccount_INT_999 {

    @Test(description = "INT-999: Verify account creation flow")
    @Description("Verify that a new account can be created successfully and confirmation message is displayed.")
    @Severity(SeverityLevel.NORMAL)
    @Step("Steps: Navigate to Create Account → Fill form → Submit → Verify confirmation message")
    public void testCreateAccount_INT_999() {
        // Initialize Page Object
        CreateAccountPage createAccountPage = page.getInstance(CreateAccountPage.class);

        // Load test data from JSON
        String testDataPath = "src/main/resources/Jsons/create-account-INT-999.json";
        org.json.simple.JSONObject testData = JsonFileReader.getTestData(testDataPath, "INT-999");

        // Call comprehensive method to create account
        createAccountPage.createAccount(testData);

        // Assertion: Confirmation message is displayed
        Assert.assertTrue(createAccountPage.isConfirmationMessageDisplayed(), "Account creation confirmation message was not displayed.");
    }
}
