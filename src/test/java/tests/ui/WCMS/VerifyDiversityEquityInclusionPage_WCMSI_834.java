package tests.ui.WCMS;

import base.utils.ConfigReader;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

public class VerifyDiversityEquityInclusionPage_WCMSI_834 extends BaseTest {
    static final String jiraTestID = "WCMSI-834";
    CookiePage cookiePage;
    AboutPage AboutPageWCMS;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Diversity, Equity, Inclusion, and Belonging: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": Diversity, Equity, Inclusion, and Belonging: Navigation Verification for All Buttons and Links")
    public void VerifyDiversityEquityInclusionAndBelongingPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            AboutPageWCMS = page.getInstance(AboutPage.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("About ASTM","Diversity, Equity, Inclusion & Belonging");
            ValidateDiversityEquityInclusionAndBelongingPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Diversity, Equity, Inclusion, and Belonging: Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate Diversity, Equity, Inclusion, and Belonging Page")
    public void ValidateDiversityEquityInclusionAndBelongingPage() {
        try {
            Assert.assertTrue(page.getElement(AboutPageWCMS.videoLink).getAttribute("src").contains("https://www.youtube.com/embed/5vIHAxqa2_w"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.LearnMoreAboutASTMMembership,"/membership-participation/memberships", "ASTM Membership"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.BoardOfDirectorsLink,"/about/governance", "Governance"));
            Assert.assertTrue(commonPage.ValidateLink(AboutPageWCMS.EmploymentOpportunityLink,"/policies/equal-opportunity-policy", "Equal Opportunity Policy"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Diversity, Equity, Inclusion, and Belonging", e);
        }
    }

}
