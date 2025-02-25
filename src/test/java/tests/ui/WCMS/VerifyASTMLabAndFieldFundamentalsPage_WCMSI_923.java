package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyASTMLabAndFieldFundamentalsPage_WCMSI_923 extends BaseTest {
    static final String jiraTestID = "WCMSI-923";
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
    @Description("ASTM Lab and Field Fundamentals: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": ASTM Lab and Field Fundamentals: Navigation Verification for All Buttons and Links")
    public void VerifyASTMLabFieldFundamentalsPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            TrainingIndustry = page.getInstance(TrainingByIndustryWCMS.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","Training Courses");
            ValidateASTMLabFieldFundamentalsPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to ASTM Lab and Field Fundamentals: Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate ASTM Lab and Field Fundamentals Page")
    public void ValidateASTMLabFieldFundamentalsPage() {
        try {
            basePage.clickOnMethod(TrainingIndustry.LabFieldFundamentals);
            WCMSICommon.waitForSec(4);
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.TrainYour,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.TheArtPerfectAnalysis,"astm-tpt-477.html", "The Art of Perfect Analysis"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.PrecisionAndBias,"astm-tpt-490.html", "Precision and Bias"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.TripsSlips,"astm-tpt-753.html", "Trips, Slips"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.PreMathBasics,"astm-tpt-455.html", "Pre-Math Basics"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.MathBasicsAsphalt,"astm-tpt-458.html", "Math Basics for Asphalt"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.MathBasicsConcrete,"astm-tpt-456.html", "Math Basics for Concrete"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.StrengthTesting,"astm-tpt-457.html", "Math Basics for Concrete Strength Testing"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.MathBasicsSoil,"astm-tpt-527.html", "Math Basics for Soils"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.QualityManagement,"astm-tpt-465.html", "Quality Management 101 eLearning Series"));

            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.GeneralIndustry,"astm-tpt-947.html", "My Virtual Safety Training for General Industry"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.TrainerForConstruction,"astm-tpt-948.html", "My Virtual Safety Training for Construction"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.LabManagementCertificate,"astm-tpt-1008.html", "Lab Manager Academy"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.HowManageLabStaff,"astm-tpt-1004.html", "How to Manage Lab Staff"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.BetterLabLeader,"astm-tpt-1005.html", "How to Be a Better Lab Leader"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.LabOperations,"astm-tpt-1006.html", "Lab Operations"));
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.LabManagement,"astm-tpt-1007.html", "How to Improve Lab Management"));

            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.TrainYourWholeTeam,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on ASTM Lab and Field Fundamentals", e);
        }
    }

}
