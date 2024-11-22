package tests.ui.WCMS;

import base.utils.ConfigReader;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.ASTMDigital_LibraryWCMS;
import pages.ui.CommonPage_WCMS;
import pages.ui.CookiePage;
import pages.ui.Tracker_ServicesWCMS;
import tests.ui.base.BaseTest;
@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyASTMDigitalLibraryWCMSI_607 extends BaseTest {
    static final String jiraTestID = "WCMSI-607";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    ASTMDigital_LibraryWCMS digitalLibrary;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("WCMSI-372:  Set 5: Market Insights & Innovation, Standards & Publications, Book of Standards, Digital Library, Laboratory Services, Tracker Services")
    @Description("To validate the Functionality of page ASTM Digital Library")
    @Test(description = jiraTestID + "Validate the Functionality of page ASTM Digital Library")
    public void validateDigitalLibrary() {
        commonPage = page.getInstance(CommonPage_WCMS.class);
        digitalLibrary = page.getInstance(ASTMDigital_LibraryWCMS.class);
        cookiePage = page.getInstance(CookiePage.class);
        cookiePage.handleOneTrustCookie();
        NavigateDigitalLibrary();
        ValidateDigitalLibraryContent();
    }
    @Step("Validate links and buttons available on page")
    public void ValidateDigitalLibraryContent() {
        Assert.assertTrue(commonPage.ValidateLinkNewtab(digitalLibrary.ASMEDigitalCollection, "https://asmedigitalcollection.asme.org/astm", "ASTM Content | ASME Digital Collection", "\'ASME Digital Collection\' Link"));
        Assert.assertTrue(commonPage.ValidateLink(digitalLibrary.PeerReviewedLearnMore,"/standards-and-solutions/standards-and-publications/symposia-papers","Symposia Papers & STPs","\'Peer-Reviewed Symposia Papers and Conference Proceedings\' Learn More Link"));
        Assert.assertTrue(commonPage.ValidateLink(digitalLibrary.ManualsMonographsLearnMore,"/standards-and-solutions/standards-and-publications/mnl","Manuals, Monographs, & Data Series","\'Manuals, Monographs, & Data Series\' Learn More Link"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(digitalLibrary.JournalsLearnMore,"https://www.astm.org/products-services/standards-and-publications/journals.html","Journals - Standards & Publications - Products & Services","\'Journals\' Learn More Link"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(digitalLibrary.TechnicalReportsLearnMore,"https://www.astm.org/products-services/standards-and-publications/technical-reports.html","Technical Reports - Standards & Publications - Products & Services","\'Technical Reports\' Learn More Link"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(digitalLibrary.AutherLearnMore, "https://assets.contentstack.io/v3/assets/blt5eb0a2cb04534832/blt7da9f76c4fd7f491/66d8138c0e97bcb39464bc0b/Publish-With-ASTM_1.pdf?branch=development", "", "\'Author\' Learn More Button"));
        Assert.assertTrue(commonPage.ValidateLink(digitalLibrary.DiscoverASTMCompass, "/standards-and-solutions/enterprise-solutions/astm-compass", "ASTM Compass", "\'Discover ASTM Compass\' Button"));
        Assert.assertTrue(commonPage.ValidateLink(digitalLibrary.ContactUs, "/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales", "\'Contact US \'Button"));
    }
    @Step("Validate Navigation to Digital Library")
    public void NavigateDigitalLibrary() {
        commonPage.getstandardandSolution();
        commonPage.clickonASTMDigitalLibrary();
        Assert.assertEquals(driver.getTitle(), "ASTM Digital Library");
    }
}
