package tests.ui.WCMSContent;

import base.utils.ConfigReader;
import base.utils.JsonFileReader;
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

public class VerifyEspanolPageContentInWCMSApplication_WCMSI_1062 extends BaseTest {
    static final String jiraTestID = "WCMSI-1062";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    CookiePage cookiePage;
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify 'Español' Page content in WCMS application-Set 3")
    @Test(description = jiraTestID
            + ": Verify 'Español' Page content in WCMS application-Set 3", groups = {""})
    public void verifyEspanolPageContent() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            cookiePage=page.getInstance(CookiePage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);

            String url=driver.getCurrentUrl()+jsonFileReader.getJsonString("AddURL");
            driver.navigate().to(url);
            cookiePage.handleOneTrustCookie();
            WCMSPage.changeLanguage();
            validateContentUnderNewsInSpanishHeader("News in Spanish");
            validateContentUnderMainArticlesHeader("Main Articles");
            validateContentUnderRecentArticlesHeader("Recent Articles");
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to verify 'Español' Page content in WCMS application-Set 3", e);
        }
        System.out.println("Successfully verify 'Español' Page content in WCMS application-Set 3");
    }
    @Step("Validate Content under 'News in Spanish' header")
    public void validateContentUnderNewsInSpanishHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);

            String Header=WCMSPage.jsonValue(jsonObject,"Header");
            String Text1=WCMSPage.jsonValue(jsonObject,"Text1");
            String Text2=WCMSPage.jsonValue(jsonObject,"Text2");
            String LinkText=WCMSPage.jsonValue(jsonObject,"LinkText");

            Assert.assertEquals(WCMSPage.getTextByHeader(Header,WCMSPage.jsonValue(jsonObject,"text1")), Text1);
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(LinkText)));
            Assert.assertEquals(WCMSPage.getTextByHeader(Header,WCMSPage.jsonValue(jsonObject,"text2")), Text2);
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(LinkText)));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'News in Spanish' header ", e);
        }
    }
    @Step("Validate Content under 'Main Articles' header")
    public void validateContentUnderMainArticlesHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String Header=WCMSPage.jsonValue(jsonObject,"Header");
            String SubHeader1=WCMSPage.jsonValue(jsonObject,"SubHeader1");
            String Button1=WCMSPage.jsonValue(jsonObject,"Button1");
            String SubHeader2=WCMSPage.jsonValue(jsonObject,"SubHeader2");
            String Button2=WCMSPage.jsonValue(jsonObject,"Button2");
            String SubHeader3=WCMSPage.jsonValue(jsonObject,"SubHeader3");
            String Button3=WCMSPage.jsonValue(jsonObject,"Button3");
            String SubHeader4=WCMSPage.jsonValue(jsonObject,"SubHeader4");
            String Button4=WCMSPage.jsonValue(jsonObject,"Button4");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(Header)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getSubheaderUnderHeader(Header, SubHeader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderSubheader(SubHeader1, Button1)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getSubheaderUnderHeader(Header, SubHeader2)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderSubheader(SubHeader2, Button2)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getSubheaderUnderHeader(Header, SubHeader3)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderSubheader(SubHeader3, Button3)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getSubheaderUnderHeader(Header, SubHeader4)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderSubheader(SubHeader4, Button4)));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Main Articles' header ", e);
        }
    }
    @Step("Validate Content under 'Recent Articles' header")
    public void validateContentUnderRecentArticlesHeader(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String Header = WCMSPage.jsonValue(jsonObject, "Header");
            String SubHeader1 = WCMSPage.jsonValue(jsonObject, "SubHeader1");
            String SubHeader2 = WCMSPage.jsonValue(jsonObject, "SubHeader2");
            String SubHeader3 = WCMSPage.jsonValue(jsonObject, "SubHeader3");
            String Button = WCMSPage.jsonValue(jsonObject, "Button");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(Header)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getSubheaderUnderHeader(Header, SubHeader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getSubheaderUnderHeader(Header, SubHeader2)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getSubheaderUnderHeader(Header, SubHeader3)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderHeader(Header, Button)));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Recent Articles' header ", e);
        }
    }
}
