package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyCorporateCitizenshipPage_WCMSI_938 extends BaseTest {
    static final String jiraTestID = "WCMSI-938";
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
    @Description("VerifyCorporateCitizenshipLinksOfThePage")
    @Test(description = jiraTestID + "VerifyCorporateCitizenshipPageLinksOfThePage")
    public void VerifyDetailedOverviewPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            AboutPageWCMS = page.getInstance(AboutPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("About ASTM","Corporate Citizenship");
            ValidateCorporateCitizenshipPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Corporate Citizenship Page", e);
        }
    }
    @Step("Validate Corporate Citizenship Page")
    public void ValidateCorporateCitizenshipPage() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.HelpingOurWorld, "Helping-Our-World-Report", "Helping Our World Work Better" +
                    " 2023 Report"));


        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Corporate Citizenship ", e);
        }
    }

}
