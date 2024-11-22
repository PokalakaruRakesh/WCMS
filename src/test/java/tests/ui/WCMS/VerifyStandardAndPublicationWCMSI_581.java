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
import pages.ui.StandardAndPuplicationWCMS;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyStandardAndPublicationWCMSI_581 extends BaseTest {
    static final String jiraTestID = "WCMSI-581";
    CookiePage cookiePage;
    StandardAndPuplicationWCMS StandardAndPublication;
    CommonPage_WCMS commonPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("WCMSI-372:  Set 5: Market Insights & Innovation, Standards & Publications, Book of Standards, Digital Library, Laboratory Services, Tracker Services")
    @Description("To validate the Standard And Publication functionality on the page")
    @Test(description = jiraTestID + "Validate the navigation on the page")
    public void ValidateStandardAndPublicationPage() {
        try {
            StandardAndPublication = page.getInstance(StandardAndPuplicationWCMS.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            cookiePage.handleOneTrustCookie();
            NavigatetoStandardAndPublicationPage();
            validateStandardAndPublicationPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to Standards & Publications page", e);
        }
    }

    @Step("Validate links and buttons available on page")
    private void validateStandardAndPublicationPage() {
        try {
            Assert.assertTrue(commonPage.ValidateLinkNewtab(StandardAndPublication.BrowseByCategory, "https://www.astm.org/products-services/standards-and-publications/standards/standards-category-list.html", "Standards By Category - Standards Products - Standards & Publications - Products & Services", "\'Browse by Category\' Button"));
            Assert.assertTrue(commonPage.ValidateLink(StandardAndPublication.SignUpTracker, "/standards-and-solutions/standards-and-publications/astm-standards-tracker", "ASTM Standards Tracker", "\'Sign Up for Tracker\' Button"));
            Assert.assertTrue(commonPage.ValidateLink(StandardAndPublication.BookAstmStandard, "/standards-and-solutions/bos", "Annual Book of ASTM Standards", "\'Book of ASTM Standards\'Learn More Link"));
            Assert.assertTrue(commonPage.ValidateLink(StandardAndPublication.ASTMCompass, "/standards-and-solutions/enterprise-solutions/astm-compass", "ASTM Compass", "\'ASTM Compass\'Learn More Link"));
            Assert.assertTrue(commonPage.ValidateLink(StandardAndPublication.ASTMDigitalLibrary, "/standards-and-solutions/digital-library", "ASTM Digital Library", "\'ASTM Digital Library\'Learn More Link"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(StandardAndPublication.Adjuncts, "https://www.astm.org/products-services/standards-and-publications/adjuncts-and-reference-radiographs.html", "Adjuncts and Reference Radiographs - Standards & Publications - Products & Services", "\'Adjuncts\' Button"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(StandardAndPublication.ReferenceRadiographs, "https://www.astm.org/products-services/standards-and-publications/adjuncts-and-reference-radiographs.html", "Adjuncts and Reference Radiographs - Standards & Publications - Products & Services", "\' Adjuncts\' Button"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(StandardAndPublication.ResearchReportsCommittee, "https://www.astm.org/products-services/standards-and-publications/research-reports.html", "Research Reports - Standards & Publications - Products & Services", "\'Research Reports by Committee\' Button"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(StandardAndPublication.ViewUOPStandards, "https://www.astm.org/products-services/standards-and-publications/standards/uop-standards.html", "UOP Standards - Standards Products - Standards & Publications - Products & Services", "\'View UOP Standards\' Button"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(StandardAndPublication.ASMEDigitalCollection, "https://asmedigitalcollection.asme.org/astm", "ASTM Content | ASME Digital Collection", "\'View UOP Standards\' Button"));
            Assert.assertTrue(commonPage.ValidateLink(StandardAndPublication.PeerReviewedSymposiaPapersSTPs, "/standards-and-solutions/standards-and-publications/symposia-papers", "Symposia Papers & STPs", "\'Peer-Reviewed Symposia Papers & STPs\' Learn More Link"));
            Assert.assertTrue(commonPage.ValidateLink(StandardAndPublication.ManualsMonographsDataSeries, "/standards-and-solutions/standards-and-publications/mnl", "Manuals, Monographs, & Data Series", "\'Manuals, Monographs & Data Series\' Learn More Link"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(StandardAndPublication.Journals, "https://www.astm.org/products-services/standards-and-publications/journals.html", "Journals - Standards & Publications - Products & Services", "\'Journals\' Learn More Link"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(StandardAndPublication.TechnicalReports, "https://www.astm.org/products-services/standards-and-publications/technical-reports.html", "Technical Reports - Standards & Publications - Products & Services", "\'Technical Reports\' Learn More Link"));
            Assert.assertTrue(commonPage.ValidateLink(StandardAndPublication.OpenReadingRoom, "/standards-and-solutions/standards-and-publications/reading-room", "Reading Room", "\'Reading Room\' Button"));
            Assert.assertTrue(commonPage.ValidateLink(StandardAndPublication.ViewCOVIDRelated, "/standards-and-solutions/standards-publications/covid-19", "ASTM Standards & COVID-19", "\'View COVID-19 Related Standards\' Button"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(StandardAndPublication.ShopRequestStandard, "/standards-and-solutions/enterprise-solutions/astm-compass", "ASTM Compass", "\'subscribe to an online volume via ASTM Compass\' Link"));
            Assert.assertTrue(commonPage.ValidateLink(StandardAndPublication.ContactUs, "/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales", "\'Contact US\' Button"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Validate navigation to Standards & Publications page")
    public void NavigatetoStandardAndPublicationPage() {
        try {
            commonPage.getstandardandSolution();
            commonPage.clickOnStandardAndPublications();
            WCMSICommon.waitForSec(3);
            Assert.assertEquals(driver.getTitle(), "Standards & Publications");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to Standards & Publications page", e);
        }
    }

}

