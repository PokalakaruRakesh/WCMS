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
import pages.ui.TechnicalCommitteesWCMS;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyTechnicalCommittees_WCMSI_526 extends BaseTest {
    static final String jiraTestID = "WCMSI-526";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    TechnicalCommitteesWCMS technicalCommittees;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("WCMSI-338: Set 2: History, 125th Anniversary Case Studies, Membership, Students, Emerging Professionals, Consumer Participation, Technical Committees, Regional Offices")
    @Description("To validate the navigation to Technical Committees")
    @Test(description = jiraTestID + "Validate the navigation and to Technical Committees page")
    public void validateTechnicalCommittees() {
        commonPage = page.getInstance(CommonPage_WCMS.class);
        technicalCommittees = page.getInstance(TechnicalCommitteesWCMS.class);
        cookiePage = page.getInstance(CookiePage.class);
        cookiePage.handleOneTrustCookie();
        navigatetoTechnicalCommittees();
        validaTechnicalCommitteesLinks();
    }

    @Step("Validate links and buttons available on Technical Committees page")
    public void validaTechnicalCommitteesLinks() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(technicalCommittees.workItemfullListView, "/membership-participation/technical-committees/work-items-full-list", "Work Items- Full List"));
            Assert.assertTrue(commonPage.ValidateLink(technicalCommittees.InitiateNewStandardsActivity, "/membership-participation/technical-committees/new-standards-development", "New Standards Development"));
            Assert.assertTrue(commonPage.ValidateLink(technicalCommittees.SocietyReview, "/society-review", "Society (Public) Review | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(technicalCommittees.ANSIPublicReview, "/membership-participation/technical-committees/ansi-review", "ANSI Public Review"));
            Assert.assertTrue(commonPage.ValidateLink(technicalCommittees.SCCPublicReview, "/scc-public-review", "SCC Public Review"));
            Assert.assertTrue(commonPage.ValidateLink(technicalCommittees.joinNow, "/membership-participation/memberships", ""));
            Assert.assertTrue(commonPage.ValidateLink(technicalCommittees.TechnicalCommitteeeFullList, "/membership-participation/technical-committees/committee-all", "Technical Committees by Designation - Full List"));
            Assert.assertTrue(commonPage.ValidateLink(technicalCommittees.InterlaboratoryStudyProgram, "/membership-participation/technical-committees/interlaboratory-studies-program", "Interlaboratory Study Program"));
            Assert.assertTrue(commonPage.ValidateLink(technicalCommittees.EmergingProfessionalsProgram, "/membership-participation/emerging-professionals", "Emerging Professionals Program"));
            Assert.assertTrue(commonPage.ValidateLink(technicalCommittees.LabServices, "/standards-and-solutions/laboratory-services", "ASTM International Laboratory Services"));
            Assert.assertTrue(commonPage.ValidateLink(technicalCommittees.SustainabilityReferenceDatabase, "/membership-participation/technical-committees/sustainability-reference", "ASTM Sustainability Reference Database"));
            Assert.assertTrue(commonPage.ValidateLink(technicalCommittees.PoliciesProcedures, "/policies", "Policies"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Technical Committees page", e);
        }
    }

    @Step("Validate navigation to Technical Committees page")
    public void navigatetoTechnicalCommittees() {
        try {
            commonPage.clickOnMembershipParticipation();
            commonPage.clickOnTechnicalCommittees();
            Assert.assertTrue(driver.getTitle().contains("Technical Committees | ASTM"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Technical Committees page", e);
        }
    }
}
