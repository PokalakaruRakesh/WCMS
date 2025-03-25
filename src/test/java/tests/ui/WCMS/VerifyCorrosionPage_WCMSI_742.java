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

public class VerifyCorrosionPage_WCMSI_742 extends BaseTest {
    static final String jiraTestID = "WCMSI-742";
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
    @Description("ASTM Corrosion Training Page")
    @Test(description = jiraTestID + ": ASTM Corrosion Training : Verify the UI, Responsiveness, content and Links of the page")
    public void VerifyASTMCorrosionTrainingPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);
            TrainingIndustry = page.getInstance(TrainingByIndustryWCMS.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","Training Courses");
            ReusableMethods.scrollIntoView(page.getElement(WCMSPage.getLinkText("Corrosion")),driver);
            WaitStatementUtils.waitForElementToBeClickable(driver,page.getElement(WCMSPage.getLinkText("Corrosion")),5);
            page.getElement(WCMSPage.getLinkText("Corrosion")).click();

            ValidateASTMCorrosionTrainingPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate ASTM Corrosion Training Page", e);
        }
    }
    @Step("Validate ASTM Corrosion Training Page")
    public void ValidateASTMCorrosionTrainingPage() {
        try {

            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.CorrosionContactUs,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.ApplicationASTMB117,"astm-tpt-980.html", "Understanding and Application of ASTM B117"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.ElectrochemicalTechniques,"astm-tpt-471", "Corrosion Testing, Measurement"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.CorrosionInhibitors,"astm-tpt-873", "Corrosion Inhibitors for Oil"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.B117StandardPractice,"astm-tpt-1023.html", "ASTM B117"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.G85StandardPractice,"astm-tpt-1024", "ASTM G85 Standard Practice"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.ModuloLearningPara,"astm-tpt-1029", "ASTM Procedimiento estandar"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.CorrosionContactUs2,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on ASTM Corrosion Training Page", e);
        }
    }

}
