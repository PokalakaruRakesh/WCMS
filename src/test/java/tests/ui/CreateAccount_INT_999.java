package tests.ui;

import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.ui.CreateAccountPage;
import org.testng.Assert;

public class CreateAccount_INT_999 {

    @Test(description = "INT-999: Verify account creation process with valid and invalid inputs")
    @Description("To verify the account creation process with valid and invalid inputs. Account should be created successfully and confirmation message displayed.")
    @Severity(SeverityLevel.NORMAL)
    @Step("Steps: Fill create account form with valid & invalid data → Submit → Verify confirmation or error message")
    public void testCreateAccount_INT_999() {
        CreateAccountPage createAccountPage = page.getInstance(CreateAccountPage.class);

        // Valid account creation
        createAccountPage.clearAllFields();
        createAccountPage.typeFirstName("Test");
        createAccountPage.typeMiddleName("A");
        createAccountPage.typeLastName("User");
        createAccountPage.typeOrganization("TestOrg");
        String email = "testuser" + System.currentTimeMillis() + "@example.com";
        createAccountPage.typeEmail(email);
        createAccountPage.typePassword("Password123!");
        createAccountPage.typeConfirmPassword("Password123!");
        createAccountPage.clickCreateAccount();
        Assert.assertTrue(createAccountPage.isConfirmationMessageDisplayed(), "Confirmation message should be displayed after successful account creation.");

        // Invalid email scenario
        createAccountPage.clearAllFields();
        createAccountPage.submitWithInvalidEmail();
        Assert.assertTrue(createAccountPage.isInvalidEmailErrorDisplayed(), "Error message for invalid email should be displayed.");

        // Mismatched passwords scenario
        createAccountPage.clearAllFields();
        createAccountPage.submitWithMismatchedPasswords();
        Assert.assertTrue(createAccountPage.isPasswordMismatchErrorDisplayed(), "Error message for password mismatch should be displayed.");

        // Blank fields scenario
        createAccountPage.clearAllFields();
        createAccountPage.submitWithBlankFields();
        Assert.assertTrue(createAccountPage.isRequiredFieldsErrorDisplayed(), "Error message for required fields should be displayed.");
    }
}
