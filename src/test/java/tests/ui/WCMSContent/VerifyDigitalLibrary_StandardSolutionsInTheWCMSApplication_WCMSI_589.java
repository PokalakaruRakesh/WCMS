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

public class VerifyDigitalLibrary_StandardSolutionsInTheWCMSApplication_WCMSI_589 extends BaseTest {
    static final String jiraTestID = "WCMSI-589";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    SoftAssert softAssert;
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify Digital Library Page content in WCMS application-Set 5")
    @Test(description = jiraTestID
            + ":Verify Digital Library Page content in WCMS application-Set 5", groups = {""})
    public void VerifyDigitalLibrary_StandardSolutionsInTheWCMSApplication() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);
            WCMSPage.NavigateToPage(jsonFileReader.getJsonString("Menu"), jsonFileReader.getJsonString("Submenu"),"Standards & Solutions");
            WCMSPage.NavigateToSubmenuList(jsonFileReader.getJsonString("SubmenuList"),"Digital Library");
            validateContentUnderASTMDigitalLibraryHeader("Digital Library");
            validateContentUnderDigitalLibraryNumbersHeader("Digital Library by the Numbers");
            validateContentUnderContentOverviewHeader("Content Overview");
            validateContentUnderCoverageAreasHeader("Coverage Areas");
            validateContentUnderAuthorsHeader("Authors");
            validateContentUnderASTMCompass("ASTM Compass");
            validateContentUnderOrderingAssistanceHeader("Ordering Assistance");
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify the Standards and Solutions page content in the WCMS application - Set 1", e);
        }
        System.out.println("Successfully Verify the Standards and Solutions  page content in the WCMS application - Set 1");
    }

    @Step("Validate Content under 'ASTM Digital Library' header")
    public void validateContentUnderASTMDigitalLibraryHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(header)));

            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'ASTM Digital Library' header ", e);
        }
    }

    @Step("Validate Content under 'Digital Library Numbers' header")
    public void validateContentUnderDigitalLibraryNumbersHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String mainHeader1=WCMSPage.jsonValue(jsonObject,"MainHeader1");
            String mainHeader2=WCMSPage.jsonValue(jsonObject,"MainHeader2");
            String mainHeader3=WCMSPage.jsonValue(jsonObject,"MainHeader3");
            String mainHeader4=WCMSPage.jsonValue(jsonObject,"MainHeader4");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(mainHeader1)));
            Assert.assertEquals(WCMSPage.getTextByUnderMainHeader(mainHeader1,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertEquals(WCMSPage.getTextByUnderMainHeader(mainHeader2,WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));
            Assert.assertEquals(WCMSPage.getTextByUnderMainHeader(mainHeader3,WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));
            Assert.assertEquals(WCMSPage.getTextByUnderMainHeader(mainHeader4,WCMSPage.jsonValue(jsonObject,"text4")),
                    WCMSPage.jsonValue(jsonObject,"Text4"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'Digital Library Numbers' header ", e);
        }
    }
    @Step("Validate Content under 'Content Overview' header")
    public void validateContentUnderContentOverviewHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            String subHeader1=WCMSPage.jsonValue(jsonObject,"subHeader1");
            String subHeader2=WCMSPage.jsonValue(jsonObject,"subHeader2");
            String subHeader3=WCMSPage.jsonValue(jsonObject,"subHeader3");
            String subHeader4=WCMSPage.jsonValue(jsonObject,"subHeader4");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader2)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader3)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader4)));

            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subHeader1,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subHeader2,
                    WCMSPage.jsonValue(jsonObject,"Button2"))));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subHeader3,
                    WCMSPage.jsonValue(jsonObject,"Button3"))));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text4")),
                    WCMSPage.jsonValue(jsonObject,"Text4"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subHeader4,
                    WCMSPage.jsonValue(jsonObject,"Button4"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'Content Overview' header ", e);
        }
    }

    @Step("Validate Content under 'Coverage Areas' header")
    public void validateContentUnderCoverageAreasHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            String subHeader=WCMSPage.jsonValue(jsonObject,"subHeader");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader)));

            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text4")),
                    WCMSPage.jsonValue(jsonObject,"Text4"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text5")),
                    WCMSPage.jsonValue(jsonObject,"Text5"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text6")),
                    WCMSPage.jsonValue(jsonObject,"Text6"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text7")),
                    WCMSPage.jsonValue(jsonObject,"Text7"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text8")),
                    WCMSPage.jsonValue(jsonObject,"Text8"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text9")),
                    WCMSPage.jsonValue(jsonObject,"Text9"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text10")),
                    WCMSPage.jsonValue(jsonObject,"Text10"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text11")),
                    WCMSPage.jsonValue(jsonObject,"Text11"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text12")),
                    WCMSPage.jsonValue(jsonObject,"Text12"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text13")),
                    WCMSPage.jsonValue(jsonObject,"Text13"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text14")),
                    WCMSPage.jsonValue(jsonObject,"Text14"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text15")),
                    WCMSPage.jsonValue(jsonObject,"Text15"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'Coverage Areas' header ", e);
        }
    }

    @Step("Validate Content under 'Authors' header")
    public void validateContentUnderAuthorsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            String subHeader=WCMSPage.jsonValue(jsonObject,"subHeader");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader)));

            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text4")),
                    WCMSPage.jsonValue(jsonObject,"Text4"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text5")),
                    WCMSPage.jsonValue(jsonObject,"Text5"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text6")),
                    WCMSPage.jsonValue(jsonObject,"Text6"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'Authors' header ", e);
        }
    }
    @Step("Validate Content under 'ASTM Compass' header")
    public void validateContentUnderASTMCompass(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));

            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'ASTM Compass' header ", e);
        }
    }
    @Step("Validate Content under 'Ordering Assistance' header")
    public void validateContentUnderOrderingAssistanceHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'Ordering Assistance' header ", e);
        }
    }
}
