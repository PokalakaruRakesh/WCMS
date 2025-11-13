package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONObject;
import base.utils.JsonFileReader;
import tests.ui.base.BaseTest;
import pages.ui.HeaderFooterComponentPage;

public class ValidateHeaderAndFooterComponents_INT_111 extends BaseTest {

    private static final String TEST_DATA_PATH = "src/main/resources/Jsons/validate-header-and-footer-components-INT-111.json";
    private static final String TEST_CASE_ID = "INT-111";
    private String baseUrl;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        try {
            JSONObject testData = JsonFileReader.getTestData(TEST_DATA_PATH, TEST_CASE_ID);
            // Extract URL from test data
            JSONObject urlObject = (JSONObject) testData.get("TestData");
            if (urlObject != null && urlObject instanceof org.json.simple.JSONArray) {
                org.json.simple.JSONArray arr = (org.json.simple.JSONArray) urlObject;
                if (!arr.isEmpty() && arr.get(0) instanceof JSONObject) {
                    JSONObject scenarioObj = (JSONObject) arr.get(0);
                    baseUrl = (String) scenarioObj.getOrDefault("URL", "https://stage-www.astm.org/");
                } else {
                    baseUrl = "https://stage-www.astm.org/";
                }
            } else {
                baseUrl = "https://stage-www.astm.org/";
            }
            driver.get(baseUrl);
        } catch (Exception e) {
            baseUrl = "https://stage-www.astm.org/";
            driver.get(baseUrl);
        }
    }

    @Test(description = "INT-111: Validate header and footer components are visible and correct")
    @Description("User should be able to see the header and footer components successfully.")
    @Severity(SeverityLevel.NORMAL)
    public void validateHeaderAndFooterComponents_INT_111() {
        try {
            HeaderFooterComponentPage headerFooterComponentPage = page.getInstance(HeaderFooterComponentPage.class);
            headerFooterComponentPage.validateHeaderAndFooterComponents();
        } catch (Exception e) {
            e.printStackTrace();
            assert false : "Test failed due to exception: " + e.getMessage();
        }
    }
}
