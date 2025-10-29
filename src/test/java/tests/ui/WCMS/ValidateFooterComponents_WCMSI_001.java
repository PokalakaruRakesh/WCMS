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
import com.astm.commonFunctions.WCMSICommon;
import base.utils.PublicCommon;

public class ValidateFooterComponents_WCMSI_001 extends tests.ui.base.BaseTest {
    private HomePage_WCMS homePageWCMS;
    private CommonPage_WCMS commonPageWCMS;

    @BeforeMethod
    public void setUpPages() {
        homePageWCMS = page.getInstance(HomePage_WCMS.class);
        commonPageWCMS = page.getInstance(CommonPage_WCMS.class);
    }

    @Test(description = "INT-001: Validate Footer components are visible and correct")
    @Description("INT-001: User should be able to see the footer components successfully")
    @Severity(SeverityLevel.NORMAL)
    public void testValidateFooterComponents_INT_001() {
        stepNavigateToHomePage();
        stepValidateFooterIsVisible();
        stepValidateFooterLinks();
        stepValidateFooterCopyright();
        stepValidateFooterSocialIcons();
        stepValidateFooterContactInfo();
    }

    @Step("Navigate to Home Page")
    public void stepNavigateToHomePage() {
        try {
            homePageWCMS.navigateToHomePage();
            PublicCommon.reportPass("Navigated to Home Page successfully");
        } catch (Exception e) {
            PublicCommon.reportFailAssert("Failed to navigate to Home Page: " + e.getMessage());
        }
    }

    @Step("Validate Footer is visible")
    public void stepValidateFooterIsVisible() {
        try {
            Assert.assertTrue(commonPageWCMS.isFooterVisible(), "Footer should be visible on the page");
            PublicCommon.reportPass("Footer is visible on the page");
        } catch (AssertionError | Exception e) {
            PublicCommon.reportFailAssert("Footer visibility validation failed: " + e.getMessage());
        }
    }

    @Step("Validate Footer Links")
    public void stepValidateFooterLinks() {
        try {
            Assert.assertTrue(commonPageWCMS.areFooterLinksPresent(), "All expected footer links should be present");
            PublicCommon.reportPass("All expected footer links are present");
        } catch (AssertionError | Exception e) {
            PublicCommon.reportFailAssert("Footer links validation failed: " + e.getMessage());
        }
    }

    @Step("Validate Footer Copyright")
    public void stepValidateFooterCopyright() {
        try {
            Assert.assertTrue(commonPageWCMS.isFooterCopyrightPresent(), "Footer copyright should be present");
            PublicCommon.reportPass("Footer copyright is present");
        } catch (AssertionError | Exception e) {
            PublicCommon.reportFailAssert("Footer copyright validation failed: " + e.getMessage());
        }
    }

    @Step("Validate Footer Social Icons")
    public void stepValidateFooterSocialIcons() {
        try {
            Assert.assertTrue(commonPageWCMS.areFooterSocialIconsPresent(), "Footer social icons should be present");
            PublicCommon.reportPass("Footer social icons are present");
        } catch (AssertionError | Exception e) {
            PublicCommon.reportFailAssert("Footer social icons validation failed: " + e.getMessage());
        }
    }

    @Step("Validate Footer Contact Info")
    public void stepValidateFooterContactInfo() {
        try {
            Assert.assertTrue(commonPageWCMS.isFooterContactInfoPresent(), "Footer contact info should be present");
            PublicCommon.reportPass("Footer contact info is present");
        } catch (AssertionError | Exception e) {
            PublicCommon.reportFailAssert("Footer contact info validation failed: " + e.getMessage());
        }
    }
}
