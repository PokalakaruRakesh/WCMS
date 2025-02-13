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
import pages.ui.EnterpriseSolutionWCMS;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyEnterpriseSolutions_WCMSI_625 extends BaseTest {
    static final String jiraTestID = "WCMSI-625";
    CookiePage cookiePage;
    EnterpriseSolutionWCMS enterpriseSolution;
    CommonPage_WCMS commonPage;
    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("WCMSI-383: Set 6: Technical Committee Details, Standards Products, BoS Selection Detail Page, Enterprise Solutions, Compass, SpecBuilder, Custom Platforms, Multimedia Services, Training Courses")
    @Description("To validate the Enterprise Solutions functionality on the page")
    @Test(description = jiraTestID + "Validate the navigation on the page")
    public void ValidateEnterpriseSolutionsPage() {
        try {
            enterpriseSolution = page.getInstance(EnterpriseSolutionWCMS.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            cookiePage.handleOneTrustCookie();
            navigatetoEnterpriseSolutionsPage();
            validateEnterpriseSolutionsPage();
        } catch  (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to Enterprise Solutions page", e);
        }
    }
    @Step("Validate links and buttons available on page")
    private void validateEnterpriseSolutionsPage() {
        Assert.assertTrue(commonPage.ValidateLinkNewtab(enterpriseSolution.WhyASTM, "/ASTM-Advantage_Infographic_2023.pdf", "", "\'Why ASTM?\' Button"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(enterpriseSolution.ASTMAdvantage, "https://marketing.astm.org/acton", "", "\'The ASTM Advantage\' Link"));
        Assert.assertTrue(commonPage.ValidateLink(enterpriseSolution.ASTMCompass, "/standards-and-solutions/enterprise-solutions/astm-compass", "ASTM Compass", "\'ASTM Compass\' Learn More Link"));
        Assert.assertTrue(commonPage.ValidateLink(enterpriseSolution.SubscriptionPortals, "standards-and-solutions/enterprise-solutions/subscription-portals", "Subscription Portals", "\'Subscription Portals\' Learn More Link"));
        Assert.assertTrue(commonPage.ValidateLink(enterpriseSolution.ASTMSpecBuilder, "/standards-and-solutions/enterprise-solutions/specbuilder", "ASTM SpecBuilder", "\'ASTM SpecBuilder\' Learn More Link"));
        Assert.assertTrue(commonPage.ValidateLink(enterpriseSolution.MultimediaServices, "/standards-and-solutions/enterprise-solutions/multimedia-services", "ASTM Multimedia Solutions", "\'Multimedia Services\' Learn More Link"));
        Assert.assertTrue(commonPage.ValidateLink(enterpriseSolution.ImproveLaboratoryEfficiency, "/standards-and-solutions/laboratory-services", "ASTM International Laboratory Services", "\'Improve Your Laboratory’s Efficiency\' Learn More Link"));
        Assert.assertTrue(commonPage.ValidateLink(enterpriseSolution.TrainStandardsExperts, "/standards-and-solutions/training-courses", "ASTM Industry Training Solutions", "\'Train with Standards Experts\' Learn More Link"));
        Assert.assertTrue(commonPage.ValidateLink(enterpriseSolution.ASTMDigitalLibrary, "/standards-and-solutions/digital-library", "ASTM Digital Library", "\'ASTM Digital Library\' Learn More Link"));
    }

    @Step("Validate navigation to Enterprise Solutions page")
    public void navigatetoEnterpriseSolutionsPage(){
        try{
            commonPage.getstandardandSolution();
            commonPage.clickOnEnterpriseSolution();
            WCMSICommon.waitForSec(3);
            Assert.assertTrue(driver.getTitle().contains("Enterprise Solutions"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
    }catch (Exception e){
        e.printStackTrace();
        WCMSICommon.reportFailAssert("Failed to Validate the navigation to Enterprise Solutions page", e);
    }
    }

}

