package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyGovernancePage_WCMSI_851 extends BaseTest {
    static final String jiraTestID = "WCMSI-864";
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
    @Description("VerifyGovernancePage")
    @Test(description = jiraTestID + "VerifyGovernancePage")
    public void VerifyInResidenceTrainingProgramsPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            AboutPageWCMS = page.getInstance(AboutPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("About ASTM","Governance");
            ValidateGovernancePage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the In-Residence Training Programs Page", e);
        }
    }
    @Step("Validate Governance Page")
    public void ValidateGovernancePage() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.BoardOfDirectors, "Board-Book-Web.pdf", "ASTM International 2024 Board of Directors"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.SeniorStaff, "Senior-Staff-2024.pdf", "ASTM International Leadership Team"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.AnnualReport, "2023-ASTM-Annual-Report", "ASTM International 2023 Annual Report"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.AnnualBusinessMeeting, "2024-Annual-Business-Meeting.pdf", "2024-Annual-Business-Meeting.pdf"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.ASTMByLaws, "Bylaws102019E.pdf", "ASTM BYLAWS"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.ASTMCharter, "CHARTER.pdf", "CHARTER.doc"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.ASTMBoardBookPDF, "21188-2024-Board-Book-Web.pdf", "ASTM International 2024 Board of Directors"));



        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Governance Page ", e);
        }
    }

}
