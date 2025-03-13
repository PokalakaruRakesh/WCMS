package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyDraftStandardTemplatesPage_WCMSI_967 extends BaseTest {
    static final String jiraTestID = "WCMSI-967";
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
    @Description("Draft Standard Templates: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": Draft Standard Templates: Navigation Verification for All Buttons and Links")
    public void VerifyDraftStandardTemplatesPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            technicalCommittees = page.getInstance(TechnicalCommitteesWCMS.class);
            basePage = page.getInstance(BasePage.class);

            commonPage.downloadFileSetup(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Membership & Participation","Technical Committees");
            ValidateDraftStandardTemplatesPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Draft Standard Templates: Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate Draft Standard Templates Page")
    public void ValidateDraftStandardTemplatesPage() {
        try {
            basePage.clickOnMethod(WCMSPage.getSubmenuList("Key Documents and Forms"));
            WCMSICommon.waitForSec(4);
            basePage.clickOnMethod(technicalCommittees.DraftStandardTemplatesLink);
            WCMSICommon.waitForSec(2);
            Assert.assertTrue(commonPage.ValidateDownloadedFile(technicalCommittees.TestMethods, "TestMethods"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(technicalCommittees.Specifications, "Specifications"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(technicalCommittees.GuidesPractices, "PracticesGuides"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(technicalCommittees.Classification, "Classifications"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(technicalCommittees.Terminology,"Terminology"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(technicalCommittees.ResearchReport, "research_report_template"));

            Assert.assertTrue(commonPage.ValidateDownloadedFile(technicalCommittees.TemplateFeatures,"TemplateFeatures"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(technicalCommittees.TheFormStyle,"bluebook_FormStyle.pdf"));

            Assert.assertTrue(page.getElement(technicalCommittees.TechnicalSupport).getAttribute("href").contains("support@astm.org"));
            Assert.assertTrue(page.getElement(technicalCommittees.TemplateQuestions).getAttribute("href").contains("ewhealen@astm.org"));


        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Draft Standard Templates page", e);
        }
    }

}
