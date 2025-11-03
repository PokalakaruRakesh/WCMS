package tests.ui;

import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.ui.CreateAccountPage;
import base.utils.JsonFileReader;
import org.testng.Assert;
import java.util.Map;

public class CreateAccount_INT_999 {

    @Test(description = "INT-999: Create account")
    @Description("Verify that a new account can be created successfully and confirmation message is displayed.")
    @Severity(SeverityLevel.NORMAL)
    @Step("Steps: Navigate to Create Account → Fill in details → Submit → Verify confirmation message")
    public void testCreateAccount_INT_999() {
        // Load test data from JSON
        Map<String, Object> testData = JsonFileReader.getTestData("src/main/resources/Jsons/create-account-INT-999.json", "INT-999");
        String firstName = testData.getOrDefault("FirstName", "TestFirst").toString();
        String middleName = testData.getOrDefault("MiddleName", "TestMiddle").toString();
        String lastName = testData.getOrDefault("LastName", "TestLast").toString();
        String organization = testData.getOrDefault("Organization", "TestOrg").toString();
        String email = testData.getOrDefault("Email", "testuser" + System.currentTimeMillis() + "@example.com").toString();
        String password = testData.getOrDefault("Password", "Test@12345").toString();
        String confirmPassword = testData.getOrDefault("ConfirmPassword", password).toString();

        CreateAccountPage createAccountPage = page.getInstance(CreateAccountPage.class);

        // Fill in the account creation form using Page Object methods
        createAccountPage.enterFirstName(firstName);
        createAccountPage.enterMiddleName(middleName);
        createAccountPage.enterLastName(lastName);
        createAccountPage.enterOrganization(organization);
        createAccountPage.enterEmail(email);
        createAccountPage.enterPassword(password);
        createAccountPage.enterConfirmPassword(confirmPassword);
        createAccountPage.clickCreateAccountButton();

        // Assertion: Verify confirmation message is displayed
        boolean isConfirmationDisplayed = createAccountPage.isConfirmationMessageDisplayed();
        Assert.assertTrue(isConfirmationDisplayed, "Account creation confirmation message was not displayed.");
    }
}
