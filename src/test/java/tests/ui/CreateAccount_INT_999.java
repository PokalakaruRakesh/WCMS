package tests.ui;

import com.astm.commonFunctions.WCMSICommon;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
//import org.json.simple.JSONObject;
import base.utils.JsonFileReader;
import pages.ui.CreateAccountPage;
import tests.ui.base.BaseTest;

public class CreateAccount_INT_999 extends BaseTest {
    static final String jiraTestID = "INT_999";
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get("https://stage-store.astm.org/customer/account/create/?acc_class=b2c&acc_type=b2c");
    }
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that a user can create an account successfully and a confirmation message is displayed.")
    @Test(description = "INT-999: Verify account creation flow and confirmation message")
    public void testCreateAccount_INT_999() {
        try {
            // Load test data
            /*String testDataPath = "src/main/resources/Jsons/create-account-INT-999.json";
            JSONObject testData = JsonFileReader.getTestData(testDataPath, jiraTestID);

            // Extract explicit parameters from test data
            String firstName = (String) testData.get("firstName");
            String lastName = (String) testData.get("lastName");
            String middleName = (String) testData.get("middleName");
            String email = (String) testData.get("email");
            String password = (String) testData.get("password");
            String confirmPassword = (String) testData.get("confirmPassword");*/

            // Initialize Page Object
            CreateAccountPage createAccountPage = page.getInstance(CreateAccountPage.class);

            // Call the comprehensive flow method
            createAccountPage.completeCreateAccountFlow("test", "test", "test","Org","test@yopmail.com" ,"password@123", "password@123", true );

            // Assertion: Confirmation message should be displayed
            Assert.assertTrue(createAccountPage.isConfirmationMessageDisplayed(), "Account creation confirmation message was not displayed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
