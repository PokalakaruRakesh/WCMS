package tests.ui.WCMS;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONObject;
import base.utils.JsonFileReader;
import tests.ui.base.BaseTest;
import pages.ui.CreateAccountPage;

public class CreateAccount_INT_999 extends BaseTest {

    @Test(description = "INT-999: Create account - Test the account creation process with various valid and invalid inputs")
    @Description("Test the account creation process with various valid and invalid inputs. Account should be created successfully and confirmation message displayed.")
    @Severity(SeverityLevel.NORMAL)
    public void testCreateAccount_INT_999() {
        try {
            // Load test data for INT-999
            String testDataPath = "src/main/resources/Jsons/create-account-INT-999.json";
            JSONObject testData = JsonFileReader.getTestData(testDataPath, "INT-999");

            // Extract required parameters explicitly
            String firstName = (String) testData.get("firstName");
            String lastName = (String) testData.get("lastName");
            String email = (String) testData.get("email");
            String password = (String) testData.get("password");
            String confirmPassword = (String) testData.get("confirmPassword");

            // Get instance of CreateAccountPage
            CreateAccountPage createAccountPage = page.getInstance(CreateAccountPage.class);

            // Use comprehensive method for account creation
            createAccountPage.completeCreateAccountFlow_INT_999(firstName, lastName, email, password, confirmPassword);

            // Assert confirmation message is displayed
            Assert.assertTrue(createAccountPage.isConfirmationMessageDisplayed(), "Account confirmation message was not displayed!");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during account creation test: " + e.getMessage());
        }
    }
}
