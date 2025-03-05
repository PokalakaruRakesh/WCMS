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
import pages.ui.MultimediaServicesWCMS;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyMultimediaSolutionsFunctionality_WCMSI_634 extends BaseTest {
    static final String jiraTestID = "WCMSI-634";
    CookiePage cookiePage;
    MultimediaServicesWCMS MultimediaSolutions;
    CommonPage_WCMS commonPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("WCMSI-383: Set 6: Technical Committee Details, Standards Products, BoS Selection Detail Page, Enterprise Solutions, Compass, SpecBuilder, Custom Platforms, Multimedia Services, Training Courses")
    @Description("To validate the Multimedia navigation and content on the page")
    @Test(description = jiraTestID + "Validate the Book of Standard navigation and content on the page")
    public void validateMultimediaSolutions() {
        try {
            commonPage = page.getInstance(CommonPage_WCMS.class);
            MultimediaSolutions = page.getInstance(MultimediaServicesWCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            cookiePage.handleOneTrustCookie();
            navigateMultimediaSolutions();
            validateMultimediaSolutionsContent();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to Multimedia Solutions page", e);
        }
    }
    @Step("Validate links and buttons available on Multimedia Solutions page")
    public void validateMultimediaSolutionsContent() {
        try{
        Assert.assertEquals(commonPage.getVideoLink().getAttribute("src"), "https://fast.wistia.net/embed/iframe/m4qv0rhely");
        ScreenshotUtil.takeScreenshotForAllure(driver);
        Assert.assertTrue(commonPage.ValidateLink(MultimediaSolutions.RequestAppointment, "https://marketing.astm.org/acton", ""));
        Assert.assertTrue(commonPage.ValidateLink(MultimediaSolutions.QuickGuide,"https://marketing.astm.org",""));
        Assert.assertEquals(commonPage.getWistiaVideoLink("Revolutionize Your Content with CGI").getAttribute("src"), "https://fast.wistia.net/embed/iframe/c0zph57f92");
        Assert.assertEquals(commonPage.getWistiaVideoLink("Promote Your Brand, Expand Your Reach").getAttribute("src"), "https://fast.wistia.net/embed/iframe/39uxp6dtp7");
        ScreenshotUtil.takeScreenshotForAllure(driver);
        Assert.assertTrue(commonPage.ValidateLink(MultimediaSolutions.ContactMultimediaTeam,"https://marketing.astm.org/acton",""));
        }catch (Exception e){
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate links and buttons available on Multimedia Solutions page",e);
        }
    }

    @Step("Validate Navigation to Multimedia Solutions")
    public void navigateMultimediaSolutions() {
        try {
            commonPage.getstandardandSolution();
            commonPage.clickonASTMMultimediaSolutions();
            Assert.assertTrue(driver.getTitle().contains( "ASTM Multimedia Solutions"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to ASTM Multimedia Solutions", e);
        }
    }
}
