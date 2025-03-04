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
            Assert.assertTrue(commonPage.ValidateLink(anniversaryCaseStudies.AircraftBrakingMeasurements, "aircraft-braking", "Aircraft Braking Measurements"));
            Assert.assertTrue(commonPage.ValidateLink(anniversaryCaseStudies.AmusementRides, "amusement-rides", "Amusement Rides"));
            Assert.assertTrue(commonPage.ValidateLink(anniversaryCaseStudies.BabyCribs, "standards-baby-cribs", "Baby Cribs"));
            Assert.assertTrue(commonPage.ValidateLink(anniversaryCaseStudies.BarrierFaceCoverings, "standards-barrier-face-coverings", "Barrier Face Coverings"));
            Assert.assertTrue(commonPage.ValidateLink(anniversaryCaseStudies.BiodegradablePlastic, "standards-biodegradable-plastic", "Biodegradable Plastic"));
            Assert.assertTrue(commonPage.ValidateLink(anniversaryCaseStudies.BiodieselFuelBlend, "standards-biodiesel-fuel-blend", "Biodiesel Fuel Blend"));
            Assert.assertTrue(commonPage.ValidateLink(anniversaryCaseStudies.Disinfection, "standards-disinfection", "Disinfection"));
            Assert.assertTrue(commonPage.ValidateLink(anniversaryCaseStudies.Infrastructure, "standards-infrastructure", "Infrastructure"));
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
