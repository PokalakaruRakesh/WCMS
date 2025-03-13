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
class ASTMLightSportAircraftTrainingPage_WCMSI_745 extends BaseTest {
    static final String jiraTestID = "WCMSI-745";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;
    TrainingByIndustryWCMS TrainingIndustry;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("ASTM Light Sport Aircraft Training Page")
    @Test(description = jiraTestID + ": ASTM Light Sport Aircraft Training Page: Verify the UI, Responsiveness, content and Links of the page")
    public void VerifyAccreditationsPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);
            TrainingIndustry = page.getInstance(TrainingByIndustryWCMS.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","Training Courses");
            ReusableMethods.scrollIntoView(page.getElement(WCMSPage.getLinkText("Light Sport Aircraft")),driver);
            WaitStatementUtils.waitForElementToBeClickable(driver,page.getElement(WCMSPage.getLinkText("Light Sport Aircraft")),5);
            page.getElement(WCMSPage.getLinkText("Light Sport Aircraft")).click();

            ASTMLightSportAircraftTrainingPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the ASTM Light Sport Aircraft Training Page", e);
        }
    }
    @Step("Validate ASTM Light Sport Aircraft Training Page")
    public void ASTMLightSportAircraftTrainingPage() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.AirCraftContactUs,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));
//            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.CoalTraining,"https://qa.astm.org/astm", "Rubber Testing:  Selecting, Performing, and Interpreting ASTM Rubber Test Methods"));
//            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.CoalTraining,"https://qa.astm.org/astm", "Rubber Testing:  Selecting, Performing, and Interpreting ASTM Rubber Test Methods"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.AirCraftContactUs2,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on ASTM Light Sport Aircraft Training Page", e);
        }
    }

}

