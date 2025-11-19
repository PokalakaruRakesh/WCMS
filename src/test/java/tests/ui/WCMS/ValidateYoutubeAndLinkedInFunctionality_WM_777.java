package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import base.utils.JsonFileReader;
import org.json.simple.JSONObject;
import tests.ui.base.BaseTest;
import pages.ui.FooterSectionPage;

public class ValidateYoutubeAndLinkedInFunctionality_WM_777 extends BaseTest {

    private String testDataPath = "src/main/resources/Jsons/validate-youtube-and-linkedin-functionality-WM-777.json";
    private String baseUrl;
    private String expectedYouTubeUrl;
    private String expectedLinkedInUrl;
    private String expectedLinkedInTitleSubstring;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        // Load test data for WM-777
        JSONObject testData = JsonFileReader.getTestData(testDataPath, "WM-777");
        if (testData != null) {
            // Extract values explicitly as per Rule A
            baseUrl = "https://la.astm.org/standards/iec/";
            expectedYouTubeUrl = "https://www.youtube.com/ASTMIntl";
            expectedLinkedInUrl = "https://www.linkedin.com/company/astm-international";
            expectedLinkedInTitleSubstring = "ASTM International";
        }
    }

    @Test(description = "WM-777: Validate Youtube and LinkedIn Functionality in footer")
    @Description("Validate that YouTube and LinkedIn icons in the footer open correct company pages in new tabs and LinkedIn loads with company information and posts.")
    @Severity(SeverityLevel.NORMAL)
    public void validateYoutubeAndLinkedInFooterLinks_WM_777() {
        try {
            // Navigate to the base URL
            driver.get(baseUrl);
            FooterSectionPage footerSectionPage = page.getInstance(FooterSectionPage.class);
            boolean result = footerSectionPage.validateYouTubeAndLinkedInFooterLinks(
                expectedYouTubeUrl,
                expectedLinkedInUrl,
                expectedLinkedInTitleSubstring
            );
            Assert.assertTrue(result, "YouTube and/or LinkedIn footer links validation failed.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during YouTube and LinkedIn footer validation: " + e.getMessage());
        }
    }
}
