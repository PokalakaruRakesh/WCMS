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
import pages.ui.StandardAndPuplicationWCMS;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyEnterpriseSolutionsWCMS_625 extends BaseTest {
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
        Assert.assertTrue(commonPage.ValidateLinkNewtab(enterpriseSolution.WhyASTM, "https://assets.contentstack.io/v3/assets/blt5eb0a2cb04534832/blt8732d4cac3726dc3/66fb8accf32d377544a07f07/ASTM-Advantage_Infographic_2023.pdf?branch=development", "", "\'Why ASTM?\' Button"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(enterpriseSolution.ASTMAdvantage, "https://marketing.astm.org/acton/fs/blocks/showLandingPage/a/9652/p/p-03cf/t/page/fm/0?utm_term=The%20ASTM%20Advantage%3A%20Tools%20and%20Resources%20to%20Maximize%20Your%20Competitive%20Advantage&utm_campaign=TEST-Get%20the%20ASTM%20Advantage%20-%20Boost%20Your%20Business%20with%20Custom%20Products&utm_content=email&utm_source=Act-On+Software&utm_medium=email&sid=TV2:WLB29mJBh&_gl=1*18nn20q*_gcl_au*MTY5MjE3OTU0Ny4xNzI0MTY3ODk4%20/", "", "\'The ASTM Advantage\' Link"));
        Assert.assertTrue(commonPage.ValidateLink(enterpriseSolution.ASTMCompass, "/standards-and-solutions/enterprise-solutions/astm-compass", "ASTM Compass", "\'ASTM Compass\' Learn More Link"));
        Assert.assertTrue(commonPage.ValidateLink(enterpriseSolution.SubscriptionPortals, "https://dev-www.astm.org/standards-and-solutions/enterprise-solutions/online-subscriptions", "Online Subscriptions", "\'Subscription Portals\' Learn More Link"));
        Assert.assertTrue(commonPage.ValidateLink(enterpriseSolution.ASTMSpecBuilder, "/standards-and-solutions/enterprise-solutions/specbuilder", "ASTM SpecBuilder", "\'ASTM SpecBuilder\' Learn More Link"));
        Assert.assertTrue(commonPage.ValidateLink(enterpriseSolution.MultimediaServices, "/standards-and-solutions/enterprise-solutions/multimedia-services", "ASTM Multimedia Solutions", "\'Multimedia Services\' Learn More Link"));
        Assert.assertTrue(commonPage.ValidateLink(enterpriseSolution.ImproveLaboratoryEfficiency, "/standards-and-solutions/enterprise-solutions/astm-compass", "ASTM Compass", "\'Improve Your Laboratory’s Efficiency\' Learn More Link"));
        Assert.assertTrue(commonPage.ValidateLink(enterpriseSolution.TrainStandardsExperts, "/standards-and-solutions/training-courses", "Training Courses", "\'Train with Standards Experts\' Learn More Link"));
        Assert.assertTrue(commonPage.ValidateLink(enterpriseSolution.ASTMDigitalLibrary, "/standards-and-solutions/digital-library", "ASTM Digital Library", "\'ASTM Digital Library\' Learn More Link"));
    }

    @Step("Validate navigation to Enterprise Solutions page")
    public void navigatetoEnterpriseSolutionsPage(){
        try{
            commonPage.getstandardandSolution();
            commonPage.clickOnEnterpriseSolution();
            WCMSICommon.waitForSec(3);
            Assert.assertEquals(driver.getTitle(),"Enterprise Solutions");
            ScreenshotUtil.takeScreenshotForAllure(driver);
    }catch (Exception e){
        e.printStackTrace();
        WCMSICommon.reportFailAssert("Failed to Validate the navigation to Enterprise Solutions page", e);
    }
    }

}

