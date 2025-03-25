package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyASTMEnvironmentalTrainingPage_WCMSI_719 extends BaseTest {
    static final String jiraTestID = "WCMSI-719";
    CookiePage cookiePage;
    TrainingByIndustryWCMS TrainingIndustry;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("ASTM Environmental Training: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": ASTM Environmental Training: Navigation Verification for All Buttons and Links")
    public void VerifyASTMEnvironmentalTrainingPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            TrainingIndustry = page.getInstance(TrainingByIndustryWCMS.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","Training Courses");
            ValidateASTMEnvironmentalTrainingPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to ASTM Environmental Training Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate ASTM Environmental Training Page")
    public void ValidateASTMEnvironmentalTrainingPage() {
        try {
            basePage.clickOnMethod(TrainingIndustry.Environment);
            WCMSICommon.waitForSec(4);
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.BrownfieldsRedevelopment,"brownfields.training", "Brownfields Redevelopment"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.TrainYour,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Phase I Environmental Site Assessments: 1-Day"),"astm-tpt-409", "Phase I Environmental Site Assessments"));


            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Phase II Environmental Site Assessment Process"),"astm-tpt", ""));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Property Condition Assessments"),"astm-tpt", "Property Condition"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Building Energy Performance"),"astm-tpt", ""));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Estimating LNAPL Transmissivity"),"astm-tpt", "Estimating LNAPL Transmissivity"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Risk-Based Corrective Action"),"astm-tpt", "Real Estate Professionals"));

            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("ASTM Standards for Brownfields"),"brownfields.training", "Brownfields Redevelopment"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Diligence Using ASTM E3224"),"astm-tpt", "Diligence Using ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("The New Phase I ESA Standard"),"astm-tpt", "The New Phase I ESA Standard"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Site Inspections and Interviews"),"astm-tpt", "Site Inspections"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Due Diligence In New Jersey"),"astm-tpt", "Due Diligence In New Jersey"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Environmental Due Diligence Primer"),"astm-tpt", "Environmental Due Diligence Primer"));

            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("ASTM E3164 Standard Guide"),"astm-tpt", "ASTM E3164 Standard Guide"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Non-Aqueous Phase Liquid"),"astm-tpt", "Non-Aqueous Phase Liquid"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Risk-Based Correct Action"),"astm-tpt", "Risk-Based Correct Action"));

            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Phase II Environmental Site Assessments"),"astm-tpt", ""));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Activity and Use Limitations"),"astm-tpt", "Activity and Use Limitations"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("ASTM Standards for Asbestos Control"),"astm-tpt", "ASTM Standards for Asbestos Control"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Environmental Regulatory Compliance Audits"),"astm-tpt", "Environmental Regulatory Compliance Audits"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Vapor Encroachment"),"astm-tpt", "Vapor Encroachment"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("ASTM E2790 Identifying and Complying"),"astm-tpt", "ASTM E2790 Identifying and Complying"));

            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Phase I and Phase II Environmental Site Assessment Program"),"astm-tpt", "Phase I and Phase II Environmental Site Assessment Program"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("ASTM E1527 Phase I Environmental Site Assessment"),"astm-tpt", "ASTM E1527 Phase I Environmental Site Assessment"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("ASTM E1903 Phase II Environmental Site Assessment"),"astm-tpt", "ASTM E1903 Phase II Environmental Site Assessment"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("ASTM E2600 Standard"),"astm-tpt", "ASTM E2600 Standard"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("ASTM E2091 Standard"),"astm-tpt", "ASTM E2091 Standard"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("ASTM E3356 | Overview"),"astm-tpt", "ASTM E3356"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("ASTM D6008 Standard Practice"),"astm-tpt", "ASTM D6008 Standard Practice"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Advanced Environmental Liabilities"),"astm-tpt", "Advanced Environmental Liabilities"));

            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.TrainYourWholeTeam,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on ASTM Environmental Training", e);
        }
    }

}
