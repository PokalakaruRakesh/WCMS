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

public class VerifyMultimediaServices_StandardSolutionsInTheWCMSApplication_WCMSI_603 extends BaseTest {
    static final String jiraTestID = "WCMSI-603";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    SoftAssert softAssert;
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify ASTM Multimedia Solutions Page content in WCMS application-Set 6")
    @Test(description = jiraTestID
            + ":Verify ASTM Multimedia Solutions Page content in WCMS application-Set 6", groups = {""})
    public void verifyMultimediaServices_StandardSolutionsInTheWCMSApplication() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);
            WCMSPage.NavigateToPage(jsonFileReader.getJsonString("Menu"), jsonFileReader.getJsonString("Submenu"),"Standards & Solutions");
            WCMSPage.NavigateToSubmenuList(jsonFileReader.getJsonString("SubmenuList"),"ASTM SpecBuilder");
            validateContentUnderASTMMultimediaSolutionsHeader("ASTM Multimedia Solutions");
            validateContentUnderCostEffectiveMediaHeader("CostEffective Media");
            validateContentUnderStreamlineTrainingHeader("Streamline Training");
            validateContentUnderRevolutionizeHeader("Revolutionize");
            validateContentUnderPromoteYourBrandHeader("Promote Your Brand");
            validateContentUnderCreateYourOwnHeader("Create Your Own");
            validateContentUnderContactHeader("Contact");
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify ASTM Multimedia Solutions Page content in WCMS application-Set 6", e);
        }
        System.out.println("Successfully Verify ASTM Multimedia Solutions Page content in WCMS application-Set 6");
    }
    @Step("Validate Content under 'ASTM Multimedia Solutions' header")
    public void validateContentUnderASTMMultimediaSolutionsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String mainHeader=WCMSPage.jsonValue(jsonObject,"MainHeader");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(mainHeader)));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderMainheader(mainHeader,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderMainheader(mainHeader,
                    WCMSPage.jsonValue(jsonObject,"Button2"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'ASTM Multimedia Solutions' header", e);
        }
    }
    @Step("Validate Content under 'CostEffective Media' header")
    public void validateContentUnderCostEffectiveMediaHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            String subHeader1=WCMSPage.jsonValue(jsonObject,"subHeader1");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader1)));

            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader1,WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader1, WCMSPage.jsonValue(jsonObject, "text4")),
                    WCMSPage.jsonValue(jsonObject, "Text4"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader1, WCMSPage.jsonValue(jsonObject, "text5")),
                    WCMSPage.jsonValue(jsonObject, "Text5"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader1, WCMSPage.jsonValue(jsonObject, "text6")),
                    WCMSPage.jsonValue(jsonObject, "Text6"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader1, WCMSPage.jsonValue(jsonObject, "text7")),
                    WCMSPage.jsonValue(jsonObject, "Text7"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader1, WCMSPage.jsonValue(jsonObject, "text8")),
                    WCMSPage.jsonValue(jsonObject, "Text8"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader1, WCMSPage.jsonValue(jsonObject, "text9")),
                    WCMSPage.jsonValue(jsonObject, "Text9"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader1, WCMSPage.jsonValue(jsonObject, "text10")),
                    WCMSPage.jsonValue(jsonObject, "Text10"));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subHeader1, WCMSPage.jsonValue(jsonObject, "text11")),
                    WCMSPage.jsonValue(jsonObject, "Text11"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'CostEffective Media' header", e);
        }
    }
    @Step("Validate Content under 'Streamline Training' header")
    public void validateContentUnderStreamlineTrainingHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header1=WCMSPage.jsonValue(jsonObject,"Header1");
            String header2=WCMSPage.jsonValue(jsonObject,"Header2");
            String subHeader1=WCMSPage.jsonValue(jsonObject,"subHeader1");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header1)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header2)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader1)));

            Assert.assertEquals(WCMSPage.getTextByHeader(header1,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'Streamline Training' header", e);
        }
    }
    @Step("Validate Content under 'Revolutionize' header")
    public void validateContentUnderRevolutionizeHeader(String jsonElement) {
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
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'Revolutionize' header", e);
        }
    }

    @Step("Validate Content under 'Promote Your Brand' header")
    public void validateContentUnderPromoteYourBrandHeader(String jsonElement) {
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
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject, "text4")),
                    WCMSPage.jsonValue(jsonObject, "Text4"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject, "text5")),
                    WCMSPage.jsonValue(jsonObject, "Text5"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject, "text6")),
                    WCMSPage.jsonValue(jsonObject, "Text6"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject, "text7")),
                    WCMSPage.jsonValue(jsonObject, "Text7"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'Promote Your Brand' header", e);
        }
    }

    @Step("Validate Content under 'Create Your Own' header")
    public void validateContentUnderCreateYourOwnHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'Create Your Own' header", e);
        }
    }
    @Step("Validate Content under 'Contact' header")
    public void validateContentUnderContactHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            String subHeader=WCMSPage.jsonValue(jsonObject,"subHeader");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subHeader)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'Contact' header", e);
        }
    }

}
