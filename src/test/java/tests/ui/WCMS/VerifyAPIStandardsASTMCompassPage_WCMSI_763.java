package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

class VerifyAPIStandardsASTMCompassPage_WCMSI_763 extends BaseTest {
    static final String jiraTestID = "WCMSI-763";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;
    EnterpriseSolutionWCMS EnterpriseSolution;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {

    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify API Standards ASTM Compass Page")
    @Test(description = jiraTestID + ": Directions : Verify the UI, Responsiveness, content and Links of the page")
    public void VerifyAPIStandardsASTMCompassPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);
            EnterpriseSolution = page.getInstance(EnterpriseSolutionWCMS.class);

            driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM")+"standards-and-solutions/enterprise-solutions/other-publishers/api");
            cookiePage.handleOneTrustCookie();

            ValidateAPIStandardsASTMCompassPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate API Standards ASTM Compass Page", e);
        }
    }
    @Step("Validate Directions Page")
    public void ValidateAPIStandardsASTMCompassPage() {
        try {
            Assert.assertEquals(commonPage.getVideoLink().getAttribute("src"), "https://www.youtube.com/embed/fzOJyMHdMQM");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(commonPage.ValidateLink(EnterpriseSolution.APIRequestDemo,"https://marketing.astm.org", ""));
            Assert.assertTrue(commonPage.ValidateLink(EnterpriseSolution.CompassEBook,"https://marketing.astm.org", "astm keeping"));
            Assert.assertTrue(commonPage.ValidateLink(EnterpriseSolution.APIRequestDemo2,"https://marketing.astm.org", ""));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Validate API Standards ASTM Compass Page", e);
        }
    }

}

