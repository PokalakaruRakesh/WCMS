package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyCorporateCitizenship_WCMSI_941 extends BaseTest {
    static final String jiraTestID = "WCMSI-941";
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
    @Description("VerifyDetailedOverviewContentLinksOfThePage")
    @Test(description = jiraTestID + "VerifyDetailedOverviewContentLinksOfThePage")
    public void VerifyDetailedOverviewPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            AboutPageWCMS = page.getInstance(AboutPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("About ASTM","Governance");
            WCMSPage.NavigateToSubmenuList("Detailed Overview","Detailed Overview | ASTM");
            ValidateAboutPageWCMS();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Detailed Overview Page", e);
        }
    }
    @Step("Validate About Page")
    public void ValidateAboutPageWCMS() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.Over12000ASTMStandards, "solutions/standards-publications", "Standards & Publications | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.WelcomeEncourageParticipation, "membership-participation/memberships", "ASTM Membership | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.ThroughMoreThan140Technical, "technical-committees/committee-all", "Technical Committees by Designation - Full List | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.ASTMStandardsOverview, "/standards-and-solutions/standards-publications", "Standards & Publications | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.GuidingPrinciples, "Principles_English", "mj17 6_Principles_v3.5"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.CertificationAndDeclaration, "/standards-and-solutions/certification", "Certification | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.EquipmentInstitute, "https://www.seinet.org/", "Welcome to Safety Equipment Institute | Safety Equipment Institute"));
//            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.TechnicalTrainingPrograms, "/standards-and-solutions/training-courses", "ASTM Industry Training Solutions | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.ProficiencyTesting, "laboratory-services/proficiency-testing.html", "Proficiency Testing - Laboratory Services - Products & Services"));


        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the About Page ", e);
        }
    }

}
