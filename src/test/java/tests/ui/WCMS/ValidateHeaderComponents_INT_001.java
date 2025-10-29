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
import base.utils.PublicCommon;
import tests.ui.base.BaseTest;

public class ValidateHeaderComponents_INT_001 extends BaseTest {
    private HomePage_WCMS homePage;
    private CommonPage_WCMS commonPage;

    @BeforeMethod
    public void setUpPages() {
        homePage = page.getInstance(HomePage_WCMS.class);
        commonPage = page.getInstance(CommonPage_WCMS.class);
    }

    @Test(description = "INT-001: Validate header components are displayed successfully")
    @Description("User should be able to see the header components successfully")
    @Severity(SeverityLevel.NORMAL)
    public void testValidateHeaderComponents() {
        stepNavigateToHomePage();
        stepVerifyHeaderLogoDisplayed();
        stepVerifyHeaderNavigationMenuDisplayed();
        stepVerifyHeaderSearchBarDisplayed();
        stepVerifyHeaderUserProfileIconDisplayed();
        stepVerifyHeaderNotificationsIconDisplayed();
    }

    @Step("Navigate to Home Page")
    public void stepNavigateToHomePage() {
        try {
            homePage.navigateToHomePage();
            PublicCommon.reportPass("Navigated to Home Page successfully");
        } catch (Exception e) {
            PublicCommon.reportFailAssert("Failed to navigate to Home Page: " + e.getMessage());
        }
    }

    @Step("Verify Header Logo is displayed")
    public void stepVerifyHeaderLogoDisplayed() {
        try {
            Assert.assertTrue(homePage.isHeaderLogoDisplayed(), "Header logo should be visible");
            PublicCommon.reportPass("Header logo is displayed");
        } catch (AssertionError | Exception e) {
            PublicCommon.reportFailAssert("Header logo is not displayed: " + e.getMessage());
        }
    }

    @Step("Verify Header Navigation Menu is displayed")
    public void stepVerifyHeaderNavigationMenuDisplayed() {
        try {
            Assert.assertTrue(homePage.isHeaderNavigationMenuDisplayed(), "Header navigation menu should be visible");
            PublicCommon.reportPass("Header navigation menu is displayed");
        } catch (AssertionError | Exception e) {
            PublicCommon.reportFailAssert("Header navigation menu is not displayed: " + e.getMessage());
        }
    }

    @Step("Verify Header Search Bar is displayed")
    public void stepVerifyHeaderSearchBarDisplayed() {
        try {
            Assert.assertTrue(homePage.isHeaderSearchBarDisplayed(), "Header search bar should be visible");
            PublicCommon.reportPass("Header search bar is displayed");
        } catch (AssertionError | Exception e) {
            PublicCommon.reportFailAssert("Header search bar is not displayed: " + e.getMessage());
        }
    }

    @Step("Verify Header User Profile Icon is displayed")
    public void stepVerifyHeaderUserProfileIconDisplayed() {
        try {
            Assert.assertTrue(homePage.isHeaderUserProfileIconDisplayed(), "Header user profile icon should be visible");
            PublicCommon.reportPass("Header user profile icon is displayed");
        } catch (AssertionError | Exception e) {
            PublicCommon.reportFailAssert("Header user profile icon is not displayed: " + e.getMessage());
        }
    }

    @Step("Verify Header Notifications Icon is displayed")
    public void stepVerifyHeaderNotificationsIconDisplayed() {
        try {
            Assert.assertTrue(homePage.isHeaderNotificationsIconDisplayed(), "Header notifications icon should be visible");
            PublicCommon.reportPass("Header notifications icon is displayed");
        } catch (AssertionError | Exception e) {
            PublicCommon.reportFailAssert("Header notifications icon is not displayed: " + e.getMessage());
        }
    }
}
