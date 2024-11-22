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

public class VerifyConsumerParticipationPageContentInTheWCMSApplication_WCMSI_506 extends BaseTest {
    static final String jiraTestID = "WCMSI-506";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    CookiePage cookiePage;
    
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify the Consumer Participation content in the WCMS application - Set 2")
    @Test(description = jiraTestID
            + ": Verify the Consumer Participation content in the WCMS application - Set 2", groups = {""})
    public void verifyConsumerParticipationPageContent() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            cookiePage=page.getInstance(CookiePage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);

            WCMSPage.NavigateToPage(jsonFileReader.getJsonString("Menu"),jsonFileReader.getJsonString("Submenu"),"Membership & Participation");
            WCMSPage.NavigateToSubmenuList(jsonFileReader.getJsonString("SubmenuList"),"Consumers and ASTM International");
            validateConsumersaAndASTMInternationalHeader("ConsumersandASTMInternational");
            validateContentUnderStandardsHelpOurWorldWorkBetterHeader("StandardsHelpOurWorldWorkBetter");
            validateContentUnderWhyConsumerVoiceMattersHeader("WhyConsumerVoiceMatters");
            validateContentUnderLearnHowYouGetInvolvedHeader("SettingASTMStandards");
            validateContentUnderGetInvolvedMakeDifferenceHeader("GetInvolvedMakeDifference");
            validateContentUnderClientTestimonialsHeader("ClientTestimonials");
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify the 'Consumer Participation' content in the WCMS application - Set 2", e);
        }
        System.out.println("Successfully Verify the 'Consumer Participation' content in the WCMS application - Set 2");
    }


    @Step("Validate Content under 'Consumers and ASTM International' header")
    public void validateConsumersaAndASTMInternationalHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(WCMSPage.jsonValue(jsonObject,"Mainheader"))));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Consumers and ASTM International' header ", e);
        }
    }
    @Step("Validate Content under 'Standards help our world work better' header")
    public void validateContentUnderStandardsHelpOurWorldWorkBetterHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header"))));
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
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text5")),
                    WCMSPage.jsonValue(jsonObject,"Text5"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'The winners were as follows' header ", e);
        }
    }
    @Step("Validate Content under 'Why the Consumer Voice Matters' header")
    public void validateContentUnderWhyConsumerVoiceMattersHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header1");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header2"))));

            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text1_1")),
                    WCMSPage.jsonValue(jsonObject,"Text1_1"));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text1_2")),
                    WCMSPage.jsonValue(jsonObject,"Text1_2"));
            /*Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));*/
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text4")),
                    WCMSPage.jsonValue(jsonObject,"Text4"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button"))));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Why the Consumer Voice Matters' header ", e);
        }
    }
    @Step("Validate Content under 'Learn how you can get involved in setting ASTM standards' header")
    public void validateContentUnderLearnHowYouGetInvolvedHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));

            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text3_1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text3_2"))));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Learn how you can get involved in setting ASTM standards' header ", e);
        }
    }
    @Step("Validate Content under 'Get involved. Make a difference' header")
    public void validateContentUnderGetInvolvedMakeDifferenceHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));

            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text4"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text5")),
                    WCMSPage.jsonValue(jsonObject,"Text5_1"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text5_2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text5_3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button"))));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Get involved. Make a difference' header ", e);
        }
    }
    @Step("Validate Content under 'Client Testimonials' header")
    public void validateContentUnderClientTestimonialsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"SubHeader1"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(WCMSPage.jsonValue(jsonObject,"SubHeader1"),WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertEquals(WCMSPage.getTextByHeader(WCMSPage.jsonValue(jsonObject,"SubHeader1"),WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"SubHeader2"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(WCMSPage.jsonValue(jsonObject,"SubHeader2"),WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));
            Assert.assertEquals(WCMSPage.getTextByHeader(WCMSPage.jsonValue(jsonObject,"SubHeader2"),WCMSPage.jsonValue(jsonObject,"text4")),
                    WCMSPage.jsonValue(jsonObject,"Text4"));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"SubHeader3"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(WCMSPage.jsonValue(jsonObject,"SubHeader3"),WCMSPage.jsonValue(jsonObject,"text5")),
                    WCMSPage.jsonValue(jsonObject,"Text5"));
            Assert.assertEquals(WCMSPage.getTextByHeader(WCMSPage.jsonValue(jsonObject,"SubHeader3"),WCMSPage.jsonValue(jsonObject,"text6")),
                    WCMSPage.jsonValue(jsonObject,"Text6"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Client Testimonials' header ", e);
        }
    }
}
