package tests.ui.WCMS;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ui.HomePage_WCMS;
import pages.ui.CommonPage_WCMS;
import tests.ui.base.BaseTest;
import com.astm.commonFunctions.Common;

public class ValidateFooterComponents_WCMSI_111 extends BaseTest {
    private HomePage_WCMS homePage;
    private CommonPage_WCMS commonPage;

    @Test(description = "INT-111: Validate footer components are visible and correct")
    @Description("INT-111: User should be able to see the footer components successfully")
    @Severity(SeverityLevel.NORMAL)
    public void validateFooterComponents() {
        homePage = page.getInstance(HomePage_WCMS.class);
        commonPage = page.getInstance(CommonPage_WCMS.class);

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
            homePage.navigateToHomePage();
            Common.reportPass("Navigated to Home Page successfully");
        } catch (Exception e) {
            Common.reportFailAssert("Failed to navigate to Home Page: " + e.getMessage());
        }
    }

    @Step("Validate footer is visible")
    public void stepValidateFooterIsVisible() {
        try {
            Assert.assertTrue(commonPage.isFooterVisible(), "Footer should be visible on the page");
            Common.reportPass("Footer is visible on the page");
        } catch (AssertionError | Exception e) {
            Common.reportFailAssert("Footer is not visible: " + e.getMessage());
        }
    }

    @Step("Validate footer links are present and correct")
    public void stepValidateFooterLinks() {
        try {
            Assert.assertTrue(commonPage.areFooterLinksPresent(), "Footer links should be present");
            Assert.assertTrue(commonPage.areFooterLinksCorrect(), "Footer links should be correct");
            Common.reportPass("Footer links are present and correct");
        } catch (AssertionError | Exception e) {
            Common.reportFailAssert("Footer links validation failed: " + e.getMessage());
        }
    }

    @Step("Validate footer copyright text")
    public void stepValidateFooterCopyright() {
        try {
            Assert.assertTrue(commonPage.isFooterCopyrightPresent(), "Footer copyright should be present");
            Common.reportPass("Footer copyright is present");
        } catch (AssertionError | Exception e) {
            Common.reportFailAssert("Footer copyright validation failed: " + e.getMessage());
        }
    }

    @Step("Validate footer social icons")
    public void stepValidateFooterSocialIcons() {
        try {
            Assert.assertTrue(commonPage.areFooterSocialIconsPresent(), "Footer social icons should be present");
            Common.reportPass("Footer social icons are present");
        } catch (AssertionError | Exception e) {
            Common.reportFailAssert("Footer social icons validation failed: " + e.getMessage());
        }
    }

    @Step("Validate footer contact information")
    public void stepValidateFooterContactInfo() {
        try {
            Assert.assertTrue(commonPage.isFooterContactInfoPresent(), "Footer contact information should be present");
            Common.reportPass("Footer contact information is present");
        } catch (AssertionError | Exception e) {
            Common.reportFailAssert("Footer contact information validation failed: " + e.getMessage());
        }
    }
}
