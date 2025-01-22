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

public class VerifyMarketInsightsInnovationPageContentWCMSApplication_WCMSI_587 extends BaseTest {
    static final String jiraTestID = "WCMSI-587";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    CookiePage cookiePage;
    
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify \"Market Insights & Innovation\" Page content in WCMS application-Set 5")
    @Test(description = jiraTestID
            + ": Verify \"Market Insights & Innovation\" Page content in WCMS application-Set 5", groups = {""})
    public void verify125thAnniversaryCaseStudiesContentInTheWCMSApplication() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            cookiePage=page.getInstance(CookiePage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);

            WCMSPage.NavigateToPage(jsonFileReader.getJsonString("Menu"),jsonFileReader.getJsonString("Submenu"),"Standards & Solutions");
            WCMSPage.NavigateToSubmenuList(jsonFileReader.getJsonString("SubmenuList"),"Market Insights and Innovation");
            validateContentUnderEmpoweringEmergingSectorsSteeringInnovationHeader("EmpoweringEmerging");
            validateCentersOfExcellenceHeader("CentersOfExcellence");
            validateNeedOrderingAssistanceHeader("NeedOrdering");
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify \"Market Insights & Innovation\" Page content in WCMS application-Set 5", e);
        }
        System.out.println("Successfully Verify \"Market Insights & Innovation\" Page content in WCMS application-Set 5");
    }


    @Step("Validate Content under 'Empowering Emerging Sectors and Steering Innovation' header")
    public void validateContentUnderEmpoweringEmergingSectorsSteeringInnovationHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String mainHeader=WCMSPage.jsonValue(jsonObject,"MainHeader");
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            String subheader1=WCMSPage.jsonValue(jsonObject,"Subheader1");
            String subheader2=WCMSPage.jsonValue(jsonObject,"Subheader2");
            String subheader3=WCMSPage.jsonValue(jsonObject,"Subheader3");
            String subheader4=WCMSPage.jsonValue(jsonObject,"Subheader4");


            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(mainHeader)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subheader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subheader2)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subheader3)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subheader4)));

            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button1"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button2"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button3"))));

            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader1,WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subheader1,
                    WCMSPage.jsonValue(jsonObject,"Button4"))));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader2,WCMSPage.jsonValue(jsonObject,"text4")),
                    WCMSPage.jsonValue(jsonObject,"Text4"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subheader2,
                    WCMSPage.jsonValue(jsonObject,"Button5"))));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader3,WCMSPage.jsonValue(jsonObject,"text5")),
                    WCMSPage.jsonValue(jsonObject,"Text5"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subheader3,
                    WCMSPage.jsonValue(jsonObject,"Button6"))));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader4,WCMSPage.jsonValue(jsonObject,"text6")),
                    WCMSPage.jsonValue(jsonObject,"Text6"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subheader4,
                    WCMSPage.jsonValue(jsonObject,"Button7"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Empowering Emerging Sectors and Steering Innovation' header ", e);
        }
    }
    @Step("Validate Content under 'Centers of Excellence (COE)'")
    public void validateCentersOfExcellenceHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");
            String subheader1=WCMSPage.jsonValue(jsonObject,"Subheader1");
            String subheader2=WCMSPage.jsonValue(jsonObject,"Subheader2");
            String subheader3=WCMSPage.jsonValue(jsonObject,"Subheader3");
            String subheader4=WCMSPage.jsonValue(jsonObject,"Subheader4");
            String subheader5=WCMSPage.jsonValue(jsonObject,"Subheader5");
            String subheader6=WCMSPage.jsonValue(jsonObject,"Subheader6");


            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subheader1)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subheader2)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subheader3)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subheader4)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subheader5)));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(subheader6)));

            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text")),
                    WCMSPage.jsonValue(jsonObject,"Text"));

            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader1,WCMSPage.jsonValue(jsonObject,"text1")),
                    WCMSPage.jsonValue(jsonObject,"Text1"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subheader1,
                    WCMSPage.jsonValue(jsonObject,"LinkText1"))));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader2,WCMSPage.jsonValue(jsonObject,"text2")),
                    WCMSPage.jsonValue(jsonObject,"Text2"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subheader2,
                    WCMSPage.jsonValue(jsonObject,"LinkText2"))));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader3,WCMSPage.jsonValue(jsonObject,"text3")),
                    WCMSPage.jsonValue(jsonObject,"Text3"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subheader3,
                    WCMSPage.jsonValue(jsonObject,"LinkText3"))));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader4,WCMSPage.jsonValue(jsonObject,"text4")),
                    WCMSPage.jsonValue(jsonObject,"Text4"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subheader4,
                    WCMSPage.jsonValue(jsonObject,"LinkText4"))));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader5,WCMSPage.jsonValue(jsonObject,"text5")),
                    WCMSPage.jsonValue(jsonObject,"Text5"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subheader5,
                    WCMSPage.jsonValue(jsonObject,"LinkText5"))));
            Assert.assertEquals(WCMSPage.getTextSubHeader(subheader6,WCMSPage.jsonValue(jsonObject,"text6")),
                    WCMSPage.jsonValue(jsonObject,"Text6"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader(subheader6,
                    WCMSPage.jsonValue(jsonObject,"LinkText6"))));


        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Centers of Excellence (COE)' header ", e);
        }
    }
    @Step("Validate Content under 'Need ordering assistance? Contact our Customer Support team'")
    public void validateNeedOrderingAssistanceHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header"))));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Button"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Need ordering assistance? Contact our Customer Support team.' header ", e);
        }
    }
}

