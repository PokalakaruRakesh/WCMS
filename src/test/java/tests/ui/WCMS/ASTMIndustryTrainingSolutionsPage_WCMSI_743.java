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
class ASTMIndustryTrainingSolutionsPage_WCMSI_743 extends BaseTest {
    static final String jiraTestID = "WCMSI-743";
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
    @Description("ASTM Industry Training Solutions Page")
    @Test(description = jiraTestID + ": ASTM Industry Training Solutions Page: Verify the UI, Responsiveness, content and Links of the page")
    public void VerifyASTMIndustryTrainingSolutionsPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);
            TrainingIndustry = page.getInstance(TrainingByIndustryWCMS.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","Training Courses");
            ReusableMethods.scrollIntoView(page.getElement(WCMSPage.getLinkText("Textiles")),driver);
            WaitStatementUtils.waitForElementToBeClickable(driver,page.getElement(WCMSPage.getLinkText("Textiles")),5);
            page.getElement(WCMSPage.getLinkText("Textiles")).click();

            ValidateASTMIndustryTrainingSolutionsPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate ASTM Industry Training Solutions Page", e);
        }
    }
    @Step("Validate ASTM Industry Training Solutions Page")
    public void ValidateASTMIndustryTrainingSolutionsPage() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.TextilesContactUs,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.TextileStandards,"stage.astm.org/astm", "ASTM Textile Standards for Yarns and Sewing Threads"));
            //Raise defect for the below links INT-7872
            // /*Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.ChildrenSleepwear,"stage.astm.org/astm", ""));
            /*Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.UpholsteredFurniture,"stage.astm.org/astm", ""));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.WearingApparel,"stage.astm.org/astm", ""));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.QualityPerformanceStandards,"stage.astm.org/astm", ""));*/
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.TextilesContactUs2,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on ASTM Industry Solutions Training Page", e);
        }
    }

}

