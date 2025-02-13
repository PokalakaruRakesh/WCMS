package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.Common;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

import java.util.Arrays;
import java.util.List;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyReferenceMaterialsPage_WCMSI_987 extends BaseTest {
    static final String jiraTestID = "WCMSI-987";
    CookiePage cookiePage;
    ReferenceMaterials_WCMS referenceMaterialsPage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Reference Materials: Verify the UI, Responsiveness, content and Links of the page")
    @Test(description = jiraTestID + ": Reference Materials: Verify the UI, Responsiveness, content and Links of the page")
    public void VerifyReferenceMaterialsPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            referenceMaterialsPage = page.getInstance(ReferenceMaterials_WCMS.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","Reference Materials");
            ValidateReferenceMaterialsPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Reference Materials page", e);
        }
    }
    @Step("Validate Reference Materials Page")
    public void ValidateReferenceMaterialsPage() {
        try {
            driver.switchTo().frame(referenceMaterialsPage.getFrame());
            Assert.assertEquals(referenceMaterialsPage.getVideoLink().getAttribute("src"), "https://embed-ssl.wistia.com/deliveries/04c6b2abac10a153206020e4133279f5.webp?image_crop_resized=1280x720");
            driver.switchTo().defaultContent();
            Assert.assertTrue(commonPage.ValidateLink(referenceMaterialsPage.ViewReferenceMaterials, "ASTM_Reference_Materials_Petroleum_Catalog_Oct2023.pdf", ""));
            Assert.assertTrue(commonPage.ValidateLink(referenceMaterialsPage.ViewReferenceMaterials, "ASTM_Reference_Materials_Petroleum_Catalog_Oct2023.pdf", ""));
            Assert.assertTrue(Common.isElementDisplayed(driver,referenceMaterialsPage.ContactUs));
            //Assert.assertTrue(commonPage.ValidateLink(referenceMaterialsPage.ContactUs, "mailto:refmat@astm.org", ""));
            Assert.assertTrue(commonPage.ValidateLink(referenceMaterialsPage.ReferenceMaterialsCatalog, "ASTM_Reference_Materials_Petroleum_Catalog_Oct2023.pdf", ""));
            Assert.assertTrue(Common.isElementDisplayed(driver,referenceMaterialsPage.QuoteRequest));
           // Assert.assertTrue(commonPage.ValidateLink(referenceMaterialsPage.QuoteRequest, "RefMatOrderForm091324.docx", ""));
            Assert.assertTrue(commonPage.ValidateLink(referenceMaterialsPage.viewOurCatalog, "ASTM_Reference_Materials_Petroleum_Catalog_Oct2023.pdf", ""));
            Assert.assertTrue(commonPage.ValidateLink(referenceMaterialsPage.RequestYourOrderNow, "RefMatOrderForm091324.docx", ""));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Reference Materials", e);
        }
    }

}
