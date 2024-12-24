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

public class VerifyEnterpriseSolutions_StandardSolutionsInTheWCMSApplication_WCMSI_599 extends BaseTest {
    static final String jiraTestID = "WCMSI-599";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    SoftAssert softAssert;
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify Enterprise Solutions Page content in WCMS application-Set 6")
    @Test(description = jiraTestID
            + ":Verify Enterprise Solutions Page content in WCMS application-Set 6", groups = {""})
    public void VerifyEnterpriseSolutions_StandardSolutionsInTheWCMSApplication() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);
            WCMSPage.NavigateToPage(jsonFileReader.getJsonString("Menu"), jsonFileReader.getJsonString("Submenu"),"Standards & Solutions");
            WCMSPage.NavigateToSubmenuList(jsonFileReader.getJsonString("SubmenuList"),"Enterprise Solutions");
            validateContentUnderEnterpriseSolutionsHeader("Enterprise Solutions");
            validateContentUnderEnterpriseSolutions1Header("Enterprise Solutions1");
            validateContentUnderGetASTMAdvantageHeader("ASTM Advantage");
            validateContentUnderAlsoAvailableHeader("Also Available");

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify the Standards and Solutions page content in the WCMS application - Set 1", e);
        }
        System.out.println("Successfully Verify the Enterprise Solutions page content in the WCMS application - Set 1");
    }
    @Step("Validate Content under 'Enterprise Solutions' header")
    public void validateContentUnderEnterpriseSolutionsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            String subHeader=WCMSPage.jsonValue(jsonObject,"subHeader");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader)));

            Assert.assertEquals(WCMSPage.getTextByUnderMainHeader(header,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertEquals(WCMSPage.getTextByUnderMainHeader(header,WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));
            Assert.assertEquals(WCMSPage.getTextByUnderMainHeader(header,WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderMainheader(header,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderMainheader(header,
                    WCMSPage.jsonValue(jsonObject,"Button2"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'Enterprise SOlutions' header", e);
        }
    }

    @Step("Validate Content under 'Enterprise Solutions1' header")
    public void validateContentUnderEnterpriseSolutions1Header(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String subHeader1=WCMSPage.jsonValue(jsonObject,"subHeader1");
            String subHeader2=WCMSPage.jsonValue(jsonObject,"subHeader2");
            String subHeader3=WCMSPage.jsonValue(jsonObject,"subHeader3");
            String subHeader4=WCMSPage.jsonValue(jsonObject,"subHeader4");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader2)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader3)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader4)));

            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader1,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader2,WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader3,WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader4,WCMSPage.jsonValue(jsonObject,"text4")),
                    WCMSPage.jsonValue(jsonObject,"Text4"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subHeader1,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subHeader2,
                    WCMSPage.jsonValue(jsonObject,"Button2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subHeader3,
                    WCMSPage.jsonValue(jsonObject,"Button3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subHeader4,
                    WCMSPage.jsonValue(jsonObject,"Button4"))));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'Enterprise Solutions' header", e);
        }
    }
    @Step("Validate Content under 'Enterprise Solutions1' header")
    public void validateContentUnderGetASTMAdvantageHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            String subHeader=WCMSPage.jsonValue(jsonObject,"subHeader");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subHeader,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'Enterprise Solutions' header", e);
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

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader2)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader3)));

            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader1,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader2,WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader3,WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subHeader1,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subHeader2,
                    WCMSPage.jsonValue(jsonObject,"Button2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subHeader3,
                    WCMSPage.jsonValue(jsonObject,"Button3"))));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'Also Available' header", e);
        }
    }
}
