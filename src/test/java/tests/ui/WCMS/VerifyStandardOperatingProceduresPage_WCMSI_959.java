package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ReusableMethods;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyStandardOperatingProceduresPage_WCMSI_959 extends BaseTest {
    static final String jiraTestID = "WCMSI-959";
    CookiePage cookiePage;
    LaboratoryServices_WCMS loborataryServicesPage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Standard Operating Procedures (SOP):Verify the Links of the page")
    @Test(description = jiraTestID + ": Standard Operating Procedures (SOP):Verify the Links of the page")
    public void VerifyStandardOperatingProceduresPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            loborataryServicesPage = page.getInstance(LaboratoryServices_WCMS.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","Laboratory Services");
            ValidateStandardOperatingProceduresPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to verify Standard Operating Procedures (SOP) page links", e);
        }
    }
    @Step("Validate Standard Operating Procedures Page")
    public void ValidateStandardOperatingProceduresPage() {
        try {
            WCMSICommon.waitForSec(5);
            basePage.clickOnMethod(loborataryServicesPage.SOPsLearnMoreLink);
            Assert.assertTrue(commonPage.ValidateLink(loborataryServicesPage.ContactSales,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(loborataryServicesPage.LaboratoryServicesOverviewPDF,"Lab-Services_Infographic_Oct_2022.pdf", "Lab-Services_Infographic_Oct_2022.pdf"));
            Assert.assertTrue(commonPage.ValidateLink(loborataryServicesPage.AccessNewASTMStandardContactSalesLink,"/standards-and-solutions/enterprise-solutions/salesforce", "Contact Sales | ASTM"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Digital Access To International Standards", e);
        }
    }

}
