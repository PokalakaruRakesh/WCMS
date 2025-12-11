package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.JsonFileReader;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ui.ContactCreationPage;
import tests.ui.base.BaseTest;

public class InvalidEmailFormatRejection_TC_N002 extends BaseTest {

    private static final String TEST_DATA_PATH = "src/test/resources/testdata/TC-N002-data.json";
    private static final String LOGIN_DATA_PATH = "src/test/resources/Jsons/TC-N001-login-data.json";

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        try {
            String url = ConfigReader.getProperty("url");
            driver.get(url);
            // Perform login as precondition
            JSONObject loginData = JsonFileReader.getTestData(LOGIN_DATA_PATH, "validLogin");
            String email = (String) loginData.get("email");
            String password = (String) loginData.get("password");
            LoginPage loginPage = page.getInstance(LoginPage.class);
            loginPage.login(email, password);
            // Navigate to contact creation screen
            // Assumes navigation via Contacts link and Create button
            // If navigation is more complex, update accordingly
            // (No direct navigation method in provided context)
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "invalidEmailData")
    public Object[][] invalidEmailData() {
        JSONArray testDataArr = JsonFileReader.getTestDataArray(TEST_DATA_PATH, "testData");
        Object[][] data = new Object[testDataArr.size()][3];
        for (int i = 0; i < testDataArr.size(); i++) {
            JSONObject obj = (JSONObject) testDataArr.get(i);
            data[i][0] = obj.get("scenario");
            data[i][1] = obj.get("email");
            data[i][2] = obj.get("expectedError");
        }
        return data;
    }

    @Test(dataProvider = "invalidEmailData", description = "TC-N002: Invalid Email Format Rejection")
    @Description("Verify system rejects invalid email formats and displays appropriate error message.")
    @Severity(SeverityLevel.NORMAL)
    public void testInvalidEmailFormatRejection(String scenario, String invalidEmail, String expectedError) {
        try {
            ContactCreationPage contactCreationPage = page.getInstance(ContactCreationPage.class);
            // Use sample valid data for required fields (as test data does not provide these)
            String firstName = "TestFirst";
            String lastName = "TestLast";
            String company = "TestCompany";
            String position = "TestPosition";
            String emailType = "Personal";
            boolean errorShown = contactCreationPage.createContactWithInvalidEmailAndVerifyError(
                firstName, lastName, company, position, invalidEmail, emailType
            );
            Assert.assertTrue(errorShown, "[" + scenario + "] Expected error message for invalid email was not displayed.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
