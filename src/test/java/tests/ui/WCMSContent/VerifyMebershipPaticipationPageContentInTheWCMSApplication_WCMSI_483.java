package tests.ui.WCMSContent;

import base.utils.ConfigReader;
import base.utils.JsonFileReader;
import com.astm.commonFunctions.Common;
import com.astm.commonFunctions.WCMSICommon;
import com.astm.commonFunctions.WCMSICommon;
import com.google.gson.JsonObject;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ui.WCMSContentPage;
import pages.ui.WCMSContentPage;
import tests.ui.base.BaseTest;

public class VerifyMebershipPaticipationPageContentInTheWCMSApplication_WCMSI_483 extends BaseTest {
    static final String jiraTestID = "WCMSI-483";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    SoftAssert softAssert;
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify the Mebership & Paticipation page content in the WCMS application - Set 1")
    @Test(description = jiraTestID
            + ": Verify the Mebership & Paticipation page content in the WCMS application - Set 1", groups = {""})
    public void verifyMebershipPaticipationPageContentInTheWCMSApplication() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);


            WCMSPage.NavigateToPage(jsonFileReader.getJsonString("Menu"), jsonFileReader.getJsonString("Submenu"),"Membership & Participation");
            validateContentUnderMembershipParticipationHeader("MembershipParticipation");
            validateContentUnderMembershipHeader("Membership");
            validateContentUnderBenefitsHeader("Benefits");
            validateContentUnderMyCommitteesASTMCompassHeader("MyCommitteesASTMCompass");
            validateContentUnderGetPublishedHeader("GetPublished");
            validateContentUnderTechnicalCommitteesHeader("TechnicalCommittees");
            validateContentUnderMeetingsSymposiaWorkshopsHeader("MeetingsSymposiaWorkshops");
            validateContentUnderMemberOfficerTrainingHeader("MemberOfficerTraining");
            validateContentUnderStudentsHeader("Students");
            validateContentUnderConsumerParticipationHeader("ConsumerParticipation");
            //validateContentUnderLatestNewsHeader("LatestNews");

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify the Mebership & Paticipation page content in the WCMS application - Set 1", e);
        }
        System.out.println("Successfully Verify the Mebership & Paticipation page content in the WCMS application - Set 1");
    }


    @Step("Validate Content under 'Membership & Participation' header")
    public void validateContentUnderMembershipParticipationHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(header)));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderMainheader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader2"),
                    WCMSPage.jsonValue(jsonObject,"Text2_1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader2"),
                    WCMSPage.jsonValue(jsonObject,"Text2_2"))));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderMainheader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader4"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader4"),
                    WCMSPage.jsonValue(jsonObject,"Text3_1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader4"),
                    WCMSPage.jsonValue(jsonObject,"Text3_2"))));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderMainheader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader5"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader6"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader6"),
                    WCMSPage.jsonValue(jsonObject,"Text4"))));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderMainheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text5"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderMainheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text6"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Membership & Participation' header ", e);
        }
    }
    @Step("Validate content under 'Membership' header")
    public void validateContentUnderMembershipHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text3"))));

            String Subheader1=WCMSPage.jsonValue(jsonObject,"Subheader1");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader1,
                    WCMSPage.jsonValue(jsonObject,"Price1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader1,
                    WCMSPage.jsonValue(jsonObject,"Text4"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader1,
                    WCMSPage.jsonValue(jsonObject,"Text5"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderSubheader(Subheader1,
                    WCMSPage.jsonValue(jsonObject,"Subheader2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader1,
                    WCMSPage.jsonValue(jsonObject,"Text6"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader1,
                    WCMSPage.jsonValue(jsonObject,"Text7"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader1,
                    WCMSPage.jsonValue(jsonObject,"Text8"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader1,
                    WCMSPage.jsonValue(jsonObject,"Text9"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderSubheader1(Subheader1,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));

            String Subheader3=WCMSPage.jsonValue(jsonObject,"Subheader3");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader3,
                    WCMSPage.jsonValue(jsonObject,"Price2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader3,
                    WCMSPage.jsonValue(jsonObject,"Text10"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader3,
                    WCMSPage.jsonValue(jsonObject,"Text11"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderSubheader(Subheader3,
                    WCMSPage.jsonValue(jsonObject,"Subheader4"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader3,
                    WCMSPage.jsonValue(jsonObject,"Text12"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader3,
                    WCMSPage.jsonValue(jsonObject,"Text13"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader3,
                    WCMSPage.jsonValue(jsonObject,"Text14"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader3,
                    WCMSPage.jsonValue(jsonObject,"Text15"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderSubheader1(Subheader3,
                    WCMSPage.jsonValue(jsonObject,"Button2"))));

            String Subheader5=WCMSPage.jsonValue(jsonObject,"Subheader5");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader5"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader5,
                    WCMSPage.jsonValue(jsonObject,"Price3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader5,
                    WCMSPage.jsonValue(jsonObject,"Text16"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader5,
                    WCMSPage.jsonValue(jsonObject,"Text17"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderSubheader(Subheader5,
                    WCMSPage.jsonValue(jsonObject,"Subheader6"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader5,
                    WCMSPage.jsonValue(jsonObject,"Text18"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader5,
                    WCMSPage.jsonValue(jsonObject,"Text19"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderSubheader1(Subheader5,
                    WCMSPage.jsonValue(jsonObject,"Button3"))));

            String Subheader7=WCMSPage.jsonValue(jsonObject,"Subheader7");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader7"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader7,
                    WCMSPage.jsonValue(jsonObject,"Text20"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader7,
                    WCMSPage.jsonValue(jsonObject,"Text21_1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader7,
                    WCMSPage.jsonValue(jsonObject,"Text21_2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderSubheader(Subheader7,
                    WCMSPage.jsonValue(jsonObject,"Subheader8"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader7,
                    WCMSPage.jsonValue(jsonObject,"Text22"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader7,
                    WCMSPage.jsonValue(jsonObject,"Text23"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(Subheader7,
                    WCMSPage.jsonValue(jsonObject,"Text24"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderSubheader1(Subheader7,
                    WCMSPage.jsonValue(jsonObject,"Button4"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Membership' header ", e);
        }
    }
    @Step("Validate content under 'Benefits' header")
    public void validateContentUnderBenefitsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader1"),
                    WCMSPage.jsonValue(jsonObject,"Text1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader1"),
                    WCMSPage.jsonValue(jsonObject,"LinkText1"))));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader2"),
                    WCMSPage.jsonValue(jsonObject,"Text2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader2"),
                    WCMSPage.jsonValue(jsonObject,"LinkText2"))));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader3"),
                    WCMSPage.jsonValue(jsonObject,"Text3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader3"),
                    WCMSPage.jsonValue(jsonObject,"LinkText3"))));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Benefits' header ", e);
        }
    }
    @Step("Validate content under 'My Committees & ASTM Compass' header")
    public void validateContentUnderMyCommitteesASTMCompassHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader1"),
                    WCMSPage.jsonValue(jsonObject,"Text1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader1"),
                    WCMSPage.jsonValue(jsonObject,"LinkText1"))));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader2"),
                    WCMSPage.jsonValue(jsonObject,"Text2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader2"),
                    WCMSPage.jsonValue(jsonObject,"LinkText2"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'My Committees & ASTM Compass' header ", e);
        }
    }
    @Step("Validate content under 'Get Published ' header")
    public void validateContentUnderGetPublishedHeader(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header = WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));

            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Get Published ' header ", e);
        }
    }
    @Step("Validate content under 'Technical Committees' header")
    public void validateContentUnderTechnicalCommitteesHeader (String jsonElement){
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header = WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader1"),
                    WCMSPage.jsonValue(jsonObject,"Text1"))));

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Technical Committees' header ", e);
        }
    }
    @Step("Validate content under 'Meetings, Symposia & Workshops' header")
    public void validateContentUnderMeetingsSymposiaWorkshopsHeader (String jsonElement){
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header = WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader1"),
                    WCMSPage.jsonValue(jsonObject,"Text1"))));

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Meetings, Symposia & Workshops' header ", e);
        }
    }
    @Step("Validate content under 'Member & Officer Training' header")
    public void validateContentUnderMemberOfficerTrainingHeader (String jsonElement){
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header = WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader1"),
                    WCMSPage.jsonValue(jsonObject,"Text1"))));

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Member & Officer Training' header ", e);
        }
    }
    @Step("Validate content under 'Students' header")
    public void validateContentUnderStudentsHeader (String jsonElement){
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header = WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader1"),
                    WCMSPage.jsonValue(jsonObject,"Text1"))));

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Students' header ", e);
        }
    }
    @Step("Validate content under 'Consumer Participation' header")
    public void validateContentUnderConsumerParticipationHeader (String jsonElement){
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header = WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader1"),
                    WCMSPage.jsonValue(jsonObject,"Text1"))));

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Consumer Participation' header ", e);
        }
    }
    @Step("Validate content under 'Latest News' header")
    public void validateContentUnderLatestNewsHeader (String jsonElement){
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header = WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)));

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text4"))));
            /*Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getButtonUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));*/

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text5"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text6"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text7"))));
            /*Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Button2"))));*/

            //Latest News needs to be add

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Latest News' header ", e);
        }
    }
}
