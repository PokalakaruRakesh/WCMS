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
import tests.ui.base.BaseTest;

public class VerifyHelpContentInTheWCMSApplication_WCMSI_485 extends BaseTest {
    static final String jiraTestID = "WCMSI-485";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    SoftAssert softAssert;
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify the Help content in the WCMS application - Set 1")
    @Test(description = jiraTestID
            + ": Verify the Help content in the WCMS application - Set 1", groups = {""})
    public void verifyHelpContentInTheWCMSApplication() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);
            softAssert = new SoftAssert();

            WCMSPage.NavigateToPage(jsonFileReader.getJsonString("Menu"), jsonFileReader.getJsonString("Submenu"));
            validateContentUnderAboutASTMHeader("AboutASTM");
            /*validateContentUnderHistoryHeader("History");
            validateContentUnderGovernanceHeader("Governance");
            validateContentUnderGlobalCooperationHeader("GlobalCooperation");
            validateContentUnderDiversityEquityInclusionAndBelongingHeader("DiversityEquityInclusionBelonging");*/
            /*validateContentUnderCultureAndCareersHeader("CultureandCareers");*/
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify the Help content in the WCMS application - Set 1", e);
        }
        System.out.println("Successfully Verify the Help content in the WCMS application - Set 1");
    }


    @Step("Validate Content under 'General' header")
    public void validateContentUnderGeneralHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(jsonFileReader.getJsonString("Mainheader"))),jsonFileReader.getJsonString("Mainheader") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(
                    WCMSPage.jsonValue(jsonObject,"Header"))),WCMSPage.jsonValue(jsonObject,"Header") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader1"))),WCMSPage.jsonValue(jsonObject,"Subheader1") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader1"),
                    WCMSPage.jsonValue(jsonObject,"Button1"))),WCMSPage.jsonValue(jsonObject,"Button1") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader2"))),WCMSPage.jsonValue(jsonObject,"Subheader2") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader2"),
                    WCMSPage.jsonValue(jsonObject,"Button2"))),WCMSPage.jsonValue(jsonObject,"Button2") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader3"))),WCMSPage.jsonValue(jsonObject,"Subheader3") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader3"),
                    WCMSPage.jsonValue(jsonObject,"Button3"))),WCMSPage.jsonValue(jsonObject,"Button3") + "content not matched");

            softAssert.assertAll();

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'General' header ", e);
        }
    }
    @Step("Validate content under 'About ASTM ' header")
    public void validateContentUnderAboutASTMHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)),WCMSPage.jsonValue(jsonObject,"Header") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Link1"))),WCMSPage.jsonValue(jsonObject,"Link1") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Link2"))),WCMSPage.jsonValue(jsonObject,"Link2") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Link3"))),WCMSPage.jsonValue(jsonObject,"Link3") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Link4"))),WCMSPage.jsonValue(jsonObject,"Link4") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Link5"))),WCMSPage.jsonValue(jsonObject,"Link5") + "content not matched");

            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'About ASTM ' header ", e);
        }
    }
    @Step("Validate content under 'Policies ' header")
    public void validateContentUnderPoliciesHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)),WCMSPage.jsonValue(jsonObject,"Header") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Link1"))),WCMSPage.jsonValue(jsonObject,"Link1") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Link2"))),WCMSPage.jsonValue(jsonObject,"Link2") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Link3"))),WCMSPage.jsonValue(jsonObject,"Link3") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Link4"))),WCMSPage.jsonValue(jsonObject,"Link4") + "content not matched");

            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Policies ' header ", e);
        }
    }
    @Step("Validate content under 'Accounts and Order Information' header")
    public void validateContentUnderAccountsOrderInformationHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)),WCMSPage.jsonValue(jsonObject,"Header") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text"))),WCMSPage.jsonValue(jsonObject,"Text") + "content not matched");


            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                   WCMSPage.jsonValue(jsonObject,"Subheader1"))),WCMSPage.jsonValue(jsonObject,"Subheader1") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader1"),
                   WCMSPage.jsonValue(jsonObject,"Text1"))),WCMSPage.jsonValue(jsonObject,"Text1") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader1"),
                    WCMSPage.jsonValue(jsonObject,"Text2"))),WCMSPage.jsonValue(jsonObject,"Text2") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader1"),
                    WCMSPage.jsonValue(jsonObject,"Text3"))),WCMSPage.jsonValue(jsonObject,"Text3") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader2"))),WCMSPage.jsonValue(jsonObject,"Subheader2") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader2"),
                    WCMSPage.jsonValue(jsonObject,"Text4"))),WCMSPage.jsonValue(jsonObject,"Text4") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader2"),
                    WCMSPage.jsonValue(jsonObject,"Text5"))),WCMSPage.jsonValue(jsonObject,"Text5") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader2"),
                    WCMSPage.jsonValue(jsonObject,"Text6"))),WCMSPage.jsonValue(jsonObject,"Text6") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader3"))),WCMSPage.jsonValue(jsonObject,"Subheader3") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader3"),
                    WCMSPage.jsonValue(jsonObject,"Text7"))),WCMSPage.jsonValue(jsonObject,"Text7") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader3"),
                    WCMSPage.jsonValue(jsonObject,"Text8"))),WCMSPage.jsonValue(jsonObject,"Text8") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader3"),
                    WCMSPage.jsonValue(jsonObject,"Text9"))),WCMSPage.jsonValue(jsonObject,"Text9") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader4"))),WCMSPage.jsonValue(jsonObject,"Subheader4") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader4"),
                    WCMSPage.jsonValue(jsonObject,"Text11"))),WCMSPage.jsonValue(jsonObject,"Text11") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader4"),
                    WCMSPage.jsonValue(jsonObject,"Text12"))),WCMSPage.jsonValue(jsonObject,"Text12") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader4"),
                    WCMSPage.jsonValue(jsonObject,"Text13"))),WCMSPage.jsonValue(jsonObject,"Text13") + "content not matched");
            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Global Cooperation' header ", e);
        }
    }
    @Step("Validate content under 'I purchased a subscription, how do I access it?' header")
    public void validateContentUnderIPurchasedHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)),WCMSPage.jsonValue(jsonObject,"Header") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text1"))),WCMSPage.jsonValue(jsonObject,"Text1") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text2"))),WCMSPage.jsonValue(jsonObject,"Text2") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text3"))),WCMSPage.jsonValue(jsonObject,"Text3") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text4"))),WCMSPage.jsonValue(jsonObject,"Text4") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Link1"))),WCMSPage.jsonValue(jsonObject,"Link1") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text5"))),WCMSPage.jsonValue(jsonObject,"Text5") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Link2"))),WCMSPage.jsonValue(jsonObject,"Link2") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text6"))),WCMSPage.jsonValue(jsonObject,"Text6") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Link3"))),WCMSPage.jsonValue(jsonObject,"Link3") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text7"))),WCMSPage.jsonValue(jsonObject,"Text7") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text8"))),WCMSPage.jsonValue(jsonObject,"Text8") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text9"))),WCMSPage.jsonValue(jsonObject,"Text9") + "content not matched");
            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text10"))),WCMSPage.jsonValue(jsonObject,"Text10") + "content not matched");
            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'I purchased a subscription, how do I access it?' header ", e);
        }
    }
    @Step("Validate content under 'International And Domestic Shipping' header")
    public void validateContentUnderInternationalAndDomesticShippingHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(WCMSPage.jsonValue(jsonObject,"Subheader1"))),WCMSPage.jsonValue(jsonObject,"Subheader1") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(WCMSPage.jsonValue(jsonObject,"Subheader1"),
                    WCMSPage.jsonValue(jsonObject,"Text1"))),WCMSPage.jsonValue(jsonObject,"Text1") + "content not matched");

            /*softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                   WCMSPage.jsonValue(jsonObject,"Button1"))),WCMSPage.jsonValue(jsonObject,"Button1") + "content not matched");

            softAssert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                   WCMSPage.jsonValue(jsonObject,"Button2"))),WCMSPage.jsonValue(jsonObject,"Button2") + "content not matched");*/
            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'International And Domestic Shipping' header ", e);
        }
    }

}
