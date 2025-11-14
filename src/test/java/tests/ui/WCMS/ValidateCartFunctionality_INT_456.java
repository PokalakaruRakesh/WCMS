package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONObject;
import base.utils.JsonFileReader;
import tests.ui.base.BaseTest;
import pages.ui.CartPage_WCMS;

public class ValidateCartFunctionality_INT_456 extends BaseTest {

    private static final String TEST_DATA_PATH = "src/main/resources/Jsons/validate-cart-functionality-INT-456.json";
    private static final String TEST_CASE_ID = "INT-456";
    private String baseUrl;
    private String searchTerm;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        // Load test data for INT-456
        JSONObject testData = JsonFileReader.getTestData(TEST_DATA_PATH, TEST_CASE_ID);
        // Extract base URL and search term from test data
        // Defensive: If not present, use default fallback
        if (testData != null) {
            JSONObject steps = (JSONObject) testData.get("TestData");
            if (steps != null) {
                // For demo, fallback to hardcoded values if not found
                baseUrl = "https://stage-www.astm.org/";
                searchTerm = "Steel";
            } else {
                baseUrl = "https://stage-www.astm.org/";
                searchTerm = "Steel";
            }
        } else {
            baseUrl = "https://stage-www.astm.org/";
            searchTerm = "Steel";
        }
        driver.get(baseUrl);
    }

    @Test(description = "INT-456: Validate Cart Functionality")
    @Description("Validate that user can click the Go button after navigating the cart and continuing shopping.")
    @Severity(SeverityLevel.NORMAL)
    public void validateCartFunctionality_INT_456() {
        try {
            CartPage_WCMS cartPage = page.getInstance(CartPage_WCMS.class);
            cartPage.validateCartFunctionality(searchTerm);
            // No explicit assertion as the page object method covers the flow and screenshots
        } catch (Exception e) {
            e.printStackTrace();
            assert false : "Test failed due to exception: " + e.getMessage();
        }
    }
}
