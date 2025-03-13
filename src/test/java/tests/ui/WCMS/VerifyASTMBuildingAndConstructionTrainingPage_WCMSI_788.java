package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyASTMBuildingAndConstructionTrainingPage_WCMSI_788 extends BaseTest {
    static final String jiraTestID = "WCMSI-788";
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
    @Description("ASTM Building and Construction Training: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": ASTM Building and Construction Training: Navigation Verification for All Buttons and Links")
    public void VerifyASTMBuildingAndConstructionTrainingPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            TrainingIndustry = page.getInstance(TrainingByIndustryWCMS.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","Training Courses");
            ValidateASTMBuildingConstructionTrainingPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to ASTM Building and Construction Training: Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate ASTM Building and Construction Training Page")
    public void ValidateASTMBuildingConstructionTrainingPage() {
        try {
            basePage.clickOnMethod(TrainingIndustry.Cannabis);
            WCMSICommon.waitForSec(4);
            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.TrainYour,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("ASTM/ACES Performance Grading"),"astm-tpt", ""));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Aggregate Base"),"astm-tpt", "Aggregate Base Testing"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Aggregate Testing"),"astm-tpt", "Aggregate Testing"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("ASTM Asphalt Lab"),"astm-tpt", "Asphalt Lab"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Asphalt Aggregate Laboratory"),"astm-tpt", "Asphalt Aggregate Laboratory"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Asphalt Binder"),"astm-tpt", "Asphalt Binder"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Asphalt Mixture"),"astm-tpt", "Asphalt Mixture"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Asphalt Mixture Field Technician"),"astm-tpt", "Asphalt Mixture Field Technician"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Building Enclosure Testing"),"astm-tpt", "Building Enclosure Testing"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Cement Testing"),"astm-tpt", "Cement Testing"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Concrete Field Testing"),"astm-tpt", "Concrete Field Testing"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Concrete Lab Testing"),"astm-tpt", "Concrete Lab"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Concrete Strength Testing"),"astm-tpt", "Concrete Strength Testing"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Emulsified Asphalt"),"astm-tpt", "Emulsified Asphalt"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Geotechnical Testing"),"astm-tpt", "Geotechnical Testing"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Masonry eLearning"),"astm-tpt", "Masonry eLearning"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Performance Grade Bitumen"),"astm-tpt", "Performance Grade Bitumen"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Consolidating Concrete"),"astm-tpt", "Consolidating Concrete"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Soil Compaction Quality"),"astm-tpt", "Soil Compaction Quality"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Soil Laboratory Technician"),"astm-tpt", "Soil Laboratory Technician"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Rock Mechanics"),"astm-tpt", "Rock Mechanics"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("en pruebas de campo del"),"astm-tpt", "en pruebas de campo del"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("en pruebas de resistencia del"),"astm-tpt", "en pruebas de resistencia del"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("D698 Volume of Compaction"),"astm-tpt", "D698"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Math Basics"),"astm-tpt", "Math Basics"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Math Basics for Asphalt"),"astm-tpt", "Math Basics for Asphalt"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Math Basics for Concrete"),"astm-tpt", "Math Basics for Concrete"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Math Basics for Concrete Strength"),"astm-tpt", "Math Basics for Concrete Strength"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Math Basics for Soils"),"astm-tpt", "Math Basics for Soils"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Test Sieving Methods"),"astm-tpt", "Test Sieving Methods"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Quality Management"),"astm-tpt", "Quality Management"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Falls Interactive "),"astm-tpt", "Trips, Slips"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("ASTM C293/C293M Standard"),"astm-tpt", "ASTM C293/C293M Standard"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("ASTM C469/C469M Standard"),"astm-tpt", "ASTM C469/C469M Standard"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("ASTM C642 Standard"),"astm-tpt", "ASTM C642 Standard"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("ASTM D20 Standard"),"astm-tpt", "ASTM D20 Standard"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("ASTM D2170/D2170M Standard"),"astm-tpt", "ASTM D2170/D2170M"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Treinamento de ensaio de campo de"),"astm-tpt", "Treinamento de ensaio de campo de"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Treinamento de ensaio de"),"astm-tpt", "Treinamento de ensaio de"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Safety Trainer for Construction"),"astm-tpt", "Construction"));
            Assert.assertTrue(commonPage.ValidateLink(commonPage.getElement("Safety Trainer for General Industry"),"astm-tpt", "General Industry"));

            Assert.assertTrue(commonPage.ValidateLink(TrainingIndustry.TrainYourWholeTeam,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on ASTM Building and Construction Training", e);
        }
    }

}
