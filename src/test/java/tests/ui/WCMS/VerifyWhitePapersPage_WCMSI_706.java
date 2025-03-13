package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyWhitePapersPage_WCMSI_706 extends BaseTest {
    static final String jiraTestID = "WCMSI-706";
    CookiePage cookiePage;
    AboutPage AboutPageWCMS;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("White Papers: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": White Papers: Navigation Verification for All Buttons and Links")
    public void VerifyWhitePapersPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            AboutPageWCMS = page.getInstance(AboutPage.class);
            basePage = page.getInstance(BasePage.class);

            driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM")+"about/white-papers");
            cookiePage.handleOneTrustCookie();
            ValidateWhitePapersPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to White Papers Page: Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate White Papers Page")
    public void ValidateWhitePapersPage() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.RolesAndResponsibilitiesLink,"AC377-Autonomy-in-Aviation-R10.pdf", "Roles and Responsibilities"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.GlobalCollaborationLink,"PPE-White-Paper-R2.pdf", "PPE-White-Paper-R2.pdf"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.StandardsDevelopmentLink,"Innovations-White-Paper.pdf", "Innovations-White-Paper.pdf"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.StrengtheningTransatlanticLink,"SES_ASTMWhitePaper.pdf", "SES_ASTMWhitePaper.pdf"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on White Papers page", e);
        }
    }

}
