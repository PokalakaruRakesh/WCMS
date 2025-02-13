package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.CommonPage_WCMS;
import pages.ui.CookiePage;
import pages.ui.RegionalOfficesWCMS;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyRegionalOffices_WCMSI_529 extends BaseTest {
    static final String jiraTestID = "WCMSI-529";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    RegionalOfficesWCMS RegionalOffices;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("WCMSI-338: Set 2: History, 125th Anniversary Case Studies, Membership, Students, Emerging Professionals, Consumer Participation, Technical Committees, Regional Offices")
    @Description("To validate the navigation to Regional Offices")
    @Test(description = jiraTestID + "Validate the navigation and to Regional Offices page")
    public void validateRegionalOffices() {
        commonPage = page.getInstance(CommonPage_WCMS.class);
        RegionalOffices = page.getInstance(RegionalOfficesWCMS.class);
        cookiePage = page.getInstance(CookiePage.class);
        cookiePage.handleOneTrustCookie();
        navigatetoRegionalOffices();
        validateRegionalOfficesLinks();
    }

    @Step("Validate links and buttons available on RegionalOffices page")
    public void validateRegionalOfficesLinks() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(RegionalOffices.Direction, "/membership-participation/memberships/directions", "Directions | ASTM", "\'Directions\' Button"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(RegionalOffices.americaLatinaRelgion, "https://la.astm.org/", "ASTM International in Spanish | Engineering Standards in Spanish", "\'ASTM in the America Latina Region\' link"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(RegionalOffices.linkPortuguese, "https://br.astm.org/", "ASTM International in Portuguese | ASTM International", "\'ASTM in Portuguese\' link"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(RegionalOffices.linkJapanese, "https://jp.astm.org/", "ASTM International Standards, Training & Certification In Spanish", "\'ASTM in Japanese\' link"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(RegionalOffices.linkKorea, "https://kr.astm.org/", "ASTM International in Korean | International Standards in Korean", "\'ASTM in Korea\' link"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(RegionalOffices.linkMandarin, "https://cn.astm.org/", "ASTM International Standards, Training & Certification In Mandarin", "\'ASTM in Mandarin\' link"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Regional Offices page", e);
        }
    }
    @Step("Validate navigation to Regional Offices page")
    public void navigatetoRegionalOffices() {
        commonPage.ClickOnAboutNavigationOption();
        commonPage.clickOnRegionalOffices();
        Assert.assertTrue(driver.getTitle().contains("Regional Offices and Support | ASTM"));
    }

}
