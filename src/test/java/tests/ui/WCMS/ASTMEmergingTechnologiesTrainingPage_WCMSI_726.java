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
class ASTMEmergingTechnologiesTrainingPage_WCMSI_726 extends BaseTest {
    static final String jiraTestID = "WCMSI-726";
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
    @Description("ASTM Emerging Technologies Training Page")
    @Test(description = jiraTestID + ": ASTM Emerging Technologies Training : Verify the UI, Responsiveness, content and Links of the page")
    public void VerifyASTMPlasticsTrainingPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);
            TrainingIndustry = page.getInstance(TrainingByIndustryWCMS.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","Training Courses");
            ReusableMethods.scrollIntoView(page.getElement(WCMSPage.getLinkText("Emerging Technologies")),driver);
            WaitStatementUtils.waitForElementToBeClickable(driver,page.getElement(WCMSPage.getLinkText("Emerging Technologies")),5);
            page.getElement(WCMSPage.getLinkText("Emerging Technologies")).click();

            ValidateASTMEmergingTechnologiesTrainingPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate ASTM Emerging Technologies Training Page", e);
        }
    }
    @Step("Validate ASTM Emerging Technologies Training Page")
    public void ValidateASTMEmergingTechnologiesTrainingPage() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.EmergingContactUs,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.WebinarOnDemand,"astm-tpt-693", "Applications for Exoskeltons Webinar OnDemand"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.ExoskeletonPPEInterface,"astm-tpt-692.html", "Exoskeleton and PPE Interface"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.DataManagementProgram,"astm-tpt-845.html", "Additive Manufacturing Data"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.DesignProgram,"astm-tpt-846.html", "Additive Manufacturing Design Program"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.ProcessesProgram,"astm-tpt-847.html", "Additive Manufacturing Processes Program"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.MetalsProgram,"astm-tpt-848.html", "Metals Program"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.BedFusionProgram,"astm-tpt-849.html", "Laser Powder Bed Fusion Program"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.SafetyCertificate,"astm-tpt-971.html", "Additive Manufacturing Safety Certificate"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.TestingProgram,"astm-tpt-850.html", "Additive Manufacturing Testing Program"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.AdditiveCertification,"astm-tpt-1059.html", "Additive Manufacturing Qualification"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.ManufacturingELearning,"astm-tpt-970.html", "Principles of Additive Manufacturing"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.WordWebinarOnDemand,"astm-tpt-817.html", "What's in a Word"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.AutonomyDesign,"astm-tpt-975.html", "Autonomy Design and Operations in Aviation"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.DevelopmentalPillars,"astm-tpt-976.html", "Developmental Pillars of Increased Autonomy for Aircraft"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.F3586Remote,"astm-tpt-1014.html", "How to Use ASTM F3586 Remote ID"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.EmergingContactUs2,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on ASTM Emerging Technologies Training Page", e);
        }
    }

}

