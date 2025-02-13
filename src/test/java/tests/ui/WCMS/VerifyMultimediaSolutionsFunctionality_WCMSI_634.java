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
        Assert.assertTrue(commonPage.ValidateLinkNewtab(MultimediaSolutions.RequestAppointment, "https://marketing.astm.org/acton/fs/blocks/showLandingPage/a/9652/p/p-03b5/t/page/fm/1?_gl=1*16xtsq3*_gcl_au*MjY3MzYyNjc4LjE3MjQ3ODM3NjE", "", "\'Request AN Appointment \' Button"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(MultimediaSolutions.QuickGuide,"https://marketing.astm.org/acton/attachment/9652/f-a4d90de7-4ded-4ef6-8cb9-f27cd0fb7b22/1/-/-/-/-/ASTM%20Multimedia%20Services.pdf?_gl=1*1j2zz8g*_gcl_au*MTA2MDM2NTE5MC4xNzI0NzcxNzIw","","\'Quick Guide\' Button"));
        Assert.assertEquals(commonPage.getWistiaVideoLink("Revolutionize Your Content with CGI").getAttribute("src"), "https://fast.wistia.net/embed/iframe/c0zph57f92");
        Assert.assertEquals(commonPage.getWistiaVideoLink("Promote Your Brand, Expand Your Reach").getAttribute("src"), "https://fast.wistia.net/embed/iframe/39uxp6dtp7");
        ScreenshotUtil.takeScreenshotForAllure(driver);
        Assert.assertTrue(commonPage.ValidateLinkNewtab(MultimediaSolutions.ContactMultimediaTeam,"https://marketing.astm.org/acton/fs/blocks/showLandingPage/a/9652/p/p-03b5/t/page/fm/1?_gl=1*1l6cu5i*_gcl_au*MjY3MzYyNjc4LjE3MjQ3ODM3NjE","","\'Contact the Multimedia Team\' Link"));
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
            Assert.assertEquals(driver.getTitle(), "ASTM Multimedia Solutions");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to ASTM Multimedia Solutions", e);
        }
    }
}
