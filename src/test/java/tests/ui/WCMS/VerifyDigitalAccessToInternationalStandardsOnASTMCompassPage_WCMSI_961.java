package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyDigitalAccessToInternationalStandardsOnASTMCompassPage_WCMSI_961 extends BaseTest {
    static final String jiraTestID = "WCMSI-961";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    EnterpriseSolutionWCMS EnterpriseSolutionWCMSPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;
    ASTMCompassWCMS ASTMCompassWCMS;


    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Digital Access to International Standards on ASTM Compass: Verify the UI, Responsiveness, content and Links of the page (Chrome / Edge / Mobile)")
    @Test(description = jiraTestID + ": Digital Access to International Standards on ASTM Compass: Verify the UI, Responsiveness, content and Links of the page (Chrome / Edge / Mobile)")
    public void VerifyASTMCompassPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            EnterpriseSolutionWCMSPage = page.getInstance(EnterpriseSolutionWCMS.class);
            ASTMCompassWCMS = page.getInstance(ASTMCompassWCMS.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","ASTM Compass");
            ValidateASTMCompassPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the ASTM Compass Page ", e);
        }
    }
    @Step("Validate ASTM Compass Page")
    public void ValidateASTMCompassPage() {
        try {
            basePage.clickOnMethod(ASTMCompassWCMS.Exploreabroad);
            Assert.assertTrue(commonPage.ValidateLink(EnterpriseSolutionWCMSPage.AASHTO, "aashto-standards", "AASHTO Standards"));
            Assert.assertTrue(commonPage.ValidateLink(EnterpriseSolutionWCMSPage.AATCC, "aatcc-standards", "AATCC Standards"));
            Assert.assertTrue(commonPage.ValidateLink(EnterpriseSolutionWCMSPage.Aenor, "aenor-marketing", "AENOR Standards on ASTM Compass"));
            Assert.assertTrue(commonPage.ValidateLink(EnterpriseSolutionWCMSPage.API, "publishers/api", "API Standards on ASTM Compass"));
            Assert.assertTrue(commonPage.ValidateLink(EnterpriseSolutionWCMSPage.AWWA, "awwa-standards", "AWWA Standards"));
            Assert.assertTrue(commonPage.ValidateLink(EnterpriseSolutionWCMSPage.CGA, "cga-standards", "CGA Standards - Compressed Gas Association"));
            Assert.assertTrue(commonPage.ValidateLink(EnterpriseSolutionWCMSPage.IES, "ies-marketing", "IES Standards on ASTM Compass"));
            Assert.assertTrue(commonPage.ValidateLink(EnterpriseSolutionWCMSPage.UOP, "uop-standards", "UOP Standards"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link available on About ASTM", e);
        }
    }

}
