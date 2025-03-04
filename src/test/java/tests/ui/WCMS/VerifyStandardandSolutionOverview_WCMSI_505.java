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
import pages.ui.Standard_SolutionOverviewWCMS;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyStandardandSolutionOverview_WCMSI_505 extends BaseTest {
    static final String jiraTestID = "WCMSI-505";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    Standard_SolutionOverviewWCMS Standard_SolutionOverview;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("WCMSI-327: Set 1: About ASTM, M&P, S&S, Help and FAQ")
    @Description("To validate the navigation to Standard and Solution Overview")
    @Test(description = jiraTestID + "Validate the navigation and to Standard and Solution Overview page")
    public void validateMembershipAndParticipation() {
        commonPage = page.getInstance(CommonPage_WCMS.class);
        Standard_SolutionOverview = page.getInstance(Standard_SolutionOverviewWCMS.class);
        cookiePage = page.getInstance(CookiePage.class);
        cookiePage.handleOneTrustCookie();
        navigatetoStandardSolutionOverview();
        validateStandardSolutionOverviewLinks();
    }

    @Step("Validate links and buttons available on Standard and Solution Overview page")
    public void validateStandardSolutionOverviewLinks() {
        try {
            // Expected title addition is pending due to https://astm.atlassian.net/browse/WCMSI-1090
            Assert.assertTrue(commonPage.ValidateLink(Standard_SolutionOverview.StandardsLearnMore, "/standards-and-solutions/bos", "Annual Book of ASTM Standards | ASTM", "\'Standard\' Learn More Button"));
            //Assert.assertTrue(commonPage.ValidateLink(Standard_SolutionOverview.SubscriptionPortalsLearnMore, "/standards-and-solutions/enterprise-solutions/subscription-portals", "Subscription Portals | ASTM", "\'Subscription Portals\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLink(Standard_SolutionOverview.ASTMCompassLearnMore, "/standards-and-solutions/enterprise-solutions/astm-compass", "", "\'ASTM Compass\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLink(Standard_SolutionOverview.ASTMSpecBuilderLearnMore, "/standards-and-solutions/enterprise-solutions/specbuilder", "ASTM SpecBuilder | ASTM", "\'ASTM SpecBuilder\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLink(Standard_SolutionOverview.InternationalStandardsLearnMore, "enterprise-solutions/other-publishers", "", "\'Third-Party Content\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLink(Standard_SolutionOverview.MultimediaServicesLearnMore, "/standards-and-solutions/enterprise-solutions/multimedia-services", "ASTM Multimedia Solutions | ASTM", "\'Multimedia Services\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(Standard_SolutionOverview.ASTMXcellerateLearnMore, "https://astmxcellerate.com/", "ASTM Xcellerate", "\'ASTM Xcellerate\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLink(Standard_SolutionOverview.CentersExcellenceLearnMore, "/standards-and-solutions/market-insights-and-innovation", "Market Insights", "\'Centers of Excellence\' Learn More Link"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(Standard_SolutionOverview.StandardizationImpactReportLearnMore, "https://marketing.astm.org", "ASTM Standardization Impact", "\'Standardization Impact Report\' Learn More Link"));
            Assert.assertTrue(commonPage.ValidateLink(Standard_SolutionOverview.LaboratoryServicesLearnMore, "/standards-and-solutions/laboratory-services", "ASTM International Laboratory Services | ASTM", "\'Laboratory Services\' Learn More Button"));
            Assert.assertTrue(commonPage.ValidateLink(Standard_SolutionOverview.TrainingLearnMore, "/standards-and-solutions/training-courses", "ASTM Industry Training Solutions | ASTM", "\'Training\' Learn More Link"));
            Assert.assertTrue(commonPage.ValidateLink(Standard_SolutionOverview.CertificationLearnMore, "/standards-and-solutions/certification", "Certification | ASTM", "\'Certification\' Learn More Link"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(Standard_SolutionOverview.CementConcreteReferenceLaboratoryLearnMore, "http://www.ccrl.us/", "Cement & Concrete Reference Laboratory", "\'Cement and Concrete Reference Laboratory\' Learn More Button"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Standard and Solution Overview page", e);
        }
    }

    @Step("Validate navigation to Standard and Solution Overview page")
    public void navigatetoStandardSolutionOverview() {
        try {
            commonPage.getstandardandSolution();
            commonPage.clickStandardAndSolutionOverview();
            Assert.assertEquals(driver.getTitle(), "Standards & Solutions | ASTM");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available Standard and Solution Overview", e);
        }
    }
}
