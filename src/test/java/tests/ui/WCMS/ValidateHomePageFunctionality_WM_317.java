package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.ui.HomePage_WCMS;
import tests.ui.base.BaseTest;

public class ValidateHomePageFunctionality_WM_317 extends BaseTest {

    private HomePage_WCMS homePageWCMS;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        // No explicit URL in test data, so use default base URL if configured in BaseTest
        // If required, uncomment and set URL: driver.get("https://qa-regional.astm.org/");
    }

    @Test(description = "WM-317: Validate Home Page Functionality - Verify all buttons and links are working correctly")
    @Description("WM-317: User should be able to verify that all buttons and links on the page are working correctly.")
    @Severity(SeverityLevel.NORMAL)
    public void validateHomePageFunctionality_WM_317() {
        try {
            homePageWCMS = page.getInstance(HomePage_WCMS.class);
            // Call the comprehensive method that validates all main buttons and links
            homePageWCMS.validateAllHomePageButtonsAndLinks();
            // Optionally, add assertions here if the Page Object exposes verification methods/results
        } catch (Exception e) {
            e.printStackTrace();
            assert false : "Exception occurred during Home Page Functionality validation: " + e.getMessage();
        }
    }
}
