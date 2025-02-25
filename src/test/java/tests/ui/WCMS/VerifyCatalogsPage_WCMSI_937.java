package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyCatalogsPage_WCMSI_937 extends BaseTest {
    static final String jiraTestID = "WCMSI-925";
    CookiePage cookiePage;
    StandardAndPuplicationWCMS StandardAndPublication;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Catalogs: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": Catalogs: Navigation Verification for All Buttons and Links")
    public void VerifyCatalogsPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            StandardAndPublication = page.getInstance(StandardAndPuplicationWCMS.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            //WCMSPage.NavigateToPage("Standards & Solutions","Standards & Publications");
            ValidateCatalogsPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Catalogs: Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate Catalogs Page")
    public void ValidateCatalogsPage() {
        try {
            driver.get(driver.getCurrentUrl()+"standards-and-solutions/catalogs");
            Assert.assertTrue(commonPage.ValidateLink(StandardAndPublication.BOSCatalogViewOnline,"https://www.astmcatalogs.org/astmcatalogs/2024_bos_catalog_/MobilePagedReplica.action", "ASTM Catalogs"));
            Assert.assertTrue(commonPage.ValidateLink(StandardAndPublication.ASTMAdvantageViewOnline,"https://marketing.astm.org/acton", ""));
            Assert.assertTrue(commonPage.ValidateLink(StandardAndPublication.ReferenceMaterialsViewOnline,"ASTM_Reference_Materials_Petroleum_Catalog_Oct2023.pdf", "ASTM_Reference_Materials"));
            Assert.assertTrue(commonPage.ValidateLink(StandardAndPublication.eLearningBrochureViewOnline,"ASTM_eLearning_Brochure_May_2024.pdf", "ASTM_eLearning"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Market Insights", e);
        }
    }

}
