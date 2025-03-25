package tests.ui.WCMS;

import base.utils.ConfigReader;
import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.WCMSICommon;
import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.BasePage;
import pages.ui.CommonPage_WCMS;
import pages.ui.CookiePage;
import pages.ui.WCMSContentPage;
import tests.ui.base.BaseTest;

import java.util.List;

public class VerifySearchFunctionality_WCMSI_1189 extends BaseTest {
    static final String jiraTestID = "WCMSI-1189";
    CookiePage cookiePage;
    CommonPage_WCMS commonPage;
    WCMSContentPage WCMSPage;
    BasePage basePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify search functionality")
    @Test(description = jiraTestID + ": Verify search functionality")
    public void VerifySearchFunctionality() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            ValidateSearchFunctionality();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to search functionality", e);
        }
    }
    @Step("Validate search functionality")
    public void ValidateSearchFunctionality() {
        try {
            ValidateSearchResults("R");
            ValidateSearchResults("Iron");
            ValidateSearchResults("Standards");
            Search("$");
            Assert.assertTrue(WaitStatementUtils.explicitWaitForVisibility(driver,page.getElement(commonPage.DidNotProduceAnyResults)));
            Search("");
            ScreenshotUtil.takeScreenshotForAllure(driver);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the search functionality", e);
        }
    }
    @Step("Validate Search Results ")
    public void ValidateSearchResults(String searchKeyword) {
        try {
            Search(searchKeyword);
            WCMSICommon.waitForSec(5);
            Assert.assertTrue(WaitStatementUtils.explicitWaitForVisibility(driver,page.getElement(commonPage.SearchResult),10));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            List<WebElement> results=basePage.getElements(commonPage.SearchResults);
            for (int i=0;i<3;i++){
                Assert.assertTrue(results.get(i).getText().contains(searchKeyword));
            }
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Search Results", e);
        }
    }
    public void Search(String searchKeyword) {
        try {
            basePage.getElement(commonPage.Search).clear();
            page.getElement(commonPage.Search).sendKeys(searchKeyword);
            page.getElement(commonPage.SearchIcon).click();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Search", e);
        }
    }
}
