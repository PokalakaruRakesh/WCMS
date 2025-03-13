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
class ASTMPlasticsTrainingPage_WCMSI_737 extends BaseTest {
    static final String jiraTestID = "WCMSI-737";
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
    @Description("ASTM plastics Training Page")
    @Test(description = jiraTestID + ": ASTM Plastics Training : Verify the UI, Responsiveness, content and Links of the page")
    public void VerifyASTMPlasticsTrainingPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);
            TrainingIndustry = page.getInstance(TrainingByIndustryWCMS.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","Training Courses");
            ReusableMethods.scrollIntoView(page.getElement(WCMSPage.getLinkText("Plastics")),driver);
            WaitStatementUtils.waitForElementToBeClickable(driver,page.getElement(WCMSPage.getLinkText("Plastics")),5);
            page.getElement(WCMSPage.getLinkText("Plastics")).click();

            ValidateASTMPlasticsTrainingPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate ASTM Plastics Training Page", e);
        }
    }
    @Step("Validate ASTM Oxygen Training Page")
    public void ValidateASTMPlasticsTrainingPage() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.PlasticsContactUs,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.SustainableMaterials,"https://stage-store.astm.org/astm-tpt-545.html", "Sustainable Materials"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.MajorTestingTechniques,"https://stage-store.astm.org/astm-tpt-19.html", "Major Testing Techniques for Plastics: An Introduction"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.TestingPlasticsBasics,"https://stage-store.astm.org/astm-tpt-602.html", "The Basics of Testing Plastics eLearning Program"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.PlasticsContactUs2,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on ASTM Plastics Training Page", e);
        }
    }

}

