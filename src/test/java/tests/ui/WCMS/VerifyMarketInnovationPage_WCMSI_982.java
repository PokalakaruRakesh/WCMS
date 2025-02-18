package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ReusableMethods;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.Common;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.*;
import tests.ui.base.BaseTest;

@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyMarketInnovationPage_WCMSI_982 extends BaseTest {
    static final String jiraTestID = "WCMSI-982";
    CookiePage cookiePage;
    MarketInsightsInnovation_WCMS marketInsiteInnovation;
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
            marketInsiteInnovation = page.getInstance(MarketInsightsInnovation_WCMS.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);

            cookiePage.handleOneTrustCookie();
            WCMSPage.NavigateToPage("Standards & Solutions","Market Insights & Innovation");
            ValidateReferenceMaterialsPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Reference Materials page", e);
        }
    }
    @Step("Validate Reference Materials Page")
    public void ValidateReferenceMaterialsPage() {
        try {
            ReusableMethods.scrollToElement(driver,commonPage.getElement(marketInsiteInnovation.MarketInnovationsLearnMore));
            WaitStatementUtils.waitForElementToBeClickable(driver, commonPage.getElement(marketInsiteInnovation.MarketInnovationsLearnMore));
            WaitStatementUtils.waitForElementStaleness(driver, commonPage.getElement(marketInsiteInnovation.MarketInnovationsLearnMore),3);
            commonPage.getElement(marketInsiteInnovation.MarketInnovationsLearnMore).click();
            WCMSICommon.waitForSec(4);
            Assert.assertTrue(commonPage.ValidateLink(marketInsiteInnovation.ASTMXcellerate, "astmxcellerate.com", "ASTM Xcellerate"));
            Assert.assertTrue(commonPage.ValidateLink(marketInsiteInnovation.LearnMoreAMCoE, "amcoe.org", "Making AM Better, Faster - AM CoE - Home"));
            Assert.assertTrue(commonPage.ValidateLink(marketInsiteInnovation.LearnMoreETCoE, "etcoe.org", "Exo Technology Center of Excellence"));
            Assert.assertTrue(WaitStatementUtils.waitForElementToBeClickable(driver,commonPage.getElement(marketInsiteInnovation.TechnicalExpertsLearnMore)));
            Assert.assertTrue(commonPage.ValidateLink(marketInsiteInnovation.ASTMExoGamesLearnMore, "etcoe.org", "Exo Technology Center of Excellence"));
            Assert.assertTrue(commonPage.ValidateLink(marketInsiteInnovation.contactUs, "showLandingPage", ""));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Reference Materials", e);
        }
    }

}
