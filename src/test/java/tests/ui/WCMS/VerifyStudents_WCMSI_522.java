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
            Assert.assertTrue(commonPage.ValidateLink(Students.ApplyOnline, "application/student", "ASTM International - Membership"));
            Assert.assertTrue(commonPage.ValidateLink(Students.GraduateScholarship, "ASTM_Graduate_Scholarship_Application.pdf", ""));
            Assert.assertTrue(commonPage.ValidateLink(Students.ProfessorYearAward, "ASTM_Professor_of_The_Year_Nomination.pdf", ""));
            Assert.assertTrue(commonPage.ValidateLink(Students.MatterScholarship, "ASTM-Mather-Scholarship-Application.pdf", ""));
            Assert.assertTrue(commonPage.ValidateLink(Students.ProjectGrants, "ASTM_Grant_Application.pdf", ""));
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
