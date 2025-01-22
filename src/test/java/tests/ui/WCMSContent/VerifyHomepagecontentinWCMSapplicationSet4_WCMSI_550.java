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

public class VerifyHomepagecontentinWCMSapplicationSet4_WCMSI_550 extends BaseTest {
    static final String jiraTestID = "WCMSI-550";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    CookiePage cookiePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify \"Home page\" page content in WCMS application-Set 4")
    @Test(description = jiraTestID
            + ":Verify \"Home page\" page content in WCMS application-Set 4", groups = {""})
    public void verifyHomepagecontentinWCMSapplication() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            cookiePage = page.getInstance(CookiePage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);


            validateContentOfHelpingOurWorldWorkBetter("Home");
            validateContentUnderTheLatestHeader("TheLatest");
            validateContentUnderStandardSolutionstHeader("Standards & Solutions");
            validateContentUnderMarketInsightsInnovationHeader("Market Insights & Innovation");
            validateContentUnderblocks("blocks");
            //Need to script Latest News
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify \"Home page\" page content in WCMS application-Set 4", e);
        }
        System.out.println("Successfully Verify \"Home page\" page content in WCMS application-Set 4");
    }
    @Step("Validate Content under 'Helping Our World Work Better' header")
    public void validateContentOfHelpingOurWorldWorkBetter(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            Assert.assertEquals(WCMSPage.getBannerText(), WCMSPage.jsonValue(jsonObject, "Banner"));
            Assert.assertTrue(WCMSPage.getButtonText(WCMSPage.jsonValue(jsonObject,"button")).contains(WCMSPage.jsonValue(jsonObject,"button")));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Helping Our World Work Better' header", e);
        }
    }

    @Step("Validate Content under 'The Latest' header")
    public void validateContentUnderTheLatestHeader(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header = WCMSPage.jsonValue(jsonObject, "Header");
            String subheader1 = WCMSPage.jsonValue(jsonObject, "Subheader1");
            String subheader2 = WCMSPage.jsonValue(jsonObject, "Subheader2");
            String subheader3 = WCMSPage.jsonValue(jsonObject, "Subheader3");
            String subheader4 = WCMSPage.jsonValue(jsonObject, "Subheader4");
            String subheader5 = WCMSPage.jsonValue(jsonObject, "Subheader5");
            String subheader6 = WCMSPage.jsonValue(jsonObject, "Subheader6");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(subheader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(subheader2)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(subheader3)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(subheader4)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(subheader5)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(subheader6)));


            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader1,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader2,WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader3,WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader4,WCMSPage.jsonValue(jsonObject,"text4")),
                    WCMSPage.jsonValue(jsonObject,"Text4"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader5,WCMSPage.jsonValue(jsonObject,"text5")),
                    WCMSPage.jsonValue(jsonObject,"Text5"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader6,WCMSPage.jsonValue(jsonObject,"text6")),
                    WCMSPage.jsonValue(jsonObject,"Text6"));


        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'The Latest' header", e);
        }
    }

    @Step("Validate Content under 'Standards & Solutions' header")
    public void validateContentUnderStandardSolutionstHeader(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header = WCMSPage.jsonValue(jsonObject, "Header");
            String subheader1 = WCMSPage.jsonValue(jsonObject, "Subheader1");
            String subheader2 = WCMSPage.jsonValue(jsonObject, "Subheader2");
            String subheader3 = WCMSPage.jsonValue(jsonObject, "Subheader3");
            String subheader4 = WCMSPage.jsonValue(jsonObject, "Subheader4");
            String subheader5 = WCMSPage.jsonValue(jsonObject, "Subheader5");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(subheader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(subheader2)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(subheader3)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(subheader4)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(subheader5)));

            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader1,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader2,WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader3,WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader4,WCMSPage.jsonValue(jsonObject,"text4")),
                    WCMSPage.jsonValue(jsonObject,"Text4"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader5,WCMSPage.jsonValue(jsonObject,"text5")),
                    WCMSPage.jsonValue(jsonObject,"Text5"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Standards & Solutions' header", e);
        }
    }

    @Step("Validate Content under 'Market Insights & Innovation' header")
    public void validateContentUnderMarketInsightsInnovationHeader(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header = WCMSPage.jsonValue(jsonObject, "Header");
            String header5 = WCMSPage.jsonValue(jsonObject, "Header5");
            String header6 = WCMSPage.jsonValue(jsonObject, "Header6");
            String subheader1 = WCMSPage.jsonValue(jsonObject, "Subheader1");
            String subheader2 = WCMSPage.jsonValue(jsonObject, "Subheader2");
            String subheader3 = WCMSPage.jsonValue(jsonObject, "Subheader3");
            String subheader4 = WCMSPage.jsonValue(jsonObject, "Subheader4");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(subheader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(subheader2)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(subheader3)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(subheader4)));



            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader1,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader2,WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader3,WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader4,WCMSPage.jsonValue(jsonObject,"text4")),
                    WCMSPage.jsonValue(jsonObject,"Text4"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text5")),
                    WCMSPage.jsonValue(jsonObject,"Text5"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text6")),
                    WCMSPage.jsonValue(jsonObject,"Text6"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Market Insights & Innovation' header", e);
        }
    }
    @Step("Validate Content under 'blocks'")
    public void validateContentUnderblocks(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String mainHeader = WCMSPage.jsonValue(jsonObject, "MainHeader");
            String mainHeader1 = WCMSPage.jsonValue(jsonObject, "MainHeader1");
            String mainHeader2 = WCMSPage.jsonValue(jsonObject, "MainHeader2");
            String subheader = WCMSPage.jsonValue(jsonObject, "Subheader");
            String subheader1 = WCMSPage.jsonValue(jsonObject, "Subheader1");
            String subheader2 = WCMSPage.jsonValue(jsonObject, "Subheader2");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getMainHeader(mainHeader)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getMainHeader(mainHeader2)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getMainHeader(mainHeader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(subheader)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(subheader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(subheader2)));




            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader1,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader2,WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Market Insights & Innovation' header", e);
        }

    }}