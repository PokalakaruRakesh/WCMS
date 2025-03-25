package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.Common;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyOnlineTrainingPage_WCMSI_867 extends BaseTest {
    static final String jiraTestID = "WCMSI-867";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;
    AboutPage AboutPageWCMS;


    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("VerifyOnlineTrainingPage")
    @Test(description = jiraTestID + "VerifyOnlineTrainingPage")
    public void VerifyOnlineTrainingPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            AboutPageWCMS = page.getInstance(AboutPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("About ASTM","Online Training");
            ValidateOnlineTrainingPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Online Training Page", e);
        }
    }
    @Step("Validate Online Training Page")
    public void ValidateOnlineTrainingPage() {
        try {
            scrollAndverifyElementPresent(AboutPageWCMS.ContactMariaJiverage,"mailto:mjiverage@astm.org");
            scrollAndverifyElementPresent(AboutPageWCMS.ActivatingASTMMoU, "#mou");
            scrollAndverifyElementPresent(AboutPageWCMS.TheStandardsSystems, "#ist");
            scrollAndverifyElementPresent(AboutPageWCMS.MarketingPromotion, "#promotion_standards");
            scrollAndverifyElementPresent(AboutPageWCMS.MembershipStakeholder, "#stakeholder_engagement");
            scrollAndverifyElementPresent(AboutPageWCMS.OverviewASTM, "#specbuilder");
            scrollAndverifyElementPresent(AboutPageWCMS.SocialMedia, "engagement");
            scrollAndverifyElementPresent(AboutPageWCMS.SimpleWaysAdopt, "#astm_std");
            scrollAndverifyElementPresent(AboutPageWCMS.ASTMStandardizationProcess, "#standardization_process");
            scrollAndverifyElementPresent(AboutPageWCMS.IntroductionStandardsWriting, "#standards_writing");
            scrollAndverifyElementPresent(AboutPageWCMS.PublicMediaRelations, "branding");
            scrollAndverifyElementPresent(AboutPageWCMS.PrecisionBias, "#precision_and_bias");
            scrollAndverifyElementPresent(AboutPageWCMS.AnnualReportTraining, "#annual_report_training");
            scrollAndverifyElementPresent(AboutPageWCMS.OutreachProgram, "#outreach_program");
            scrollAndverifyElementPresent(AboutPageWCMS.MemberOnboardingEngagement, "#member_onboarding");
            scrollAndverifyElementPresent(AboutPageWCMS.LabServicesProgram, "#lab_services");
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.WebExMeetingManager, "Webex-Meetings-Join-a-Test-Meeting", "Join a test meeting"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.RunningWebEx, "https://www.webex.com/test-meeting.html", "Cisco Webex | Test online meeting"));


           /* Assert.assertTrue(commonPage.getElement(AboutPageWCMS.ActivatingASTMMoU).getAttribute("href").contains("#mou"));
            Assert.assertTrue(commonPage.getElement(AboutPageWCMS.TheStandardsSystems).getAttribute("href").contains("#ist"));
            Assert.assertTrue(commonPage.getElement(AboutPageWCMS.MarketingPromotion).getAttribute("href").contains("#promotion_standards"));
            Assert.assertTrue(commonPage.getElement(AboutPageWCMS.MembershipStakeholder).getAttribute("href").contains("#stakeholder_engagement"));
            Assert.assertTrue(commonPage.getElement(AboutPageWCMS.OverviewASTM).getAttribute("href").contains("#specbuilder"));
            Assert.assertTrue(commonPage.getElement(AboutPageWCMS.SocialMedia).getAttribute("href").contains("#best_practices_for_engagement"));
            Assert.assertTrue(commonPage.getElement(AboutPageWCMS.SimpleWaysAdopt).getAttribute("href").contains("#astm_std"));
            Assert.assertTrue(commonPage.getElement(AboutPageWCMS.ASTMStandardizationProcess).getAttribute("href").contains("#standardization_process"));
            Assert.assertTrue(commonPage.getElement(AboutPageWCMS.ASTMStandardizationProcess).getAttribute("href").contains("#standardization_process"));
            Assert.assertTrue(commonPage.getElement(AboutPageWCMS.IntroductionStandardsWriting).getAttribute("href").contains("#standards_writing"));
            Assert.assertTrue(commonPage.getElement(AboutPageWCMS.PublicMediaRelations).getAttribute("href").contains("#relations_and_branding"));
            Assert.assertTrue(commonPage.getElement(AboutPageWCMS.PrecisionBias).getAttribute("href").contains("#relations_and_branding"));
            Assert.assertTrue(commonPage.getElement(AboutPageWCMS.PrecisionBias).getAttribute("href").contains("#precision_and_bias"));
            Assert.assertTrue(commonPage.getElement(AboutPageWCMS.AnnualReportTraining).getAttribute("href").contains("#annual_report_training"));
            Assert.assertTrue(commonPage.getElement(AboutPageWCMS.OutreachProgram).getAttribute("href").contains("#annual_report_training"));
            Assert.assertTrue(commonPage.getElement(AboutPageWCMS.MemberOnboardingEngagement).getAttribute("href").contains("#member_onboarding"));
            Assert.assertTrue(commonPage.getElement(AboutPageWCMS.LabServicesProgram).getAttribute("href").contains("#lab_services"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.WebExMeetingManager, "Webex-Meetings-Join-a-Test-Meeting", "Join a test meeting"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.RunningWebEx, "https://www.webex.com/test-meeting.html", "Cisco Webex | Test online meeting"));
*/
            //Rest of the pages in this page are Static. Hence, not automated.


        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Online Training Page ", e);
        }
    }
    public void scrollAndverifyElementPresent(By locator, String value) {
        try {
            ReusableMethods.scrollToElement(driver,locator);
            Assert.assertTrue(commonPage.getElement(locator).getAttribute("href").contains(value));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
