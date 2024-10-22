package tests.ui.WCMSContent;

import base.utils.ConfigReader;
import base.utils.JsonFileReader;
import com.astm.commonFunctions.Common;
import com.astm.commonFunctions.WCMSICommon;
import com.google.gson.JsonObject;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ui.WCMSContentPage;
import pages.ui.WCMSContentPage;
import tests.ui.base.BaseTest;

public class VerifyAboutASTMPageContentInTheWCMSApplication_WCMSI_465 extends BaseTest {
    static final String jiraTestID = "WCMSI-465";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    SoftAssert softAssert;
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify the About ASTM page content in the WCMS application - Set 1")
    @Test(description = jiraTestID
            + ": Verify the About ASTM page content in the WCMS application - Set 1", groups = {""})
    public void verifyAboutASTMPageContentInTheWCMSApplication() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);
            softAssert = new SoftAssert();

            WCMSPage.NavigateToPage(jsonFileReader.getJsonString("Menu"), jsonFileReader.getJsonString("Submenu"));
            validateContentUnderAboutASTMHeader("AboutASTM");
            validateContentUnderHistoryHeader("History");
            validateContentUnderGovernanceHeader("Governance");
            validateContentUnderGlobalCooperationHeader("GlobalCooperation");
            validateContentUnderDiversityEquityInclusionAndBelongingHeader("DiversityEquityInclusionBelonging");
            validateContentUnderCultureAndCareersHeader("CultureandCareers");
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify the About ASTM page content in the WCMS application - Set 1", e);
        }
        System.out.println("Successfully Verify the About ASTM  page content in the WCMS application - Set 1");
    }


    @Step("Validate Content under 'About ASTM' header")
    public void validateContentUnderAboutASTMHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(header)),WCMSPage.jsonValue(jsonObject,"Header") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderMainheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text1"))),WCMSPage.jsonValue(jsonObject,"Text1") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderMainheader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader1"))),WCMSPage.jsonValue(jsonObject,"Subheader1") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader2"))),WCMSPage.jsonValue(jsonObject,"Subheader2") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text2"))));

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderMainheader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader3"))),WCMSPage.jsonValue(jsonObject,"Subheader3") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader4"))),WCMSPage.jsonValue(jsonObject,"Subheader4") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text3"))),WCMSPage.jsonValue(jsonObject,"Text3") + "content not matched");


            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderMainheader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader5"))),WCMSPage.jsonValue(jsonObject,"Subheader5") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeaderUnderMainheader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader6"))),WCMSPage.jsonValue(jsonObject,"Subheader6") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text4"))),WCMSPage.jsonValue(jsonObject,"Text4") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderMainheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text5"))),WCMSPage.jsonValue(jsonObject,"Text5") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderMainheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text6"))),WCMSPage.jsonValue(jsonObject,"Text6") + "content not matched");
            softAssert.assertAll();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'About ASTM' header ", e);
        }
    }
    @Step("Validate content under 'History' header")
    public void validateContentUnderHistoryHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)),WCMSPage.jsonValue(jsonObject,"Header") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getImageTextUnderHeader(
                    WCMSPage.jsonValue(jsonObject,"ImageName1"),
                    WCMSPage.jsonValue(jsonObject,"ImageYear1"))),WCMSPage.jsonValue(jsonObject,"ImageYear1") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getImageTextUnderHeader(WCMSPage.jsonValue(jsonObject,"ImageName2"),
                    WCMSPage.jsonValue(jsonObject,"ImageYear2"))),WCMSPage.jsonValue(jsonObject,"ImageYear2") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getImageTextUnderHeader(WCMSPage.jsonValue(jsonObject,"ImageName3"),
                    WCMSPage.jsonValue(jsonObject,"ImageYear3"))),WCMSPage.jsonValue(jsonObject,"ImageYear3") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getImageTextUnderHeader(WCMSPage.jsonValue(jsonObject,"ImageName4"),
                    WCMSPage.jsonValue(jsonObject,"ImageYear4"))),WCMSPage.jsonValue(jsonObject,"ImageYear4") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"LinkText"))),WCMSPage.jsonValue(jsonObject,"LinkText") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text1"))),WCMSPage.jsonValue(jsonObject,"Text1") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button1"))),WCMSPage.jsonValue(jsonObject,"Button1") + "content not matched");
            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'History' header ", e);
        }
    }
    @Step("Validate content under 'Governance' header")
    public void validateContentUnderGovernanceHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)),WCMSPage.jsonValue(jsonObject,"Header") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                   WCMSPage.jsonValue(jsonObject,"Subheader1"))),WCMSPage.jsonValue(jsonObject,"Subheader1") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text1"))),WCMSPage.jsonValue(jsonObject,"Text1") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"LinkText1"))),WCMSPage.jsonValue(jsonObject,"LinkText1") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                  WCMSPage.jsonValue(jsonObject,"Subheader2"))),WCMSPage.jsonValue(jsonObject,"Subheader2") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text2"))),WCMSPage.jsonValue(jsonObject,"Text2") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderSubheader(header,
                  WCMSPage.jsonValue(jsonObject,"LinkText2"))),WCMSPage.jsonValue(jsonObject,"LinkText2") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader3"))),WCMSPage.jsonValue(jsonObject,"Subheader3") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text3"))),WCMSPage.jsonValue(jsonObject,"Text3") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"LinkText3"))),WCMSPage.jsonValue(jsonObject,"LinkText3") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text4"))),WCMSPage.jsonValue(jsonObject,"Text4") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button1"))),WCMSPage.jsonValue(jsonObject,"Button1") + "content not matched");
            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Governance' header ", e);
        }
    }
    @Step("Validate content under 'Global Cooperation' header")
    public void validateContentUnderGlobalCooperationHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)),WCMSPage.jsonValue(jsonObject,"Header") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                   WCMSPage.jsonValue(jsonObject,"Subheader1"))),WCMSPage.jsonValue(jsonObject,"Subheader1") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                   WCMSPage.jsonValue(jsonObject,"Text1"))),WCMSPage.jsonValue(jsonObject,"Text1") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"LinkText1"))),WCMSPage.jsonValue(jsonObject,"LinkText1") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader2"))),WCMSPage.jsonValue(jsonObject,"Subheader2") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"Text2"))),WCMSPage.jsonValue(jsonObject,"Text2") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"LinkText2"))),WCMSPage.jsonValue(jsonObject,"LinkText2") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader3"))),WCMSPage.jsonValue(jsonObject,"Subheader3") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(header,
                   WCMSPage.jsonValue(jsonObject,"Text3"))),WCMSPage.jsonValue(jsonObject,"Text3") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderSubheader(header,
                    WCMSPage.jsonValue(jsonObject,"LinkText3"))),WCMSPage.jsonValue(jsonObject,"LinkText3") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button1"))),WCMSPage.jsonValue(jsonObject,"Button1") + "content not matched");
            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Global Cooperation' header ", e);
        }
    }
    @Step("Validate content under 'Diversity, Equity, Inclusion and Belonging' header")
    public void validateContentUnderDiversityEquityInclusionAndBelongingHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)),WCMSPage.jsonValue(jsonObject,"Header") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text1"))),WCMSPage.jsonValue(jsonObject,"Text1") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button1"))),WCMSPage.jsonValue(jsonObject,"Button1") + "content not matched");
            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Diversity, Equity, Inclusion and Belonging' header ", e);
        }
    }
    @Step("Validate content under 'Culture and Careers ' header")
    public void validateContentUnderCultureAndCareersHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)),WCMSPage.jsonValue(jsonObject,"Header") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text1"))),WCMSPage.jsonValue(jsonObject,"Text1") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                   WCMSPage.jsonValue(jsonObject,"Button1"))),WCMSPage.jsonValue(jsonObject,"Button1") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                   WCMSPage.jsonValue(jsonObject,"Button2"))),WCMSPage.jsonValue(jsonObject,"Button2") + "content not matched");
            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Culture and Careers' header ", e);
        }
    }

}
