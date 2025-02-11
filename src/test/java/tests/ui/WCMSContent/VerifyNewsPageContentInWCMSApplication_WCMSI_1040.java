package tests.ui.WCMSContent;

import base.utils.ConfigReader;
import base.utils.JsonFileReader;
import com.astm.commonFunctions.Common;
import com.astm.commonFunctions.WCMSICommon;
import com.google.gson.JsonObject;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.CookiePage;
import pages.ui.WCMSContentPage;
import tests.ui.base.BaseTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.sun.tools.xjc.util.DOMUtils.getElement;

public class VerifyNewsPageContentInWCMSApplication_WCMSI_1040 extends BaseTest {
    static final String jiraTestID = "WCMSI-1040";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    CookiePage cookiePage;
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify 'News' Page content in WCMS application-Set 3")
    @Test(description = jiraTestID
            + ": Verify 'News' Page content in WCMS application-Set 3", groups = {""})
    public void verifyNewsPageContentInWCMSApplication() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            cookiePage=page.getInstance(CookiePage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);


            String url=driver.getCurrentUrl()+jsonFileReader.getJsonString("AddURL");
            driver.navigate().to(url);
            cookiePage.handleOneTrustCookie();
            validateContentUnderNewsHeader("News");
            //validateContentUnderWhatsHappeningHeader("WhatsHappening");
            validateContentUnderSTANDARDIZATIONNEWSHeader("STANDARDIZATIONNEWS");
            validateContentUnderASTMPodcastHeader("ASTMPodcast");
            validateContentUnderTrendingStoriesHeader("TrendingStories");
            validateContentUnderPublicityRequestFormHeader("PublicityRequestForm");
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify 'News' Page content in WCMS application-Set 3", e);
        }
        System.out.println("Successfully Verify 'News' Page content in WCMS application-Set 3");
    }

    @Step("Validate Content under 'News' header")
    public void validateContentUnderNewsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String Mainheader=WCMSPage.jsonValue(jsonObject,"Mainheader");
            String Text1=WCMSPage.jsonValue(jsonObject,"Text1");
            String Text2=WCMSPage.jsonValue(jsonObject,"Text2");
            String LinkText=WCMSPage.jsonValue(jsonObject,"LinkText");
            String Text3=WCMSPage.jsonValue(jsonObject,"Text3");
            String Text4=WCMSPage.jsonValue(jsonObject,"Text4");
            String Header1=WCMSPage.jsonValue(jsonObject,"Header1");
            String Text1_1=WCMSPage.jsonValue(jsonObject,"Text1_1");
            String LinkText1=WCMSPage.jsonValue(jsonObject,"LinkText1");
            String SubHeader=WCMSPage.jsonValue(jsonObject,"SubHeader");
            String Button=WCMSPage.jsonValue(jsonObject,"Button");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(Mainheader)));
            Assert.assertEquals(WCMSPage.getTextByHeader(Mainheader,WCMSPage.jsonValue(jsonObject,"text1")),
                    Text1);
            Assert.assertEquals(WCMSPage.getTextByHeader(Mainheader,WCMSPage.jsonValue(jsonObject,"text2")),
                    Text2);
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(LinkText)));
            Assert.assertEquals(WCMSPage.getTextByHeader(Mainheader,WCMSPage.jsonValue(jsonObject,"text3")), Text3);
            Assert.assertEquals(WCMSPage.getTextByHeader(Mainheader,WCMSPage.jsonValue(jsonObject,"text4")), Text4);
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(LinkText)));
            //Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(Header1)));
            Assert.assertEquals(WCMSPage.getText(Text1_1),Text1_1);
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(LinkText1)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(SubHeader)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(SubHeader, Button)));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'News' header ", e);
        }
    }
    @Step("Validate Content under 'What’s Happening' header")
    public void validateContentUnderWhatsHappeningHeader(String jsonElement) {
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
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(Header, SubHeader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(SubHeader1, Button1)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(Header, SubHeader2)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(SubHeader2, Button2)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(Header, SubHeader3)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(SubHeader3, Button3)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(Header, SubHeader4)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(SubHeader4, Button4)));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'What’s Happening' header ", e);
        }
    }
    @Step("Validate Content under 'STANDARDIZATION NEWS' header")
    public void validateContentUnderSTANDARDIZATIONNEWSHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String SubHeader1=WCMSPage.jsonValue(jsonObject,"SubHeader1");
            String SubHeader2=WCMSPage.jsonValue(jsonObject,"SubHeader2");
            String Text1=WCMSPage.jsonValue(jsonObject,"Text1");
            String SubHeader3=WCMSPage.jsonValue(jsonObject,"SubHeader3");
            String Text2=WCMSPage.jsonValue(jsonObject,"Text2");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(SubHeader1)));
           // Assert.assertEquals(driver,WCMSPage.getText(SubHeader1),SubHeader2);
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text1")), Text1);
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(SubHeader3)));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text2")), Text2);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'STANDARDIZATION NEWS' header ", e);
        }
    }
    @Step("Validate Content under 'ASTM Podcast' header")
    public void validateContentUnderASTMPodcastHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String Header=WCMSPage.jsonValue(jsonObject,"Header");
            String Text1=WCMSPage.jsonValue(jsonObject,"Text1");
            String Text2=WCMSPage.jsonValue(jsonObject,"Text2");
            String Text3=WCMSPage.jsonValue(jsonObject,"Text3");
            String Text4=WCMSPage.jsonValue(jsonObject,"Text4");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(Header)));
            driver.switchTo().frame(WCMSPage.getFrame());
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSpotify(Text1)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSpotify(Text2)));
           // Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSpotify(Text3)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSpotify(Text4)));
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'ASTM Podcast' header ", e);
        }
    }
    @Step("Validate Content under 'Trending Stories' header")
    public void validateContentUnderTrendingStoriesHeader(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String Header = WCMSPage.jsonValue(jsonObject, "Header");
            String SubHeader1 = WCMSPage.jsonValue(jsonObject, "SubHeader1");
            String SubHeader2 = WCMSPage.jsonValue(jsonObject, "SubHeader2");
            String SubHeader3 = WCMSPage.jsonValue(jsonObject, "SubHeader3");
            String Button = WCMSPage.jsonValue(jsonObject, "Button");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(Header)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getSubheaderUnderHeader(Header, SubHeader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderSubheader(SubHeader1, Button)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getSubheaderUnderHeader(Header, SubHeader2)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderSubheader(SubHeader2, Button)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getSubheaderUnderHeader(Header, SubHeader3)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderSubheader(SubHeader3, Button)));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Trending Stories' header ", e);
        }
    }
        @Step("Validate Content under 'Publicity Request Form' header")
        public void validateContentUnderPublicityRequestFormHeader(String jsonElement) {
            try {
                JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
                String Header=WCMSPage.jsonValue(jsonObject,"Header");
                String Text=WCMSPage.jsonValue(jsonObject,"Text");

                Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(Header)));
                Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text")), Text);            } catch (Exception e) {
                e.printStackTrace();
                WCMSICommon.reportFailAssert("Failed to validate Content under 'Publicity Request Form' header ", e);
            }
    }
}
