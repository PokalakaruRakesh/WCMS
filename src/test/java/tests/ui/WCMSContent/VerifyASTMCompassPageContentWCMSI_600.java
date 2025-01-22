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
import pages.ui.WCMSContentPage;
import tests.ui.base.BaseTest;

public class VerifyASTMCompassPageContentWCMSI_600 extends BaseTest {
    static final String jiraTestID = "WCMSI-600";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify ASTM Compass Page content in WCMS application-Set 6")
    @Test(description = jiraTestID
            + ": Verify ASTM Compass Page content in WCMS application-Set 6", groups = {""})
    public void VerifyASTMCompassPageContentInTheWCMSApplication() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);

            WCMSPage.NavigateToPage(jsonFileReader.getJsonString("Menu"), jsonFileReader.getJsonString("Submenu"), "Standards & Solutions Overview");
            WCMSPage.NavigateToSubmenuList(jsonFileReader.getJsonString("SubmenuList"), "ASTM Compass");

            validateContentUnderASTMCompassHeader("ASTM Compass");
            validateContentUnderDigitalAccessHeader("Digital Access");
            validateContentUnderWhyASTMCompassHeader("Why ASTM Compass");
            validateContentUnderOneResourceHeader("One Resource");
            validateContentUnderCustomWorkflowHeader("Custom Workflow");
            validateContentUnderCompassPointsHeader("Compass Points");
            validateContentUnderVersionComparisonHeader("Version Comparison");
            validateContentUnderVideoStandardsHeader("Video Standards");
            validateContentUnderDigitalAccessInternationalHeader("Digital Access to International");
            validateContentUnderDiscoverASTMCompassHeader("Discover ASTM Compass");

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify ASTM Compass Page content in WCMS application-Set 6", e);
        }
        System.out.println("Successfully Verify ASTM Compass Page content in WCMS application-Set 6");
    }

    @Step("Validate Content under 'ASTM Compass' header")
    public void validateContentUnderASTMCompassHeader(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getMainHeader(WCMSPage.jsonValue(jsonObject, "Mainheader"))));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeaderUnderMainheader(WCMSPage.jsonValue(jsonObject, "Mainheader"),
                    WCMSPage.jsonValue(jsonObject, "Subheader"))));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderSubheader(WCMSPage.jsonValue(jsonObject, "Subheader"),
                    WCMSPage.jsonValue(jsonObject, "Button"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'ASTM Compass' header ", e);
        }
    }
        @Step("Validate Content under 'Digital Access to ASTM Content Plus Dynamic Workflow Tools' header")
        public void validateContentUnderDigitalAccessHeader(String jsonElement){
            try {
                JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
                String header=WCMSPage.jsonValue(jsonObject,"Header");
                Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject, "Header"))));
                Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text1")),
                        WCMSPage.jsonValue(jsonObject,"Text1"));
                Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text2")),
                        WCMSPage.jsonValue(jsonObject,"Text2"));
                Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text3")),
                        WCMSPage.jsonValue(jsonObject,"Text3"));
                Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderHeader(WCMSPage.jsonValue(jsonObject, "Header"),
                        WCMSPage.jsonValue(jsonObject, "Button1"))));
                Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderHeader(WCMSPage.jsonValue(jsonObject, "Header"),
                        WCMSPage.jsonValue(jsonObject, "Button2"))));
                Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderHeader(WCMSPage.jsonValue(jsonObject, "Header"),
                        WCMSPage.jsonValue(jsonObject, "Button3"))));


            } catch (Exception e) {
                e.printStackTrace();
                WCMSICommon.reportFailAssert("Failed to validate Content under 'Digital Access to ASTM Content Plus Dynamic Workflow Tools' header ", e);
            }
        }
    @Step("Validate Content under 'Why ASTM Compass' header")
    public void validateContentUnderWhyASTMCompassHeader(String jsonElement){
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject, "Header"))));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getSubheaderUnderHeader(WCMSPage.jsonValue(jsonObject, "Header"),
                    WCMSPage.jsonValue(jsonObject, "Subheader"))));
            Assert.assertTrue(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text")).contains(WCMSPage.jsonValue(jsonObject,"Text")));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text4"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text5"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text6"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text7")),
                    WCMSPage.jsonValue(jsonObject,"Text7"));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text8")),
                    WCMSPage.jsonValue(jsonObject,"Text8"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Why ASTM Compass' header ", e);
        }
    }
    @Step("Validate Content under 'One Resource for All Your Content Needs' header")
    public void validateContentUnderOneResourceHeader(String jsonElement){
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            String Subheader1=WCMSPage.jsonValue(jsonObject,"Subheader1");
            String Subheader2=WCMSPage.jsonValue(jsonObject,"Subheader2");
            String Subheader3=WCMSPage.jsonValue(jsonObject,"Subheader3");
            String Subheader4=WCMSPage.jsonValue(jsonObject,"Subheader4");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject, "Header"))));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,Subheader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader1,
                    WCMSPage.jsonValue(jsonObject,"Text1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader1,
                    WCMSPage.jsonValue(jsonObject,"Text2"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text4")),
                    WCMSPage.jsonValue(jsonObject,"Text4"));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,Subheader2)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader2,
                    WCMSPage.jsonValue(jsonObject,"Text5"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(Subheader2,WCMSPage.jsonValue(jsonObject,"text6")),
                    WCMSPage.jsonValue(jsonObject,"Text6"));
            Assert.assertEquals(WCMSPage.getTextByHeader(Subheader2,WCMSPage.jsonValue(jsonObject,"text7")),
                    WCMSPage.jsonValue(jsonObject,"Text7"));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,Subheader3)));
            Assert.assertEquals(WCMSPage.getTextByHeader(Subheader3,WCMSPage.jsonValue(jsonObject,"text8")),
                    WCMSPage.jsonValue(jsonObject,"Text8"));
            Assert.assertEquals(WCMSPage.getTextByHeader(Subheader3,WCMSPage.jsonValue(jsonObject,"text9")),
                    WCMSPage.jsonValue(jsonObject,"Text9"));
            Assert.assertEquals(WCMSPage.getTextByHeader(Subheader3,WCMSPage.jsonValue(jsonObject,"text10")),
                    WCMSPage.jsonValue(jsonObject,"Text10"));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,Subheader4)));
            Assert.assertEquals(WCMSPage.getTextByHeader(Subheader4,WCMSPage.jsonValue(jsonObject,"text11")),
                    WCMSPage.jsonValue(jsonObject,"Text11"));
            Assert.assertEquals(WCMSPage.getTextByHeader(Subheader4,WCMSPage.jsonValue(jsonObject,"text12")),
                    WCMSPage.jsonValue(jsonObject,"Text12"));
            Assert.assertEquals(WCMSPage.getTextByHeader(Subheader4,WCMSPage.jsonValue(jsonObject,"text13")),
                    WCMSPage.jsonValue(jsonObject,"Text13"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'One Resource for All Your Content Needs", e);
        }
    }
    @Step("Validate Content under 'Custom Workflow Tools for Standards Users' header")
    public void validateContentUnderCustomWorkflowHeader(String jsonElement){
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            String Text1=WCMSPage.jsonValue(jsonObject,"Text1");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text1")),
                    Text1);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Custom Workflow Tools for Standards Users'", e);
        }
    }
    @Step("Validate Content under 'Compass Points' header")
    public void validateContentUnderCompassPointsHeader(String jsonElement){
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            String Subheader=WCMSPage.jsonValue(jsonObject,"Subheader");
            String Text1=WCMSPage.jsonValue(jsonObject,"Text1");
            String Text2=WCMSPage.jsonValue(jsonObject,"Text2");
            String Subheader1=WCMSPage.jsonValue(jsonObject,"Subheader1");
            String Text3=WCMSPage.jsonValue(jsonObject,"Text3");
            String Subheader2=WCMSPage.jsonValue(jsonObject,"Subheader2");
            String Text4=WCMSPage.jsonValue(jsonObject,"Text4");
            String Subheader3=WCMSPage.jsonValue(jsonObject,"Subheader3");
            String Text5=WCMSPage.jsonValue(jsonObject,"Text5");
            String Text6=WCMSPage.jsonValue(jsonObject,"Text6");
            String Text7=WCMSPage.jsonValue(jsonObject,"Text7");
            String Text8=WCMSPage.jsonValue(jsonObject,"Text8");
            String Text9=WCMSPage.jsonValue(jsonObject,"Text9");
            String Text10=WCMSPage.jsonValue(jsonObject,"Text10");


            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(Subheader)));
            Assert.assertEquals(WCMSPage.getTextByHeader(Subheader,WCMSPage.jsonValue(jsonObject,"text1")), Text1);
            Assert.assertEquals(WCMSPage.getTextByHeader(Subheader,WCMSPage.jsonValue(jsonObject,"text2")), Text2);

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getSubheaderUnderHeader(header,Subheader1)));
            Assert.assertEquals(WCMSPage.getTextByHeader(Subheader1,WCMSPage.jsonValue(jsonObject,"text3")), Text3);

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getSubheaderUnderHeader(header,Subheader2)));
            Assert.assertEquals(WCMSPage.getTextByHeader(Subheader2,WCMSPage.jsonValue(jsonObject,"text4")), Text4);

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(Subheader3)));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text5")), Text5);
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text6")), Text6);
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text7")), Text7);
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text8")), Text8);
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text9")), Text9);
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text10")), Text10);


        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Compass Points'", e);
        }
    }
    @Step("Validate Content under 'Version Comparison' header")
    public void validateContentUnderVersionComparisonHeader(String jsonElement){
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            String Text1=WCMSPage.jsonValue(jsonObject,"Text1");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text1")),
                    Text1);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Version Comparison'", e);
        }
    }
    @Step("Validate Content under 'Video Standards' header")
    public void validateContentUnderVideoStandardsHeader(String jsonElement){
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            String Text1=WCMSPage.jsonValue(jsonObject,"Text1");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text1")),
                    Text1);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Video Standards'", e);
        }
    }
    @Step("Validate Content under 'Digital Access to International Standards' header")
    public void validateContentUnderDigitalAccessInternationalHeader(String jsonElement){
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            String Text1=WCMSPage.jsonValue(jsonObject,"Text1");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text1")),
                    Text1);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Digital Access to International Standards'", e);
        }
    }
    @Step("Validate Content under 'Discover ASTM Compass® and start working smarter today' header")
    public void validateContentUnderDiscoverASTMCompassHeader(String jsonElement){
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            String Subheader=WCMSPage.jsonValue(jsonObject,"Subheader");
            String Button=WCMSPage.jsonValue(jsonObject,"Button");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getSubheaderUnderHeader(header,Subheader)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderHeader(header,Button)));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Discover ASTM Compass® and start working smarter today'", e);
        }
    }

    }

