package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyASTMInsightSQCPage_WCMSI_855 extends BaseTest {
    static final String jiraTestID = "WCMSI-855";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;
    Standard_SolutionOverviewWCMS Standard_SolutionOverviewWCMS;


    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("VerifyASTMInsightSQCPage")
    @Test(description = jiraTestID + "VerifyASTMInsightSQCPage")
    public void VerifyInResidenceTrainingProgramsPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            Standard_SolutionOverviewWCMS = page.getInstance(Standard_SolutionOverviewWCMS.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","ASTM Insight SQC");

            ValidateASTMInsightSQCPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the ASTM InsightSQC Page", e);
        }
    }
    @Step("Validate ASTM InsightSQC Page")
    public void ValidateASTMInsightSQCPage() {
        try {

            Assert.assertTrue(commonPage.ValidateLink(Standard_SolutionOverviewWCMS.InsightSQCDemo, "marketing.astm.org", ""));
            Assert.assertTrue(commonPage.ValidateLink(Standard_SolutionOverviewWCMS.RequestSamplesDemo, "marketing.astm.org", ""));


        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the ASTM InsightSQC Page ", e);
        }
    }

}
