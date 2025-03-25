package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

class VerifyContactSalesPage_WCMSI_716 extends BaseTest {
    static final String jiraTestID = "WCMSI-716";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;
    EnterpriseSolutionWCMS EnterpriseSolution;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify Contact Sales Page")
    @Test(description = jiraTestID + ": Contact Sales : Verify the UI, Responsiveness, content and Links of the page")
    public void VerifyContactSalesPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);
            EnterpriseSolution = page.getInstance(EnterpriseSolutionWCMS.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","Enterprise Solutions");


            ValidateContactSalesPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Contact Sales Page", e);
        }
    }
    @Step("Validate Contact Sales Page")
    public void ValidateContactSalesPage() {
        try {

            basePage.clickOnMethod(EnterpriseSolution.ContactUsEnterprise);
            WCMSICommon.waitForSec(4);
            Assert.assertTrue(WCMSICommon.isWebElementDisplayed(driver,EnterpriseSolution.SubmitButton));
            Assert.assertTrue(commonPage.ValidateLink(EnterpriseSolution.PrivacyPolicy,"/policies/privacy-policy", "Privacy Policy | ASTM"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Contact Sales Page", e);
        }
    }

}

