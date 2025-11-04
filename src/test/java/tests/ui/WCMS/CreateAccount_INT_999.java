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

    @Test(description = "INT-999: Verify Create Account functionality")
    @Description("To verify the functionality of the Create Account page. Account should be created successfully and confirmation message displayed.")
    @Severity(SeverityLevel.NORMAL)
    public void verifyCreateAccountFunctionality_INT_999() {
        try {
            // Load test data for INT-999
            String testDataPath = "src/main/resources/Jsons/create-account-INT-999.json";
            JSONObject testData = JsonFileReader.getTestData(testDataPath, "INT-999");

            // Extract explicit parameters from test data
            String firstName = (String) testData.get("firstName");
            String lastName = (String) testData.get("lastName");
            String email = (String) testData.get("email");
            String password = (String) testData.get("password");
            String confirmPassword = (String) testData.get("confirmPassword");

            CreateAccountPage createAccountPage = page.getInstance(CreateAccountPage.class);
            // Call the comprehensive method for the Create Account flow
            createAccountPage.completeCreateAccountFlow(firstName, lastName, email, password, confirmPassword);

            // Assert confirmation message is displayed
            Assert.assertTrue(createAccountPage.isConfirmationMessageDisplayed(), "Account confirmation message was not displayed.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred in verifyCreateAccountFunctionality_INT_999: " + e.getMessage());
        }
    }
}
