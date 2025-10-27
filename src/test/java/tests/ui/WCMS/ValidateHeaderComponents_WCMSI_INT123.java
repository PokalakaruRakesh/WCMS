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

public class ValidateHeaderComponents_WCMSI_INT123 extends BaseTest {
    private HomePage_WCMS homePageWCMS;
    private CommonPage_WCMS commonPageWCMS;

    @BeforeMethod(alwaysRun = true)
    public void setUpPages() {
        homePageWCMS = page.getInstance(HomePage_WCMS.class);
        commonPageWCMS = page.getInstance(CommonPage_WCMS.class);
    }

    @Test(description = "INT-123: Validate header components are visible and functional on the home page.")
    @Description("INT-123: User should be able to see the header components successfully.")
    @Severity(SeverityLevel.NORMAL)
    public void validateHeaderComponents_INT123() {
        stepNavigateToHomePage();
        stepValidateHeaderLogo();
        stepValidateHeaderNavigationMenu();
        stepValidateHeaderSearchIcon();
        stepValidateHeaderAccountIcon();
        stepValidateHeaderLanguageSelector();
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

    @Step("Validate Header Logo is displayed")
    public void stepValidateHeaderLogo() {
        try {
            Assert.assertTrue(homePageWCMS.isHeaderLogoDisplayed(), "Header logo should be visible");
            PublicCommon.reportPass("Header logo is displayed successfully");
        } catch (AssertionError | Exception e) {
            PublicCommon.reportFailAssert("Header logo validation failed: " + e.getMessage());
        }
    }

    @Step("Validate Header Navigation Menu is displayed")
    public void stepValidateHeaderNavigationMenu() {
        try {
            Assert.assertTrue(homePageWCMS.isHeaderNavigationMenuDisplayed(), "Header navigation menu should be visible");
            PublicCommon.reportPass("Header navigation menu is displayed successfully");
        } catch (AssertionError | Exception e) {
            PublicCommon.reportFailAssert("Header navigation menu validation failed: " + e.getMessage());
        }
    }

    @Step("Validate Header Search Icon is displayed")
    public void stepValidateHeaderSearchIcon() {
        try {
            Assert.assertTrue(homePageWCMS.isHeaderSearchIconDisplayed(), "Header search icon should be visible");
            PublicCommon.reportPass("Header search icon is displayed successfully");
        } catch (AssertionError | Exception e) {
            PublicCommon.reportFailAssert("Header search icon validation failed: " + e.getMessage());
        }
    }

    @Step("Validate Header Account Icon is displayed")
    public void stepValidateHeaderAccountIcon() {
        try {
            Assert.assertTrue(homePageWCMS.isHeaderAccountIconDisplayed(), "Header account icon should be visible");
            PublicCommon.reportPass("Header account icon is displayed successfully");
        } catch (AssertionError | Exception e) {
            PublicCommon.reportFailAssert("Header account icon validation failed: " + e.getMessage());
        }
    }

    @Step("Validate Header Language Selector is displayed")
    public void stepValidateHeaderLanguageSelector() {
        try {
            Assert.assertTrue(homePageWCMS.isHeaderLanguageSelectorDisplayed(), "Header language selector should be visible");
            PublicCommon.reportPass("Header language selector is displayed successfully");
        } catch (AssertionError | Exception e) {
            PublicCommon.reportFailAssert("Header language selector validation failed: " + e.getMessage());
        }
    }
}
