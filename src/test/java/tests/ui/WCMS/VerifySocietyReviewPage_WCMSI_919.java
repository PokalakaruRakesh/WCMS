package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifySocietyReviewPage_WCMSI_919 extends BaseTest {
    static final String jiraTestID = "WCMSI-919";
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
    @Description("Society (Public) Review: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": Society (Public) Review: Navigation Verification for All Buttons and Links")
    public void VerifySocietyReviewPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            technicalCommittees = page.getInstance(TechnicalCommitteesWCMS.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Membership & Participation","Technical Committees");
            ValidateSocietyReviewPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Society (Public) Review: Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate Society (Public) Review Page")
    public void ValidateSocietyReviewPage() {
        try {
            basePage.clickOnMethod(technicalCommittees.SocietyReview);
            WCMSICommon.waitForSec(4);
            Assert.assertTrue(commonPage.ValidateLink(technicalCommittees.DownloadBallotActions,"public_society_review.pdf", "public_society_review.pdf"));
            Assert.assertTrue(page.getElement(technicalCommittees.SocietyReviewMail).getAttribute("href").contains("socrev@astm.org"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Society (Public) Review", e);
        }
    }

}
