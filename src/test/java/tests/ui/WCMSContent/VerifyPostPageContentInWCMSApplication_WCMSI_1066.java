package tests.ui.WCMSContent;

import base.utils.ConfigReader;
import base.utils.JsonFileReader;
import base.utils.ReusableMethods;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.Common;
import com.astm.commonFunctions.WCMSICommon;
import com.google.gson.JsonObject;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.CookiePage;
import pages.ui.WCMSContentPage;
import tests.ui.base.BaseTest;

public class VerifyPostPageContentInWCMSApplication_WCMSI_1066 extends BaseTest {
    static final String jiraTestID = "WCMSI-1066";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    CookiePage cookiePage;
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify 'Post' Page content in WCMS application-Set 3")
    @Test(description = jiraTestID
            + ": Verify 'Post' Page content in WCMS application-Set 3", groups = {""})
    public void verifyPostPageContent() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            cookiePage=page.getInstance(CookiePage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);

            String url=driver.getCurrentUrl()+jsonFileReader.getJsonString("AddURL");
            driver.navigate().to(url);
            cookiePage.handleOneTrustCookie();
            validatePostPageOfEachCardOnPage("News");
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to verify 'Post' Page content in WCMS application-Set 3", e);
        }
        System.out.println("Successfully verify 'Query' Page content in WCMS application-Set 3");
    }
    @Step("Validate Post Page of each card on page")
    public void validatePostPageOfEachCardOnPage(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String Mainheader=WCMSPage.jsonValue(jsonObject,"Mainheader");
            String LinkText1=WCMSPage.jsonValue(jsonObject,"LinkText1");
            String URL1=WCMSPage.jsonValue(jsonObject,"URL1");
            String Header1=WCMSPage.jsonValue(jsonObject,"Header1");
            String LinkText2=WCMSPage.jsonValue(jsonObject,"LinkText2");
            String URL2=WCMSPage.jsonValue(jsonObject,"URL2");
            String Header2=WCMSPage.jsonValue(jsonObject,"Header2");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(Mainheader)));
            page.getElement(WCMSPage.getLinkText(LinkText1)).click();
            WCMSICommon.waitForSec(4);
            Assert.assertTrue(driver.getCurrentUrl().contains(URL1));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(Header1)));
            driver.navigate().back();
            WCMSICommon.waitForSec(4);
            ReusableMethods.scrollToElement(driver,page.getElement(WCMSPage.getLinkText(LinkText2)));
            WaitStatementUtils.waitForElementToBeClickable(driver,page.getElement(WCMSPage.getLinkText(LinkText2)));
            page.getElement(WCMSPage.getLinkText(LinkText2)).click();
            WCMSICommon.waitForSec(4);
            Assert.assertTrue(driver.getCurrentUrl().contains(URL2));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(Header2)));
            driver.navigate().back();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Queried Category - update' header ", e);
        }
    }
}
