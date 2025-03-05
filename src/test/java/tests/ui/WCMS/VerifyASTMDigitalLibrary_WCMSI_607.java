package tests.ui.WCMS;

import base.utils.ConfigReader;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.ASTMDigital_LibraryWCMS;
import pages.ui.CommonPage_WCMS;
import pages.ui.CookiePage;
import tests.ui.base.BaseTest;
@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyASTMDigitalLibrary_WCMSI_607 extends BaseTest {
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
        Assert.assertTrue(commonPage.ValidateLink(digitalLibrary.ASMEDigitalCollection, "https://asmedigitalcollection.asme.org/astm", "ASTM Content | ASME Digital Collection"));
        Assert.assertTrue(commonPage.ValidateLink(digitalLibrary.PeerReviewedLearnMore,"/standards-and-solutions/standards-and-publications/symposia-papers","Symposia Papers & STPs"));
        Assert.assertTrue(commonPage.ValidateLink(digitalLibrary.ManualsMonographsLearnMore,"/standards-and-solutions/standards-and-publications/mnl","Manuals, Monographs, & Data Series"));
        Assert.assertTrue(commonPage.ValidateLink(digitalLibrary.JournalsLearnMore,"/journals.html","Journals - Standards & Publications - Products & Services"));
        Assert.assertTrue(commonPage.ValidateLink(digitalLibrary.TechnicalReportsLearnMore,"/technical-reports.html","Technical Reports - Standards & Publications - Products & Services"));
        Assert.assertTrue(commonPage.ValidateLink(digitalLibrary.AutherLearnMore, "/Publish-With-ASTM_1.pdf", ""));
        Assert.assertTrue(commonPage.ValidateLink(digitalLibrary.DiscoverASTMCompass, "/standards-and-solutions/enterprise-solutions/astm-compass", "ASTM Compass"));
        Assert.assertTrue(commonPage.ValidateLink(digitalLibrary.ContactUs, "/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales"));
    }
    @Step("Validate Navigation to Digital Library")
    public void NavigateDigitalLibrary() {
        commonPage.getstandardandSolution();
        commonPage.clickonASTMDigitalLibrary();
        Assert.assertTrue(driver.getTitle().contains("ASTM Digital Library"));
    }
}
