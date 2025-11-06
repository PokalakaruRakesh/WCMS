package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import org.testng.Assert;
import base.utils.JsonFileReader;
import tests.ui.base.BaseTest;
import pages.ui.SearchPage;

public class VerifySearchFunctionality_INT_666 extends BaseTest {

    private final String testDataPath = "src/main/resources/Jsons/verify-search-functionality-INT-666.json";
    private JSONObject testData;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        // Load test data for INT-666
        testData = JsonFileReader.getTestData(testDataPath, "INT-666");
    }

    @Test(description = "INT-666: Verify Search functionality displays results related to 'Standards'")
    @Description("Verify Search functionality: Search results related to 'Standards' should be displayed.")
    @Severity(SeverityLevel.NORMAL)
    @Step("INT-666: Verify Search functionality")
    public void verifySearchFunctionality_INT_666() {
        try {
            SearchPage searchPage = page.getInstance(SearchPage.class);

            // Extract search keyword from test data or use default if not present
            String searchKeyword = testData != null && testData.get("searchKeyword") != null
                ? (String) testData.get("searchKeyword")
                : "Standards";

            boolean result = searchPage.performSearchAndVerifyResults(searchKeyword);
            Assert.assertTrue(result, "Search results related to 'Standards' were not displayed as expected.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during search functionality test: " + e.getMessage());
        }
    }
}
