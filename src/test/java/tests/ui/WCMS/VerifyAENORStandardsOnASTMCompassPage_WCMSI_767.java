package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyAENORStandardsOnASTMCompassPage_WCMSI_767 extends BaseTest {
    static final String jiraTestID = "WCMSI-767";
    CookiePage cookiePage;
    EnterpriseSolutionWCMS enterpriseSolution;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("AENOR Standards on ASTM Compass: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": AENOR Standards on ASTM Compass: Navigation Verification for All Buttons and Links")
    public void VerifyIESStandardsASTMCompassPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            enterpriseSolution = page.getInstance(EnterpriseSolutionWCMS.class);
            basePage = page.getInstance(BasePage.class);

            driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM")+"standards-and-solutions/enterprise-solutions/other-publishers/aenor-marketing");
            cookiePage.handleOneTrustCookie();
            ValidateAENORStandardsOnASTMCompassPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to AENOR Standards on ASTM Compass: Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate AENOR Standards on ASTM Compass Page")
    public void ValidateAENORStandardsOnASTMCompassPage() {
        try {
            Assert.assertTrue(page.getElement(enterpriseSolution.BenefitsDigitalVideo).getAttribute("src").contains("https://www.youtube.com/embed/fzOJyMHdMQM"));
            Assert.assertTrue(commonPage.ValidateLink(enterpriseSolution.BenefitsDigitalRequestDemo,"https://marketing.astm.org/acton", ""));
            Assert.assertTrue(commonPage.ValidateLink(enterpriseSolution.DownloadCompassEBook,"https://marketing.astm.org/acton/fs/blocks/showLandingPage", "astm keeping pace with standards"));
            Assert.assertTrue(commonPage.ValidateLink(enterpriseSolution.AdvancingYourProjectsRequestDemo,"https://marketing.astm.org/acton/fs/blocks/showLandingPage", ""));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on AENOR Standards on ASTM Compass", e);
        }
    }

}
