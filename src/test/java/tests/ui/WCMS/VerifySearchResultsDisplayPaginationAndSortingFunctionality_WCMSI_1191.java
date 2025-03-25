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
import pages.ui.*;
import tests.ui.base.BaseTest;

import java.util.List;

public class VerifySearchResultsDisplayPaginationAndSortingFunctionality_WCMSI_1191 extends BaseTest {
    static final String jiraTestID = "WCMSI-977";
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
    @Description("Verify Search Results Display, Pagination, and Sorting Functionality")
    @Test(description = jiraTestID + ": Verify Search Results Display, Pagination, and Sorting Functionality")
    public void VerifySearchResultsDisplayPaginationAndSortingFunctionality() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            commonPage = page.getInstance(CommonPage_WCMS.class);
            cookiePage = page.getInstance(CookiePage.class);
            basePage = page.getInstance(BasePage.class);

            cookiePage.handleOneTrustCookie();
            ValidateSearchResultsDisplayPaginationAndSorting();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify Search Results Display, Pagination, and Sorting Functionality", e);
        }
    }
    @Step("Validate Search Results Display, Pagination, and Sorting")
    public void ValidateSearchResultsDisplayPaginationAndSorting() {
        try {
            String searchKeyword = "Steel";
            page.getElement(commonPage.Search).sendKeys(searchKeyword);
            page.getElement(commonPage.SearchIcon).click();
            WCMSICommon.waitForSec(5);
            Assert.assertTrue(WaitStatementUtils.explicitWaitForVisibility(driver,page.getElement(commonPage.SearchResult)));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(WCMSICommon.selectValueInDropdownbyVisibleText(page.getElement(commonPage.show),"10"));
            WaitStatementUtils.waitForElementStaleness(driver,page.getElement(commonPage.show),10);
            Assert.assertTrue(WCMSICommon.selectValueInDropdownbyVisibleText(page.getElement(commonPage.show),"20"));
            WaitStatementUtils.waitForElementStaleness(driver,page.getElement(commonPage.show),10);
            Assert.assertTrue(WCMSICommon.selectValueInDropdownbyVisibleText(page.getElement(commonPage.show),"30"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(WCMSICommon.selectValueInDropdown(page.getElement(commonPage.SortBy),"Designation"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            WaitStatementUtils.waitForElementStaleness(driver,page.getElement(commonPage.SortBy),10);
            Assert.assertTrue(WCMSICommon.selectValueInDropdown(page.getElement(commonPage.SortBy),"Date"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            WaitStatementUtils.waitForElementStaleness(driver,page.getElement(commonPage.SortBy),10);
            Assert.assertTrue(WCMSICommon.selectValueInDropdown(page.getElement(commonPage.SortBy),"Relevance"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            WaitStatementUtils.waitForElementStaleness(driver,page.getElement(commonPage.SortBy),10);
            Assert.assertTrue(WCMSICommon.selectValueInDropdown(page.getElement(commonPage.SortBy),"Title"));
            ScreenshotUtil.takeScreenshotForAllure(driver);
            Assert.assertTrue(WaitStatementUtils.explicitWaitForVisibility(driver,page.getElement(commonPage.ArrowIcon)));
            WCMSICommon.waitForSec(5);
            basePage.clickOnMethod(commonPage.Nextbutton);
            WaitStatementUtils.waitForElementStaleness(driver,page.getElement(commonPage.ActivePage),10);
            ReusableMethods.scrollToElement(driver,commonPage.ActivePage);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            WCMSICommon.waitForSec(5);
            Assert.assertTrue(page.getElement(commonPage.ActivePage).getText().contains("2"));
            basePage.clickOnMethod(commonPage.PreviousButton);
            WaitStatementUtils.waitForElementStaleness(driver,page.getElement(commonPage.ActivePage),10);
            ReusableMethods.scrollToElement(driver,commonPage.ActivePage);
            ScreenshotUtil.takeScreenshotForAllure(driver);
            WCMSICommon.waitForSec(5);
            Assert.assertTrue(page.getElement(commonPage.ActivePage).getText().contains("1"));
            List<WebElement> results=basePage.getElements(commonPage.SearchResults);
            for (int i=0;i<5;i++){
                Assert.assertTrue(results.get(i).getText().contains(searchKeyword));
            }
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate the Link and button available on MARC Records page", e);
        }
    }

}
