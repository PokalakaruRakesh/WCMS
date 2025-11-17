package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import tests.ui.base.BaseTest;
import pages.ui.HomePage_WCMS;

public class ValidateHomePageFunctionality_WM_317 extends BaseTest {

    private static final String TEST_DATA_PATH = "src/main/resources/Jsons/validate-home-page-functionality-WM-317.json";
    private JSONObject testData;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        // Load test data for WM-317
        try {
            JSONParser parser = new JSONParser();
            JSONObject allData = (JSONObject) parser.parse(new FileReader(TEST_DATA_PATH));
            testData = (JSONObject) allData.get("WM-317");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load test data for WM-317");
        }
        // No URL provided in test data, so assuming navigation is handled in BaseTest or via test step
    }

    @Test(description = "WM-317: Validate Home Page Functionality - Verify all buttons and links on the home page are working correctly.")
    @Description("WM-317: User should be able to verify that all buttons and links on the page are working correctly.")
    @Severity(SeverityLevel.NORMAL)
    @Step("Validate all buttons and links on the Home Page")
    public void validateHomePageFunctionality_WM_317() {
        try {
            HomePage_WCMS homePage = page.getInstance(HomePage_WCMS.class);
            // Comprehensive method call as per Page Object best practice
            homePage.validateAllHomePageButtonsAndLinks();
            // No further assertions here as the method is expected to throw if any navigation fails
        } catch (Exception e) {
            e.printStackTrace();
            assert false : "Exception occurred during home page functionality validation: " + e.getMessage();
        }
    }
}
