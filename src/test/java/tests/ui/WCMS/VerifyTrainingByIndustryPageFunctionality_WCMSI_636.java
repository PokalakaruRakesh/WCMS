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
import pages.ui.TrainingByIndustryWCMS;
import tests.ui.base.BaseTest;

public class VerifyTrainingByIndustryPageFunctionality_WCMSI_636 extends BaseTest {
    static final String jiraTestID = "WCMSI-636";
    CookiePage cookiePage;
    TrainingByIndustryWCMS TrainingIndustry;
    CommonPage_WCMS commonPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("WCMSI-383: Set 6: Technical Committee Details, Standards Products, BoS Selection Detail Page, Enterprise Solutions, Compass, SpecBuilder, Custom Platforms, Multimedia Services, Training Courses")
    @Description("To validate the Training By Industry Functionality on the page")
    @Test(description = jiraTestID + "Validate the navigation and content on the page")
    @Step("Validate links and buttons available on page")
    public void ValidateTrainingByIndustryPage() {
        try {
            TrainingIndustry = page.getInstance(TrainingByIndustryWCMS.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            cookiePage.handleOneTrustCookie();
            navigationTrainingIndustryPage();
            validateTrainingIndustryPageContent();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to Training By Industry Page Functionality", e);
        }

    }

    @Step("Validate links and buttons available on page")
    public void validateTrainingIndustryPageContent() {
        Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.TrainWholeTeam, "/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales", "\'Train Your Whole Team\' Button"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(TrainingIndustry.EBook, "https://marketing.astm.org/acton/media/9652/expertly-driven-training?_gl=1*9qbavz*_gcl_au*MTkyMDYxNjAzOC4xNzI0OTQzODc0", "Expertly Driven Training", "\'eBook: Expertly Driven Training\' Button"));
        Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.LearningSupportFAQs, "/tpt-faq", "ASTM Training and E-Learning Policies and FAQs", "Learning Support & FAQs Button clicked"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(TrainingIndustry.ViewTrainingCatalog, "https://assets.contentstack.io/v3/assets/blt5eb0a2cb04534832/bltc7d1d9b3bbc58493/66ffa0ae363a961150f483b3/ASTM_Live_Training_Brochure.pdf?branch=development", "", "\'View Training Catalog\'"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(TrainingIndustry.LabManagerAcademy, "https://www.astm.org/astm-tpt-1008.html?utm_term=REGISTER%20NOW&amp;utm_campaign=TEST-Elevate%20Your%20Career%20With%20ASTM%27s%20Lab%20Management%20Certificate&amp;utm_content=email&amp;utm_source=Act-On+Software&amp;utm_medium=email%E2%80%AF", "Lab Manager Academy | Lab Management Certificate", "\'Lab Manager Academy\' Learn More Button"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(TrainingIndustry.AdditiveManufacturing, "https://amcoe.org/ewd/", "Education & Workforce Development - AM CoE", "\'Complete Set - All sections and volumes\' Link"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(TrainingIndustry.BuildingConstruction, "/standards-and-solutions/training-courses/building-and-construction-training", "ASTM Building and Construction Training", "\'Building Construction\' Link"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(TrainingIndustry.AdditiveManufacturing, "https://amcoe.org/ewd/", "Education & Workforce Development - AM CoE", "\'Complete Set - All sections and volumes\' Link"));
//        Assert.assertTrue(commonPage.ValidateLinkNewtab(TrainingIndustry.NonferrousMetalProducts, "https://www.astm.org/products-services/astm-bos-2.html", "Section 2: Nonferrous Metal Products", "\'Nonferrous Metal Products\'Link"));
//        Assert.assertTrue(commonPage.ValidateLinkNewtab(TrainingIndustry.MetalsTestMethodsAnalyticalProcedures, "https://www.astm.org/products-services/astm-bos-3.html", "Section 3: Metals Test Methods and Analytical Procedures", "\'Metals Test Methods and Analytical Procedures\' Link"));
//        Assert.assertTrue(commonPage.ValidateLinkNewtab(TrainingIndustry.Construction, "https://www.astm.org/products-services/astm-bos-4.html", "Section 4: Construction", "Construction Clicked"));
//        Assert.assertTrue(commonPage.ValidateLinkNewtab(TrainingIndustry.PetroleumProductsLubricantsFossilFuels, "https://www.astm.org/products-services/astm-bos-5.html", "Section 5: Petroleum Products, Lubricants, and Fossil Fuels", "\'Petroleum Products, Lubricants, and Fossil Fuels\' Link"));
//        Assert.assertTrue(commonPage.ValidateLinkNewtab(TrainingIndustry.PaintsRelatedCoatingsAromatics, "https://www.astm.org/products-services/astm-bos-6.html", "Section 6: Paints, Related Coatings, and Aromatics", "\'Paints, Related Coatings, and Aromatics \'Link"));
//        Assert.assertTrue(commonPage.ValidateLinkNewtab(TrainingIndustry.Textiles, "https://www.astm.org/products-services/astm-bos-7.html", "Section 7: Textiles", "\'Textiles\' Link"));
//        Assert.assertTrue(commonPage.ValidateLinkNewtab(TrainingIndustry.Plastics, "https://www.astm.org/products-services/astm-bos-8.html", "Section 8: Plastics", "\'Plastics\'Link"));
//        Assert.assertTrue(commonPage.ValidateLinkNewtab(TrainingIndustry.Rubber, "https://www.astm.org/products-services/astm-bos-9.html", "Section 9: Rubber", "\'Rubber Link\' Link"));
//        Assert.assertTrue(commonPage.ValidateLinkNewtab(TrainingIndustry.ElectricalInsulationElectronics, "https://www.astm.org/products-services/astm-bos-10.html", "Section 10: Electrical Insulation and Electronics", "\'Electrical Insulation and Electronics \'Link"));
//        Assert.assertTrue(commonPage.ValidateLinkNewtab(TrainingIndustry.WaterEnvironmentalTechnology, "https://www.astm.org/products-services/astm-bos-11.html", "Section 11: Water and Environmental Technology", "\'Water and Environmental Technology Clicked\'Link"));
//        Assert.assertTrue(commonPage.ValidateLinkNewtab(TrainingIndustry.NuclearSolarGeothermalEnergy, "https://www.astm.org/products-services/astm-bos-12.html", "Section 12: Nuclear, Solar, and Geothermal Energy", "\'Nuclear, Solar, and Geothermal Energy\' Link"));
//        Assert.assertTrue(commonPage.ValidateLinkNewtab(TrainingIndustry.MedicalDeviceServices, "https://www.astm.org/products-services/astm-bos-13.html", "Section 13: Medical Devices and Services", "\'Section 13: Medical Devices and Services\' Link"));
//        Assert.assertTrue(commonPage.ValidateLinkNewtab(TrainingIndustry.GeneralMethodsInstrumentation, "https://www.astm.org/products-services/astm-bos-14.html", "Section 14: General Methods and Instrumentation", "\'General Methods and Instrumentation\' Link"));
//        Assert.assertTrue(commonPage.ValidateLinkNewtab(TrainingIndustry.GeneralProductsChemicalSpecialtiesEndUseProducts, "https://www.astm.org/products-services/astm-bos-15.html", "Section 15: General Products, Chemical Specialties, and End Use Products", "\'General Products, Chemical Specialties, and End Use Products\' Link"));
    }

    @Step("Validate navigation to Training By Industry page")
    public void navigationTrainingIndustryPage() {
        try {
            commonPage.getstandardandSolution();
            commonPage.clickonTrainningByIndustry();
            WCMSICommon.waitForSec(3);
            Assert.assertTrue(driver.getTitle().contains("ASTM Industry Training Solutions"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to Training By Industry ", e);
        }

    }

}
