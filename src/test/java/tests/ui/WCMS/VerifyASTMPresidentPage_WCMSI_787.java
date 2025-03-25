package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyASTMPresidentPage_WCMSI_787 extends BaseTest {
    static final String jiraTestID = "WCMSI-787";
    CookiePage cookiePage;
    ASTMDigital_LibraryWCMS digitalLibrary;
    AboutPage aboutPage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("ASTM President: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": ASTM President: Navigation Verification for All Buttons and Links")
    public void VerifyASTMPresidentPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            aboutPage = page.getInstance(AboutPage.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("About ASTM","ASTM President");
            ValidateASTMPresidentPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to ASTM President: Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate ASTM President Page")
    public void ValidateASTMPresidentPage() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(aboutPage.ClickHereLink,"ASTM-Andrew-G-Kireta-hi-res.jpg", "ASTM-Andrew-G-Kireta-hi-res.jpg"));
            Assert.assertTrue(commonPage.ValidateLink(aboutPage.FollowAndyOnXLink,"https://x.com/ASTMpres", ""));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on ASTM President page", e);
        }
    }

}
