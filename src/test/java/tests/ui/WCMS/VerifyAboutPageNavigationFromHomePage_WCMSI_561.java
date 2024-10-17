package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.AboutPage;
import pages.ui.CommonPage_WCMS;
import pages.ui.CookiePage;
import tests.ui.base.BaseTest;

import java.util.Arrays;
import java.util.List;
@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyAboutPageNavigationFromHomePage_WCMSI_561 extends BaseTest {
    static final String jiraTestID = "WCMSI-561";
    CookiePage cookiePage;
    AboutPage aboutPage;
    CommonPage_WCMS commonPage;
    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("WCMSI-327: Set 1: About ASTM, M&P, S&S, Help and FAQ")
    @Description("To validate the About page navigation and content on the page")
    @Test(description = jiraTestID + "Auto: {WCMSI-463, WCMSI-480, WCMSI-482, WCMSI-488, WCMSI-490}")
    public void ValidateTheAboutPage() {
        try{
            aboutPage = page.getInstance(AboutPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            cookiePage.handleOneTrustCookie();
            //Navigate to About page
            NavigateToAboutPage();
            //Validate content on About page
            ValidateContent();
        }
        catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to About page", e);
        }
    }
    @Step("Validate links and buttons available on About page")
    public void ValidateContent(){
        try{
            driver.navigate().refresh();
            //Validate Youtube video
            Assert.assertEquals(aboutPage.getVideoLink().getAttribute("src"),"https://www.youtube.com/embed/TnIsBlFUegY?rel=0");
            //Validate Interactive Timeline link
            Assert.assertTrue(commonPage.ValidateLink(aboutPage.interactiveTimelineLink,"/about/125th-anniversary/astm-timeline","ASTM Time Line","Interactive Timeline link"));
            //Validate view Button under History section
            Assert.assertTrue(commonPage.ValidateLink(aboutPage.viewBtnUnderHistory,"/about/history","History","View Button under History section"));
            //Validate view Button under Governance section
            // Validate Learn More Button under Global Cooperation section
            Assert.assertTrue(commonPage.ValidateLink(aboutPage.learnMoreBtnUnderGlobalCooperation,"/about/global-cooperation","Global Cooperation","Learn More Button under Global Cooperation section"));
            //Validate Learn More Button under Diversity, Equity, Inclusion, and Belonging section
            // Validate View Open Opportunities Link
            Assert.assertTrue(commonPage.ValidateLink(aboutPage.viewOpenOpportunitiesLink,"https://workforcenow.adp.com/mascsr/default/mdf/recruitment/recruitment.html","Recruitment","View Open Opportunities Link"));
            //Validate Learn More link In Governance cards
            List<String> expectedLink = Arrays.asList("2024-Board-Book-Web.pdf", "Senior-Staff-2024.pdf", "2023-ASTM-Annual-Report.pdf");
            Assert.assertTrue(commonPage.ValidateLinksUnderTiles(aboutPage.getLearnMoreLinksUnderTiles("Governance"),expectedLink,"Governance"));
        }catch (Exception e){
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on About page", e);
        }
    }
    @Step("Validate navigation to About page")
    public void NavigateToAboutPage(){
        try{
            commonPage.ClickOnAboutNavigationOption();
            commonPage.ClickOnAboutOverviewOption();
            WCMSICommon.waitForSec(3);
            Assert.assertEquals(driver.getTitle(),"About ASTM");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        }catch (Exception e){
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to About page", e);
        }
    }
}
