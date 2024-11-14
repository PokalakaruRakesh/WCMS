package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.AboutPage;
import pages.ui.CommonPage_WCMS;
import pages.ui.CookiePage;
import pages.ui.LaboratoryServices_WCMS;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyLaboratoryServicesFunctionality_WCMSI_609 extends BaseTest {
    static final String jiraTestID = "WCMSI-609";
    CookiePage cookiePage;
    LaboratoryServices_WCMS loborataryServicesPage;
    CommonPage_WCMS commonPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("WCMSI-372:  Set 5: Market Insights & Innovation, Standards & Publications, Book of Standards, Digital Library, Laboratory Services, Tracker Services")
    @Description("To validate the Book of and content on the page")
    @Test(description = jiraTestID + "Validate the navigation and content on the page")
    public void ValidateTheLaboratoryServicePage() {
        try {
           loborataryServicesPage = page.getInstance(LaboratoryServices_WCMS.class);
           commonPage = page.getInstance(CommonPage_WCMS.class);
           cookiePage = page.getInstance(CookiePage.class);
           cookiePage.handleOneTrustCookie();
           NavigateToLaboratoryPage();
           ValidateLaboratoryPageContent();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to Laboratory Services page", e);
        }
    }
    @Step("Validate links and buttons available on Laboratory page")
    public void ValidateLaboratoryPageContent() {
        try {
            Assert.assertEquals(commonPage.getVideoLink().getAttribute("src"), "https://www.youtube.com/embed/oJ03GYQfKbE?si=IYbs4bQc7n43qD6c?rel=0");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(commonPage.ValidateLinkNewtab(loborataryServicesPage.OnDemandWebinar, "https://event.on24.com/wcc/r/4113501/CFC9E7BF78EF39A8FC19AF64526377E4", "Improve Accuracy, Reduce Costs, and Work Smarter with ASTM Laboratory Services", "\'OnDemand Webinar\' Button"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(loborataryServicesPage.SubscribeNewsletter, "https://marketing.astm.org/acton/media/9652/astm-lab-services-newsletter-signup?_gl=1*1qnmnun*_gcl_au*ODA0MjMzMjE2LjE3MjE4NDUzNTI", "ASTM Lab Services Newsletter Signup", "\'Subscribe Newsletter\' Link"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(loborataryServicesPage.Contact, "https://marketing.astm.org/acton/fs/blocks/showLandingPage/a/9652/p/p-03de/t/page/fm/0?_gl=1*hdbd2e*_gcl_au*Mzg4ODIzMjQuMTcyNTg1Njk3Mg..", "", "\'Contact\' Link"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(loborataryServicesPage.ProficiencyTestingLearnMore, "https://www.astm.org/products-services/laboratory-services/proficiency-testing.html", "Proficiency Testing - Laboratory Services - Products & Services", "\'Proficiency Testing\'Learn more Link"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(loborataryServicesPage.ReferenceMaterialsLearnMore, "https://www.astm.org/products-services/laboratory-services/petroleum-reference-materials.html", "Reference Materials - Laboratory Services - Products & Services", "\'Reference Materials\' Learn More Link"));
            Assert.assertTrue(commonPage.ValidateLink(loborataryServicesPage.ContactUs, "/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales", "\'ContactUs\' Button"));
            Assert.assertTrue(commonPage.ValidateLink(loborataryServicesPage.ASTMInsightSQC, "/standards-and-solutions/laboratory-services/astm-insight-sqc", "ASTM Insight SQC", "\'ASTM Insight SQC\' Learn More Link"));
            Assert.assertTrue(commonPage.ValidateLink(loborataryServicesPage.StandardOperatingProcedures, "/standards-and-solutions/laboratory-services/standard-operating-procedures-sop", "Standard Operating Procedures (SOP)", "\'Standard Operating Procedures (SOP)\' Learn More Link"));
            Assert.assertTrue(commonPage.ValidateLink(loborataryServicesPage.AssessmentChecklists, "/standards-and-solutions/laboratory-services/test-method-assessment-checklists-tma", "Test Method Assessment (TMA) Checklists", "\'Test Method Assessment\' Learn More Link"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(loborataryServicesPage.CementConcreteReferenceLaboratory, "http://www.ccrl.us/", "Cement & Concrete Reference Laboratory", "\'Cement and Concrete Reference Laboratory\' Learn More Link"));
            Assert.assertTrue(commonPage.ValidateLink(loborataryServicesPage.DevelopInternalDocuments, "/standards-and-solutions/enterprise-solutions/specbuilder", "ASTM SpecBuilder", "\'Develop Internal Documents with ASTM SpecBuilder\' Learn More Link"));
            Assert.assertTrue(commonPage.ValidateLink(loborataryServicesPage.GetStandardsOnline, "/standards-and-solutions/enterprise-solutions/astm-compass", "ASTM Compass", "\'Get Standards Online with ASTM Compass® \'Learn More Link"));
            Assert.assertTrue(commonPage.ValidateLink(loborataryServicesPage.DevelopInternalDocuments, "/standards-and-solutions/enterprise-solutions/specbuilder", "ASTM SpecBuilder", "\'Develop Internal Documents with ASTM SpecBuilder\' Learn More Link"));
            Assert.assertTrue(commonPage.ValidateLink(loborataryServicesPage.TrainWithExperts, "/standards-and-solutions/training-courses", "Training Courses", "\'Train with the Experts\' Learn More Link"));
        }catch (Exception e){
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate links and buttons available on Laboratory page",e);
        }
    }
    @Step("Validate navigation to Laboratory page")
    public void NavigateToLaboratoryPage() {
        try{
            commonPage.getstandardandSolution();
            commonPage.clickOnLaboratoryServices();
            WCMSICommon.waitForSec(3);
            Assert.assertEquals(driver.getTitle(),"ASTM International Laboratory Services");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        }catch (Exception e){
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to ASTM International Laboratory Services page", e);
        }
    }
}

