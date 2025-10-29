package tests.ui.WCMS;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ui.HomePage_WCMS;
import pages.ui.CommonPage_WCMS;
import com.astm.commonFunctions.Common;
import com.astm.commonFunctions.WCMSICommon;
import com.astm.base.utils.PublicCommon;
import tests.ui.base.BaseTest;

public class VerifyCreateAccountPageURL_INT_003 extends BaseTest {
    private HomePage_WCMS homePage;
    private CommonPage_WCMS commonPage;

    @Test(description = "INT-003: Verify Create Account Page URL")
    @Description("Verify that navigating to the Create Account page lands on the expected URL.")
    @Severity(SeverityLevel.NORMAL)
    public void verifyCreateAccountPageURL() {
        homePage = page.getInstance(HomePage_WCMS.class);
        commonPage = page.getInstance(CommonPage_WCMS.class);

        stepNavigateToHomePage();
        stepClickCreateAccountLink();
        stepVerifyCreateAccountPageURL();
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

    @Step("Click on Create Account link")
    public void stepClickCreateAccountLink() {
        try {
            homePage.clickCreateAccount();
            PublicCommon.reportPass("Clicked on Create Account link successfully");
        } catch (Exception e) {
            PublicCommon.reportFailAssert("Failed to click Create Account link: " + e.getMessage());
        }
    }

    @Step("Verify Create Account Page URL is as expected")
    public void stepVerifyCreateAccountPageURL() {
        try {
            String expectedUrl = "https://store.astm.org/customer/account/create/?acc_class=b2c&acc_type=b2c";
            String actualUrl = commonPage.getCurrentUrl();
            Assert.assertEquals(actualUrl, expectedUrl, "Create Account page URL should match expected");
            PublicCommon.reportPass("Create Account Page URL verified successfully: " + actualUrl);
        } catch (AssertionError | Exception e) {
            PublicCommon.reportFailAssert("Create Account Page URL verification failed: " + e.getMessage());
        }
    }
}
