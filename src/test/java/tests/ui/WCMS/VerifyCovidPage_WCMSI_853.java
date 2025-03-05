package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyCovidPage_WCMSI_853 extends BaseTest {
    static final String jiraTestID = "WCMSI-853";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;
    StandardAndPuplicationWCMS standardAndPuplicationWCMS;


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
            standardAndPuplicationWCMS = page.getInstance(StandardAndPuplicationWCMS.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","Standards & Publications");
            ValidateGovernancePage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the In-Residence Training Programs Page", e);
        }
    }
    @Step("Validate Governance Page")
    public void ValidateGovernancePage() {
        try {
            basePage.clickOnMethod(standardAndPuplicationWCMS.CovidStandards);
            Assert.assertTrue(commonPage.ValidateLink(standardAndPuplicationWCMS.AccessStandards, "https://qa.astm.org/products-services/reading-room.html", "Reading Room - Products & Services"));





        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Governance Page ", e);
        }
    }



}
