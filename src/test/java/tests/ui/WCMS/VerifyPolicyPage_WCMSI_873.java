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

public class VerifyPolicyPage_WCMSI_873 extends BaseTest {
    static final String jiraTestID = "WCMSI-873";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;
    HomePage_WCMS HomePageWCMS;


    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("VerifyVerifyPolicyPage")
    @Test(description = jiraTestID + "VerifyVerifyPolicyPage")
    public void VerifyVerifyPolicyPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            HomePageWCMS = page.getInstance(HomePage_WCMS.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            clickOnPoliciesPage();
            ValidateVerifyPolicyPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Policy Page", e);
        }
    }
    @Step("Validate Policy Page")
    public void ValidateVerifyPolicyPage() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(HomePageWCMS.IPPolicy, "Itpolicy.pdf", "Originally Approved 28 April 1999"));
            Assert.assertTrue(commonPage.ValidateLink(HomePageWCMS.AIPolicy, "ASTM_AI_Policy.pdf", "Microsoft Word - ASTM-Letterhead_db.docx"));
            Assert.assertTrue(commonPage.ValidateLink(HomePageWCMS.UseOfAIQuestions, "https://forms.office.com/r/hLHk0arRLa", "Inquiry Regarding Use of AI on ASTM Content"));
            Assert.assertTrue(commonPage.ValidateLink(HomePageWCMS.LogoPolicy, "/policies/logo-policy", "Logo Policy | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(HomePageWCMS.LinkingPolicy, "link_policy.pdf", ""));
            Assert.assertTrue(commonPage.ValidateLink(HomePageWCMS.PoliciesPrivacyPolicy, "/policies/privacy-policy", "Privacy Policy | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(HomePageWCMS.ReturnPolicy, "/policies/return-policy", "Return Policy | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(HomePageWCMS.VeteranPolicy, "/policies/veteran-and-disabilities-policy", "Veteran and Disabilities Policy | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(HomePageWCMS.EqualEmploymentPolicy, "/policies/equal-opportunity-policy", "Equal Opportunity Policy | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(HomePageWCMS.EmploymentLawPolicy, "EEO_is_the_Law", "EEO_is_the_Law.pdf"));
            Assert.assertTrue(commonPage.ValidateLink(HomePageWCMS.PayTransparency, "Pay_Transparency_Nondiscrimination_Provision.pdf", "Pay_Transparency_Nondiscrimination_Provision.pdf"));
            Assert.assertTrue(commonPage.ValidateLink(HomePageWCMS.EEOLaw, "OFCCP_EEO_Supplement_Final_JRF_QA_508c.pdf", "EEO is the Law Poster Supplement"));
            Assert.assertTrue(commonPage.ValidateLink(HomePageWCMS.PolicyFAQ, "/policies/tpt-faq", "ASTM Training and E-Learning Policies and FAQs | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(HomePageWCMS.InstructorInterests, "/policies/instructor-proprietary-interests", "Instructor Proprietary Interests - Policies | ASTM"));



        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Policy Page", e);
        }
    }
    @Step("Validate Policy Page")
    public void clickOnPoliciesPage() {
        try {
            ReusableMethods.scrollIntoView(page.getElement(WCMSPage.getFooter("Policies")),driver);
            WaitStatementUtils.waitForElementToBeClickable(driver,page.getElement(WCMSPage.getFooter("Policies")),5);
            page.getElement(WCMSPage.getFooter("Policies")).click();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Policy Page", e);
        }
    }
}
