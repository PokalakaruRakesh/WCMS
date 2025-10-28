package tests.ui.WCMS;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.HeaderComponentPage;
import tests.ui.base.BaseTest;
import com.astm.commonFunctions.Common;
import com.astm.commonFunctions.WCMSICommon;

public class ValidateHeaderComponents_WCMSI_INT123 extends BaseTest {
    private HeaderComponentPage headerComponentPage;
    private Common common;
    private WCMSICommon wcmsiCommon;

    @BeforeMethod
    public void setUp() {
        headerComponentPage = page.getInstance(HeaderComponentPage.class);
        common = page.getInstance(Common.class);
        wcmsiCommon = page.getInstance(WCMSICommon.class);
    }

    @Test(description = "INT-123: Validate header components are visible and correct")
    @Description("INT-123: User should be able to see the header components successfully")
    @Severity(SeverityLevel.NORMAL)
    public void testValidateHeaderComponents_INT123() {
        stepNavigateToHomePage();
        stepValidateHeaderLogo();
        stepValidateHeaderNavigationLinks();
        stepValidateHeaderSearchIcon();
        stepValidateHeaderUserProfileIcon();
        stepValidateHeaderNotificationsIcon();
    }

    @Step("Navigate to Home Page")
    public void stepNavigateToHomePage() {
        try {
            common.navigateToHomePage();
            com.astm.commonFunctions.PublicCommon.reportPass("Navigated to Home Page successfully");
        } catch (Exception e) {
            com.astm.commonFunctions.PublicCommon.reportFailAssert("Failed to navigate to Home Page: " + e.getMessage());
        }
    }

    @Step("Validate Header Logo is displayed")
    public void stepValidateHeaderLogo() {
        try {
            Assert.assertTrue(headerComponentPage.isHeaderLogoDisplayed(), "Header logo should be visible");
            com.astm.commonFunctions.PublicCommon.reportPass("Header logo is displayed successfully");
        } catch (AssertionError | Exception e) {
            com.astm.commonFunctions.PublicCommon.reportFailAssert("Header logo validation failed: " + e.getMessage());
        }
    }

    @Step("Validate Header Navigation Links are displayed")
    public void stepValidateHeaderNavigationLinks() {
        try {
            Assert.assertTrue(headerComponentPage.areHeaderNavigationLinksDisplayed(), "Header navigation links should be visible");
            com.astm.commonFunctions.PublicCommon.reportPass("Header navigation links are displayed successfully");
        } catch (AssertionError | Exception e) {
            com.astm.commonFunctions.PublicCommon.reportFailAssert("Header navigation links validation failed: " + e.getMessage());
        }
    }

    @Step("Validate Header Search Icon is displayed")
    public void stepValidateHeaderSearchIcon() {
        try {
            Assert.assertTrue(headerComponentPage.isHeaderSearchIconDisplayed(), "Header search icon should be visible");
            com.astm.commonFunctions.PublicCommon.reportPass("Header search icon is displayed successfully");
        } catch (AssertionError | Exception e) {
            com.astm.commonFunctions.PublicCommon.reportFailAssert("Header search icon validation failed: " + e.getMessage());
        }
    }

    @Step("Validate Header User Profile Icon is displayed")
    public void stepValidateHeaderUserProfileIcon() {
        try {
            Assert.assertTrue(headerComponentPage.isHeaderUserProfileIconDisplayed(), "Header user profile icon should be visible");
            com.astm.commonFunctions.PublicCommon.reportPass("Header user profile icon is displayed successfully");
        } catch (AssertionError | Exception e) {
            com.astm.commonFunctions.PublicCommon.reportFailAssert("Header user profile icon validation failed: " + e.getMessage());
        }
    }

    @Step("Validate Header Notifications Icon is displayed")
    public void stepValidateHeaderNotificationsIcon() {
        try {
            Assert.assertTrue(headerComponentPage.isHeaderNotificationsIconDisplayed(), "Header notifications icon should be visible");
            com.astm.commonFunctions.PublicCommon.reportPass("Header notifications icon is displayed successfully");
        } catch (AssertionError | Exception e) {
            com.astm.commonFunctions.PublicCommon.reportFailAssert("Header notifications icon validation failed: " + e.getMessage());
        }
    }
}
