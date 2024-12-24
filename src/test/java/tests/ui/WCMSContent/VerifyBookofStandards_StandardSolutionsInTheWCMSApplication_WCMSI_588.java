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

public class VerifyBookofStandards_StandardSolutionsInTheWCMSApplication_WCMSI_588 extends BaseTest {
    static final String jiraTestID = "WCMSI-588";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    SoftAssert softAssert;
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify Standards and Solutions- Book of Standards content in the WCMS application - Set 5")
    @Test(description = jiraTestID
            + ":Verify Book of Standards  Page content in WCMS application-Set 5", groups = {""})
    public void VerifyBookofStandards_StandardSolutionsInTheWCMSApplication() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);
            WCMSPage.NavigateToPage(jsonFileReader.getJsonString("Menu"), jsonFileReader.getJsonString("Submenu"),"Standards & Solutions");
            WCMSPage.NavigateToSubmenuList(jsonFileReader.getJsonString("SubmenuList"),"Annual Book of ASTM Standards");
            validateContentUnderAnnualBookofASTMStandardsHeader("Book of Standards");
            validateContentUnderBenefitsHeader("Benefits");
            validateContentUnderEnterpriseSubscriptions("Enterprise Subscriptions");
            validateContentUnderBookofASTMStandards("ASTM Standard Section");
            validateContentUnderOrderingAssistanceHeader("Ordering Assistance");

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify the Standards and Solutions page content in the WCMS application - Set 1", e);
        }
        System.out.println("Successfully Verify the Standards and Solutions  page content in the WCMS application - Set 1");
    }
    @Step("Validate Content under 'Annual Book of ASTM Standards' header")
    public void validateContentUnderAnnualBookofASTMStandardsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(header)));

            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
//            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text2")),
//                    WCMSPage.jsonValue(jsonObject,"Text2"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'Annual Book of ASTM Standards' header ", e);
        }
    }
    @Step("Validate Content under 'Benefits of online standards volumes include' header")
    public void validateContentUnderBenefitsHeader(String jsonElement) {
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
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text4")),
                    WCMSPage.jsonValue(jsonObject,"Text4"));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text5")),
                    WCMSPage.jsonValue(jsonObject,"Text5"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'Benefits of online standards volumes include' header ", e);
        }
    }
    @Step("Validate Content under 'Enterprise Subscriptions' header")
    public void validateContentUnderEnterpriseSubscriptions(String jsonElement) {
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
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'Enterprise Subscriptions' header ", e);
        }
    }
    @Step("Validate Content under 'Book of ASTM Standards by Section' header")
    public void validateContentUnderBookofASTMStandards(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));

            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text1")),
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
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text16")),
                    WCMSPage.jsonValue(jsonObject,"Text16"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Validate Content under 'Book of ASTM Standards by Section' header ", e);
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
