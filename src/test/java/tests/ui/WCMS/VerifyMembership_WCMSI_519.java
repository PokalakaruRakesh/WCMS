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
import pages.ui.MembershipWCMS;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyMembership_WCMSI_519 extends BaseTest {
    static final String jiraTestID = "WCMSI-519";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    MembershipWCMS Membership;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("WCMSI-338: Set 2: History, 125th Anniversary Case Studies, Membership, Students, Emerging Professionals, Consumer Participation, Technical Committees, Regional Offices")
    @Description("To validate the navigation to Membership Page")
    @Test(description = jiraTestID + "Validate the navigation and to Membership page")
    public void validateMembership() {
        commonPage = page.getInstance(CommonPage_WCMS.class);
        Membership = page.getInstance(MembershipWCMS.class);
        cookiePage = page.getInstance(CookiePage.class);
        cookiePage.handleOneTrustCookie();
        navigateToMembership();
        validateMembershipLinks();
    }

    @Step("Validate links and buttons available on Membership Page")
    public void validateMembershipLinks() {
        try {
            Assert.assertTrue(commonPage.ValidateLinkNewtab(Membership.ParticipatingMembership, "https://member.astm.org/application/participating", "ASTM International - Membership", "\'Participating Membership\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(Membership.OrganizationalMembership, "https://member.astm.org/application/organizational", "ASTM International - Membership", "\'Organizational Membership\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(Membership.InformationalMembership, "astm.org//get-involved/membership/memindividual24.html", "2024 Individual Membership", "\'Informational Membership\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLink(Membership.StudentMembership, "/membership-participation/student-members", "Student Members", "\'Student Members\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(Membership.EmergingProfessionals, "/membership-participation/emerging-professionals", "Emerging Professionals Program", "\'Emerging Professionals\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLink(Membership.JoinASTMTechnicalCommittee, "/membership-participation/technical-committees", "Technical Committees", "\'Join an ASTM Technical Committee\' Learn More link"));

            Assert.assertTrue(commonPage.ValidateLink(Membership.MemberResources, "/membership-participation/technical-committees", "Technical Committees", "\'Emerging Professionals\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLink(Membership.NewMemberOrientation, "/standards-and-solutions/training-courses/member-training#new-member-training", "Classroom for Members", "\' New Member Orientation\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLink(Membership.VirtualClassroomMembers, "/standards-and-solutions/training-courses/member-training", "Classroom for Members", "\'Classroom for Members\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLink(Membership.TechnicalCommitteeResources, "/membership-participation/technical-committees", "Technical Committees", "\'Technical Committee Resources\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLink(Membership.KeyDocumentsForms, "/membership-participation/technical-committees/key-documents", "Key Documents and Forms", "\'Key Documents & Forms\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLink(Membership.MembershipFAQs, "/faq", "Frequently Asked Questions", "\'Membership FAQs\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(Membership.RenewReinstateMembership, "astm.org/customer/account/login/referer/aHR0cHM6Ly93d3cuYXN0bS5vcmcvY3VzdG9tZXIvYWNjb3VudC9sb2dpbi8%3D/", "Customer Login", "\'Renew or Reinstate Membership\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLink(Membership.ContactASTMMember, "/contact", "Contact Us", "\'Contact ASTM Member\' Learn More link"));


        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Membership Page", e);
        }
    }

    @Step("Validate navigation to Membership Page")
    public void navigateToMembership() {
        try {
            commonPage.clickOnMembershipParticipation();
            WCMSICommon.waitForSec(1);
            commonPage.clickOnMembership();
            WCMSICommon.waitForSec(1);
            Assert.assertTrue(driver.getTitle().contains("ASTM Membership | ASTM"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate navigation to Membership page", e);
        }
    }
}
