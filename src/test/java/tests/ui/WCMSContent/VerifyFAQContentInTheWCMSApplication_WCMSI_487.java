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

public class VerifyFAQContentInTheWCMSApplication_WCMSI_487 extends BaseTest {
    static final String jiraTestID = "WCMSI-487";
    JsonFileReader jsonFileReader;
    WCMSContentPage WCMSPage;
    
    @BeforeMethod(alwaysRun = true)
    public void beforeLoginTest() {
        driver.get(ConfigReader.getValue("BASE_URL_WCMS_ASTM"));
    }
    @Severity(SeverityLevel.NORMAL)
    @TmsLink(jiraTestID)
    @Description("Verify the FAQ content in the WCMS application - Set 1")
    @Test(description = jiraTestID
            + ": Verify the FAQ content in the WCMS application - Set 1", groups = {""})
    public void verifyFAQContentInTheWCMSApplication() {
        try {
            WCMSPage = page.getInstance(WCMSContentPage.class);
            jsonFileReader = new JsonFileReader();
            jsonFileReader.setJiraID(jiraTestID);

            WCMSPage.NavigateToPage1(jsonFileReader.getJsonString("Menu"),"Frequently Asked Questions");
            validateContentUnderFrequentlyAskedQuestionsHeader("FrequentlyAskedQuestions");
            validateContentUnderGeneralHeader("General");
            validateContentUnderStandardsHeader("Standards");
            validateContentUnderCopyrightPermissionsHeader("CopyrightAndPermissions");
            validateContentUnderTrainingCertificationHeader("TrainingCertification");
            validateContentUnderRegulationsGovernmentHeader("RegulationsGovernment");
            validateContentUnderMembershipHeader("Membership");
            validateContentUnderMeetingsHeader("Meetings");
            validateContentUnderSymposiaHeader("Symposia");
            validateContentUnderSubscriptionsOrderSupportHeader("SubscriptionsOrderSupport");
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to Verify the 'FAQ' content in the WCMS application - Set 1", e);
        }
        System.out.println("Successfully Verify the 'FAQ' content in the WCMS application - Set 1");
    }


    @Step("Validate Content under 'Frequently Asked Questions' header")
    public void validateContentUnderFrequentlyAskedQuestionsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getMainHeader(WCMSPage.jsonValue(jsonObject,"Mainheader"))));

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getTextUnderMainheader(WCMSPage.jsonValue(jsonObject,"Mainheader"),
                    WCMSPage.jsonValue(jsonObject,"Text"))));

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Frequently Asked Questions' header ", e);
        }
    }
    @Step("Validate Content under 'General' header")
    public void validateContentUnderGeneralHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)),header + " content not matched");

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown1");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown( WCMSPage.jsonValue(jsonObject,"Dropdown1")),WCMSPage.jsonValue(jsonObject,"Text1"));
            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown2");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown( WCMSPage.jsonValue(jsonObject,"Dropdown2")),WCMSPage.jsonValue(jsonObject,"Text2"));
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'General' header ", e);
        }
    }
    @Step("Validate Content under 'Standards' header")
    public void validateContentUnderStandardsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)),header + " content not matched");

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown1");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown1")),WCMSPage.jsonValue(jsonObject,"Text1"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown2");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown2")),WCMSPage.jsonValue(jsonObject,"Text2"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown3");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown3")),WCMSPage.jsonValue(jsonObject,"Text3"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown4");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown4")),WCMSPage.jsonValue(jsonObject,"Text4"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown5");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown5")),WCMSPage.jsonValue(jsonObject,"Text5"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown6");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown6")),WCMSPage.jsonValue(jsonObject,"Text6"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","dropdown7");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"dropdown7")),WCMSPage.jsonValue(jsonObject,"Text7"));
            

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Standards' header ", e);
        }
    }
    @Step("Validate Content under 'Copyright and Permissions' header")
    public void validateContentUnderCopyrightPermissionsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)),header + " content not matched");

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown1");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown1")),WCMSPage.jsonValue(jsonObject,"Text1"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown2");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown2")),WCMSPage.jsonValue(jsonObject,"Text2"));

            

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Copyright and Permissions' header ", e);
        }
    }
    @Step("Validate Content under 'Training and Certification' header")
    public void validateContentUnderTrainingCertificationHeader(String jsonElement) {
        try {
            JsonObject jsonObject = WCMSPage.jsonData(jiraTestID, jsonElement);
            String header = WCMSPage.jsonValue(jsonObject, "Header");

            Assert.assertTrue(Common.isElementDisplayed(driver, WCMSPage.getHeader(header)), header + " content not matched");

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown1");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown1")), WCMSPage.jsonValue(jsonObject, "Text1"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown2");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown2")), WCMSPage.jsonValue(jsonObject, "Text2"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown3");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown3")), WCMSPage.jsonValue(jsonObject, "Text3"));
            

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Training and Certification' header ", e);
        }
    }
        @Step("Validate Content under 'Regulations and Government' header")
        public void validateContentUnderRegulationsGovernmentHeader(String jsonElement) {
            try {
                JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
                String header=WCMSPage.jsonValue(jsonObject,"Header");

                Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)),header + " content not matched");

                WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown1");
                Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown1")),WCMSPage.jsonValue(jsonObject,"Text1"));

                WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown2");
                Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown2")),WCMSPage.jsonValue(jsonObject,"Text2"));

                WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown3");
                Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown3")),WCMSPage.jsonValue(jsonObject,"Text3"));

                WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown4");
                Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown4")),WCMSPage.jsonValue(jsonObject,"Text4"));
                

            } catch (Exception e) {
                e.printStackTrace();
                WCMSICommon.reportFailAssert("Failed to validate Content under 'Regulations and Government' header ", e);
            }
    }
    @Step("Validate Content under 'Membership' header")
    public void validateContentUnderMembershipHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)),header + " content not matched");

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown1");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown1")),WCMSPage.jsonValue(jsonObject,"Text1"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown2");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown2")),WCMSPage.jsonValue(jsonObject,"Text2"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown3");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown3")),WCMSPage.jsonValue(jsonObject,"Text3"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown4");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown4")),WCMSPage.jsonValue(jsonObject,"Text4"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown5");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown5")),WCMSPage.jsonValue(jsonObject,"Text5"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown6");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown6")),WCMSPage.jsonValue(jsonObject,"Text6"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown7");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown7")),WCMSPage.jsonValue(jsonObject,"Text7"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown8");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown8")),WCMSPage.jsonValue(jsonObject,"Text8"));
            

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Membership' header ", e);
        }
    }
    @Step("Validate Content under 'Meetings' header")
    public void validateContentUnderMeetingsHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)),header + " content not matched");

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown1");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown1")),WCMSPage.jsonValue(jsonObject,"Text1"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown2");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown2")),WCMSPage.jsonValue(jsonObject,"Text2"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown3");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown3")),WCMSPage.jsonValue(jsonObject,"Text3"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown4");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown4")),WCMSPage.jsonValue(jsonObject,"Text4"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown5");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown5")),WCMSPage.jsonValue(jsonObject,"Text5"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown6");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown6")),WCMSPage.jsonValue(jsonObject,"Text6"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown7");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown7")),WCMSPage.jsonValue(jsonObject,"Text7"));
            

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Meetings' header ", e);
        }
    }
    @Step("Validate Content under 'Symposia' header")
    public void validateContentUnderSymposiaHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)),header + " content not matched");

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown1");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown1")),WCMSPage.jsonValue(jsonObject,"Text1"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown2");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown2")),WCMSPage.jsonValue(jsonObject,"Text2"));

            

        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Symposia' header ", e);
        }
    }
    @Step("Validate Content under 'Subscriptions and Order Support' header")
    public void validateContentUnderSubscriptionsOrderSupportHeader(String jsonElement) {
        try {
            JsonObject jsonObject=WCMSPage.jsonData(jiraTestID,jsonElement);
            String header=WCMSPage.jsonValue(jsonObject,"Header");

            Assert.assertTrue(Common.isElementDisplayed(driver,WCMSPage.getHeader(header)),header + " content not matched");

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown1");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown1")),WCMSPage.jsonValue(jsonObject,"Text1"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown2");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown2")),WCMSPage.jsonValue(jsonObject,"Text2"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown3");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown3")),WCMSPage.jsonValue(jsonObject,"Text3"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown4");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown4")),WCMSPage.jsonValue(jsonObject,"Text4"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","dropdown5");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"dropdown5")),WCMSPage.jsonValue(jsonObject,"Text5"));

            WCMSPage.clickOnDropdown(jsonObject,"Header","Dropdown6");
            Assert.assertEquals(WCMSPage.getTextUnderDropDown(WCMSPage.jsonValue(jsonObject,"Dropdown6")),WCMSPage.jsonValue(jsonObject,"Text6"));
            
        } catch (Exception e) {
            e.printStackTrace();
            WCMSICommon.reportFailAssert("Failed to validate Content under 'Subscriptions and Order Support' header ", e);
        }
    }
}
