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
class VerifyProfessionalEngineersPage_WCMSI_841 extends BaseTest {
    static final String jiraTestID = "WCMSI-841";
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
    @Description("Professional Engineers Page")
    @Test(description = jiraTestID + ": Professional Engineers : Verify the UI, Responsiveness, content and Links of the page")
    public void VerifyProfessionalEngineersPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);
            TrainingIndustry = page.getInstance(TrainingByIndustryWCMS.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","Training Courses");


            ValidateProfessionalEngineersPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Professional Engineers Page", e);
        }
    }
    @Step("Validate Professional Engineers Page")
    public void ValidateProfessionalEngineersPage() {
        try {

            basePage.clickOnMethod(TrainingIndustry.ProfessionalEngineer);
            WCMSICommon.waitForSec(4);
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.ContactUsProfessionalEng,"/contact", "Contact ASTM | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.Certificate,"2022-Certificate-of-Attendance", "2022-Certificate-of-Attendance.pdf"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.SubscriptionHere,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Professional Engineers Page", e);
        }
    }

}

