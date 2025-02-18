package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ScreenshotUtil;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.CommonPage_WCMS;
import pages.ui.CookiePage;
import pages.ui.MarketInsightsInnovation_WCMS;
import tests.ui.base.BaseTest;
@Epic("WCMSI-2: Design and Development of Pages")
public class VerifyMarketInsights_Innovation_WCMSI_593 extends BaseTest {
    static final String jiraTestID = "WCMSI-593";
    CookiePage cookiePage;
    MarketInsightsInnovation_WCMS marketInsiteInnovation;
    CommonPage_WCMS commonPage;
    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Story("WCMSI-372:  Set 5: Market Insights & Innovation, Standards & Publications, Book of Standards, Digital Library, Laboratory Services, Tracker Services")
    @Description("To validate the Market Insights and Innovation content on the page")
    @Test(description = jiraTestID + "Validate the navigation and content on the page")
    public void ValidateTheMarketInsights_InnovationPage() {
        try {
            marketInsiteInnovation = page.getInstance(MarketInsightsInnovation_WCMS.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            cookiePage.handleOneTrustCookie();
            NavigatetoMarketInsightsInnovationPage();
            validateMarketInsightsInnovationContent();
        } catch  (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the navigation to Market Insights and Innovation  page", e);
        }
    }
    @Step("Validate links and buttons available on page")
    public void validateMarketInsightsInnovationContent(){
        Assert.assertTrue(commonPage.ValidateLinkNewtab(marketInsiteInnovation.askASTM,"https://marketing.astm.org/acton/fs/blocks/showLandingPage/a/9652/p/p-03d8/t/page/fm/0","","Ask ASTM Clicked"));
        Assert.assertTrue(commonPage.ValidateLink(marketInsiteInnovation.getInvolved,"/membership-participation/memberships","ASTM Membership","Get Involved Clicked"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(marketInsiteInnovation.ASTMXcellerate,"https://astmxcellerate.com/","ASTM Xcellerate","ASTM Xcellerate Learn More Clicked"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(marketInsiteInnovation.standardizationImpactReport,"https://marketing.astm.org/acton/fs/blocks/showLandingPage/a/9652/p/p-0403/t/page/fm/0","ASTM Standardization Impact Report 2024","Standardization Impact Report Learn More CLicked"));
        Assert.assertTrue(commonPage.ValidateLinkNewtab(marketInsiteInnovation.MarketIntelligenceWohlersReports,"https://wohlersassociates.com/reports/","State of the Industry Reports - Wohlers Associates","Market Intelligence & Wohlers Reports Learn More Clicked"));
        Assert.assertTrue(commonPage.ValidateLink(marketInsiteInnovation.SpecialtyReports,"/standards-and-solutions/market-insights-and-innovation/wohlers-report","Wohlers","Wohlers Report Learn More Clicked"));
        Assert.assertTrue(commonPage.ValidateLink(marketInsiteInnovation.contactUs,"","","Contact Us Clicked"));

    }
    @Step("Validate navigation to Market Insights and Innovation page")
    public void NavigatetoMarketInsightsInnovationPage(){
        try{
            commonPage.getstandardandSolution();
            commonPage.clickOnMarketInsightsInnovation();
            WCMSICommon.waitForSec(3);
            Assert.assertEquals(driver.getTitle(),"Market Insights & Innovation | ASTM");
            ScreenshotUtil.takeScreenshotForAllure(driver);
    }catch (Exception e){
        e.printStackTrace();
        WCMSICommon.reportFailAssert("Failed to Validate the navigation to Market Insights and Innovation page", e);
    }
    }

}

