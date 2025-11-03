package tests.ui;

import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.ui.CreateAccountPage;
import base.utils.JsonFileReader;
import java.util.Map;

public class CreateAccount_INT_999 {

    @Test(description = "INT-999: Create account")
    @Description("Verify that a new account can be created and confirmation message is displayed.")
    @Severity(SeverityLevel.NORMAL)
    @Step("Steps: Navigate to Create Account → Fill details → Submit → Verify confirmation message")
    public void testCreateAccount_INT_999() {
        // Load test data from JSON file
        Map<String, String> testData = JsonFileReader.getTestData("src/main/resources/Jsons/create-account-INT-999.json", "INT-999");

        String firstName = testData.getOrDefault("FirstName", "TestFirstName");
        String middleName = testData.getOrDefault("MiddleName", "T");
        String lastName = testData.getOrDefault("LastName", "TestLastName");
        String organization = testData.getOrDefault("Organization", "TestOrg");
        String email = testData.getOrDefault("Email", "testuser" + System.currentTimeMillis() + "@example.com");
        String password = testData.getOrDefault("Password", "Test@1234");
        String confirmPassword = testData.getOrDefault("ConfirmPassword", password);

        CreateAccountPage createAccountPage = page.getInstance(CreateAccountPage.class);

        // Prefer high-level wrapper if available, else call granular steps
        createAccountPage.createAccount(firstName, middleName, lastName, organization, email, password, confirmPassword);

        // Assertion: Confirmation message displayed
        Assert.assertTrue(
            createAccountPage.isConfirmationMessageDisplayed(),
            "Account creation confirmation message should be displayed."
        );
    }
}
