package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyWohlersAndSpecialtyReportPage_WCMSI_945 extends BaseTest {
    static final String jiraTestID = "WCMSI-945";
    CookiePage cookiePage;
    WohlersAndSpecialty_WCMS wohlersAndSpecialtyPage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Wohlers and Specialty Report:Verify the Links of the page")
    @Test(description = jiraTestID + ": Wohlers and Specialty Report:Verify the Links of the page")
    public void VerifyWohlersSpecialtyReportPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            wohlersAndSpecialtyPage = page.getInstance(WohlersAndSpecialty_WCMS.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","Wohlers and Specialty Reports");
            ValidateWohlersAndSpecialtyReportPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to verify Wohlers and Specialty Report page links", e);
        }
    }
    @Step("Validate Wohlers and Specialty Report Page")
    public void ValidateWohlersAndSpecialtyReportPage() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(wohlersAndSpecialtyPage.ResearchDevelopmentLearnMore,"wohlers-report-2024-shows-metal-am-growth-in-new-report", "Wohlers Report 2024 - Just Released! Latest 3D Printing Trends"));
            Assert.assertTrue(commonPage.ValidateLink(wohlersAndSpecialtyPage.PrintingAdditiveOrderNow,"product/wr2024/", "Wohlers Report 2024 - Wohlers Associates"));
            Assert.assertTrue(commonPage.ValidateLink(wohlersAndSpecialtyPage.AlsoAvailableLearnMore,"product-category/specialty-reports", "Specialty Reports Archives - Wohlers Associates"));
            Assert.assertTrue(commonPage.ValidateLink(wohlersAndSpecialtyPage.HowToOrderOrderNow,"product/wr2024/", "Wohlers Report 2024 - Wohlers Associates"));
            Assert.assertTrue(page.getElement(wohlersAndSpecialtyPage.HowToOrderMail).getAttribute("href").contains("wa@wohlersassociates.com"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Digital Access To International Standards", e);
        }
    }

}
