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
import pages.ui.Help_WCMS;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyHelpOverview_WCMSI_511 extends BaseTest {
    static final String jiraTestID = "WCMSI-511'";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    Help_WCMS helpWcms;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("WCMSI-327: Set 1: About ASTM, M&P, S&S, Help and FAQ")
    @Description("To validate the navigation to Help Overview")
    @Test(description = jiraTestID + "Validate the navigation and to Help Overview page")
    public void validateHelpOverviewPage() {
        commonPage = page.getInstance(CommonPage_WCMS.class);
        helpWcms = page.getInstance(Help_WCMS.class);
        cookiePage = page.getInstance(CookiePage.class);
        cookiePage.handleOneTrustCookie();
        navigatetoHelpOverview();

        validateHelpOverviewLinks();
    }


    @Step("Validate links and buttons available on Help Overview page")
    public void validateHelpOverviewLinks() {
        try {
            if(driver.getCurrentUrl().contains("qa")){
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.InvoiceRequests, "/contact", "Contact Us", "\'Invoice Requests\' Learn More Link"));
                Assert.assertTrue(commonPage.ValidateLinkNewtab(helpWcms.LoginProblemsPasswordReset, "v3/assets/blt5eb0a2cb04534832", "", "\'Login Problems/Password Reset\' Learn More link"));
                Assert.assertTrue(commonPage.ValidateLinkNewtab(helpWcms.ASTMOnlinePaymentPortalFAQPage, "https://marketing.astm.org", "ASTM Service Request Form", "\'ASTM Online Payment Portal FAQ Page\' Learn More link"));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.Aboutus, "/about", "", "\'About us\' link"));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.WhatASTM, "/about/fact-sheet", "", "\'What is ASTM? / ASTM Fact Sheet\' link"));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.WhatNewASTM, "news/press-releases", "Press Releases | ASTM", "\'What is ASTM? / ASTM Fact Sheet\' link"));
                Assert.assertTrue(commonPage.ValidateLinkNewtab(helpWcms.ElectronicLicenseAgreement, "License_Agreement.pdf", "", "\'Electronic License Agreement\' Link"));
                Assert.assertTrue(commonPage.ValidateLinkNewtab(helpWcms.TermsandConditionsChart, "Terms_of_Use_Terms_Conditions_Chart.pdf", "", "\'Terms and Conditions Chart\' Link"));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.PrivacyPolicy, "/policies/privacy-policy", "Privacy Policy", "\'Privacy Policy\' Link"));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.CopyrightPermissions, "/copyright-and-permissions", "Copyright and Permissions", "\'Copyright and Permissions\' Link"));
                //Assert.assertTrue(commonPage.ValidateLink(helpWcms.AIPolicy, "https://assets.contentstack.io/v3/assets/blt5eb0a2cb04534832/blt7c6c41032d134f82/67407132bef4ad6004f2edeb/ASTM_AI_Policy.pdf?branch=stage", "", "\'AI Policy\' Link"));
                Assert.assertTrue(commonPage.ValidateLinkNewtab(helpWcms.OtherPolicies, "https://www.astm.org/media/wysiwyg/ASTM_AI_Policy.pdf", "", "\'Other Policies\' Link"));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.EmailSubscriptionsettingsLearnMore, "/email-subscription-settings", "", "\'Email subscription settings\' Link"));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.AddRemoveMarketing, "/contact", "Contact", "\' How do I Add/Remove myself to ASTM Marketing\' Link"));
                Assert.assertTrue(commonPage.ValidateLinkNewtab(helpWcms.OrderOnline, "/contact", "Contact", "\' I’m having trouble placing an order online\' Link"));
                Assert.assertTrue(commonPage.ValidateLinkNewtab(helpWcms.InvoiceOnlineCreditCard, "https://marketing.astm.org/acton/attachment/9652/f-cc4cc0a2-fd35-4b9e-a8e8-784da709e015/1/-/-/-/-/BillTrust%20-%20Credit%20Card.pdf?utm_term=Credit%20Card%20Payment%20Instructions&utm_content=landing+page&utm_source=Act-On+Software&utm_medium=landing+page&sid=TV2:a4QQsQD7t", "", "\' How do I pay my invoice online with a credit card\' Link"));
                Assert.assertTrue(commonPage.ValidateLinkNewtab(helpWcms.OnlinePaymentBilltrustFAQ, "https://marketing.astm.org/acton/fs/blocks/showLandingPage/a/9652/p/p-0378/t/page/fm/0", "", "\' Online Payment (Billtrust) FAQ Page\' Link"));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.RefundRequest, "/contact", "Contact", "\' How do I submit a refund request\' Link"));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.MembershipTypesBenefits, "/membership-participation/memberships", "", "\' Membership Types and Benefits\' Link"));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.MemberTrainingNewMemberOrientation, "/standards-and-solutions/training-courses/member-training", "", "\' Member Training and New Member Orientation\' Link"));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.RegionalOfficesSupportLearnMore, "/about/locations/regional-offices-and-support", "", "\' Regional Offices and Support\' Learn More Button"));
                Assert.assertTrue(commonPage.ValidateLinkNewtab(helpWcms.EZProxy, "EZproxy_and_ASTM.pdf", "", "\' EZProxy \' Link"));
                Assert.assertTrue(commonPage.ValidateLinkNewtab(helpWcms.DeletingCookiesCache, "Deleting_Cookies_and_Cache.pdf", "", "\' Deleting Cookies and Cache\' Link"));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.W9Form, "ASTM_W-9_2024.pdf", "", "\' W-9 Form\' Link"));
            }else {
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.InvoiceRequests, "/contact", "Contact Us"));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.LoginProblemsPasswordReset, "v3/assets/blt5eb0a2cb04534832",""));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.ASTMOnlinePaymentPortalFAQPage, "https://marketing.astm.org", "ASTM Service Request Form"));
                //About ASTM
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.Overview, "/about", "About ASTM Overview"));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.ASTMFactSheet, "/about/fact-sheet", ""));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.ASTMNewsroom, "/news/press-releases", "Press Releases"));
                //Assert.assertTrue(commonPage.ValidateLink(helpWcms.MediaContact, "mailto:dbergels@astm.org", "About ASTM Overview"));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.LogoPolicy, "/logo-policy", "Logo Policy"));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.ReadingRoom, "/reading-room", "Reading Room - Products & Services"));
                //Policies and Agreements
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.PrivacyPolicy, "/policies/privacy-policy", "Privacy Policy"));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.CopyrightPermissions, "/copyright-and-permissions", "Copyright and Permissions"));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.ElectronicLicenseAgreement, "License_Agreement.pdf", ""));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.AIPolicy, "AI_Policy.pdf", ""));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.TermsOfUseAndConditions, "Terms_of_Use_Terms_Conditions_Chart.pdf", ""));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.OtherPolicies, "https://www.astm.org/media/wysiwyg/ASTM_AI_Policy.pdf", ""));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.W9Form, "ASTM_W-9_2024.pdf", ""));

                Assert.assertTrue(commonPage.ValidateLink(helpWcms.InvoiceOnlineCreditCard, "https://marketing.astm.org/acton/attachment/9652/f-cc4cc0a2-fd35-4b9e-a8e8-784da709e015", ""));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.OnlinePaymentBilltrustFAQ, "https://marketing.astm.org/acton/fs/blocks/showLandingPage/a/9652/p/p-0378/t/page/fm/0", ""));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.RefundRequest, "/contact", "Contact", "\' How do I submit a refund request\' Link"));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.MembershipTypesBenefits, "/membership-participation/memberships", "", "\' Membership Types and Benefits\' Link"));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.MemberTrainingNewMemberOrientation, "/standards-and-solutions/training-courses/member-training", ""));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.EZProxy, "EZproxy_and_ASTM.pdf", ""));
                Assert.assertTrue(commonPage.ValidateLink(helpWcms.DeletingCookiesCache, "Deleting_Cookies_and_Cache.pdf", ""));
            }

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button Help Overview page", e);
        }
    }

    @Step("Validate navigation to Help Overview page")
    public void navigatetoHelpOverview() {
        try {
            commonPage.getHelp();
            commonPage.clickHelpOverview();
            Assert.assertEquals(driver.getTitle(), "Help Center | ASTM");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Help Overview", e);
        }
    }
}
