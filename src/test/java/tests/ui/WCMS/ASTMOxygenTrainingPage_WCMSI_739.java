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
class ASTMOxygenTrainingPage_WCMSI_739 extends BaseTest {
    static final String jiraTestID = "WCMSI-739";
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
    @Description("ASTM Oxygen Training Page")
    @Test(description = jiraTestID + ": ASTM Oxygen Training : Verify the UI, Responsiveness, content and Links of the page")
    public void VerifyASTMOxygenTrainingPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);
            TrainingIndustry = page.getInstance(TrainingByIndustryWCMS.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","Training Courses");
            ReusableMethods.scrollIntoView(page.getElement(WCMSPage.getLinkText("Oxygen")),driver);
            WaitStatementUtils.waitForElementToBeClickable(driver,page.getElement(WCMSPage.getLinkText("Oxygen")),5);
            page.getElement(WCMSPage.getLinkText("Oxygen")).click();

            ValidateASTMOxygenTrainingPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate ASTM Oxygen Training Page", e);
        }
    }
    @Step("Validate ASTM Oxygen Training Page")
    public void ValidateASTMOxygenTrainingPage() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.OxygenContactUs,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));
            //404-To be fixed
            //Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.FireHazardslive,"stage-store.astm.org", ""));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.FireHazardsELearning,"stage-store.astm.org", "Fire Hazards In Oxygen Systems -- eLearning Course"));
            //404-To be fixed
            //Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.OxygenSystemLive,"", ""));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.OxygenSystemELearning,"stage-store.astm.org", "Oxygen Systems Operations and Maintenance - eLearning Course"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.OxygenContactUs2,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on ASTM Oxygen Training Page", e);
        }
    }

}

