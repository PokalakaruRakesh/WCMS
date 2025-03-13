package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyPublishBooksAndJournalsPage_WCMSI_710 extends BaseTest {
    static final String jiraTestID = "WCMSI-710";
    CookiePage cookiePage;
    PublishWithASTMWCMS PublishWithASTM;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Publish Books and Journals with ASTM: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": Publish Books and Journals with ASTM: Navigation Verification for All Buttons and Links")
    public void VerifyASTMCannabisTrainingPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            PublishWithASTM = page.getInstance(PublishWithASTMWCMS.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Membership & Participation","Publish with ASTM");
            ValidatePublishBooksAndJournalsPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Publish Books and Journals with ASTM: Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate Publish Books and Journals Page")
    public void ValidatePublishBooksAndJournalsPage() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(PublishWithASTM.DigitalLibrary,"/standards-and-solutions/digital-library", "Digital Library"));
            Assert.assertTrue(commonPage.ValidateLink(PublishWithASTM.OpenAccessPolicy,"open-access", "Open Access Policy - Journals"));
            Assert.assertTrue(commonPage.ValidateLink(PublishWithASTM.LearnMoreLink,"Publish-With-ASTM_1.pdf", "ASTM International Digital Library"));
            Assert.assertTrue(commonPage.ValidateLink(PublishWithASTM.BooksSoftwareDigitalLibrary,"/digital-library", "Digital Library"));
            Assert.assertTrue(commonPage.ValidateLink(PublishWithASTM.BooksSoftwareBookProposalGuide,"ASTM_Book_Proposal_Guide.pdf", "Guide to Publishing in ASTM"));

            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("All Journals"),"journals.html", "Journals"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Advances in Civil Engineering Materials"),"advances-in-civil-engineering-materials", "Engineering Materials"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Geotechnical Testing Journal"),"geotechnical-testing-journal", "Geotechnical Testing"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Journal of Testing and Evaluation"),"journal-of-testing-and-evaluation", "Journal of Testing and Evaluation"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Materials Performance"),"materials-performance-and-characterization", "Materials Performance"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Smart and Sustainable"),"smart-and-sustainable-manufacturing-systems", "Smart and Sustainable Manufacturing Systems"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("About our Publishing Partners"),"AboutJ&J.pdf", "AboutJ&J"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("ASTM Publication Ethics Policy"),"Publication_Ethics_Policy.pdf", "Publication_Ethics_Policy.pdf"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("ASTM Style Manual"),"ASTM_Style_Manual_nonGTJ", "Introduction"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("GTJ"),"ASTM_Style_Manual_GTJ", "Introduction"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Author Instructions"),"ASTM_Instructions_for_Authors", "Selected Technical Papers"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Committee on Publications"),"COP_Policies_and_Procedures_updated", "COMMITTEE ON PUBLICATIONS"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Open Access Policy"),"open-access", "Open Access Policy"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Special Issue Guidelines"),"Guidelines_For_Special_Issue", "Guidelines_For_Special_Issue"));

            Assert.assertTrue(page.getElement(commonPage.getElement("Todd Reitzel")).getAttribute("href").contains("treitzel@astm.org"));
            Assert.assertTrue(page.getElement(commonPage.getElement("Alyssa Conaway")).getAttribute("href").contains("aconaway@astm.org"));
            Assert.assertTrue(page.getElement(commonPage.getElement("Monica Siperko")).getAttribute("href").contains("msiperko@astm.org"));
            Assert.assertTrue(page.getElement(commonPage.getElement("Lesley West")).getAttribute("href").contains("lwest@astm.org"));
            Assert.assertTrue(page.getElement(commonPage.getElement("Jessica Schmidt")).getAttribute("href").contains("jschmidt@astm.org"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Publish Books and Journals with ASTM", e);
        }
    }

}
