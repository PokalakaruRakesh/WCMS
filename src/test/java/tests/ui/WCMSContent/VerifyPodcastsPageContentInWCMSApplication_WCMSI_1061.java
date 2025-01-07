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

public class VerifyPodcastsPageContentInWCMSApplication_WCMSI_1061 extends BaseTest {
    static final String jiraTestID = "WCMSI-1061";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    CookiePage cookiePage;
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify 'Podcasts' Page content in WCMS application-Set 3")
    @Test(description = jiraTestID
            + ": Verify 'Podcasts' Page content in WCMS application-Set 3", groups = {""})
    public void verifyPodcastsPageContent() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            cookiePage=page.getInstance(CookiePage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);

            String url=driver.getCurrentUrl()+jsonFileReader.getJsonString("AddURL");
            driver.navigate().to(url);
            cookiePage.handleOneTrustCookie();
            validateContentUnderStandardsImpactPodcastsHeader("StandardsImpactPodcasts");
            validateContentUnderASTMPodcastHeader("ASTMPodcast");
            validateContentUnderRelatedStoriesHeader("RelatedStories");
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to verify 'Podcasts' Page content in WCMS application-Set 3", e);
        }
        System.out.println("Successfully verify 'Podcasts' Page content in WCMS application-Set 3");
    }
    @Step("Validate Content under 'Standards Impact Podcasts' header")
    public void validateContentUnderStandardsImpactPodcastsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);

            String Header=WCMSPage.jsonValue(jsonObject,"Header");
            String SubHeader1=WCMSPage.jsonValue(jsonObject,"SubHeader1");
            String SubHeader2=WCMSPage.jsonValue(jsonObject,"SubHeader2");
            String SubHeader3=WCMSPage.jsonValue(jsonObject,"SubHeader3");
            String SubHeader4=WCMSPage.jsonValue(jsonObject,"SubHeader4");
            String SubHeader5=WCMSPage.jsonValue(jsonObject,"SubHeader5");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(Header)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(Header, SubHeader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(Header, SubHeader2)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(Header, SubHeader3)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(Header, SubHeader4)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(Header, SubHeader5)));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Standards Impact Podcasts' header ", e);
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
            //Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSpotify(Text3)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSpotify(Text4)));
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'ASTM Podcast' header ", e);
        }
    }
    @Step("Validate Content under 'Related Stories' header")
    public void validateContentUnderRelatedStoriesHeader(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String Header = WCMSPage.jsonValue(jsonObject, "Header");
            String SubHeader1 = WCMSPage.jsonValue(jsonObject, "SubHeader1");
            String SubHeader2 = WCMSPage.jsonValue(jsonObject, "SubHeader2");
            String SubHeader3 = WCMSPage.jsonValue(jsonObject, "SubHeader3");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(Header)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getSubheaderUnderHeader(Header, SubHeader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getSubheaderUnderHeader(Header, SubHeader2)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getSubheaderUnderHeader(Header, SubHeader3)));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Related Stories' header ", e);
        }
    }
}
