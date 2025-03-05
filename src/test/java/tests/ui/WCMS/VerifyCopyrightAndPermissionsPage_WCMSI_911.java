package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyCopyrightAndPermissionsPage_WCMSI_911 extends BaseTest {
    static final String jiraTestID = "WCMSI-911";
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
    @Description("Copyright and Permissions: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": Copyright and Permissions: Navigation Verification for All Buttons and Links")
    public void VerifyCopyrightPermissionsPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            copyrightAndPermissionspage = page.getInstance(CopyrightAndPermissionsWCMS.class);
            basePage = page.getInstance(BasePage.class);

            commonPage.downloadFileSetup(ConfigReader.getValue("BASE_URL_WCMS_ASTM")+"copyright-and-permissions");
            cookiePage.handleOneTrustCookie();
            ValidateCopyrightPermissionsPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Copyright and Permissions: Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate Copyright and Permissions Page")
    public void ValidateCopyrightPermissionsPage() {
        try {
            Assert.assertTrue(commonPage.ValidateDownloadedFile(copyrightAndPermissionspage.SinglePDFDownload, "Single_PDF_copyrightlicense_agreement.doc"));
            Assert.assertTrue(commonPage.ValidateDownloadedFile(copyrightAndPermissionspage.SubscriptionProducts, "copyrightlicense_agreement_subscription.doc"));
            Assert.assertTrue(commonPage.ValidateLink(copyrightAndPermissionspage.PermissionMail,"marketplace.copyright.com", ""));
            Assert.assertTrue(page.getElement(copyrightAndPermissionspage.ASTMTechnicalMail).getAttribute("href").contains("mailto:khooper@astm.org"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Copyright and Permissions", e);
        }
    }

}
