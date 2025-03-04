package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ReusableMethods;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyNewStandardsDevelopmentPage_WCMSI_915 extends BaseTest {
    static final String jiraTestID = "WCMSI-915";
    CookiePage cookiePage;
    TechnicalCommitteesWCMS technicalCommittees;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("New Standards Development: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": New Standards Development: Navigation Verification for All Buttons and Links")
    public void VerifyNewStandardsDevelopmentPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            technicalCommittees = page.getInstance(TechnicalCommitteesWCMS.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Membership & Participation","Technical Committees");
            ValidateNewStandardsDevelopmentPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to New Standards Development: Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate New Standards Development Page")
    public void ValidateNewStandardsDevelopmentPage() {
        try {
            basePage.clickOnMethod(technicalCommittees.InitiateNewStandardsActivity);
            basePage.clickOnMethod(commonPage.dropDown("New Standards Development Activity"));
            Assert.assertTrue(commonPage.ValidateLink(technicalCommittees.TestMethodsSpecificationsLink, "lead-template", "Draft Standard Templates | ASTM"));
            basePage.clickOnMethod(commonPage.dropDown("New Standards Development Activity"));
            Assert.assertTrue(commonPage.ValidateLink(technicalCommittees.PetroleumSteelLink, "standards-category-list.html", "Standards By Category"));
            basePage.clickOnMethod(commonPage.dropDown("Case Studies"));
            Assert.assertTrue(commonPage.ValidateLink(technicalCommittees.LightSportAircraftLink, "LSA_Case_Study.pdf", "ASTM International"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on New Standards Development", e);
        }
    }

}
