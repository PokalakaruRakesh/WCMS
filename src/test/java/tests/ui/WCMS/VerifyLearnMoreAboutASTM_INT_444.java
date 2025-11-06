package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.ui.AboutPage;
import tests.ui.base.BaseTest;
import org.testng.Assert;

public class VerifyLearnMoreAboutASTM_INT_444 extends BaseTest {

    private AboutPage aboutPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        // No specific URL or login precondition for this test case
        // If required, navigation to home page can be added here
    }

    @Test(description = "INT-444: Learn More About ASTM - Verify Global ASTM Standards listed under About ASTM Overview header")
    @Description("Verify that the user can see Global ASTM Standards listed under the About ASTM Overview header after clicking 'Learn More About ASTM'.")
    @Severity(SeverityLevel.NORMAL)
    public void testLearnMoreAboutASTM_INT_444() {
        try {
            aboutPage = page.getInstance(AboutPage.class);
            // Use the comprehensive method for the scenario
            boolean isGlobalASTMStandardsVisible = aboutPage.completeLearnMoreAboutASTMFlow();
            Assert.assertTrue(isGlobalASTMStandardsVisible, "Global ASTM Standards are not visible under the About ASTM Overview header.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred in testLearnMoreAboutASTM_INT_444: " + e.getMessage());
        }
    }
}
