package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.ASTMSpecBuilderWCMS;
import pages.ui.CommonPage_WCMS;
import pages.ui.CookiePage;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyASTMSpecBuilder_WCMSI_630 extends BaseTest {
    static final String jiraTestID = "WCMSI-630";
    CookiePage cookiePage;
    ASTMSpecBuilderWCMS ASTMSpecbuilder;
    CommonPage_WCMS commonPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("WCMSI-383: Set 6: Technical Committee Details, Standards Products, BoS Selection Detail Page, Enterprise Solutions, Compass, SpecBuilder, Custom Platforms, Multimedia Services, Training Courses")
    @Description("To validate the functionality of Enterprise Solutions page")
    @Test(description = jiraTestID + "Validate the navigation on the page")
    public void ValidateASTMSpecbuilderPage() {
        try {
            ASTMSpecbuilder = page.getInstance(ASTMSpecBuilderWCMS.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            cookiePage.handleOneTrustCookie();
            navigatetoASTMSpecbuilderPage();
            validateASTMSpecbuilderPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to ASTM Specbuilder page", e);
        }
    }

    @Step("Validate links and buttons available on page")
    private void validateASTMSpecbuilderPage() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(ASTMSpecbuilder.RequestDemo, "/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales", "\'Request Demo\' Button"));
            Assert.assertTrue(commonPage.ValidateLinkNewtab(ASTMSpecbuilder.VieweBook, "https://marketing.astm.org/acton/media/9652/astm-specbuilder-compass-ebook?_gl=1*1235i7p*_gcl_au*MTA2MDM2NTE5MC4xNzI0NzcxNzIw", "ASTM-SpecBuilder-Compass_Ebook", "\'View eBook: ASTM SpecBuilder\' Link"));
            Assert.assertTrue(commonPage.ValidateLink(ASTMSpecbuilder.GetStarted, "/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM", "\'Get Started\' Button"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate links and buttons available on ASTM Specbuilder page", e);
        }

    }

    @Step("Validate navigation to ASTM Specbuilder page")
    public void navigatetoASTMSpecbuilderPage() {
        try {
            commonPage.getstandardandSolution();
            commonPage.clickOnASTMSpecbuilder();
            WCMSICommon.waitForSec(3);
            Assert.assertTrue(driver.getTitle().contains("ASTM SpecBuilder"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to ASTM SpecBuilder page", e);
        }
    }

}

