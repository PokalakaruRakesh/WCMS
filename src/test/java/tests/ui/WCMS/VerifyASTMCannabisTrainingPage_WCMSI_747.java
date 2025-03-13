package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyASTMCannabisTrainingPage_WCMSI_747 extends BaseTest {
    static final String jiraTestID = "WCMSI-747";
    CookiePage cookiePage;
    TrainingByIndustryWCMS TrainingIndustry;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("ASTM Cannabis Training: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": ASTM Cannabis Training: Navigation Verification for All Buttons and Links")
    public void VerifyASTMCannabisTrainingPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            TrainingIndustry = page.getInstance(TrainingByIndustryWCMS.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","Training Courses");
            ValidateASTMCannabisTrainingPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to ASTM Cannabis Training: Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate ASTM Cannabis Training Page")
    public void ValidateASTMCannabisTrainingPage() {
        try {
            basePage.clickOnMethod(TrainingIndustry.Cannabis);
            WCMSICommon.waitForSec(4);
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.TrainYour,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Live Training"),"astm-tpt", ""));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("eLearning"),"astm-tpt", ""));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Cannabis Laboratory Testing"),"astm-tpt", "Cannabis Laboratory Testing"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Security for the Cannabis"),"astm-tpt", "Security for the Cannabis"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Quality Management Systems"),"astm-tpt", "Quality Management Systems"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Sistemas de"),"astm-tpt", "Sistemas de"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Cannabis Science"),"astm-tpt", "Cannabis Science"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("ASTM Standard Guide for Requirements"),"https://buyastm.mm411.com", ""));

            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.TrainYourWholeTeam,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on ASTM Cannabis Training", e);
        }
    }

}
