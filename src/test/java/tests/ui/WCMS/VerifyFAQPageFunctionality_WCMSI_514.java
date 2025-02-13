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
//import pages.ui.FAQ_PageWCMS;
import tests.ui.base.BaseTest;

public class VerifyFAQPageFunctionality_WCMSI_514 extends BaseTest {
    static final String jiraTestID = "WCMSI-514";
    CookiePage cookiePage;
    //FAQ_PageWCMS FAQPage;
    CommonPage_WCMS commonPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("")
    @Description("Verification of the FAQ Page functionality")
    @Test(description = jiraTestID + "")
    public void ValidateTheFAQPage() {
        try{
            commonPage = page.getInstance(CommonPage_WCMS.class);
            //FAQPage.getInstance(FAQ_PageWCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            cookiePage.handleOneTrustCookie();
            NavigateToFAQPage();
            ValidateContentFAQ();
        }
        catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to FAQ Page", e);
        }
    }
    @Step("Validate links available on FAQ page")
    public void ValidateContentFAQ(){
        //Assert.assertTrue(commonPage.ValidateLink(FAQPage.generalDropdown1,"/faq","Frequently Asked Questions","FAQ Page Opened"));

    }
    @Step("Validate navigation to FAQ page")
    public void NavigateToFAQPage(){
        try{
            //driver.get("https://qa-www.astm.org/faq");
            WCMSICommon.waitForSec(3);
            Assert.assertEquals(driver.getTitle(),"Frequently Asked Questions");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        }catch (Exception e){
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to FAQ page", e);
        }
    }
}
