package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.ui.HeaderComponentPage;
import base.utils.JsonFileReader;
import org.json.simple.JSONObject;
import tests.ui.base.BaseTest;

public class ValidateHeaderComponents_INT_124 extends BaseTest {

    private String baseUrl;
    private static final String TEST_DATA_PATH = "src/main/resources/Jsons/validate-header-components-INT-124.json";

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        // Load base URL from test data
        JSONObject testData = JsonFileReader.getTestData(TEST_DATA_PATH, "INT-124");
        if (testData != null && testData.containsKey("TestData")) {
            Object[] testDataArr = ((org.json.simple.JSONArray) testData.get("TestData")).toArray();
            for (Object obj : testDataArr) {
                JSONObject scenario = (JSONObject) obj;
                if (scenario.containsKey("scenario") && scenario.get("scenario").toString().toLowerCase().contains("header menu")) {
                    // Use URL from test data if present
                    baseUrl = "https://stage-www.astm.org/";
                    break;
                }
            }
        } else {
            baseUrl = "https://stage-www.astm.org/"; // fallback
        }
        driver.get(baseUrl);
    }

    @Test(description = "INT-124: Validate header components are visible and correct")
    @Description("User should be able to see the header components successfully as per INT-124")
    @Severity(SeverityLevel.NORMAL)
    public void validateHeaderComponents_INT_124() {
        try {
            HeaderComponentPage headerComponentPage = page.getInstance(HeaderComponentPage.class);
            headerComponentPage.validateHeaderComponents();
            // If no exception, test passes
            Assert.assertTrue(true, "Header components are visible and correct as per INT-124");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred while validating header components: " + e.getMessage());
        }
    }
}
