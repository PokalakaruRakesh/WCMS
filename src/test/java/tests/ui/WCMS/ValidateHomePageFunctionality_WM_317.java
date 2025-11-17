package tests.ui.WCMS;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.HomePage_WCMS;
import pages.ui.HomePage_WCMS.LinkValidationData;
import tests.ui.base.BaseTest;
import base.utils.JsonFileReader;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;

public class ValidateHomePageFunctionality_WM_317 extends BaseTest {

    private static final String TEST_DATA_PATH = "src/main/resources/Jsons/validate-home-page-functionality-WM-317.json";
    private static final String TEST_CASE_ID = "WM-317";
    private List<LinkValidationData> linkValidationDataList;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        // Load and parse test data before each test
        linkValidationDataList = new ArrayList<>();
        try {
            JSONObject testData = JsonFileReader.getTestData(TEST_DATA_PATH, TEST_CASE_ID);
            JSONArray testDataArray = testData.getJSONArray("TestData");
            for (int i = 0; i < testDataArray.length(); i++) {
                JSONObject item = testDataArray.getJSONObject(i);
                String linkText = item.optString("linkText", "");
                String buttonText = item.optString("buttonText", "");
                String expectedUrl = item.optString("expectedUrl", "");
                String element = item.optString("element", "");
                boolean isVisible = item.optBoolean("isVisible", true);
                // Determine locator based on linkText or buttonText
                By locator = null;
                String elementName = linkText.isEmpty() ? buttonText : linkText;
                boolean opensInNewTab = false;
                // For demonstration, use linkText to build locator; in real code, use robust locator strategy
                if (!linkText.isEmpty()) {
                    locator = By.linkText(linkText);
                } else if (!buttonText.isEmpty()) {
                    locator = By.linkText(buttonText);
                } else {
                    // fallback if both are empty
                    continue;
                }
                // Heuristic: if expectedUrl starts with http and not the base domain, open in new tab
                if (expectedUrl.startsWith("http") && !expectedUrl.contains("qa-regional.astm.org")) {
                    opensInNewTab = true;
                }
                linkValidationDataList.add(new LinkValidationData(locator, expectedUrl, "", elementName, opensInNewTab));
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load test data for WM-317: " + e.getMessage(), e);
        }
    }

    @Test(description = "WM-317: Validate Home Page Functionality - All links and buttons are accessible and working")
    @Description("Validate the functionality and accessibility of all links and buttons on the home page. All links should be verified and confirmed to be working correctly.")
    @Severity(SeverityLevel.NORMAL)
    public void validateHomePageFunctionality_WM_317() {
        try {
            HomePage_WCMS homePage = page.getInstance(HomePage_WCMS.class);
            // Use the comprehensive method from the Page Object
            homePage.validateAllHomePageLinksAndButtons(linkValidationDataList);
        } catch (Exception e) {
            e.printStackTrace();
            assert false : "Test failed due to exception: " + e.getMessage();
        }
    }
}
