package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.ui.IECStandardsPage;
import tests.ui.base.BaseTest;

public class ValidateYoutubeAndLinkedInFunctionality_WM_333 extends BaseTest {

    private IECStandardsPage iecStandardsPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        // No login or special precondition required for this test case
        // Navigation will be handled in the test itself
    }

    @Test(description = "WM-333: Validate Youtube and LinkedIn Functionality on IEC Standards page")
    @Description("Validate that the IEC Standards page displays all required headers, buttons, and links in correct order and functionality as per WM-333.")
    @Severity(SeverityLevel.NORMAL)
    public void validateYoutubeAndLinkedInFunctionality_WM_333() {
        try {
            iecStandardsPage = page.getInstance(IECStandardsPage.class);
            // Navigate to IEC Standards page via main menu
            iecStandardsPage.navigateToIECStandardsPage();
            // Validate all headers, buttons, and links as per the test case
            iecStandardsPage.validateIECStandardsPageContent();
        } catch (Exception e) {
            e.printStackTrace();
            assert false : "Test failed due to exception: " + e.getMessage();
        }
    }
}
