package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.AnniversaryCaseStudiesWCMS;
import pages.ui.CommonPage_WCMS;
import pages.ui.CookiePage;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyAnniversaryCaseStudies_WCMSI_530 extends BaseTest {
    static final String jiraTestID = "WCMSI-530";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    AnniversaryCaseStudiesWCMS anniversaryCaseStudies;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("WCMSI-338: Set 2: History, 125th Anniversary Case Studies, Membership, Students, Emerging Professionals, Consumer Participation, Technical Committees, Regional Offices")
    @Description("To validate the navigation to 125th Anniversary Case Studies")
    @Test(description = jiraTestID + "Validate the navigation to 125th Anniversary Case Studies page")
    public void validateTechnicalCommittees() {
        commonPage = page.getInstance(CommonPage_WCMS.class);
        anniversaryCaseStudies = page.getInstance(AnniversaryCaseStudiesWCMS.class);
        cookiePage = page.getInstance(CookiePage.class);
        cookiePage.handleOneTrustCookie();
        navigatetoAnniversaryCaseStudies();
        validaAnniversaryCaseStudiesLinks();
    }

    @Step("Validate links and buttons available on 125th Anniversary Case Studies page")
    public void validaAnniversaryCaseStudiesLinks() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(anniversaryCaseStudies.AircraftBrakingMeasurements, "news/case-study-on-standards-aircraft-braking-measurements", "Case Study on Standards: Aircraft Braking Measurements | ASTM Standardization News", "\'Aircraft Braking Measurements\' link"));
            Assert.assertTrue(commonPage.ValidateLink(anniversaryCaseStudies.AmusementRides, "case-study-on-standards-amusement-rides", "Case Study on Standards: Amusement Rides | ASTM Standardization News", "\'Amusement Rides\' Link"));
            Assert.assertTrue(commonPage.ValidateLink(anniversaryCaseStudies.BabyCribs, "case-study-on-standards-baby-cribs", "Case Study on Standards: Baby Cribs | ASTM Standardization News", "\'Baby Cribs\' Link"));
            Assert.assertTrue(commonPage.ValidateLink(anniversaryCaseStudies.BarrierFaceCoverings, "case-study-on-standards-barrier-face-coverings", "Case Study on Standards: Barrier Face Coverings | ASTM Standardization News", "\'Barrier Face Coverings\' Link"));
            Assert.assertTrue(commonPage.ValidateLink(anniversaryCaseStudies.BiodegradablePlastic, "case-study-on-standards-biodegradable-plastic", "Case Study on Standards: Biodegradable Plastic | ASTM Standardization News", "\'Biodegradable Plastic\' Link"));
            Assert.assertTrue(commonPage.ValidateLink(anniversaryCaseStudies.BiodieselFuelBlend, "case-study-on-standards-biodiesel-fuel-blend", "Case Study on Standards: Biodiesel Fuel Blend | ASTM Standardization News", "\'Biodiesel Fuel Blend\' Link"));
            Assert.assertTrue(commonPage.ValidateLink(anniversaryCaseStudies.Disinfection, "case-study-on-standards-disinfection", "Case Study on Standards: Disinfection | ASTM Standardization News", "\'Disinfection\' Link"));
            Assert.assertTrue(commonPage.ValidateLink(anniversaryCaseStudies.Infrastructure, "case-study-on-standards-infrastructure", "Case Study on Standards: Infrastructure | ASTM Standardization News", "\'Infrastructure\' Link"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on 125th Anniversary Case Studies", e);
        }
    }

    @Step("Validate navigation to 125th Anniversary Case Studies page")
    public void navigatetoAnniversaryCaseStudies() {
        try {
            commonPage.ClickOnAboutNavigationOption();
            commonPage.clickOnAnniversaryCaseStudies();
            WCMSICommon.waitForSec(2);
            Assert.assertEquals(driver.getTitle(), "125th Anniversary Case Studies | ASTM");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on 125th Anniversary Case Studies page", e);
        }
    }
}
