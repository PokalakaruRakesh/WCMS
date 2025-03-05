package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyCareersPage_WCMSI_857 extends BaseTest {
    static final String jiraTestID = "WCMSI-857";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;
    AboutPage AboutPageWCMS;


    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("VerifyCareersPage")
    @Test(description = jiraTestID + "VerifyCareersPage")
    public void VerifyInResidenceTrainingProgramsPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            AboutPageWCMS = page.getInstance(AboutPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("About ASTM","Governance");

            ValidateCareersPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Careers Page", e);
        }
    }
    @Step("Validate Careers Page")
    public void ValidateCareersPage() {
        try {
            basePage.clickOnMethod(AboutPageWCMS.CultureCareers);
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.ViewOpenOpportunities, "recruitment/recruitment.html", "Career Center | Recruitment"));
            Assert.assertTrue(page.getElement(AboutPageWCMS.AccessibilityHrEmail).getAttribute("href").contains("mailto:hr@astm.org"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.LearnAboutDiversity, "/about/diversity-inclusion", "Diversity, Equity, Inclusion, and Belonging | ASTM"));
            Assert.assertTrue(page.getElement(AboutPageWCMS.DiversityHrEmail).getAttribute("href").contains("mailto:hr@astm.org"));
            Assert.assertTrue(page.getElement(AboutPageWCMS.DiversityHrEmail2).getAttribute("href").contains("mailto:hr@astm.org"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.EVerifyEnglish, "EverifyPosterEnglish.pdf", "E-Verify Participation Poster English Version"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.EVerifySpanish, "EverifyPosterSpanish.pdf", "EverifyPosterSpanish.pdf"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.WorkPlaceDiscrimination, "EEOC_KnowYourRights_2022.pdf", "Know Your Rights: Workplace Discrimination is Illegal"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.RTW, "RTW_Poster_English_Version.pdf", "IF YOU HAVE THE RIGHT TO WORK (ENGLISH)"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.RTWS, "RTW_Poster_Spanish_Version.pdf", "Microsoft PowerPoint - WebBP_POSTER_RtoW-Spanishversion.ppt"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.ReviewEEOS, "/policies/equal-opportunity-policy", "Equal Opportunity Policy | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.ReviewVeteran, "/policies/veteran-and-disabilities-policy", "Veteran and Disabilities Policy | ASTM"));




        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Careers Page ", e);
        }
    }

}
