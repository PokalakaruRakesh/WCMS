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
    public void setUp() {
        // Load base URL from test data
        JSONObject testData = JsonFileReader.getTestData(TEST_DATA_PATH, TEST_CASE_ID);
        if (testData != null && testData.containsKey("TestData")) {
            JSONObject firstScenario = null;
            try {
                firstScenario = (JSONObject) ((org.json.simple.JSONArray) testData.get("TestData")).get(0);
            } catch (Exception ignored) {}
            if (firstScenario != null && firstScenario.containsKey("baseUrl")) {
                baseUrl = (String) firstScenario.get("baseUrl");
            } else {
                // Fallback to hardcoded URL if not present in scenario
                baseUrl = "https://stage-www.astm.org/";
            }
        } else {
            baseUrl = "https://stage-www.astm.org/";
        }
        driver.get(baseUrl);
    }

    @Test(description = "INT-111: Validate header and footer components on ASTM homepage")
    @Description("Validate that the header and footer components are displayed correctly on the ASTM homepage as per INT-111.")
    @Severity(SeverityLevel.NORMAL)
    public void validateHeaderAndFooterComponents_INT_111() {
        try {
            HeaderFooterComponentPage headerFooterComponentPage = page.getInstance(HeaderFooterComponentPage.class);
            headerFooterComponentPage.validateHeaderAndFooterComponents();
            // No explicit assertions here since the Page Object method should throw if any element is missing
        } catch (Exception e) {
            e.printStackTrace();
            assert false : "Exception occurred during header and footer validation: " + e.getMessage();
        }
    }
}
