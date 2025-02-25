package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifySCCPublicReviewPage_WCMSI_921 extends BaseTest {
    static final String jiraTestID = "WCMSI-921";
    CookiePage cookiePage;
    TechnicalCommitteesWCMS technicalCommittees;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));

    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("SCC Public Review: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": SCC Public Review: Navigation Verification for All Buttons and Links")
    public void VerifySCCPublicReviewPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            technicalCommittees = page.getInstance(TechnicalCommitteesWCMS.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Membership & Participation","Technical Committees");
            ValidateSCCPublicReviewPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to SCC Public Review: Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate SCC Public Review Page")
    public void ValidateSCCPublicReviewPage() {
        try {
            basePage.clickOnMethod(technicalCommittees.SCCPublicReview);
            WCMSICommon.waitForSec(4);
            Assert.assertTrue(commonPage.ValidateLink(technicalCommittees.committeeF15,"/membership-participation/technical-committees/committee-f15", "Committee F15 on Consumer Products"));
            Assert.assertTrue(commonPage.ValidateLink(technicalCommittees.DownloadWorkProgram,"scc_work_program.pdf", "SCC Work Program"));
            Assert.assertTrue(page.getElement(technicalCommittees.PublicReviewMail).getAttribute("href").contains("accreditation@astm.org"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on SCC Public Review", e);
        }
    }

}
