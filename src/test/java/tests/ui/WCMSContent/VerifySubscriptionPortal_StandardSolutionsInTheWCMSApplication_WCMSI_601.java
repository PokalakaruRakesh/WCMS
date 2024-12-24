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
import org.testng.asserts.SoftAssert;
import pages.ui.WCMSContentPage;
import tests.ui.base.BaseTest;

public class VerifySubscriptionPortal_StandardSolutionsInTheWCMSApplication_WCMSI_601 extends BaseTest {
    static final String jiraTestID = "WCMSI-601";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    SoftAssert softAssert;
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify Subscription Portals Page content in WCMS application-Set 6")
    @Test(description = jiraTestID
            + ":Verify Subscription Portals Page content in WCMS application-Set 6", groups = {""})
    public void verifySubscriptionPortal_StandardSolutionsInTheWCMSApplication() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);
            WCMSPage.NavigateToPage(jsonFileReader.getJsonString("Menu"), jsonFileReader.getJsonString("Submenu"),"Standards & Solutions");
            WCMSPage.NavigateToSubmenuList(jsonFileReader.getJsonString("SubmenuList"),"ASTM SpecBuilder");
            validateContentUnderSubscriptionPortalHeader("Subscription Portal");
            validateContentUnderYourContentHeader("Your Content");
            validateContentUnderYourContentOnASTMCompassHeader("Your Content on ASTM Compass");
            validateContentUnderCreateCompanySubscriptionPortalHeader("Create a Company Subscription Portal");
            validateContentUnderAlsoAvailableHeader("Also Available");
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify Subscription Portals Page content in WCMS application-Set 6", e);
        }
        System.out.println("Successfully Verify Subscription Portals Page content in WCMS application-Set 6");
    }
    @Step("Validate Content under 'Subscription Portal' header")
    public void validateContentUnderSubscriptionPortalHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String mainHeader=WCMSPage.jsonValue(jsonObject,"MainHeader");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(mainHeader)));

            Assert.assertEquals(WCMSPage.getTextByUnderMainHeader(mainHeader,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderMainheader(mainHeader,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderMainheader(mainHeader,
                    WCMSPage.jsonValue(jsonObject,"Button2"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'Subscription Portal' header", e);
        }
    }
    @Step("Validate Content under 'Your Content' header")
    public void validateContentUnderYourContentHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));

            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));

            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));

            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));
                 } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'Your Content' header", e);
        }
    }
    @Step("Validate Content under 'Your Content' header")
    public void validateContentUnderYourContentOnASTMCompassHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            String subHeader1=WCMSPage.jsonValue(jsonObject,"subHeader1");
            String subHeader2=WCMSPage.jsonValue(jsonObject,"subHeader2");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader2)));

            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader1,WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader1,WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader1,WCMSPage.jsonValue(jsonObject,"text4")),
                    WCMSPage.jsonValue(jsonObject,"Text4"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader1,WCMSPage.jsonValue(jsonObject,"text5")),
                    WCMSPage.jsonValue(jsonObject,"Text5"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader1,WCMSPage.jsonValue(jsonObject,"text6")),
                    WCMSPage.jsonValue(jsonObject,"Text6"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader1,WCMSPage.jsonValue(jsonObject,"text7")),
                    WCMSPage.jsonValue(jsonObject,"Text7"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader1,WCMSPage.jsonValue(jsonObject,"text8")),
                    WCMSPage.jsonValue(jsonObject,"Text8"));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subHeader2,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));



        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'Your Content' header", e);
        }
    }

    @Step("Validate Content under 'Create a Company Subscription Portal' header")
    public void validateContentUnderCreateCompanySubscriptionPortalHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            String subHeader=WCMSPage.jsonValue(jsonObject,"subHeader");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader)));

            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));

            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));

            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subHeader,
                    WCMSPage.jsonValue(jsonObject,"Button"))));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'Create a Company Subscription Portal' header", e);
        }
    }
    @Step("Validate Content under 'Also Available' header")
    public void validateContentUnderAlsoAvailableHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            String subHeader1=WCMSPage.jsonValue(jsonObject,"subHeader1");
            String subHeader2=WCMSPage.jsonValue(jsonObject,"subHeader2");
            String subHeader3=WCMSPage.jsonValue(jsonObject,"subHeader3");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader2)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader2)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader2)));

            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader1,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader2,WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader3,WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'Also Available' header", e);
        }
    }
}
