package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ReusableMethods;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
class VerifySustainabilityReferencePage_WCMSI_976 extends BaseTest {
    static final String jiraTestID = "WCMSI-976";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;
    TechnicalCommitteesWCMS TechnicalCommittees;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Sustainability Reference Page")
    @Test(description = jiraTestID + ": Sustainability Reference Page: Verify the UI, Responsiveness, content and Links of the page")
    public void VerifySustainabilityReferencePage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);
            TechnicalCommittees = page.getInstance(TechnicalCommitteesWCMS.class);

            commonPage.downloadFileSetup(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Membership & Participation","Technical Committees");
            ValidateSustainabilityReferencePage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Sustainability Reference Page", e);
        }
    }
    @Step("Validate Sustainability Reference Page")
    public void ValidateSustainabilityReferencePage() {
        try {
            basePage.clickOnMethod(TechnicalCommittees.SustainabilityReference);
            WCMSICommon.waitForSec(4);
            Assert.assertTrue(commonPage.ValidateDownloadedFile(TechnicalCommittees.SustainabilityStandardsListing,"sustainability_standards.xls"));
            Assert.assertTrue(page.getElement(TechnicalCommittees.InclusionSustainabilityDatabase).getAttribute("href").contains("mailto:kstraiton@astm.org"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(TechnicalCommittees.SustainabilityOverview,"E60_2024_PPT.pptx"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(TechnicalCommittees.SustainabilityChinese,"Sustainability_Overview_Translation.doc"));
            Assert.assertTrue(commonPage.ValidateLink(TechnicalCommittees.EPASustainability,"http://www.epa.gov/sustainability/", "Sustainability | US EPA"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Sustainability Reference Page", e);
        }
    }

}

