package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

class VerifyDirectionsPage_WCMSI_870 extends BaseTest {
    static final String jiraTestID = "WCMSI-870";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;
    MembershipWCMS Membership;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {

    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify Directions Page")
    @Test(description = jiraTestID + ": Directions : Verify the UI, Responsiveness, content and Links of the page")
    public void VerifyContactSalesPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);
            Membership = page.getInstance(MembershipWCMS.class);

            driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM")+"membership-participation/memberships/directions");
            cookiePage.handleOneTrustCookie();

            ValidateDirectionsPage();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Directions Page", e);
        }
    }
    @Step("Validate Directions Page")
    public void ValidateDirectionsPage() {
        try {

            basePage.clickOnMethod(Membership.PhiladelphiaInternational);
            WCMSICommon.waitForSec(4);
            Assert.assertTrue(commonPage.ValidateLink(Membership.AceLimousine,"https://www.acelimosvce.com", "Ace Limousine & Airport Service"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Directions Page", e);
        }
    }

}

