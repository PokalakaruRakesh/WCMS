package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyFAQPage_WCMSI_514 extends BaseTest {
    static final String jiraTestID = "WCMSI-514";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    FAQPage WCMSFAQ;
    BasePage basePage;


    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {

    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("FAQ: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + "FAQ: Navigation Verification for All Buttons and Links")
    public void VerifyFAQPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            WCMSFAQ = page.getInstance(FAQPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);


            driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM")+"faq");
            cookiePage.handleOneTrustCookie();
            ValidateFAQPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the FAQ Page", e);
        }
    }
    @Step("Validate FAQ Page")
    public void ValidateFAQPage() {
        try {
            basePage.clickOnMethod(commonPage.clickOnDropDown("What is an ASTM standard"));
            Assert.assertTrue(commonPage.ValidateLink(WCMSFAQ.selectLinkByHeader("What is an ASTM standard","various types"), "standards-category-list.html", "Standards By Category"));
            basePage.clickOnMethod(commonPage.clickOnDropDown("Where can I obtain information about copying"));
            Assert.assertTrue(commonPage.ValidateLink(WCMSFAQ.selectLinkByHeader("Where can I obtain information about copying","Learn more"), "copyright-and-permissions", "Copyright and Permissions | ASTM"));
            basePage.clickOnMethod(commonPage.clickOnDropDown("Does ASTM offer Continuing Education Credits"));
            Assert.assertTrue(commonPage.ValidateLink(WCMSFAQ.selectLinkByHeader("Continuing Education Credits","Learn more"), "standards-and-solutions/training-courses", "ASTM Industry Training Solutions | ASTM"));
            basePage.clickOnMethod(commonPage.clickOnDropDown("Does ASTM certify products"));
            Assert.assertTrue(commonPage.ValidateLink(WCMSFAQ.selectLinkByHeader("Does ASTM certify products","Learn more"), "https://www.seinet.org", "Welcome to Safety Equipment Institute"));
            basePage.clickOnMethod(commonPage.clickOnDropDown("Does ASTM certify personnel"));
            Assert.assertTrue(commonPage.ValidateLink(WCMSFAQ.selectLinkByHeader("Does ASTM certify personnel","Learn more"), "standards-and-solutions/certification", "Certification | ASTM"));
            basePage.clickOnMethod(commonPage.clickOnDropDown("How do I become an ASTM International member"));
            Assert.assertTrue(commonPage.ValidateLink(WCMSFAQ.selectLinkByHeader("How do I become an ASTM International member","and join online"), "membership-participation/memberships", "ASTM Membership | ASTM"));
            basePage.clickOnMethod(commonPage.clickOnDropDown("Does ASTM offer training for new members"));
            Assert.assertTrue(commonPage.ValidateLink(WCMSFAQ.selectLinkByHeader("Does ASTM offer training for new members","Virtual Classroom for Members"), "standards-and-solutions/training-courses/member-training", "Classroom for Members | ASTM"));
            basePage.clickOnMethod(commonPage.clickOnDropDown("Where can I find additional member"));
            Assert.assertTrue(commonPage.ValidateLink(WCMSFAQ.selectLinkByHeader("Where can I find additional member","Technical Committee section"), "membership-participation/technical-committees", "Technical Committees | ASTM"));
            basePage.clickOnMethod(commonPage.clickOnDropDown("How can I register for a meeting"));
            Assert.assertTrue(commonPage.ValidateLink(WCMSFAQ.selectLinkByHeader("How can I register for a meeting","Check the full list of upcoming events"), "https://member.astm.org/meeting/", "ASTM International"));
            basePage.clickOnMethod(commonPage.clickOnDropDown("When do committees regularly meet"));
            Assert.assertTrue(commonPage.ValidateLink(WCMSFAQ.selectLinkByHeader("When do committees regularly meet","Visit the ASTM meetings page"), "https://member.astm.org/meeting/", "ASTM International"));
            basePage.clickOnMethod(commonPage.clickOnDropDown("How do I propose an ASTM symposia"));
            Assert.assertTrue(commonPage.ValidateLink(WCMSFAQ.selectLinkByHeader("How do I propose an ASTM symposia","must complete an official proposal"), "https://member.astm.org/meeting/symposia-proposal", "ASTM International"));
            //basePage.clickOnMethod(commonPage.clickOnDropDown("How do I propose an ASTM symposia"));
            //Assert.assertTrue(commonPage.ValidateLink(WCMSFAQ.selectLinkByHeader("What are the responsibilities of a symposia chair","here"), "regs_Regulations.pdf", "Regulations"));
            basePage.clickOnMethod(commonPage.clickOnDropDown("I purchased a subscription"));
            //Assert.assertTrue(commonPage.ValidateLink(WCMSFAQ.selectLinkByHeader("I purchased a subscription","help"), "/help", "Help Center | ASTM"));
            //basePage.clickOnMethod(commonPage.clickOnDropDown("I need an invoice for a recent order"));
            //Assert.assertTrue(commonPage.ValidateLink(WCMSFAQ.selectLinkByHeader("I need an invoice for a recent order","here"), "/help", "Help Center | ASTM"));
            basePage.clickOnMethod(commonPage.clickOnDropDown("My organization has purchased a"));
            Assert.assertTrue(commonPage.ValidateLink(WCMSFAQ.selectLinkByHeader("My organization has purchased a","Help"), "/help", "Help Center | ASTM"));
            basePage.clickOnMethod(commonPage.clickOnDropDown("having trouble logging"));
            Assert.assertTrue(commonPage.ValidateLink(WCMSFAQ.selectLinkByHeader("having trouble logging","here"), "/help", "Help Center | ASTM"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the FAQ Page", e);
        }
    }

}
