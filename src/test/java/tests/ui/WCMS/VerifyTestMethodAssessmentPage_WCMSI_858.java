package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyTestMethodAssessmentPage_WCMSI_858 extends BaseTest {
    static final String jiraTestID = "WCMSI-858";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;
    Standard_SolutionOverviewWCMS Standard_SolutionOverviewWCMSPage;


    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("VerifyTestMethodAssessmentPage")
    @Test(description = jiraTestID + "VerifyTestMethodAssessmentPage")
    public void VerifyTestMethodAssessmentPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            Standard_SolutionOverviewWCMSPage = page.getInstance(Standard_SolutionOverviewWCMS.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","Test Method Assessment Checklists");
            ValidateTestMethodAssessmentPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the In-Residence Training Programs Page", e);
        }
    }
    @Step("Validate Test Method Assessment Page")
    public void ValidateTestMethodAssessmentPage() {
        try {

            Assert.assertTrue(commonPage.ValidateLink(Standard_SolutionOverviewWCMSPage.ContactSales1, "/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(Standard_SolutionOverviewWCMSPage.LaboratoryServicesOverview, "Lab-Services_Infographic_Oct_2022.pdf", "Lab-Services_Infographic_Oct_2022.pdf"));
            Assert.assertTrue(commonPage.ValidateLink(Standard_SolutionOverviewWCMSPage.AccessASTMContactSales, "/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Test Method Assessment Page ", e);
        }
    }

}
