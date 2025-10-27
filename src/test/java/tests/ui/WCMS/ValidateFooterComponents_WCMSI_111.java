package tests.ui.WCMS;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.HomePage_WCMS;
import pages.ui.CommonPage_WCMS;
import com.astm.commonFunctions.Common;

public class ValidateFooterComponents_WCMSI_111 extends tests.ui.base.BaseTest {
    private HomePage_WCMS homePage;
    private CommonPage_WCMS commonPage;

    @BeforeMethod
    public void setUpPages() {
        homePage = page.getInstance(HomePage_WCMS.class);
        commonPage = page.getInstance(CommonPage_WCMS.class);
    }

    @Test(description = "INT-111: Validate footer components are visible and correct")
    @Description("Test Case INT-111: User should be able to see the footer components successfully.")
    @Severity(SeverityLevel.NORMAL)
    public void testValidateFooterComponents_WCMSI_111() {
        stepNavigateToHomePage();
        stepVerifyFooterIsVisible();
        stepVerifyFooterComponent1();
        stepVerifyFooterComponent2();
        stepVerifyFooterComponent3();
        stepVerifyFooterComponent4();
        stepVerifyFooterComponent5();
    }

    @Step("Navigate to Home Page")
    public void stepNavigateToHomePage() {
        try {
            homePage.navigateToHomePage();
            Common.reportPass("Navigated to Home Page successfully");
        } catch (Exception e) {
            Common.reportFailAssert("Failed to navigate to Home Page: " + e.getMessage());
        }
    }

    @Step("Verify footer is visible on the page")
    public void stepVerifyFooterIsVisible() {
        try {
            Assert.assertTrue(commonPage.isFooterVisible(), "Footer should be visible on the page");
            Common.reportPass("Footer is visible on the page");
        } catch (AssertionError | Exception e) {
            Common.reportFailAssert("Footer visibility verification failed: " + e.getMessage());
        }
    }

    @Step("Verify Footer Component 1 is present and correct")
    public void stepVerifyFooterComponent1() {
        try {
            Assert.assertTrue(commonPage.isFooterComponent1Present(), "Footer Component 1 should be present");
            Common.reportPass("Footer Component 1 is present and correct");
        } catch (AssertionError | Exception e) {
            Common.reportFailAssert("Footer Component 1 verification failed: " + e.getMessage());
        }
    }

    @Step("Verify Footer Component 2 is present and correct")
    public void stepVerifyFooterComponent2() {
        try {
            Assert.assertTrue(commonPage.isFooterComponent2Present(), "Footer Component 2 should be present");
            Common.reportPass("Footer Component 2 is present and correct");
        } catch (AssertionError | Exception e) {
            Common.reportFailAssert("Footer Component 2 verification failed: " + e.getMessage());
        }
    }

    @Step("Verify Footer Component 3 is present and correct")
    public void stepVerifyFooterComponent3() {
        try {
            Assert.assertTrue(commonPage.isFooterComponent3Present(), "Footer Component 3 should be present");
            Common.reportPass("Footer Component 3 is present and correct");
        } catch (AssertionError | Exception e) {
            Common.reportFailAssert("Footer Component 3 verification failed: " + e.getMessage());
        }
    }

    @Step("Verify Footer Component 4 is present and correct")
    public void stepVerifyFooterComponent4() {
        try {
            Assert.assertTrue(commonPage.isFooterComponent4Present(), "Footer Component 4 should be present");
            Common.reportPass("Footer Component 4 is present and correct");
        } catch (AssertionError | Exception e) {
            Common.reportFailAssert("Footer Component 4 verification failed: " + e.getMessage());
        }
    }

    @Step("Verify Footer Component 5 is present and correct")
    public void stepVerifyFooterComponent5() {
        try {
            Assert.assertTrue(commonPage.isFooterComponent5Present(), "Footer Component 5 should be present");
            Common.reportPass("Footer Component 5 is present and correct");
        } catch (AssertionError | Exception e) {
            Common.reportFailAssert("Footer Component 5 verification failed: " + e.getMessage());
        }
    }
}
