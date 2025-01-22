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

import javax.mail.Header;

public class VerifyStandardsPublicationsPageContentWCMSApplication_WCMSI_584 extends BaseTest {
    static final String jiraTestID = "WCMSI-584";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify \"Standards & Publications\" Page content in WCMS application-Set 5")
    @Test(description = jiraTestID
            + ": Verify \"Standards & Publications\" Page content in WCMS application-Set 5", groups = {""})
    public void verifyStandardsPublicationsPageContent() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);

            WCMSPage.NavigateToPage(jsonFileReader.getJsonString("Menu"), jsonFileReader.getJsonString("Submenu"), "Standards & Solutions");
            WCMSPage.NavigateToSubmenuList(jsonFileReader.getJsonString("SubmenuList"), "Standards & Publications");


            validateContentUnderStandardsPublicationsHeader("Standards & Publications");
            validateContentUnderASTMStandardsTrackerHeader("ASTM Standards Tracker");
            //validateContentUnderStandardsProductsHeader("Standards Products");
            validateContentUnderAdjunctsandReferenceRadiographsHeader("Adjuncts and Reference Radiographs");
            validateContentUnderResearchReportsHeader("Research Reports");
            validateContentUnderWhatyoullfindinanASTMResearchReportHeader("ASTM Research Report");
            validateContentUnderUOPStandardsHeader("UOP Standards");
            validateContentUnderPublicationsHeader("Publications");
            validateContentUnderStandardsReadingRoomHeader("Standards Reading Room");
            validateContentUnderASTMStandardsCOVID19Header("ASTM Standards & COVID-19");
            validateContentUnderSearchHeader("Search");
            validateContentUnderNeedorderingassistanceContactourCustomerSupportteamHeader("Need ordering assistance? Contact our Customer Support team.");


        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify \"Standards & Publications\" Page content in WCMS application-Set 5", e);
        }
        System.out.println("Successfully Verify \"Standards & Publications\" Page content in WCMS application-Set 5");
    }


    @Step("Validate Content under 'Standards & Publications' header")
    public void validateContentUnderStandardsPublicationsHeader(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header = WCMSPage.jsonValue(jsonObject, "Header");

            //Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(header)),WCMSPage.jsonValue(jsonObject,"Header"));


//            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderMainheader(header,
//                    WCMSPage.jsonValue(jsonObject,"Text1"))));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject, "text1")), WCMSPage.jsonValue(jsonObject, "Text1"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject, "text2")), WCMSPage.jsonValue(jsonObject, "Text2"));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderMainheader(header,
                    WCMSPage.jsonValue(jsonObject, "Button1"))));


        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Standards & Publications' header ", e);
        }
    }

    @Step("Validate Content under 'ASTM Standards Tracker' header")
    public void validateContentUnderASTMStandardsTrackerHeader(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header = WCMSPage.jsonValue(jsonObject, "Header");

            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject, "text1")), WCMSPage.jsonValue(jsonObject, "Text1"));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject, "Button1"))));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'ASTM Standards Tracker®' header ", e);
        }
    }

    @Step("Validate Content under 'Standards Products' header")
    public void validateContentUnderStandardsProductsHeader(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header = WCMSPage.jsonValue(jsonObject, "Header");

            String subheader1 = WCMSPage.jsonValue(jsonObject, "Subheader1");
            String subheader2 = WCMSPage.jsonValue(jsonObject, "Subheader2");
            String subheader3 = WCMSPage.jsonValue(jsonObject, "Subheader3");
            String subheader4 = WCMSPage.jsonValue(jsonObject, "Subheader4");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(subheader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(subheader2)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(subheader3)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(subheader4)));

            //Assert.assertEquals(WCMSPage.getTextByHeader(header, WCMSPage.jsonValue(jsonObject, "text")),
                    //WCMSPage.jsonValue(jsonObject, "Text"));

            Assert.assertEquals(WCMSPage.getTextByHeader(subheader1, WCMSPage.jsonValue(jsonObject, "text1")),
                    WCMSPage.jsonValue(jsonObject, "Text1"));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderSubheader(subheader1,
                    WCMSPage.jsonValue(jsonObject, "LinkText1"))));
            //Assert.assertEquals(WCMSPage.getTextByHeader(subheader2, WCMSPage.jsonValue(jsonObject, "text2")),
                    //WCMSPage.jsonValue(jsonObject, "Text2"));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderSubheader(subheader2,
                    WCMSPage.jsonValue(jsonObject, "LinkText2"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(subheader3, WCMSPage.jsonValue(jsonObject, "text3")),
                    WCMSPage.jsonValue(jsonObject, "Text3"));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderSubheader(subheader3,
                    WCMSPage.jsonValue(jsonObject, "LinkText3"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(subheader4, WCMSPage.jsonValue(jsonObject, "text4")),
                    WCMSPage.jsonValue(jsonObject, "Text4"));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderSubheader(subheader4,
                    WCMSPage.jsonValue(jsonObject, "LinkText4"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Standards Products' header ", e);
        }
    }

    @Step("Validate Content under 'Adjuncts and Reference Radiographs' header")
    public void validateContentUnderAdjunctsandReferenceRadiographsHeader(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header = WCMSPage.jsonValue(jsonObject, "Header");

            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject, "text1")), WCMSPage.jsonValue(jsonObject, "Text1"));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject, "Button1"))));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Adjuncts and Reference Radiographs' header ", e);
        }
    }

    @Step("Validate Content under 'Research Reports' header")
    public void validateContentUnderResearchReportsHeader(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header = WCMSPage.jsonValue(jsonObject, "Header");

            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject, "text1")), WCMSPage.jsonValue(jsonObject, "Text1"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Research Reports' header ", e);
        }
    }

    @Step("Validate Content under 'What youll find in an ASTM Research Report' header")
    public void validateContentUnderWhatyoullfindinanASTMResearchReportHeader(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header = WCMSPage.jsonValue(jsonObject, "Header");

            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject, "text1")), WCMSPage.jsonValue(jsonObject, "Text1"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject, "text2")), WCMSPage.jsonValue(jsonObject, "Text2"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject, "text3")), WCMSPage.jsonValue(jsonObject, "Text3"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject, "text4")), WCMSPage.jsonValue(jsonObject, "Text4"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject, "text5")), WCMSPage.jsonValue(jsonObject, "Text5"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject, "text6")), WCMSPage.jsonValue(jsonObject, "Text6"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject, "text7")), WCMSPage.jsonValue(jsonObject, "Text7"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'What youll find in an ASTM Research Report' header ", e);
        }
    }

    @Step("Validate Content under 'UOP Standards' header")
    public void validateContentUnderUOPStandardsHeader(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header = WCMSPage.jsonValue(jsonObject, "Header");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject, "Button1"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Research Reports' header ", e);
        }
    }

    @Step("Validate Content under 'Publications' header")
    public void validateContentUnderPublicationsHeader(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header = WCMSPage.jsonValue(jsonObject, "Header");

            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject, "text1")), WCMSPage.jsonValue(jsonObject, "Text1"));

            String subheader1 = WCMSPage.jsonValue(jsonObject, "Subheader1");
            String subheader2 = WCMSPage.jsonValue(jsonObject, "Subheader2");
            String subheader3 = WCMSPage.jsonValue(jsonObject, "Subheader3");
            String subheader4 = WCMSPage.jsonValue(jsonObject, "Subheader4");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(subheader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(subheader2)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(subheader3)));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getsubheader(subheader4)));

            Assert.assertEquals(WCMSPage.getTextByHeader(header, WCMSPage.jsonValue(jsonObject, "text1")),
                    WCMSPage.jsonValue(jsonObject, "Text1"));

            Assert.assertEquals(WCMSPage.getTextByHeader(subheader1, WCMSPage.jsonValue(jsonObject, "text2")),
                    WCMSPage.jsonValue(jsonObject, "Text2"));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderSubheader(subheader1,
                    WCMSPage.jsonValue(jsonObject, "LinkText1"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(subheader2, WCMSPage.jsonValue(jsonObject, "text3")),
                    WCMSPage.jsonValue(jsonObject, "Text3"));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderSubheader(subheader2,
                    WCMSPage.jsonValue(jsonObject, "LinkText2"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(subheader3, WCMSPage.jsonValue(jsonObject, "text4")),
                    WCMSPage.jsonValue(jsonObject, "Text4"));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderSubheader(subheader3,
                    WCMSPage.jsonValue(jsonObject, "LinkText3"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(subheader4, WCMSPage.jsonValue(jsonObject, "text5")),
                    WCMSPage.jsonValue(jsonObject, "Text5"));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderSubheader(subheader4,
                    WCMSPage.jsonValue(jsonObject, "LinkText4"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Publications' header ", e);
        }
    }

    @Step("Validate Content under 'Standards Reading Room' header")
    public void validateContentUnderStandardsReadingRoomHeader(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header = WCMSPage.jsonValue(jsonObject, "Header");

            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject, "text1")), WCMSPage.jsonValue(jsonObject, "Text1"));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject, "Button1"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Standards Reading Room' header ", e);
        }
    }

    @Step("Validate Content under 'ASTM Standards & COVID-19' header")
    public void validateContentUnderASTMStandardsCOVID19Header(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header = WCMSPage.jsonValue(jsonObject, "Header");

            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject, "text1")), WCMSPage.jsonValue(jsonObject, "Text1"));
            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject, "Button1"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'ASTM Standards & COVID-19' header ", e);
        }
    }

    @Step("Validate Content under 'Search' header")
    public void validateContentUnderSearchHeader(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header = WCMSPage.jsonValue(jsonObject, "Header");

            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject, "text1")), WCMSPage.jsonValue(jsonObject, "Text1"));


        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Search' header ", e);
        }
    }

    @Step("Validate Content under 'Need ordering assistance? Contact our Customer Support team.' header")
    public void validateContentUnderNeedorderingassistanceContactourCustomerSupportteamHeader(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header = WCMSPage.jsonValue(jsonObject, "Header");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject, "Button1"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Need ordering assistance? Contact our Customer Support team.' header ", e);
        }
    }
}






















