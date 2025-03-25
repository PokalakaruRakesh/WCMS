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

public class VerifyDiversityEquityInclusionBelongingPage_WCMSI_834 extends BaseTest {
    static final String jiraTestID = "WCMSI-834";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;
    AboutPage AboutPageWCMS;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Diversity Equity Inclusion Belonging: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": Consumer Participation : Navigation Verification for All Buttons and Links")
    public void VerifyDiversityEquityInclusionBelongingPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);
            AboutPageWCMS = page.getInstance(AboutPage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("About ASTM","Diversity, Equity, Inclusion & Belonging");
            ValidateDiversityEquityInclusionBelongingPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify Diversity Equity Inclusion Belonging: Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate Diversity Equity Inclusion Belonging Page")
    public void ValidateDiversityEquityInclusionBelongingPage() {
        try {
            Assert.assertEquals(commonPage.getVideoLink().getAttribute("src"), "https://www.youtube.com/embed/5vIHAxqa2_w");
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.ASTMMembership, "/membership-participation/memberships", "ASTM Membership | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.ASTMBoardOfDirectors, "/about/governance", "Governance | ASTM"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.EqualOpportunity, "/policies/equal-opportunity-policy", "Equal Opportunity Policy | ASTM"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Diversity Equity Inclusion Belonging", e);
        }
    }

}
