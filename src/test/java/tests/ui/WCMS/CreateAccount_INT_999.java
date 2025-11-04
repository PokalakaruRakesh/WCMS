package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import pages.ui.CreateAccountPage;
import src.main.java.base.utils.JsonFileReader;
import org.json.simple.JSONObject;
import tests.ui.base.BaseTest;

public class CreateAccount_INT_999 extends BaseTest {

    private CreateAccountPage createAccountPage;
    private static final String TEST_DATA_PATH = "src/main/resources/Jsons/create-account-INT-999.json";

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        // No URL provided in test data, so nothing to navigate here
    }

    @Test(description = "INT-999: Test the account creation process with valid and invalid inputs.")
    @Description("Test the account creation process with valid and invalid inputs. Account should be created successfully and confirmation message displayed.")
    @Severity(SeverityLevel.NORMAL)
    public void testCreateAccount_INT_999() {
        try {
            createAccountPage = page.getInstance(CreateAccountPage.class);
            // Load test data for INT-999
            JSONObject testData = JsonFileReader.getTestData(TEST_DATA_PATH, "INT-999");

            // Extract explicit parameters from test data
            String firstName = (String) testData.get("firstName");
            String middleInitial = (String) testData.get("middleInitial");
            String lastName = (String) testData.get("lastName");
            String email = (String) testData.get("email");
            String password = (String) testData.get("password");
            String confirmPassword = (String) testData.get("confirmPassword");
            String phone = (String) testData.get("phone");
            String company = (String) testData.get("company");
            String address = (String) testData.get("address");
            String city = (String) testData.get("city");
            String state = (String) testData.get("state");
            String zip = (String) testData.get("zip");
            String country = (String) testData.get("country");
            // Add more fields as required by the page object method signature

            // Use comprehensive method for create account flow
            createAccountPage.completeCreateAccountFlow(
                firstName,
                middleInitial,
                lastName,
                email,
                password,
                confirmPassword,
                phone,
                company,
                address,
                city,
                state,
                zip,
                country
                // Add more params if required by the method
            );

            Assert.assertTrue(createAccountPage.isConfirmationMessageDisplayed(), "Account creation confirmation message was not displayed.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during Create Account test: " + e.getMessage());
        }
    }
}
