package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyASTMTrainingAndELearningPoliciesAndFAQsPage_WCMSI_907 extends BaseTest {
    static final String jiraTestID = "WCMSI-907";
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
    @Description("ASTM Training and E-Learning Policies and FAQs: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": ASTM Training and E-Learning Policies and FAQs: Navigation Verification for All Buttons and Links")
    public void VerifyASTMTrainingAndELearningPoliciesFAQsPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            copyrightAndPermissionspage = page.getInstance(CopyrightAndPermissionsWCMS.class);
            basePage = page.getInstance(BasePage.class);

            driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM")+"policies/tpt-faq");
            cookiePage.handleOneTrustCookie();
            ValidateASTMTrainingAndELearningPoliciesPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to ASTM Training and E-Learning Policies and FAQs: Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate ASTM Training and E-Learning Policies and FAQs Page")
    public void ValidateASTMTrainingAndELearningPoliciesPage() {
        try {
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(page.getElement(copyrightAndPermissionspage.ReceiptInvoiceMail).getAttribute("href").contains("train@astm.org"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(page.getElement(copyrightAndPermissionspage.CustomerCancellationMail).getAttribute("href").contains("train@astm.org"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on ASTM Training and E-Learning Policies and FAQs", e);
        }
    }

}
