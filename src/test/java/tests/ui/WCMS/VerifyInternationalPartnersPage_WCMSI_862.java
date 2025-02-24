package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyInternationalPartnersPage_WCMSI_862 extends BaseTest {
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
    @Description("VerifyInternationalPartnersPage")
    @Test(description = jiraTestID + "VerifyInternationalPartnersPage")
    public void VerifyInternationalPartnersPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            AboutPageWCMS = page.getInstance(AboutPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("About ASTM","International Partners");
            ValidateInternationalPartnersPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the International Partners Page", e);
        }
    }
    @Step("Validate International Partners Page")
    public void ValidateInternationalPartnersPage() {
        try {

            //Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.OECDCaseStudy, "irc-astm-case-study.pdf", "The Case of ASTM International"));
            Assert.assertTrue(page.getElement(AboutPageWCMS.APEC).getAttribute("href").contains("#apec"));
            Assert.assertTrue(page.getElement(AboutPageWCMS.IFC).getAttribute("href").contains("#ifc"));
            Assert.assertTrue(page.getElement(AboutPageWCMS.MCC).getAttribute("href").contains("#mcc"));
            Assert.assertTrue(page.getElement(AboutPageWCMS.StandarsAlliance).getAttribute("href").contains("#standards_alliance"));
            Assert.assertTrue(page.getElement(AboutPageWCMS.UnitedNationsUN).getAttribute("href").contains("#united_nations"));
            Assert.assertTrue(page.getElement(AboutPageWCMS.PPECollaboration).getAttribute("href").contains("jsmo-astm-cooperation"));



        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the International Partners Page ", e);
        }
    }

}
