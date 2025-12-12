package tests.ui;

import base.utils.ConfigReader;
import base.utils.JsonFileReader;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.ContactCreationPage;
import pages.ui.LoginPage;
import org.openqa.selenium.WebDriver;
import tests.ui.base.BaseTest;
import java.util.Map;
import java.util.List;

public class VerifyCreateNewContact_TC_N001 extends BaseTest {

    private static final String TEST_DATA_PATH = "src/main/resources/Jsons/TC-N001-data.json";
    private static final String LOGIN_DATA_PATH = "src/main/resources/Jsons/TC-N001-login-data.json";
    private JsonFileReader jsonFileReader;
    private ContactCreationPage contactCreationPage;
    private LoginPage loginPage;
    private String baseUrl;
    private Map<String, Object> loginData;
    private List<Map<String, Object>> contactDataList;
    private Map<String, String> validationMessages;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        try {
            baseUrl = ConfigReader.getProperty("url");
        } catch (Exception e) {
            baseUrl = null;
        }
        jsonFileReader = new JsonFileReader();
        // Load login data
        loginData = jsonFileReader.getJsonAsMap(LOGIN_DATA_PATH);
        // Load contact data
        Map<String, Object> testData = jsonFileReader.getJsonAsMap(TEST_DATA_PATH);
        contactDataList = (List<Map<String, Object>>) testData.get("contactData");
        validationMessages = (Map<String, String>) testData.get("validationMessages");
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        contactCreationPage = new ContactCreationPage(driver);
    }

    @Test(description = "TC-N001: Create a new contact - Verify system accepts valid inputs and displays appropriate message.")
    @Description("Verify system accepts valid inputs and displays appropriate message when creating a new contact.")
    @Severity(SeverityLevel.NORMAL)
    public void verifyCreateNewContact_TC_N001() {
        try {
            // Login
            String email = loginData.get("email").toString();
            String password = loginData.get("password").toString();
            loginPage.login(email, password);

            // For demonstration, use the first contactData (standard valid input)
            Map<String, Object> contact = contactDataList.get(0);
            String firstName = contact.get("firstName").toString();
            String lastName = contact.get("lastName").toString();
            String emailAddr = contact.get("email").toString();
            String emailType = "Personal"; // Or fetch from data if present
            String category = "Lead"; // Or fetch from data if present

            // Navigate to contact creation screen
            // Assuming navigation is handled inside the Page Object or after login
            // If not, add navigation code here as per repo pattern

            contactCreationPage.createNewContact(firstName, lastName, emailAddr, emailType, category);

            // Assert success message
            boolean isSuccess = contactCreationPage.isSuccessMessageDisplayed();
            String expectedMsg = validationMessages.get("success");
            Assert.assertTrue(isSuccess, "Expected success message: '" + expectedMsg + "' but it was not displayed.");
        } catch (Exception e) {
            Assert.fail("Test failed due to exception: " + e.getMessage(), e);
        }
    }
}
