package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyInResidenceTrainingProgramsPage_WCMSI_864 extends BaseTest {
    static final String jiraTestID = "WCMSI-864";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;
    AboutPage AboutPageWCMS;


    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("VerifyInResidenceTrainingProgramsPage")
    @Test(description = jiraTestID + "VerifyInResidenceTrainingProgramsPage")
    public void VerifyInResidenceTrainingProgramsPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            AboutPageWCMS = page.getInstance(AboutPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("About ASTM","In-Residence Training Programs");
            ValidateInResidenceTrainingProgramsPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the In-Residence Training Programs Page", e);
        }
    }
    @Step("Validate InResidenceTrainingPrograms Page")
    public void ValidateInResidenceTrainingProgramsPage() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.TVGPApplication, "tvgp-application", "Global TVGO Application Oct 23.pdf"));
            Assert.assertTrue(page.getElement(AboutPageWCMS.GetInTouchEmail).getAttribute("href").contains("mailto:globalcooperation@astm.org"));


        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the In-Residence Training Programs Page ", e);
        }
    }

}
