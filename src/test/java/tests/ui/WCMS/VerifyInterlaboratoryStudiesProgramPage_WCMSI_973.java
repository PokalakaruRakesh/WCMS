package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyInterlaboratoryStudiesProgramPage_WCMSI_973 extends BaseTest {
    static final String jiraTestID = "WCMSI-973";
    CookiePage cookiePage;
    ASTMDigital_LibraryWCMS digitalLibrary;
    TechnicalCommitteesWCMS technicalCommittees;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Interlaboratory Studies Program: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": Interlaboratory Studies Program: Navigation Verification for All Buttons and Links")
    public void VerifyInterlaboratoryStudiesPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            digitalLibrary = page.getInstance(ASTMDigital_LibraryWCMS.class);
            technicalCommittees = page.getInstance(TechnicalCommitteesWCMS.class);
            basePage = page.getInstance(BasePage.class);

            commonPage.downloadFileSetup(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Membership & Participation","Technical Committees");
            ValidateInterlaboratoryStudiesProgramPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Interlaboratory Studies Program: Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate Interlaboratory Studies Program Page")
    public void ValidateInterlaboratoryStudiesProgramPage() {
        try {
            WCMSICommon.waitForSec(5);
            basePage.clickOnMethod(technicalCommittees.InterlaboratoryStudyProgramLink);
            WCMSICommon.waitForSec(4);
            Assert.assertTrue(commonPage.ValidateLink(digitalLibrary.RegisterForNewILSProgram,"redirectToILS", "ASTM Login"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(digitalLibrary.ActiveILSProgramList,"Active-Report.xlsx"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(digitalLibrary.FAQs,"ASTM_ILS_FAQ-Revised11.24.2021.pdf"));
            Assert.assertTrue(page.getElement(digitalLibrary.Contact).getAttribute("href").contains("mailto:ILS@astm.org"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(digitalLibrary.SectionA21,"A21.pdf"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(digitalLibrary.RuggednessTesting,"ruggedness_testing.pdf"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(digitalLibrary.PilotTesting,"pilot_testing.pdf"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(digitalLibrary.PrecisionBiasTemplate,"Repeatability_Template.doc"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(digitalLibrary.RepeatabilityPrecisionTemplate,"Repeatability_Template.doc"));
            Assert.assertTrue(commonPage.ValidateLink(digitalLibrary.ASTMFormAndStyleManual,"orm-style-for-astm-stds.html", "Form and Style for ASTM Standards"));
            Assert.assertTrue(page.getElement(digitalLibrary.Contactus).getAttribute("href").contains("mailto:researchreports@astm.org"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(digitalLibrary.DownloadResearchReportTemplate,"ASTM_Research_Report_Template_2024.doc"));
            Assert.assertTrue(page.getElement(digitalLibrary.submitToOurILSTeam).getAttribute("href").contains("mailto:researchreports@astm.org"));
            Assert.assertTrue(commonPage.ValidateLink(digitalLibrary.ContactASTM,"/contact", "Contact"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(digitalLibrary.InterlaboratoryStudiesProgram,"May_Jun_SN_Infograhpic_We_Can_Help_Print_v3.pdf"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Interlaboratory Studies Program page", e);
        }
    }

}
