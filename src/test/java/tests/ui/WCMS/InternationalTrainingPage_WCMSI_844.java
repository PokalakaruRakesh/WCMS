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
public class InternationalTrainingPage_WCMSI_844 extends BaseTest {
    static final String jiraTestID = "WCMSI-844";
    CookiePage cookiePage;
    Standard_SolutionOverviewWCMS Standard_SolutionOverviewWCMS;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("International Training: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + "International Training: Navigation Verification for All Buttons and Links")
    public void VerifyInternationalTrainingPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            Standard_SolutionOverviewWCMS = page.getInstance(Standard_SolutionOverviewWCMS.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","International Training");

            ValidateInternationalTrainingPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the International Training Page", e);
        }
    }
    @Step("Validate International Training Page")
    public void ValidateInternationalTrainingPage() {
        try {

            Assert.assertTrue(commonPage.ValidateLink(Standard_SolutionOverviewWCMS.ITContactSales, "/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));
            Assert.assertTrue(page.getElement(Standard_SolutionOverviewWCMS.MariaIsabelBarrios).getAttribute("href").contains("mailto:mibarrios@enginzone.org"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Training Page", e);
        }
    }

}
