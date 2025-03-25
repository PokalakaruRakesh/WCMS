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

class VerifyASTMRubberTrainingPage_WCMSI_759 extends BaseTest {
    static final String jiraTestID = "WCMSI-759";
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
    @Description("Verify the ASTM Rubber Training Page")
    @Test(description = jiraTestID + ": ASTM Rubber Training Page : Verify the UI, Responsiveness, content and Links of the page")
    public void VerifyAccreditationsPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);
            TrainingIndustry = page.getInstance(TrainingByIndustryWCMS.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","Training Courses");
            ReusableMethods.scrollIntoView(page.getElement(WCMSPage.getLinkText("Rubber")),driver);
            WaitStatementUtils.waitForElementToBeClickable(driver,page.getElement(WCMSPage.getLinkText("Rubber")),5);
            page.getElement(WCMSPage.getLinkText("Rubber")).click();

            ValidateRubberTrainingPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the ASTM Rubber Training page", e);
        }
    }
    @Step("Validate Rubber Training Page")
    public void ValidateRubberTrainingPage() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.RubberContactUs,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.RubberTraining,"astm.org/astm-tpt", ""));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.RubberContactUs2,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Rubber Training ", e);
        }
    }

}

