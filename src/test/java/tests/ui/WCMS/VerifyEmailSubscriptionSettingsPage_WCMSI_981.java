package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ReusableMethods;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyEmailSubscriptionSettingsPage_WCMSI_981 extends BaseTest {
    static final String jiraTestID = "WCMSI-981";
    CookiePage cookiePage;
    HomePage_WCMS homepage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Email Subscription Settings: Verify the UI, Responsiveness, content and Links of the page")
    @Test(description = jiraTestID + ": Email Subscription Settings: Verify the UI, Responsiveness, content and Links of the page")
    public void VerifySubscriptionSettingsPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            homepage = page.getInstance(HomePage_WCMS.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);

            String url=driver.getCurrentUrl()+"email-subscription-settings";
            driver.navigate().to(url);
            cookiePage.handleOneTrustCookie();
            ValidateSubscriptionSettingsPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Email Subscription Settings page", e);
        }
    }
    @Step("Validate Subscription Settings Page")
    public void ValidateSubscriptionSettingsPage() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(homepage.astmSubscription, "astm-subscription", "Subscription Preferences Form 051518"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Subscription Settings", e);
        }
    }

}
