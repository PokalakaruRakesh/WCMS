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
import pages.ui.MembershipAndParticipationOverviewWCMS;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyMembershipAndParticipationOverview_WCMSI_496 extends BaseTest {
    static final String jiraTestID = "WCMSI-496";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    MembershipAndParticipationOverviewWCMS MembershipAndParticipationOverview;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("WCMSI-327: Set 1: About ASTM, M&P, S&S, Help and FAQ")
    @Description("To validate the navigation to Membership And Participation Overview")
    @Test(description = jiraTestID + "Validate the navigation and to Membership And Participation page")
    public void validateMembershipAndParticipation() {
        commonPage = page.getInstance(CommonPage_WCMS.class);
        MembershipAndParticipationOverview = page.getInstance(MembershipAndParticipationOverviewWCMS.class);
        cookiePage = page.getInstance(CookiePage.class);
        cookiePage.handleOneTrustCookie();
        navigatetoMembershipAndParticipationOverview();
        validaMembershipAndParticipationLinks();

    }

    @Step("Validate links and buttons available on Membership And Participation Overview page")
    public void validaMembershipAndParticipationLinks() {
        try {
            Assert.assertTrue(commonPage.ValidateLinkNewtab(MembershipAndParticipationOverview.ParticipatingMembership, "https://member.astm.org/application/participating", "ASTM International - Membership", "\'Participating Membership\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(MembershipAndParticipationOverview.OrganizationalMembership, "https://member.astm.org/application/organizational", "ASTM International - Membership", "\'Organizational Membership\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(MembershipAndParticipationOverview.InformationalMembership, "https://www.astm.org/get-involved/membership/memindividual24.html", "2024 Individual Membership", "\'Informational Membership\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLink(MembershipAndParticipationOverview.StudentMembership, "/membership-participation/student-members", "Student Members", "\'Student Members\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLink(MembershipAndParticipationOverview.DirectCommitteeParticipation, "/membership-participation/memberships", "ASTM Membership", "\'Direct Committee Participation\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLink(MembershipAndParticipationOverview.PublicationDiscounts, "/standards-and-solutions/digital-library", "ASTM Digital Library", "\'Publication Discounts\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLink(MembershipAndParticipationOverview.StandardizationNews, "/standardization-news", "STANDARDIZATION NEWS", "\'Standardization News\' Learn More link"));
            Assert.assertTrue(commonPage.ValidateLink(MembershipAndParticipationOverview.ExploreBenefitsJoin, "/membership-participation/memberships", "ASTM Membership", "\'Explore Benefits - Join\' Button"));
            Assert.assertTrue(commonPage.ValidateLink(MembershipAndParticipationOverview.MyCommittees, "https://secure.astm.org/?redirectUrl=aHR0cHM6Ly93d3cuYXN0bS5vcmcvc3NvL2xvZ2luL2F1dG8%3D&newApproach=true", "ASTM Login", "\'My Committees\' Learn More Link"));
            Assert.assertTrue(commonPage.ValidateLink(MembershipAndParticipationOverview.ASTMCompass, "/standards-and-solutions/enterprise-solutions/astm-compass", "ASTM Compass", "\'ASTM Compass\' Learn More Link"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(MembershipAndParticipationOverview.GetPublished, "https://assets.contentstack.io/v3/assets/blt5eb0a2cb04534832/blt7da9f76c4fd7f491/66d8138c0e97bcb39464bc0b/Publish-With-ASTM_1.pdf?branch=development", "", "\'Sustainability Reference DatabaseGet Published\' Learn More Button"));
            Assert.assertTrue(commonPage.ValidateLink(MembershipAndParticipationOverview.TechnicalCommitteesLearnMore, "/membership-participation/technical-committees", "Technical Committees", "\'Technical Committees\' Learn More Button"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(MembershipAndParticipationOverview.MeetingsSymposiaWorkshopsLearMore, "https://member.astm.org/meeting/", "ASTM International", "\'Meetings, Symposia & Workshops\' Learn More Button"));
            Assert.assertTrue(commonPage.ValidateLink(MembershipAndParticipationOverview.MemberOfficerTrainingLearnMore, "/standards-and-solutions/training-courses/member-training", "Classroom for Members", "\'Member & Officer Training\' Learn More Button"));
            Assert.assertTrue(commonPage.ValidateLink(MembershipAndParticipationOverview.ConsumerParticipationLearnMore, "/membership-participation/consumer-participation", "Consumers and ASTM International", "\'Consumer Participation\' Learn More Button"));
            Assert.assertTrue(commonPage.ValidateLink(MembershipAndParticipationOverview.StudentsLearnMore, "/membership-participation/student-members", "Students", "\'Student Members\' Learn More Button"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Membership And Participation overview page", e);
        }
    }

    @Step("Validate navigation to Membership And Participation overview page")
    public void navigatetoMembershipAndParticipationOverview() {
        try {
            commonPage.clickOnMembershipParticipation();
            commonPage.clickOnMembershipAndParticipationOverviewNavigation();
            Assert.assertTrue(driver.getTitle().contains("Membership & Participation Overview | ASTM"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available Membership And Participation overview", e);
        }
    }
}
