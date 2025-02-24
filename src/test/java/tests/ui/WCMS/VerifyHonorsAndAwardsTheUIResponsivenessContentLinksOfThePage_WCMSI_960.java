package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyHonorsAndAwardsTheUIResponsivenessContentLinksOfThePage_WCMSI_960 extends BaseTest {
    static final String jiraTestID = "WCMSI-960";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;
    TechnicalCommitteesWCMS TechnicalCommitteesPage;


    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("HonorsAndAwardsTheUIResponsivenessContentLinksOfThePage")
    @Test(description = jiraTestID + "HonorsAndAwardsTheUIResponsivenessContentLinksOfThePage")
    public void VerifyHonorsAwardsProgramPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            TechnicalCommitteesPage = page.getInstance(TechnicalCommitteesWCMS.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Membership & Participation","Honors and Awards");

            ValidateHonorsAwardsProgramPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the TechnicalCommittees Page", e);
        }
    }
    @Step("Validate Honors Awards Program Page")
    public void ValidateHonorsAwardsProgramPage() {
        try {
            Assert.assertTrue(page.getElement(TechnicalCommitteesPage.StaffEmail).getAttribute("href").contains("mzamorski@astm.org"));
            Assert.assertTrue(commonPage.ValidateLink(TechnicalCommitteesPage.SocietyAwards, "society-awards", "Society Awards | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(TechnicalCommitteesPage.SocietyRecognized, "society-recognized-committee-awards", "Society Recognized Committee Awards | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(TechnicalCommitteesPage.TechnicalCommitteeAwards, "technical-committee-awards", "Technical Committee Awards | ASTM"));
            //Download functionality
//            Assert.assertTrue(commonPage.ValidateLink(TechnicalCommitteesPage.DownloadListPreviousRecipients, "Awards_Recipient_List", "Technical Committee Awards | ASTM"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link available on Honors Awards Program Page ", e);
        }
    }

}
