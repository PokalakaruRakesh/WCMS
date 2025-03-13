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
class VerifyASTMCoalChemistryTrainingPage_WCMSI_757 extends BaseTest {
    static final String jiraTestID = "WCMSI-757";
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
    @Description("ASTM Coal Chemistry Training Page")
    @Test(description = jiraTestID + ": ASTM Coal Chemistry Training: Verify the UI, Responsiveness, content and Links of the page")
    public void VerifyCoalChemistryTrainingPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);
            TrainingIndustry = page.getInstance(TrainingByIndustryWCMS.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","Training Courses");
            ReusableMethods.scrollIntoView(page.getElement(WCMSPage.getLinkText("Coal")),driver);
            WaitStatementUtils.waitForElementToBeClickable(driver,page.getElement(WCMSPage.getLinkText("Coal")),5);
            page.getElement(WCMSPage.getLinkText("Coal")).click();

            ValidateCoalChemistryTrainingPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Coal Chemistry Training Page", e);
        }
    }
    @Step("Validate Coal Chemistry Training Page")
    public void ValidateCoalChemistryTrainingPage() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.CoalContactUs,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));
            //Need to add the below step once the defect is closed - INT-7870
            //Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.CoalTraining,"stage.astm.org/astm-tpt", ""));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.CoalContactUs2,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Coal Chemistry Training Page", e);
        }
    }

}

