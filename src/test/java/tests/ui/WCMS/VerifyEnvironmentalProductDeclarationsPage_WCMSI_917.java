package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyEnvironmentalProductDeclarationsPage_WCMSI_917 extends BaseTest {
    static final String jiraTestID = "WCMSI-919";
    CookiePage cookiePage;
    EnvironmentalProductDeclarationsWCMS environmentalProductDeclarationsPage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));

    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Environmental Product Declarations: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": Environmental Product Declarations: Navigation Verification for All Buttons and Links")
    public void VerifyEnvironmentalProductDeclarationsPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            environmentalProductDeclarationsPage = page.getInstance(EnvironmentalProductDeclarationsWCMS.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","Environmental Product Declarations");
            ValidateEnvironmentalProductDeclarationsPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Environmental Product Declarations: Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate Environmental Product Declarations Page")
    public void ValidateEnvironmentalProductDeclarationsPage() {
        try {
            Assert.assertTrue(page.getElement(environmentalProductDeclarationsPage.PCRsEPDsCurrentlyPublished).getAttribute("href").contains("#pcr-epd"));
            Assert.assertTrue(page.getElement(environmentalProductDeclarationsPage.AboutTheProgram).getAttribute("href").contains("#about"));
            Assert.assertTrue(page.getElement(environmentalProductDeclarationsPage.WhyASTM).getAttribute("href").contains("#why-astm"));
            Assert.assertTrue(page.getElement(environmentalProductDeclarationsPage.ProductCategoryRuleDevelopment).getAttribute("href").contains("#rule-dev"));
            Assert.assertTrue(page.getElement(environmentalProductDeclarationsPage.EPDVerification).getAttribute("href").contains("#epd-ver"));
            Assert.assertTrue(page.getElement(environmentalProductDeclarationsPage.FrequentlyAskedQuestions).getAttribute("href").contains("#faq"));
            Assert.assertTrue(page.getElement(environmentalProductDeclarationsPage.ContactUs).getAttribute("href").contains("#contact"));
            Assert.assertTrue(commonPage.ValidateLink(environmentalProductDeclarationsPage.EPDHereLink,"environmental-product-declarations/epd-pcr", ""));
            Assert.assertTrue(commonPage.ValidateLink(environmentalProductDeclarationsPage.FAQHereLink,"CERT_faqs.pdf", "Microsoft Word - Document1"));
            Assert.assertTrue(page.getElement(environmentalProductDeclarationsPage.ContactUsMail).getAttribute("href").contains("cert@astm.org"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Environmental Product Declarations", e);
        }
    }

}
