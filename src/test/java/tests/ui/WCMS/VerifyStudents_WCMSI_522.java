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
import pages.ui.StudentsWCMS;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyStudents_WCMSI_522 extends BaseTest {
    static final String jiraTestID = "WCMSI-522";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    StudentsWCMS Students;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("WCMSI-338: Set 2: History, 125th Anniversary Case Studies, Membership, Students, Emerging Professionals, Consumer Participation, Technical Committees, Regional Offices")
    @Description("To validate the navigation to Students page ")
    @Test(description = jiraTestID + "Validate the navigation to Students page")
    public void validateTechnicalCommittees() {
        commonPage = page.getInstance(CommonPage_WCMS.class);
        Students = page.getInstance(StudentsWCMS.class);
        cookiePage = page.getInstance(CookiePage.class);
        cookiePage.handleOneTrustCookie();
        navigatetoStudentspage();
        validateStudentsLinks();
    }

    @Step("Validate links and buttons available on Students page")
    public void validateStudentsLinks() {
        try {
            Assert.assertTrue(commonPage.ValidateLinkNewtab(Students.ApplyOnline, "https://qa-member.astm.org/application/student", "ASTM International - Membership", "\'Apply Online\' Link"));
            Assert.assertTrue(commonPage.ValidateLink(Students.GraduateScholarship, "https://assets.contentstack.io/v3/assets/blt5eb0a2cb04534832/blta4e86d91da7415b3/6752b8716b5d6e1be8190b80/ASTM_Graduate_Scholarship_Application.pdf?branch=stage", "", "\'Click here for the graduate scholarship application form\' Click here Link"));
            Assert.assertTrue(commonPage.ValidateLink(Students.ProfessorYearAward, "https://assets.contentstack.io/v3/assets/blt5eb0a2cb04534832/blta55d663ffeb505bb/6752b894efbd784cf74a7dee/ASTM_Professor_of_The_Year_Nomination.pdf?branch=stage", "", "\'Click here for Professor of the Year nomination form\' Click here Link"));
            Assert.assertTrue(commonPage.ValidateLink(Students.MatterScholarship, "https://assets.contentstack.io/v3/assets/blt5eb0a2cb04534832/blt6785002c1547bb8f/67406f7bd328736af6233cdb/ASTM-Mather-Scholarship-Application.pdf?branch=stage", "", "\'Click here for the Katharine and Bryant Mather Scholarship Application form\' Click here Link"));
            Assert.assertTrue(commonPage.ValidateLink(Students.ProjectGrants, "https://assets.contentstack.io/v3/assets/blt5eb0a2cb04534832/blt5651a912e5b919fc/6752b8ac5e462a55516b2a72/ASTM_Grant_Application.pdf?branch=stage", "", "\'Click here for the ASTM grant application form\' Click here Link"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Students page", e);
        }
    }

    @Step("Validate navigation to Students page")
    public void navigatetoStudentspage() {
        try {
            commonPage.clickOnMembershipParticipation();
            commonPage.clickOnStudents();
            Assert.assertEquals(driver.getTitle(), "Student Members | ASTM");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Students page", e);
        }
    }
}
