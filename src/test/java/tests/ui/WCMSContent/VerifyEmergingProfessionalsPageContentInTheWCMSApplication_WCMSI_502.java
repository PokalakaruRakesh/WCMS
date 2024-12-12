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

public class VerifyEmergingProfessionalsPageContentInTheWCMSApplication_WCMSI_502 extends BaseTest {
    static final String jiraTestID = "WCMSI-502";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
       driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify the Emerging Professionals page content in the WCMS application - Set 2")
    @Test(description = jiraTestID
            + ": Verify the Emerging Professionals page content in the WCMS application - Set 2", groups = {""})
    public void verifyEmergingProfessionalsPageContent() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);

            WCMSPage.NavigateToPage(jsonFileReader.getJsonString("Menu"),jsonFileReader.getJsonString("Submenu"),"Membership & Participation Overview");
            WCMSPage.NavigateToSubmenuList(jsonFileReader.getJsonString("SubmenuList"),"Emerging Professionals Program");
            validateContentUnderEmergingProfessionalsProgramHeader("EmergingProfessionalsProgram");
            validateContentUnderEmpoweringTomorrowStandardsLeadersHeader("EmpoweringTomorrowStandardsLeaders");
            validateContentUnderCriteriaHeader("Criteria");
            validateContentUnderWorkshopSpeakersHeader("WorkshopSpeakers");
            validateContentUnderWorkshopDates2025Header("WorkshopDates2025");
            validateContentUnderTestimonialsHeader("Testimonials");
            validateContentUnderQuestionsHeader("Questions");
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify the 'Emerging Professionals' content in the WCMS application - Set 2", e);
        }
        System.out.println("Successfully Verify the 'Emerging Professionals' content in the WCMS application - Set 2");
    }


    @Step("Validate Content under 'EmergingProfessionalsProgram' header")
    public void validateContentUnderEmergingProfessionalsProgramHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(WCMSPage.jsonValue(jsonObject,"Mainheader"))));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Emerging Professionals Program' header ", e);
        }
    }
    @Step("Validate Content under 'Empowering Tomorrow's Standards Leaders' header")
    public void validateContentUnderEmpoweringTomorrowStandardsLeadersHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"header");

            //Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"header")),
                    //WCMSPage.jsonValue(jsonObject,"Header"));
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
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text6")),
                    WCMSPage.jsonValue(jsonObject,"Text6"));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text7")),
                    WCMSPage.jsonValue(jsonObject,"Text7"));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text8")),
                    WCMSPage.jsonValue(jsonObject,"Text8"));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text9")),
                    WCMSPage.jsonValue(jsonObject,"Text9"));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text10")),
                    WCMSPage.jsonValue(jsonObject,"Text10"));
            /*Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text11")),
                    WCMSPage.jsonValue(jsonObject,"Text11"));*/
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text12")),
                    WCMSPage.jsonValue(jsonObject,"Text12"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Empowering Tomorrow's Standards Leaders' header ", e);
        }
    }
    @Step("Validate Content under 'Criteria' header")
    public void validateContentUnderCriteriaHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text")),
                    WCMSPage.jsonValue(jsonObject,"Text"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"SubHeader1"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(WCMSPage.jsonValue(jsonObject,"SubHeader1"),WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"SubHeader2"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(WCMSPage.jsonValue(jsonObject,"SubHeader2"),WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"SubHeader3"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(WCMSPage.jsonValue(jsonObject,"SubHeader3"),WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"SubHeader4"))));
            Assert.assertTrue(WCMSPage.getTextByHeader(WCMSPage.jsonValue(jsonObject,"SubHeader4"),WCMSPage.jsonValue(jsonObject,"text4")).contains(
                    WCMSPage.jsonValue(jsonObject,"Text4")));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text5"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Criteria' header ", e);
        }
    }
    @Step("Validate Content under 'Workshop Speakers' header")
    public void validateContentUnderWorkshopSpeakersHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text")),
                    WCMSPage.jsonValue(jsonObject,"Text"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"SubHeader"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Workshop Speakers' header ", e);
        }
    }
    @Step("Validate Content under 'Workshop Dates 2025' header")
    public void validateContentUnderWorkshopDates2025Header(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header"))));
            String txt=WCMSPage.jsonValue(jsonObject,"Text1")+WCMSPage.jsonValue(jsonObject,"Text2")+WCMSPage.jsonValue(jsonObject,"Text3")
                    +WCMSPage.jsonValue(jsonObject,"Text4");
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text1")),txt);
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Workshop Dates 2025' header ", e);
        }
    }
    @Step("Validate Content under 'Testimonials' header")
    public void validateContentUnderTestimonialsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header"))));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader1"),
                    WCMSPage.jsonValue(jsonObject,"Text1"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(WCMSPage.jsonValue(jsonObject,"Subheader1"),WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader2"),
                    WCMSPage.jsonValue(jsonObject,"Text3"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(WCMSPage.jsonValue(jsonObject,"Subheader2"),WCMSPage.jsonValue(jsonObject,"text4")),
                    WCMSPage.jsonValue(jsonObject,"Text4"));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader3"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader3"),
                    WCMSPage.jsonValue(jsonObject,"Text5"))));
            Assert.assertEquals(WCMSPage.getTextByHeader(WCMSPage.jsonValue(jsonObject,"Subheader3"),WCMSPage.jsonValue(jsonObject,"text6")),
                    WCMSPage.jsonValue(jsonObject,"Text6"));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Testimonials' header ", e);
        }
    }
    @Step("Validate Content under 'Questions' header")
    public void validateContentUnderQuestionsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header"))));
            Assert.assertEquals(WCMSPage.getText1(WCMSPage.jsonValue(jsonObject,"text")),WCMSPage.jsonValue(jsonObject,"Text"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Questions' header ", e);
        }
    }
}
