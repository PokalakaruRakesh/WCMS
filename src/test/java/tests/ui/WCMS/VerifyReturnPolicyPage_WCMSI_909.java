package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyReturnPolicyPage_WCMSI_909 extends BaseTest {
    static final String jiraTestID = "WCMSI-909";
    CookiePage cookiePage;
    CopyrightAndPermissionsWCMS copyrightAndPermissionspage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Return Policy: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": Return Policy: Navigation Verification for All Buttons and Links")
    public void VerifyReturnPolicyPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            copyrightAndPermissionspage = page.getInstance(CopyrightAndPermissionsWCMS.class);
            basePage = page.getInstance(BasePage.class);

            driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM")+"policies/return-policy");
            cookiePage.handleOneTrustCookie();
            ValidateReturnPolicyPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Return Policy: Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate Return Policy Page")
    public void ValidateReturnPolicyPage() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(copyrightAndPermissionspage.ReturnPolicyWebform,"/help/contact", "Contact ASTM"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Return Policy", e);
        }
    }

}
