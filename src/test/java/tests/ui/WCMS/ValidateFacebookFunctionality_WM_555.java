package tests.ui.WCMS;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.ui.FooterSectionPage;
import base.utils.JsonFileReader;
import org.json.simple.JSONObject;
import tests.ui.base.BaseTest;

public class ValidateFacebookFunctionality_WM_555 extends BaseTest {

    private String testDataPath = "src/main/resources/Jsons/validate-facebook-functionality-WM-555.json";
    private String baseUrl;
    private String expectedFacebookUrl;
    private String expectedTitleSubstring;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        // Load test data
        JSONObject testData = JsonFileReader.getTestData(testDataPath, "WM-555");
        // Extract base URL and Facebook URL from test data
        // Fallbacks if keys are missing
        baseUrl = "https://la.astm.org/standards/iec/";
        expectedFacebookUrl = "https://www.facebook.com/ASTMInternational";
        expectedTitleSubstring = "ASTM International";
        if (testData != null) {
            Object scenarios = testData.get("TestData");
            if (scenarios instanceof org.json.simple.JSONArray) {
                org.json.simple.JSONArray arr = (org.json.simple.JSONArray) scenarios;
                for (Object obj : arr) {
                    JSONObject scenario = (JSONObject) obj;
                    if (scenario.containsKey("expectedUrl")) {
                        String url = (String) scenario.get("expectedUrl");
                        if (url != null && url.contains("facebook.com")) {
                            expectedFacebookUrl = url.replace("/YourCompanyPage", "/ASTMInternational");
                        }
                    }
                    if (scenario.containsKey("expectedCompanyName")) {
                        expectedTitleSubstring = (String) scenario.get("expectedCompanyName");
                    }
                }
            }
        }
    }

    @Test(description = "WM-555: Validate facebook Functionality - Footer Facebook link opens correct company profile page")
    @Description("Validate that the Facebook icon/link in the footer of the IEC Standards page opens the correct company Facebook profile in a new tab and loads successfully.")
    @Severity(SeverityLevel.NORMAL)
    public void validateFacebookFooterFunctionality_WM_555() {
        try {
            // Navigate to the IEC Standards page
            driver.get(baseUrl);
            FooterSectionPage footerSectionPage = page.getInstance(FooterSectionPage.class);
            boolean isFacebookFooterValid = footerSectionPage.validateFacebookFooterLink(
                expectedFacebookUrl,
                expectedTitleSubstring
            );
            Assert.assertTrue(isFacebookFooterValid, "Facebook footer link did not open the correct company profile page or page did not load as expected.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during Facebook footer functionality validation: " + e.getMessage());
        }
    }
}
