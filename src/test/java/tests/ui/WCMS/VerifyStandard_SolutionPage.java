package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.CommonPage_WCMS;
import pages.ui.CookiePage;
import tests.ui.base.BaseTest;

class VerifyStandard_SolutionPage extends BaseTest {
    static final String jiraTestID = "";
    CookiePage cookiePage;
    CommonPage_WCMS standardSolution;
    CommonPage_WCMS commonPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("")
    @Description("")
    @Test(description = jiraTestID + "")
    public void ValidateStandard_Solution() {
        try {
            standardSolution = page.getInstance(CommonPage_WCMS.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            cookiePage.handleOneTrustCookie();
            //Navigate to Standard and Solution page
            // NavigateToStandard_Solution();
            //Validate content on Standard and Solution page
            //  ValidateContentStandard_Solution();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to Standard and Solution Page", e);
        }
    }

    @Step("Validate links and buttons available Standard and Solution page")
    public void ValidateContentStandard_Solution() {



    }

//    @Step("Validate navigation to Standard & Solution page")
//    public void NavigateToStandard_Solution() {
//        try {
//            commonPage.getstandardandSolution();
//            commonPage.();
//            Thread.sleep(3000);
//            //PublicCommon.waitForSec();
//            Assert.assertEquals(driver.getTitle(), "Standard and Solution");
//            ScreenshotUtil.takeScreenshotForAllure(driver);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
