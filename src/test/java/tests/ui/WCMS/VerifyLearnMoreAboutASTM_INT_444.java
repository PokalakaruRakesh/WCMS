package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.json.simple.JSONObject;
import src.main.java.base.utils.JsonFileReader;
import pages.ui.AboutPage;
import tests.ui.base.BaseTest;

public class VerifyLearnMoreAboutASTM_INT_444 extends BaseTest {

    private AboutPage aboutPage;
    private static final String TEST_DATA_PATH = "src/main/resources/Jsons/learn-more-about-astm-INT-444.json";

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        // No URL provided in test data, so nothing to navigate here
    }

    @Test(description = "INT-444: Learn More About ASTM - Verify Global ASTM Standards listed under About ASTM Overview header")
    @Description("Verify that the user can see Global ASTM Standards listed under the About ASTM Overview header after clicking 'Learn More About ASTM'.")
    @Severity(SeverityLevel.NORMAL)
    public void verifyLearnMoreAboutASTM() {
        try {
            aboutPage = page.getInstance(AboutPage.class);
            // Load test data (not strictly needed, but for future extensibility)
            JSONObject testData = JsonFileReader.getTestData(TEST_DATA_PATH, "INT-444");
            // Comprehensive method for the scenario
            aboutPage.completeLearnMoreAboutASTMFlow();
            Assert.assertTrue(aboutPage.isGlobalASTMStandardsListed(), "Global ASTM Standards are not listed under the About ASTM Overview header.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
