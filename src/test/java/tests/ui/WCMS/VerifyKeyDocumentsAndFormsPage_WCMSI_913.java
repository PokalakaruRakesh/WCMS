package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyKeyDocumentsAndFormsPage_WCMSI_913 extends BaseTest {
    static final String jiraTestID = "WCMSI-913";
    CookiePage cookiePage;
    TechnicalCommitteesWCMS technicalCommittees;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Key Documents and Forms: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": Key Documents and Forms: Navigation Verification for All Buttons and Links")
    public void VerifyKeyDocumentsFormsPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            technicalCommittees = page.getInstance(TechnicalCommitteesWCMS.class);
            basePage = page.getInstance(BasePage.class);

            commonPage.downloadFileSetup(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Membership & Participation","Technical Committees");
            ValidateKeyDocumentsAndFormsPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Key Documents and Forms: Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate Key Documents and Forms Page")
    public void ValidateKeyDocumentsAndFormsPage() {
        try {
            basePage.clickOnMethod(WCMSPage.getSubmenuList("Key Documents and Forms"));
            WCMSICommon.waitForSec(4);
            Assert.assertTrue(commonPage.ValidateLink(technicalCommittees.FormAndStyleLink, "form-style-for-astm-stds.html", "Form and Style for ASTM Standards"));
            Assert.assertTrue(commonPage.ValidateLink(technicalCommittees.RegulationsGoverningLink, "regs-governing-tech-comm", "Regulations Governing ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(technicalCommittees.DraftStandardTemplatesLink, "lead-template", "Draft Standard Templates"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(technicalCommittees.RedBookLink, "Handbook"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(technicalCommittees.StrategicPlanningLink, "planmanual98.pdf"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(technicalCommittees.ProxyFormLink, "Proxy-Form-R7.pdf"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(technicalCommittees.CertificateAttendanceLink, "Certificate-of-Attendance-2025.pdf"));
            Assert.assertTrue(commonPage.ValidateLink(technicalCommittees.SymposiumProposalLink, "symposia-proposal", "ASTM International"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(technicalCommittees.DirectionsPreparingLink, "Instructions.doc"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Key Documents and Forms", e);
        }
    }

}
