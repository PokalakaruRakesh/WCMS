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

public class VerifyMarketInsightsPage_WCMSI_925 extends BaseTest {
    static final String jiraTestID = "WCMSI-925";
    CookiePage cookiePage;
    MarketInsightsInnovation_WCMS marketInsiteInnovation;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {

    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Market Insights: Navigation Verification for All Buttons and Links")
    @Test(description = jiraTestID + ": Market Insights: Navigation Verification for All Buttons and Links")
    public void VerifyMarketInsightsPage() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            marketInsiteInnovation = page.getInstance(MarketInsightsInnovation_WCMS.class);
            basePage = page.getInstance(BasePage.class);

            driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM")+"standards-and-solutions/market-insights-and-innovation/market-insights");
            cookiePage.handleOneTrustCookie();
            ValidateMarketInsightsPage();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Market Insights: Navigation Verification for All Buttons and Links", e);
        }
    }
    @Step("Validate MarketInsights Page")
    public void ValidateMarketInsightsPage() {
        try {
            Assert.assertTrue(commonPage.ValidateLink(marketInsiteInnovation.AdvisoryServicesContactUs,"https://marketing.astm.org/acton", ""));
            Assert.assertTrue(commonPage.ValidateLink(marketInsiteInnovation.WohlersSpecialtyReportsLearnMore,"wohlersassociates.com", "State of the Industry Reports"));
            Assert.assertTrue(commonPage.ValidateLink(marketInsiteInnovation.StandardizationImpactLearnMore,"marketing.astm.org", "Standardization Impact Report"));
            Assert.assertTrue(commonPage.ValidateLink(marketInsiteInnovation.TechnicalReportsLearnMore,"technical-reports", "Technical Reports"));
            Assert.assertTrue(commonPage.ValidateLink(marketInsiteInnovation.WhitePapersLearnMore,"/about/white-papers", "White Papers"));
            Assert.assertTrue(commonPage.ValidateLink(marketInsiteInnovation.StandardizationNewsLearnMore,"/standardization-news", "STANDARDIZATION NEWS"));
            Assert.assertTrue(commonPage.ValidateLink(marketInsiteInnovation.GetInvolvedContactUs,"https://marketing.astm.org/acton", ""));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on Market Insights", e);
        }
    }

}
