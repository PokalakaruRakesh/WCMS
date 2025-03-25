package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class GlobalCooperationPage_WCMSI_848 extends BaseTest {
    static final String jiraTestID = "WCMSI-848";
    CookiePage cookiePage;
    AboutPage aboutPage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Global Cooperation: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + "Global Cooperation: Navigation Verification for All Buttons and Links")
    public void VerifyGlobalCooperationPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            aboutPage = page.getInstance(AboutPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("About ASTM","Global Cooperation");

            ValidateGlobalCooperationPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Global Cooperation Page", e);
        }
    }
    @Step("Validate Global Cooperation Training Page")
    public void ValidateGlobalCooperationPage() {
        try {
            Assert.assertEquals(aboutPage.VideoLink().getAttribute("src"), "https://www.youtube.com/embed/Ikt-aYVdDR8");
            Assert.assertTrue(commonPage.ValidateLink(aboutPage.SupportingGlobal, "https://qa-www.astm.org", "ASTM_Supporting-Global-Growth_September2020.pdf"));
            Assert.assertTrue(commonPage.ValidateLink(aboutPage.MOUMemberList, "https://go.astm.org/mou-program-members", "ASTM INTERNATIONAL" + "Memorandum of Understanding (MoU) Program Members"));
            Assert.assertTrue(commonPage.ValidateLink(aboutPage.InResidenceTrainingPrograms, "/in-residence-training-programs", "Residence Training Programs | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(aboutPage.OnineTrainingLearnMore, "/about/global-cooperation/online-training", "Online Training | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(aboutPage.InternationalPartners, "/about/global-cooperation/international-partners", "International Partners | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(aboutPage.UAEChapterLearn, "https://astmuae.org/", "ASTM International - United Arab Emirates Chapter"));



        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Global Cooperation Page", e);
        }
    }

}
