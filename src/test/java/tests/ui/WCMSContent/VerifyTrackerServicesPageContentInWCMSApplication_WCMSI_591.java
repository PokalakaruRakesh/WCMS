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

public class VerifyTrackerServicesPageContentInWCMSApplication_WCMSI_591 extends BaseTest {
    static final String jiraTestID = "WCMSI-591";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    CookiePage cookiePage;
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify 'Tracker Services' Page content in WCMS application-Set 5")
    @Test(description = jiraTestID
            + ": Verify 'Tracker Services' Page content in WCMS application-Set 5", groups = {""})
    public void verifyTrackerServicesPageContent() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            cookiePage=page.getInstance(CookiePage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);

            WCMSPage.NavigateToPage(jsonFileReader.getJsonString("Menu"),jsonFileReader.getJsonString("Submenu"),"");
            WCMSPage.NavigateToSubmenuList(jsonFileReader.getJsonString("SubmenuList"),"");
            validateContentUnderASTMStandardsTrackerHeader("ASTMStandardsTracker");
            validateContentUnderHowToTrackStandardsHeader("HowToTrackStandards");
            validateContentUnderEmailSubscriptionSettingsHeader("EmailSubscriptionSettings");
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify 'Tracker Services' Page content in WCMS application-Set 5", e);
        }
        System.out.println("Successfully Verify 'Tracker Services' Page content in WCMS application-Set 5");
    }

    @Step("Validate Content under 'ASTM Standards Tracker' header")
    public void validateContentUnderASTMStandardsTrackerHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(WCMSPage.jsonValue(jsonObject,"Mainheader"))));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text")),
                    WCMSPage.jsonValue(jsonObject,"Text"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'ASTM Standards Tracker' header ", e);
        }
    }
    @Step("Validate Content under 'How to Track Standards' header")
    public void validateContentUnderHowToTrackStandardsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header"))));

            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text")),
                    WCMSPage.jsonValue(jsonObject,"Text"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader1"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(WCMSPage.jsonValue(jsonObject,"Subheader1"),WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader2"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(WCMSPage.jsonValue(jsonObject,"Subheader2"),WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader3"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(WCMSPage.jsonValue(jsonObject,"Subheader3"),WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader4"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(WCMSPage.jsonValue(jsonObject,"Subheader4"),WCMSPage.jsonValue(jsonObject,"text4")),
                    WCMSPage.jsonValue(jsonObject,"Text4"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'How to Track Standards' header ", e);
        }
    }
    @Step("Validate Content under 'Email Subscription Settings' header")
    public void validateContentUnderEmailSubscriptionSettingsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header"))));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text1")),WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text2")),WCMSPage.jsonValue(jsonObject,"Text2"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Email Subscription Settings' header ", e);
        }
    }
}
