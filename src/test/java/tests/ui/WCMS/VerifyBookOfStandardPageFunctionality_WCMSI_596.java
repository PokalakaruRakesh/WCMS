package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.BookOfStandardWCMS;
import pages.ui.CommonPage_WCMS;
import pages.ui.CookiePage;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyBookOfStandardPageFunctionality_WCMSI_596 extends BaseTest {
    static final String jiraTestID = "WCMSI-596";
    CookiePage cookiePage;
    BookOfStandardWCMS BookOfStandard;
    CommonPage_WCMS commonPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("WCMSI-372:  Set 5: Market Insights & Innovation, Standards & Publications, Book of Standards, Digital Library, Laboratory Services, Tracker Services")
    @Description("To validate the Book of Standard navigation and content on the page")
    @Test(description = jiraTestID + "Validate the Book of Standard navigation and content on the page")
    public void validateBookofstandard() {
        try {
            commonPage = page.getInstance(CommonPage_WCMS.class);
            BookOfStandard = page.getInstance(BookOfStandardWCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            cookiePage.handleOneTrustCookie();
            NavigateBookOfStandard();
            validateBookofStandardContent();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to Book of Standard page", e);
        }
    }
    @Step("Validate links and buttons available on Book Of Standard page")
    public void validateBookofStandardContent() {
        WCMSICommon.waitForSec(3);
        Assert.assertTrue(commonPage.ValidateLink(BookOfStandard.subscribeAstmCompass, "/standards-and-solutions/enterprise-solutions/astm-compass", "ASTM Compass", "\'subscribe to an online volume via ASTM Compass\' Link"));
        Assert.assertTrue(commonPage.ValidateLink(BookOfStandard.DiscoverASTMCompass,"/standards-and-solutions/enterprise-solutions/astm-compass","ASTM Compass","\'Discover ASTM Compass\' button"));
        Assert.assertTrue(commonPage.ValidateLink(BookOfStandard.contactUS,"/standards-and-solutions/enterprise-solutions/salesforce","Contact Sales","\'Contact US\' Link"));
        //Book of ASTM Standards by Section
        Assert.assertTrue(commonPage.ValidateLinkNewtab(BookOfStandard.CompleteSetAllSectionsVolumes, "products-services/astm-bos-all.html", "Complete Set", "\'Complete Set - All sections and volumes\' Link"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(BookOfStandard.IronSteelProducts, "products-services/astm-bos-1.html", "Section 1: Iron and Steel Products", "\'Iron Steel Products\' Link"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(BookOfStandard.NonferrousMetalProducts, "products-services/astm-bos-2.html", "Section 2: Nonferrous Metal Products", "\'Nonferrous Metal Products\'Link"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(BookOfStandard.MetalsTestMethodsAnalyticalProcedures, "products-services/astm-bos-3.html", "Section 3: Metals Test Methods and Analytical Procedures", "\'Metals Test Methods and Analytical Procedures\' Link"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(BookOfStandard.Construction, "products-services/astm-bos-4.html", "Section 4: Construction", "Construction Clicked"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(BookOfStandard.PetroleumProductsLubricantsFossilFuels, "products-services/astm-bos-5.html", "Section 5: Petroleum Products, Lubricants, and Fossil Fuels", "\'Petroleum Products, Lubricants, and Fossil Fuels\' Link"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(BookOfStandard.PaintsRelatedCoatingsAromatics, "products-services/astm-bos-6.html", "Section 6: Paints, Related Coatings, and Aromatics", "\'Paints, Related Coatings, and Aromatics \'Link"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(BookOfStandard.Textiles, "products-services/astm-bos-7.html", "Section 7: Textiles", "\'Textiles\' Link"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(BookOfStandard.Plastics, "products-services/astm-bos-8.html", "Section 8: Plastics", "\'Plastics\'Link"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(BookOfStandard.Rubber, "products-services/astm-bos-9.html", "Section 9: Rubber", "\'Rubber Link\' Link"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(BookOfStandard.ElectricalInsulationElectronics, "products-services/astm-bos-10.html", "Section 10: Electrical Insulation and Electronics", "\'Electrical Insulation and Electronics \'Link"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(BookOfStandard.WaterEnvironmentalTechnology, "products-services/astm-bos-11.html", "Section 11: Water and Environmental Technology", "\'Water and Environmental Technology Clicked\'Link"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(BookOfStandard.NuclearSolarGeothermalEnergy, "products-services/astm-bos-12.html", "Section 12: Nuclear, Solar, and Geothermal Energy", "\'Nuclear, Solar, and Geothermal Energy\' Link"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(BookOfStandard.MedicalDeviceServices, "products-services/astm-bos-13.html", "Section 13: Medical Devices and Services", "\'Section 13: Medical Devices and Services\' Link"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(BookOfStandard.GeneralMethodsInstrumentation, "products-services/astm-bos-14.html", "Section 14: General Methods and Instrumentation", "\'General Methods and Instrumentation\' Link"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(BookOfStandard.GeneralProductsChemicalSpecialtiesEndUseProducts, "products-services/astm-bos-15.html", "Section 15: General Products, Chemical Specialties, and End Use Products", "\'General Products, Chemical Specialties, and End Use Products\' Link"));

    }
    @Step("Validate Navigation to Book of Standards")
    public void NavigateBookOfStandard() {
        try {
            commonPage.getstandardandSolution();
            commonPage.clickonASTMBookofStandard();
            Assert.assertTrue(driver.getTitle().contains("Annual Book of ASTM Standards"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to Book of Standards", e);
        }
    }
}
