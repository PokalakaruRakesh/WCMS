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

public class ValidateFooterComponents_INT_002 extends tests.ui.base.BaseTest {
    private HomePage_WCMS homePage;
    private CommonPage_WCMS commonPage;

    @BeforeMethod
    public void setUpPages() {
        homePage = page.getInstance(HomePage_WCMS.class);
        commonPage = page.getInstance(CommonPage_WCMS.class);
    }

    @Test(description = "INT-002: Validate Footer components are visible and functional")
    @Description("INT-002: User should be able to see the footer components successfully.")
    @Severity(SeverityLevel.NORMAL)
    public void testValidateFooterComponents_INT_002() {
        stepNavigateToHomePage();
        stepVerifyFooterIsVisible();
        stepVerifyFooterLinks();
        stepVerifyFooterCopyright();
        stepVerifyFooterSocialIcons();
        stepVerifyFooterContactInfo();
    }

    @Step("Navigate to Home Page")
    public void stepNavigateToHomePage() {
        try {
            homePage.navigateToHomePage();
            Common.reportPass("Navigated to Home Page successfully.");
        } catch (Exception e) {
            Common.reportFailAssert("Failed to navigate to Home Page: " + e.getMessage());
        }
    }

    @Step("Verify Footer is visible on the page")
    public void stepVerifyFooterIsVisible() {
        try {
            Assert.assertTrue(homePage.isFooterVisible(), "Footer should be visible on the Home Page");
            Common.reportPass("Footer is visible on the Home Page.");
        } catch (AssertionError | Exception e) {
            Common.reportFailAssert("Footer visibility check failed: " + e.getMessage());
        }
    }

    @Step("Verify all expected footer links are present and clickable")
    public void stepVerifyFooterLinks() {
        try {
            Assert.assertTrue(homePage.areFooterLinksPresentAndClickable(), "All expected footer links should be present and clickable");
            Common.reportPass("All expected footer links are present and clickable.");
        } catch (AssertionError | Exception e) {
            Common.reportFailAssert("Footer links check failed: " + e.getMessage());
        }
    }

    @Step("Verify footer copyright information is displayed")
    public void stepVerifyFooterCopyright() {
        try {
            Assert.assertTrue(homePage.isFooterCopyrightDisplayed(), "Footer copyright should be displayed");
            Common.reportPass("Footer copyright is displayed.");
        } catch (AssertionError | Exception e) {
            Common.reportFailAssert("Footer copyright check failed: " + e.getMessage());
        }
    }

    @Step("Verify footer social icons are visible and functional")
    public void stepVerifyFooterSocialIcons() {
        try {
            Assert.assertTrue(homePage.areFooterSocialIconsVisibleAndFunctional(), "Footer social icons should be visible and functional");
            Common.reportPass("Footer social icons are visible and functional.");
        } catch (AssertionError | Exception e) {
            Common.reportFailAssert("Footer social icons check failed: " + e.getMessage());
        }
    }

    @Step("Verify footer contact information is displayed correctly")
    public void stepVerifyFooterContactInfo() {
        try {
            Assert.assertTrue(homePage.isFooterContactInfoDisplayed(), "Footer contact information should be displayed correctly");
            Common.reportPass("Footer contact information is displayed correctly.");
        } catch (AssertionError | Exception e) {
            Common.reportFailAssert("Footer contact information check failed: " + e.getMessage());
        }
    }
}
