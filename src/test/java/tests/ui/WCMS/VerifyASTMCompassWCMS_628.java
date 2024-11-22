package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.ASTMCompassWCMS;
import pages.ui.CommonPage_WCMS;
import pages.ui.CookiePage;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyASTMCompassWCMS_628 extends BaseTest {
    static final String jiraTestID = "WCMSI-628";
    CookiePage cookiePage;
    ASTMCompassWCMS ASTMCompass;
    CommonPage_WCMS commonPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("WCMSI-383: Set 6: Technical Committee Details, Standards Products, BoS Selection Detail Page, Enterprise Solutions, Compass, SpecBuilder, Custom Platforms, Multimedia Services, Training Courses")
    @Description("To validate the functionality of ASTM Compass page")
    @Test(description = jiraTestID + "Validate the navigation on the page")
    public void ValidateEnterpriseSolutionsPage() {
        try {
            ASTMCompass = page.getInstance(ASTMCompassWCMS.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            cookiePage.handleOneTrustCookie();
            navigateASTMCompassPage();
            validateASTMCompassPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to ASTM Compass page", e);
        }
    }

    @Step("Validate links and buttons available on page")
    private void validateASTMCompassPage() {
        Assert.assertTrue(commonPage.ValidateLink(ASTMCompass.contactAstmSales, "/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales", "\'Contact Sales\' Button"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(ASTMCompass.viewDemo, "https://marketing.astm.org/acton/fs/blocks/showLandingPage/a/9652/p/p-011c/t/page/fm/0?_gl=1*v8vczm*_gcl_au*MTkzODUxMjcwLjE3MjQyNzc3NjU", "", "\'View Demo\' Button"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(ASTMCompass.learnMore, "https://marketing.astm.org/acton/fs/blocks/showLandingPage/a/9652/p/p-011c/t/page/fm/0?_gl=1*1dyjo1g*_gcl_au*NjI5MDIwNjEuMTcyNDM0MjUzOQ", "", "\'Learn More\' Button"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(ASTMCompass.compassEbook, "https://marketing.astm.org/acton/fs/blocks/showLandingPage/a/9652/p/p-00c9/t/page/fm/1?_gl=1*1hi94k0*_gcl_au*ODI3MjkyOTY0LjE3MjQzMzA4NDE", "", "\'Compass EBook\' Link"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(ASTMCompass.astmCompassGuid, "https://assets.contentstack.io/v3/assets/blt5eb0a2cb04534832/blt1f090e36c831d902/66fe248dd03c5bced61261fa/CompassBeYourGuide_FINAL.pdf?branch=development", "", "\'Digital Access to International Standards\' Link"));
    }

    @Step("Validate navigation to ASTM Compass page")
    public void navigateASTMCompassPage() {
        try {
            commonPage.getstandardandSolution();
            commonPage.clickOnASTMCompass();
            WCMSICommon.waitForSec(3);
            Assert.assertTrue(driver.getTitle().contains("ASTM Compass"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to ASTM Compass page", e);
        }
    }

}

