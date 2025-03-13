package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyHowToGetInvolvedPage_WCMSI_528 extends BaseTest {
    static final String jiraTestID = "WCMSI-528";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;
    Membership_Participation MembershipParticipationPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Consumer Participation: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": Consumer Participation : Navigation Verification for All Buttons and Links")
    public void VerifyHowToGetInvolvedPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);
            MembershipParticipationPage = page.getInstance(Membership_Participation.class);


            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Membership & Participation","How to Get Involved");
            ValidateHowToGetInvolvedPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to How To Get Involved: Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate How To get Involved Page")
    public void ValidateHowToGetInvolvedPage() {
        try {
            Assert.assertEquals(commonPage.getVideoLink().getAttribute("src"), "https://www.youtube.com/embed/C4_MrBZVvXI?rel=0");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(commonPage.ValidateLink(MembershipParticipationPage.BecomeASTMMember, "/membership-participation/memberships", "ASTM Membership | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(MembershipParticipationPage.RequestFinancialAssistance, "/membership-participation/consumer-participation/feedback-form", "We Want to Hear From You | ASTM"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on How To Get Involved", e);
        }
    }

}
