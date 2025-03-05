package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.CommonPage_WCMS;
import pages.ui.CookiePage;
import pages.ui.EmergingProfessionalsProgramWCMS;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyEmergingProfessionalsProgram_WCMSI_523 extends BaseTest {
    static final String jiraTestID = "WCMSI-523";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    EmergingProfessionalsProgramWCMS emergingProfessionalsProgram;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("WCMSI-338: Set 2: History, 125th Anniversary Case Studies, Membership, Students, Emerging Professionals, Consumer Participation, Technical Committees, Regional Offices")
    @Description("To validate the navigation to Emerging Professionals Program")
    @Test(description = jiraTestID + "Validate the navigation to Emerging Professionals Program page")
    public void validateTechnicalCommittees() {
        commonPage = page.getInstance(CommonPage_WCMS.class);
        emergingProfessionalsProgram = page.getInstance(EmergingProfessionalsProgramWCMS.class);
        cookiePage = page.getInstance(CookiePage.class);
        cookiePage.handleOneTrustCookie();
        navigatetoEmergingProfessionals();
        validateEmergingProfessionalsProgramLinks();
    }

    @Step("Validate links and buttons available on 125th Anniversary Case Studies page")
    public void validateEmergingProfessionalsProgramLinks() {
        try {
            Assert.assertEquals(commonPage.getVideoLink().getAttribute("src"), "https://www.youtube.com/embed/BH9RwjaDLiA?si=L7WFlV-MM75F9YaO");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(commonPage.ValidateLink(EmergingProfessionalsProgramWCMS.Nominationform, "CURRENT_0924_EP_Nomination_Form_2024.pdf", ""));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Emerging Professionals Program", e);
        }
    }

    @Step("Validate navigation to Emerging Professionals Program page")
    public void navigatetoEmergingProfessionals() {
        try {
            commonPage.clickOnMembershipParticipation();
            commonPage.clickOnEmergingProfessionals();
            Assert.assertEquals(driver.getTitle(), "Emerging Professionals Program | ASTM");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Emerging Professionals page", e);
        }
    }
}
