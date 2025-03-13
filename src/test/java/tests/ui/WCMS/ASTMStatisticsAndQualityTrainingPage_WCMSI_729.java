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
class ASTMStatisticsAndQualityTrainingPage_WCMSI_729 extends BaseTest {
    static final String jiraTestID = "WCMSI-729";
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
    @Description("ASTM Statistics And Quality Training Page")
    @Test(description = jiraTestID + ": ASTM Statistics And Quality Training : Verify the UI, Responsiveness, content and Links of the page")
    public void VerifyASTMStatisticsAndQualityTrainingPage() {
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

            ValidateStatisticsAndQualityTrainingPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Statistics And Quality Training Page", e);
        }
    }
    @Step("Validate Statistics And Quality Training Page")
    public void ValidateStatisticsAndQualityTrainingPage() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.StatisticsContactUs,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.CoursesLivetraining,"stage-store.astm.org", "Statistics in ASTM Standard"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.CoursesElearning,"stage-store.astm.org", "Statistics in ASTM Standard"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.UnderstandLiveTraining,"stage-store.astm.org", "Understanding Test Method Precision"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.UnderstandElearning,"stage-store.astm.org", "Understanding Test Method Precision"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.Webinar,"stage-store.astm.org", ""));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.ArtOfPerfectAnalysis,"stage-store.astm.org", ""));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.Precisionbias,"stage-store.astm.org", "Precision and Bias"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.StatisticsContactUs2,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on ASTM Statistics And Quality Training Page", e);
        }
    }

}

