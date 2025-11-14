package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONObject;
import base.utils.JsonFileReader;
import pages.ui.CartPage_WCMS;

public class ValidateLoginAndCartFunctionality_INT_765 {

    private String testDataPath = "src/main/resources/Jsons/validate-login-and-cart-functionality-INT-765.json";
    private JSONObject testData;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        // Load test data for INT-765
        testData = JsonFileReader.getTestData(testDataPath, "INT-765");
        // No URL navigation here, assumed handled by base or test runner
    }

    @Test(description = "INT-765: Validate login and cart Functionality")
    @Description("Validate that user can login, access cart, continue shopping, search and click Go button successfully.")
    @Severity(SeverityLevel.NORMAL)
    public void validateLoginAndCartFunctionality() {
        try {
            CartPage_WCMS cartPage = page.getInstance(CartPage_WCMS.class);

            // Extract test data values explicitly
            String username = (String) ((JSONObject) ((org.json.simple.JSONArray) testData.get("TestData")).get(0)).get("username");
            String password = (String) ((JSONObject) ((org.json.simple.JSONArray) testData.get("TestData")).get(0)).get("password");
            String searchTerm = "Steel"; // As per test step 9 and example

            // Call the comprehensive method as per Page Object grouping rule
            cartPage.completeLoginAndCartFlow(username, password, searchTerm);

            // No explicit assertion here as the method throws on failure; add assertion if needed
        } catch (Exception e) {
            e.printStackTrace();
            assert false : "Test failed due to exception: " + e.getMessage();
        }
    }
}
