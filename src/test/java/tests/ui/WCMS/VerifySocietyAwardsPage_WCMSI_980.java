package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ReusableMethods;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifySocietyAwardsPage_WCMSI_980 extends BaseTest {
    static final String jiraTestID = "WCMSI-982";
    CookiePage cookiePage;
    SocietyAwardsPage societyAwardsPage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Society Awards: Verify the UI, Responsiveness, content and Links of the page")
    @Test(description = jiraTestID + ": Society Awards: Verify the UI, Responsiveness, content and Links of the page")
    public void VerifySocietyAwardsPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            societyAwardsPage = page.getInstance(SocietyAwardsPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Membership & Participation","Honors and Awards");
            ValidateSocietyAwardsPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Society Awards page", e);
        }
    }
    @Step("Validate SocietyAwards Page")
    public void ValidateSocietyAwardsPage() {
        try {
            basePage.clickOnMethod(societyAwardsPage.societyAwardsLink);
            Assert.assertTrue(WaitStatementUtils.waitForElementToBeClickable(driver,commonPage.getElement(societyAwardsPage.staffContactMail)));
            basePage.clickOnMethod(societyAwardsPage.awardOfMerit);
            Assert.assertTrue(commonPage.ValidateLink(societyAwardsPage.awardOfMeritLink,"Certificate-of-Attendance.pdf", "Award of Merit Guidelines PDF"));
            basePage.clickOnMethod(societyAwardsPage.cavanaughMemorialAward);
            Assert.assertTrue(commonPage.ValidateLink(societyAwardsPage.cavanaughMemorialAwardLink,"W_T_Cavanaugh_Guidelines.pdf", "W.T. Cavanaugh Memorial Award Guidelines PDF"));
            basePage.clickOnMethod(societyAwardsPage.dudleyMedalAward);
            Assert.assertTrue(commonPage.ValidateLink(societyAwardsPage.dudleyMedalAwardLink,"Charles_B._Dudley_Award_Guidelines.pdf", "Charles B. Dudley Medal Award Guidelines PDF"));
            basePage.clickOnMethod(societyAwardsPage.journalTesting);
            Assert.assertTrue(commonPage.ValidateLink(societyAwardsPage.journalTestingLink,"Journal_of_Testing_and_Evaluation_Guidelines.pdf", "Journal of Testing and Evaluation Award Guidelines PDF"));
            basePage.clickOnMethod(societyAwardsPage.painterMemorialAward);
            Assert.assertTrue(commonPage.ValidateLink(societyAwardsPage.painterMemorialAwardLink,"Robert_J._Painter_Memorial_Award.pdf", "Robert J. Painter Memorial Award Guidelines PDF"));
            basePage.clickOnMethod(societyAwardsPage.thomasPresident);
            Assert.assertTrue(commonPage.ValidateLink(societyAwardsPage.thomasPresidentLink,"Thomas_President_Leadership_Award_Guidelines.pdf", "James A. Thomas President’s Leadership Award Guidelines PDF"));
            basePage.clickOnMethod(societyAwardsPage.vossAward);
            Assert.assertTrue(commonPage.ValidateLink(societyAwardsPage.vossAwardLink,"Walter_C._Voss_Guidelines.pdf", "Walter C. Voss Award Guidelines PDF"));
            basePage.clickOnMethod(societyAwardsPage.gumpertzAward);
            Assert.assertTrue(commonPage.ValidateLink(societyAwardsPage.gumpertzAwardLink,"Werner_H._Gumpertz_Award_Guidelines.pdf", "Werner H. Gumpertz Award Guidelines PDF"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Reference Materials", e);
        }
    }

}
