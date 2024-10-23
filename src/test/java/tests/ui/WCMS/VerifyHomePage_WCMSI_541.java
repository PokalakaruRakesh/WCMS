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
import pages.ui.HomePage_WCMS;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyHomePage_WCMSI_541 extends BaseTest {
    static final String jiraTestID = "WCMSI-541";
    CookiePage cookiePage;
    HomePage_WCMS homepage;
    CommonPage_WCMS commonPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("WCMSI-361: Set 4: Home Page")
    @Description("To validate the Home page navigation and content on the page")
    @Test(description = jiraTestID + "Validate the Home page navigation and content on the page")
    public void ValidateHomePage() {
        try {
            commonPage = page.getInstance(CommonPage_WCMS.class);
            homepage = page.getInstance(HomePage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            cookiePage.handleOneTrustCookie();
            NavigateToHomePage();
            validateHomePageContent();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to Home page", e);
        }
    }

    @Step("Validate links and buttons available on Home page")
    public void validateHomePageContent() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(homepage.learnMoreaboutAstm, "/about", "About ASTM", "Learn More About ASTM Button "));
            Assert.assertTrue(commonPage.ValidateLink(homepage.standardizationNewsLearnMore, "https://sn.astm.org/?_gl=1*1hbvz04*_gcl_au*MTExNTYxNzQzNC4xNzI3MjY0NTUw", "Home | ASTM Standardization News", "Lean More about ASTM button clicked"));
            Assert.assertTrue(commonPage.ValidateLink(homepage.standardImpactLearMore, "https://standards-impact.buzzsprout.com/", "Standards Impact", "Lean More Standard Impact button clicked"));
            Assert.assertTrue(commonPage.ValidateLink(homepage.labManagerAcademyLearnMore, "https://www.astm.org/astm-tpt-1008.html", "Lab Manager Academy | Lab Management Certificate", "Lean More Lab Manager Academy clicked"));
            Assert.assertTrue(commonPage.ValidateLink(homepage.icam2024LearMore, "https://amcoe.org/event/icam2024/", "International Conference on Advanced Manufacturing 2024 - AM CoE", "Learn More ICAM clicked"));
            Assert.assertTrue(commonPage.ValidateLink(homepage.aboutAstmLearnMore, "/about", "About ASTM", "Learn More About ASTM Button"));
            Assert.assertTrue(commonPage.ValidateLink(homepage.membershipAndPartnershipLearnMore, "/membership-participation", "Membership & Participation", "Learn More Membership & Participation Button"));
            //Standards & Solutions
            Assert.assertTrue(commonPage.ValidateLink(homepage.astmCompassLearnMore, "/standards-and-solutions/enterprise-solutions/astm-compass", "ASTM Compass®", "Learn More About ASTM Compass clicked"));
            Assert.assertTrue(commonPage.ValidateLink(homepage.annualBookLearnMore, "/standards-and-solutions/bos", "Annual Book of ASTM Standards", "Learn More Annual Book of ASTM Standards clicked"));
            Assert.assertTrue(commonPage.ValidateLink(homepage.astmDigitalLearnMore, "/standards-and-solutions/digital-library/astm-digital-library-on-silverchair", "ASTM Digital Library on Silverchair", "Learn More ASTM Digital Library on Silver chair clicked"));
            Assert.assertTrue(commonPage.ValidateLink(homepage.astmSpeacBuilderLearnMore, "/standards-and-solutions/enterprise-solutions", "Enterprise Solutions", "Learn More ASTM SpecBuilder clicked"));
            Assert.assertTrue(commonPage.ValidateLink(homepage.internationalStandardLearnMore, "/standards-and-solutions/enterprise-solutions/astm-compass", "ASTM Compass®", "Learn More About International Standards clicked"));
            // Market Insights & Innovation
            Assert.assertTrue(commonPage.ValidateLinkNewtab(homepage.astmXcellerateLearnMore, "https://astmxcellerate.com/", "ASTM Xcellerate", "Learn More ASTM Xcellerate clicked"));
            Assert.assertTrue(commonPage.ValidateLink(homepage.centersofExcellenceLearnMore, "/standards-and-solutions/market-insights-and-innovation/innovation", "Market Innovation", "Learn More Centers of Excellence clicked"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(homepage.standardizationImpactReportLearnMore, "https://marketing.astm.org/acton/fs/blocks/showLandingPage/a/9652/p/p-0403/t/page/fm/0", "ASTM Standardization Impact Report 2024", "Learn More Standardization Impact Report clicked"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(homepage.marketIntelligenceLearnMore, "https://wohlersassociates.com/reports/", "State of the Industry Reports - Wohlers Associates", "Learn More Market Intelligence & Wholers Reports clicked"));
            // Laboratory Services
            Assert.assertTrue(commonPage.ValidateLink(homepage.laboratoryServicesLearnMore, "/standards-and-solutions/laboratory-services", "ASTM International Laboratory Services", "laboratory-services clicked"));
            Assert.assertTrue(commonPage.ValidateLink(homepage.trainingServicesLearnMore, "/standards-and-solutions/training-courses", "Training Courses", "Learn More Training and Certification clicked"));
            Assert.assertTrue(commonPage.ValidateLink(homepage.globalCooperationLearnMore, "/about/global-cooperation", "Global Cooperation", "Learn More Global Cooperation clicked"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Home page", e);
        }
    }

    @Step("Validate navigation to Home page")
    public void NavigateToHomePage() {
        try {
            Assert.assertEquals(driver.getTitle(), "Home");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to ASTM Home page", e);
        }
    }
}

