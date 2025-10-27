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
import base.utils.PublicCommon;
import tests.ui.base.BaseTest;

public class ValidateFooterComponents_WCMSI_111 extends BaseTest {

    private HomePage_WCMS homePage;
    private CommonPage_WCMS commonPage;

    @BeforeMethod(alwaysRun = true)
    public void setUpPages() {
        homePage = page.getInstance(HomePage_WCMS.class);
        commonPage = page.getInstance(CommonPage_WCMS.class);
    }

    @Test(description = "INT-111: Validate footer components are visible and correct")
    @Description("Test Case INT-111: User should be able to see the footer components successfully")
    @Severity(SeverityLevel.NORMAL)
    public void testValidateFooterComponents_WCMSI_111() {
        stepNavigateToHomePage();
        stepValidateFooterIsDisplayed();
        stepValidateFooterLinks();
        stepValidateFooterCopyright();
        stepValidateFooterSocialIcons();
        stepValidateFooterContactInfo();
    }

    @Step("Navigate to Home Page")
    public void stepNavigateToHomePage() {
        try {
            homePage.navigateToHomePage();
            Assert.assertTrue(homePage.isHomePageLoaded(), "Home page should be loaded");
            PublicCommon.reportPass("Navigated to home page successfully");
        } catch (Exception e) {
            PublicCommon.reportFailAssert("Failed to navigate to home page: " + e.getMessage());
        }
    }

    @Step("Validate footer is displayed on the page")
    public void stepValidateFooterIsDisplayed() {
        try {
            Assert.assertTrue(commonPage.isFooterDisplayed(), "Footer should be visible on the page");
            PublicCommon.reportPass("Footer is displayed successfully");
        } catch (AssertionError | Exception e) {
            PublicCommon.reportFailAssert("Footer is not displayed: " + e.getMessage());
        }
    }

    @Step("Validate all main footer links are present and correct")
    public void stepValidateFooterLinks() {
        try {
            Assert.assertTrue(commonPage.areFooterLinksPresent(), "All main footer links should be present");
            PublicCommon.reportPass("All main footer links are present and correct");
        } catch (AssertionError | Exception e) {
            PublicCommon.reportFailAssert("Footer links validation failed: " + e.getMessage());
        }
    }

    @Step("Validate footer copyright information")
    public void stepValidateFooterCopyright() {
        try {
            Assert.assertTrue(commonPage.isFooterCopyrightPresent(), "Footer copyright should be present");
            PublicCommon.reportPass("Footer copyright information is displayed");
        } catch (AssertionError | Exception e) {
            PublicCommon.reportFailAssert("Footer copyright validation failed: " + e.getMessage());
        }
    }

    @Step("Validate footer social media icons are present")
    public void stepValidateFooterSocialIcons() {
        try {
            Assert.assertTrue(commonPage.areFooterSocialIconsPresent(), "Footer social media icons should be present");
            PublicCommon.reportPass("Footer social media icons are present");
        } catch (AssertionError | Exception e) {
            PublicCommon.reportFailAssert("Footer social icons validation failed: " + e.getMessage());
        }
    }

    @Step("Validate footer contact information is present")
    public void stepValidateFooterContactInfo() {
        try {
            Assert.assertTrue(commonPage.isFooterContactInfoPresent(), "Footer contact information should be present");
            PublicCommon.reportPass("Footer contact information is present");
        } catch (AssertionError | Exception e) {
            PublicCommon.reportFailAssert("Footer contact information validation failed: " + e.getMessage());
        }
    }
}
