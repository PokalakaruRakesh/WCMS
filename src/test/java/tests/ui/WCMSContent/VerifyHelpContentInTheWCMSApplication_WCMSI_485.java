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

            WCMSPage.NavigateToPage(jsonFileReader.getJsonString("Menu"), jsonFileReader.getJsonString("Submenu"),"Help Center");
            validateContentUnderGeneralHeader("General");
            validateContentUnderAboutASTMHeader("AboutASTM");
            validateContentUnderPoliciesHeader("Policies");
            validateContentUnderAccountsOrderInformationHeader("AccountsAndOrderInformation");
            validateContentUnderIPurchasedHeader("IPurchasedSubscription");
            validateContentUnderInternationalAndDomesticShippingHeader("InternationalAndDomesticShipping");
            validateContentUnderPaymentsHeader("Payments");
            validateContentUnderPaymentMethodsHeader("PaymentMethods");
            validateContentUnderMembershipHeader("Membership");
            validateContentUnderRegionalOfficesSupportHeader("RegionalOfficesAndSupport");
            validateContentUnderTroubleshootingHeader("Troubleshooting");


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

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(jsonFileReader.getJsonString("Mainheader"))),jsonFileReader.getJsonString("Mainheader") + " content not matched");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(
                    WCMSPage.jsonValue(jsonObject,"Header"))),WCMSPage.jsonValue(jsonObject,"Header") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader1"))),WCMSPage.jsonValue(jsonObject,"Subheader1") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader1(WCMSPage.jsonValue(jsonObject,"Subheader1"),
                    WCMSPage.jsonValue(jsonObject,"Button1"))),WCMSPage.jsonValue(jsonObject,"Button1") + " content not matched");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader2"))),WCMSPage.jsonValue(jsonObject,"Subheader2") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader1(WCMSPage.jsonValue(jsonObject,"Subheader2"),
                    WCMSPage.jsonValue(jsonObject,"Button2"))),WCMSPage.jsonValue(jsonObject,"Button2") + " content not matched");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader3"))),WCMSPage.jsonValue(jsonObject,"Subheader3") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderSubheader1(WCMSPage.jsonValue(jsonObject,"Subheader3"),
                    WCMSPage.jsonValue(jsonObject,"Button3"))),WCMSPage.jsonValue(jsonObject,"Button3") + " content not matched");



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

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)),WCMSPage.jsonValue(jsonObject,"Header") + " content not matched");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Link1"))),WCMSPage.jsonValue(jsonObject,"Link1") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Link2"))),WCMSPage.jsonValue(jsonObject,"Link2") + " content not matched");
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"link3")),WCMSPage.jsonValue(jsonObject,"Link3"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Link4"))),WCMSPage.jsonValue(jsonObject,"Link4") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Link5"))),WCMSPage.jsonValue(jsonObject,"Link5") + " content not matched");


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

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)),WCMSPage.jsonValue(jsonObject,"Header") + " content not matched");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Link1"))),WCMSPage.jsonValue(jsonObject,"Link1") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Link2"))),WCMSPage.jsonValue(jsonObject,"Link2") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Link3"))),WCMSPage.jsonValue(jsonObject,"Link3") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Link4"))),WCMSPage.jsonValue(jsonObject,"Link4") + " content not matched");


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

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)),WCMSPage.jsonValue(jsonObject,"Header") + " content not matched");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text"))),WCMSPage.jsonValue(jsonObject,"Text") + " content not matched");


            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader1"))),WCMSPage.jsonValue(jsonObject,"Subheader1") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader1"),
                    WCMSPage.jsonValue(jsonObject,"Text1"))),WCMSPage.jsonValue(jsonObject,"Text1") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader1"),
                    WCMSPage.jsonValue(jsonObject,"Text2"))),WCMSPage.jsonValue(jsonObject,"Text2") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader1"),
                    WCMSPage.jsonValue(jsonObject,"Text3"))),WCMSPage.jsonValue(jsonObject,"Text3") + " content not matched");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader2"))),WCMSPage.jsonValue(jsonObject,"Subheader2") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader2"),
                    WCMSPage.jsonValue(jsonObject,"Text4"))),WCMSPage.jsonValue(jsonObject,"Text4") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader2"),
                    WCMSPage.jsonValue(jsonObject,"Text5"))),WCMSPage.jsonValue(jsonObject,"Text5") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader2"),
                    WCMSPage.jsonValue(jsonObject,"Text6"))),WCMSPage.jsonValue(jsonObject,"Text6") + " content not matched");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader3"))),WCMSPage.jsonValue(jsonObject,"Subheader3") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader3"),
                    WCMSPage.jsonValue(jsonObject,"Text7"))),WCMSPage.jsonValue(jsonObject,"Text7") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader3"),
                    WCMSPage.jsonValue(jsonObject,"Text8"))),WCMSPage.jsonValue(jsonObject,"Text8") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader3"),
                    WCMSPage.jsonValue(jsonObject,"Text9"))),WCMSPage.jsonValue(jsonObject,"Text9") + " content not matched");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader4"))),WCMSPage.jsonValue(jsonObject,"Subheader4") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader4"),
                    WCMSPage.jsonValue(jsonObject,"Text11"))),WCMSPage.jsonValue(jsonObject,"Text11") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader4"),
                    WCMSPage.jsonValue(jsonObject,"Text12"))),WCMSPage.jsonValue(jsonObject,"Text12") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader4"),
                    WCMSPage.jsonValue(jsonObject,"Text13"))),WCMSPage.jsonValue(jsonObject,"Text13") + " content not matched");

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

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)),WCMSPage.jsonValue(jsonObject,"Header") + " content not matched");
            String txt=WCMSPage.jsonValue(jsonObject,"Text1")+" "+WCMSPage.jsonValue(jsonObject,"Text2")+" "+WCMSPage.jsonValue(jsonObject,"Text3");
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text1")),txt);
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text4"))),WCMSPage.jsonValue(jsonObject,"Text4") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Link1"))),WCMSPage.jsonValue(jsonObject,"Link1") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text5"))),WCMSPage.jsonValue(jsonObject,"Text5") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Link2"))),WCMSPage.jsonValue(jsonObject,"Link2") + " content not matched");
            Assert.assertEquals(WCMSPage.getTextByHeader(header,WCMSPage.jsonValue(jsonObject,"text6")),
                    WCMSPage.jsonValue(jsonObject,"Text6"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Link3"))),WCMSPage.jsonValue(jsonObject,"Link3") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text7"))),WCMSPage.jsonValue(jsonObject,"Text7") + " content not matched");

            String txt1=WCMSPage.jsonValue(jsonObject,"Text8_1")+WCMSPage.jsonValue(jsonObject,"Text8_2");
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text8")),txt1);
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text9")),WCMSPage.jsonValue(jsonObject,"Text9"));
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text10")),WCMSPage.jsonValue(jsonObject,"Text10"));



        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'I purchased a subscription, how do I access it?' header ", e);
        }
    }
    @Step("Validate content under 'International And Domestic Shipping' header")
    public void validateContentUnderInternationalAndDomesticShippingHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(WCMSPage.jsonValue(jsonObject,"Subheader1"))),WCMSPage.jsonValue(jsonObject,"Subheader1") + " content not matched");

            Assert.assertTrue(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text1")).contains(WCMSPage.jsonValue(jsonObject,"Text1")));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getsubheader(WCMSPage.jsonValue(jsonObject,"Subheader2"))),WCMSPage.jsonValue(jsonObject,"Subheader2") + " content not matched");
            Assert.assertTrue(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text2")).contains(WCMSPage.jsonValue(jsonObject,"Text2")));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'International And Domestic Shipping' header ", e);
        }
    }
    @Step("Validate content under 'Payments' header")
    public void validateContentUnderPaymentsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header"))),WCMSPage.jsonValue(jsonObject,"Header") + " content not matched");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"LinkText1"))),WCMSPage.jsonValue(jsonObject,"LinkText1") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"LinkText2"))),WCMSPage.jsonValue(jsonObject,"LinkText2") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"LinkText3"))),WCMSPage.jsonValue(jsonObject,"LinkText3") + " content not matched");

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Payments' header ", e);
        }
    }
    @Step("Validate content under 'What are accepted payment methods ' header")
    public void validateContentUnderPaymentMethodsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header"))),WCMSPage.jsonValue(jsonObject,"Header") + " content not matched");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader1"))),WCMSPage.jsonValue(jsonObject,"Subheader1") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader1"),
                    WCMSPage.jsonValue(jsonObject,"Text1"))),WCMSPage.jsonValue(jsonObject,"Text1") + " content not matched");
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text2")),WCMSPage.jsonValue(jsonObject,"Text2"));
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderSubheader(WCMSPage.jsonValue(jsonObject,"Subheader1"),
                    WCMSPage.jsonValue(jsonObject,"Text3"))),WCMSPage.jsonValue(jsonObject,"Text3") + " content not matched");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader2"))),WCMSPage.jsonValue(jsonObject,"Subheader2") + " content not matched");
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text4")),WCMSPage.jsonValue(jsonObject,"Text4"));

            String txt1=WCMSPage.jsonValue(jsonObject,"Text5_1")+" "+WCMSPage.jsonValue(jsonObject,"Text5_2")+" "+WCMSPage.jsonValue(jsonObject,"Text5_3")+" "+WCMSPage.jsonValue(jsonObject,"Text5_4");
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text5")),txt1);

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getSubheaderUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Subheader3"))),WCMSPage.jsonValue(jsonObject,"Subheader3") + " content not matched");


            String txt2=WCMSPage.jsonValue(jsonObject,"Text7_1")+" "+WCMSPage.jsonValue(jsonObject,"Text7_2")+" "+WCMSPage.jsonValue(jsonObject,"Text7_3")+" "+WCMSPage.jsonValue(jsonObject,"Text7_4")+" "+WCMSPage.jsonValue(jsonObject,"Text7_5")+" "+WCMSPage.jsonValue(jsonObject,"Text7_6");
            Assert.assertEquals(WCMSPage.getText(WCMSPage.jsonValue(jsonObject,"text7")),txt2);


        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'What are accepted payment methods ' header ", e);
        }
    }
    @Step("Validate content under 'Membership' header")
    public void validateContentUnderMembershipHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header"))),WCMSPage.jsonValue(jsonObject,"Header") + " content not matched");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"LinkText1"))),WCMSPage.jsonValue(jsonObject,"LinkText1") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"LinkText2"))),WCMSPage.jsonValue(jsonObject,"LinkText2") + " content not matched");


        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Membership' header ", e);
        }
    }
    @Step("Validate content under 'Regional Offices and Support' header")
    public void validateContentUnderRegionalOfficesSupportHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header"))),WCMSPage.jsonValue(jsonObject,"Header") + " content not matched");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"Text"))),WCMSPage.jsonValue(jsonObject,"Text") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getButtonUnderHeader(header,
                    WCMSPage.jsonValue(jsonObject,"button"))),WCMSPage.jsonValue(jsonObject,"button") + " content not matched");


        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Regional Offices and Support' header ", e);
        }
    }
    @Step("Validate content under 'Troubleshooting ' header")
    public void validateContentUnderTroubleshootingHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(WCMSPage.jsonValue(jsonObject,"Header"))),WCMSPage.jsonValue(jsonObject,"Header") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(WCMSPage.jsonValue(jsonObject,"LinkText1"))),WCMSPage.jsonValue(jsonObject,"LinkText1") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(WCMSPage.jsonValue(jsonObject,"LinkText2"))),WCMSPage.jsonValue(jsonObject,"LinkText2") + " content not matched");
            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getLinkText(WCMSPage.jsonValue(jsonObject,"LinkText3"))),WCMSPage.jsonValue(jsonObject,"LinkText3") + " content not matched");

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Troubleshooting ' header ", e);
        }
    }
}
